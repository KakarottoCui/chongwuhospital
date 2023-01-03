package com.spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.*;
import dao.CommDAO;
import java.util.*;
import util.Info;
import util.DESUtil;
import net.jntoo.db.Query;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import util.Request;
import com.spring.entity.Admins;
import com.spring.service.AdminsService;

import com.spring.entity.Yonghu;
import com.spring.service.YonghuService;


/**
 * 用户登录更新密码控制器
 */
@Controller
public class UserController extends BaseController{

        @Resource
    private AdminsService adminsService;
        @Resource
    private YonghuService yonghuService;
    
    /**
     * 登录页面
     * @return
     */
    @RequestMapping("/login")
    public String Index()
    {
        return "login";
    }

    /**
     * 退出
     * @return
     */
    @RequestMapping("/logout")
    public String Logout()
    {
        request.getSession().invalidate();
        return showSuccess("退出成功" , "./");
    }



    /**
     * 验证登录用户
     * @param isAdmin
     * @param username
     * @param pwd
     * @param cx
     * @return
     */
    protected String authLoginUser(boolean isAdmin,String username , String pwd,String cx)
    {
        if(username == null || "".equals(username) ){
            return showError( "账号不允许为空" );
        }
        if(pwd == null || "".equals(pwd) ){
            return showError( "密码不允许为空" );
        }
        if(cx == null){
            return showError( "请选中登录类型" );
        }

        String random;
        // 获取 token方式的验证码值
        if(isAjax() && request.getParameter("captchToken") != null ){
            random = DESUtil.decrypt("CaptchControllerPassword" , request.getParameter("captchToken"));
        }else{
            random = (String) request.getSession().getAttribute("random");
        }
        String pagerandom = request.getParameter("pagerandom") == null ? "" : request.getParameter("pagerandom");

        if (request.getParameter("a") != null && !pagerandom.equals(random)) {
            return showError("验证码不正确" , 20);
        }

        if (cx.equals("管理员")) {
            Admins user = adminsService.login(username , pwd);
            if(user == null){
                return showError("用户名或密码错误");
            }
                        session.setAttribute("id" , user.getId());
            session.setAttribute("username" , user.getUsername());
            session.setAttribute("cx" , cx);
            session.setAttribute("login" , cx);
                        session.setAttribute("username", user.getUsername());
                        session.setAttribute("pwd", user.getPwd());
                                    JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(user));
            jsonObject.put("cx" , session.getAttribute("cx"));
            jsonObject.put("username" , session.getAttribute("username"));
            jsonObject.put("login" , session.getAttribute("login"));
            assign("session" , jsonObject);
                    }
        if (cx.equals("用户")) {
            Yonghu user = yonghuService.login(username , pwd);
            if(user == null){
                return showError("用户名或密码错误");
            }
                        session.setAttribute("id" , user.getId());
            session.setAttribute("username" , user.getYonghuming());
            session.setAttribute("cx" , cx);
            session.setAttribute("login" , cx);
                        session.setAttribute("yonghuming", user.getYonghuming());
                        session.setAttribute("mima", user.getMima());
                        session.setAttribute("xingming", user.getXingming());
                        session.setAttribute("xingbie", user.getXingbie());
                        session.setAttribute("touxiang", user.getTouxiang());
                        session.setAttribute("shouji", user.getShouji());
                        session.setAttribute("youxiang", user.getYouxiang());
                        session.setAttribute("shenfenzheng", user.getShenfenzheng());
                        session.setAttribute("zhanghuyue", user.getZhanghuyue());
                                    JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(user));
            jsonObject.put("cx" , session.getAttribute("cx"));
            jsonObject.put("username" , session.getAttribute("username"));
            jsonObject.put("login" , session.getAttribute("login"));
            assign("session" , jsonObject);
                    }

        if(session.getAttribute("username") == null){
            return showError("账号或密码错误");
        }

        String referer = request.getParameter("referer");
        if(referer == null){
            if(isAdmin){
                referer = "./main.do";
            }else{
                referer = "./";
            }
        }
                assign("token",createToken(
                session.getAttribute("cx"),
                session.getAttribute("login") ,
                session.getAttribute("username"),
                    _var.get("session")
                )
        );
                if(this.isAjax())
        {
            return json();
        }else{
            return showSuccess("登录成功", referer);
        }
    }
    public String createToken(Object cx , Object login, Object username , Object session)
    {
        String SOURCE_STRING = "0123456789ABCDEFGHIGKLMNOPQRSTUVWXYZ";
        String token = createRandomString(SOURCE_STRING,32);

        // 删除过期token
        new CommDAO().commOper("DELETE FROM token WHERE token_time<'"+ Info.getDateStr()+"'");

        HashMap tokenMap = new HashMap();
        tokenMap.put("token" , token);
        tokenMap.put("cx" , cx);
        tokenMap.put("login" , login);
        tokenMap.put("username" , username);
        tokenMap.put("valueid" , this.session.getAttribute("id"));
        // 10天的有效期
        tokenMap.put("token_time" , Info.date("yyyy-MM-dd HH:mm:ss" , Info.time() + 86400 * 10));
        tokenMap.put("session" , JSON.toJSONString(session));

        Query.make("token").add(tokenMap);

        return token;
    }

    /**
     * 使用已有token 登录
     * @return
     */
    @RequestMapping("/tokenLogin")
    public String tokenLogin()
    {
        String token = request.getParameter("token");
        HashMap<String , String> tokenInfo = Query.make("token").where("token" , token).where("token_time" , ">" , Info.getDateStr()).find();
        if(tokenInfo.isEmpty())
        {
            return jsonError("token已失效");
        }

        String cx = tokenInfo.get("login");
        Object user = null;

        if(cx.equals("管理员"))
        {
            user = adminsService.find(tokenInfo.get("valueid"));
        }
        if(cx.equals("用户"))
        {
            user = yonghuService.find(tokenInfo.get("valueid"));
        }
        if(user == null){
            return jsonError("没找到token中用户");
        }
        tokenInfo.put("session" , JSON.toJSONString(user));

        session.setAttribute("cx" , tokenInfo.get("cx"));
        session.setAttribute("login" , tokenInfo.get("login"));
        session.setAttribute("username" , tokenInfo.get("username"));
        session.setAttribute("id" , tokenInfo.get("valueid"));

        JSONObject session1 = JSON.parseObject(tokenInfo.get("session"));
        for( Map.Entry<String , Object> entry :session1.entrySet())
        {
            session.setAttribute(entry.getKey() , entry.getValue());
        }
        session1.put("cx",tokenInfo.get("cx"));
        session1.put("login",tokenInfo.get("login"));
        session1.put("username",tokenInfo.get("username"));

        assign("token" , token);
        assign("session" , session1);

        // 刷新token有效期
        tokenInfo.put("token_time" , Info.date("yyyy-MM-dd HH:mm:ss" , Info.time() + 86400 * 10));
        Query.make("token").where("token" , token).update(tokenInfo);
        return json();
    }


    /**
     * 获取随机串
     * @param source 源字符串
     * @param length 随机串的长度
     * @return 随机串
     */
    private String createRandomString(String source, int length) {
        if (this.isNullOrEmpty(source)) {
            return "";
        }

        StringBuffer result = new StringBuffer();
        Random random = new Random();

        for(int index = 0; index < length; index++) {
            result.append(source.charAt(random.nextInt(source.length())));
        }

        System.out.println(result.toString());
        return result.toString();
    }
    /**
     * 判断字符串是否为空
     * @param target
     * @return true：空，false：非空
     */
    private boolean isNullOrEmpty(String target) {
        if (null == target || "".equals(target) || target.isEmpty()) {
            return true;
        }
        return false;
    }



    /**
     * 后台主页面
     * @return
     */
    @RequestMapping("/main")
    public String main() {
        return "main";
    }

    /**
     * 后台初始页面
     * @return
     */
    @RequestMapping("/sy")
    public String sy() {
        return "sy";
    }

    /**
     * 不一定有
     * @return
     */
    @RequestMapping("/mygo")
    public String mygo() {
        return "mygo";
    }

    /**
     * 头部页面
     * @return
     */
    @RequestMapping("/top")
    public String top() {
        return "top";
    }

    /**
     * 验证登录页面
     * @return
     */
    @RequestMapping("/authLogin")
    public String authLogin()
    {
        String username = Request.get("username");
        String pwd  = Request.get("pwd");
        String cx = Request.get("cx");
        return authLoginUser(false , username,pwd,cx);
    }

    /**
     * 验证后台登录
     * @return
     */
    @RequestMapping("/authAdminLogin")
    public String authAdminLogin()
    {
        String username = Request.get("username");
        String pwd  = Request.get("pwd");
        String cx = Request.get("cx");
        return authLoginUser(true , username,pwd,cx);
    }

    /**
     * 修改登录密码页面
     * @return
     */
    @RequestMapping("/mod")
    public String mod()
    {
        return "mod";
    }

    /**
     * 保存修改密码
     * @return
     */
    @RequestMapping("/editPassword")
    public String editPassword()
    {
        String username = request.getSession().getAttribute("username").toString();
        String cx = request.getSession().getAttribute("login").toString();
        String oldPassword = Request.get("oldPassword");
        String newPwd  = Request.get("newPwd");
        String newPwd2 = Request.get("newPwd2");

        if(!newPwd.equals(newPwd2)){
            return showError("两次密码不一致");
        }


        if (cx.equals("管理员")) {
            Admins user = adminsService.login(username , oldPassword);
            if(user == null){
                return showError("原密码不正确");
            }
            adminsService.updatePassword(user.getId() , newPwd);
        }
        if (cx.equals("用户")) {
            Yonghu user = yonghuService.login(username , oldPassword);
            if(user == null){
                return showError("原密码不正确");
            }
            yonghuService.updatePassword(user.getId() , newPwd);
        }
        return showSuccess("修改密码成功" , "./mod.do");
    }
}
