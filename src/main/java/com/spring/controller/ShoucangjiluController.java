package com.spring.controller;

import com.spring.entity.Shoucangjilu;
import com.spring.service.ShoucangjiluService;
import dao.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.mapper.entity.Example;
import util.Info;
import util.Request;

import javax.annotation.Resource;
import java.util.List;

/**
 * 收藏控制器
 */
@Controller
public class ShoucangjiluController extends BaseController {

    @Resource
    protected ShoucangjiluService service;

    /**
     * 加入收藏
     * @return
     */
    @RequestMapping("/collect")
    public String collect()
    {
        if(!checkLogin()){
            return showError("您尚未登录请登录后在操作");
        }
        int id=Request.getInt("id");
        String biao=request.getParameter("biao");
        String ziduan=request.getParameter("ziduan");
        Shoucangjilu scjl = new Shoucangjilu();
        scjl.setXwid(id);
        scjl.setBiao(biao);
        scjl.setBiaoti(Query.make(biao).where("id" , id).value(ziduan));
        scjl.setUrl(request.getHeader("referer"));
        scjl.setZiduan(ziduan);
        scjl.setAddtime(Info.getDateStr());
        scjl.setUsername(request.getSession().getAttribute("username").toString());
        service.insert(scjl);
        return showSuccess("收藏成功" , request.getHeader("referer"));
    }

    /**
     * 查看收藏列表
     * @return
     */
    @RequestMapping("/shoucangjilu_list")
    public String index()
    {
        int page = Math.max(Integer.valueOf(Request.get("page" , "1")) , 1);
        Example example = new Example(Shoucangjilu.class);
        Example.Criteria criteria = example.createCriteria();

        criteria.andEqualTo("username" , request.getSession().getAttribute("username"));
        List<Shoucangjilu> list = service.selectPageExample(example , page , 15);
        if(isAjax()){
            return json();
        }
        return "shoucangjilu_list";
    }

    /**
     * 查看我的收藏
     * @return
     */
    @RequestMapping("/shoucangjilu_list2")
    public String index2()
    {
        int page = Math.max(Integer.valueOf(Request.get("page" , "1")) , 1);
        Example example = new Example(Shoucangjilu.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username" , request.getSession().getAttribute("username"));
        List<Shoucangjilu> list = service.selectPageExample(example , page , 15);
        assign("list" , list);
        if(isAjax()){
            return json();
        }
        return "shoucangjilu_list";
    }

    /**
     * 删除收藏
     * @return
     */
    @RequestMapping("/shoucangjilu_delete")
    public String delete()
    {
        String id = Request.get("id");
        service.delete(id);
        return showSuccess("删除成功");
    }

}
