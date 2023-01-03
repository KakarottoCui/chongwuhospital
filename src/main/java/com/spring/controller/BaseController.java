package com.spring.controller;



import com.alibaba.fastjson.JSON;
import com.spring.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 控制器基类
 */
abstract public class BaseController {
    @Autowired
    protected HttpServletRequest request; // 注入
    @Autowired
    protected HttpServletResponse response; // 注入
    @Autowired
    protected HttpSession session; // 注入

    protected ModelAndView mView;

    protected Map<Object,Object> _var;

    /**
     * 控制器
     */
    public BaseController()
    {
        //request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        mView = new ModelAndView();
        _var = new LinkedHashMap();
    }



    /**
     * 往模板中写入数据
     * @param name
     * @param value
     */
    protected void assign(String name , Object value)
    {
        request.setAttribute(name , value);
        _var.put(name , value);
    }

    /**
     * 弹出框
     * @param message
     * @param code
     * @param jumpUrl
     * @param jumpTime
     * @return
     */
    protected String showMessage( String message , int code , Object data , String jumpUrl , int jumpTime)
    {
        if(isAjax())
        {
            JsonResult jsonResult = new JsonResult(code , message , data);
            return renderString(response , JSON.toJSONString(jsonResult));
        }

        assign("message" , message == null ? data : message);
        assign("code" , code);
        assign("jumpUrl" , jumpUrl);
        assign("jumpTime" , jumpTime);

        return "message";
    }

    /**
     * 将写入json写到前端
     * @return
     */
    public String json()
    {
        return jsonResult(_var);
    }

    public String jsonReturn(String message , int code , Object data)
    {
        JsonResult result = new JsonResult(code , message , data);
        return renderString(response , JSON.toJSONString(result));
    }

    public String jsonResult(Object data)
    {
        return jsonReturn(null , 0 , data);
    }

    public String jsonError(String msg)
    {
        return jsonReturn(msg , 1 , null);
    }

    public Object getRequestAttributeMap()
    {
        //Map<Object,Object> map = new LinkedHashMap();
        Enumeration<String> names = request.getAttributeNames();

        while (names.hasMoreElements())
        {
            String key = names.nextElement();
            if(!_var.containsKey(key)){
                // 没有，则写入
                _var.put(key , request.getAttribute(key));
            }
        }
        return _var;
    }

    public String getJson()
    {
        Map<Object,Object> map = new LinkedHashMap();
        Enumeration<String> names = request.getAttributeNames();

        while (names.hasMoreElements())
        {
            String key = names.nextElement();
            Object value = request.getAttribute(key);
            map.put(key , value);
        }
        return renderString(response , JSON.toJSONString(map));
    }


    /**
     * 将字符串渲染到客户端
     *
     * @param response 渲染对象
     * @param string 待渲染的字符串
     * @return null
     */
    public String renderString(HttpServletResponse response, String string)
    {
        try
        {
            request.getSession();
            OutputStream stream = response.getOutputStream();
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            stream.write(string.getBytes());
            stream.flush();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return "success";
    }

    protected boolean isAjax()
    {
        String accept = request.getHeader("accept");
        if (accept != null && accept.indexOf("application/json") != -1)
        {
            return true;
        }

        String xRequestedWith = request.getHeader("X-Requested-With");
        if (xRequestedWith != null && xRequestedWith.indexOf("XMLHttpRequest") != -1)
        {
            return true;
        }

        String ajax = request.getParameter("format");
        if ("json".equalsIgnoreCase(ajax))
        {
            return true;
        }
        return false;
    }

    /**
     * 检测是否登录
     * @return
     */
    protected boolean checkLogin()
    {
        if(request.getSession().getAttribute("username") == null || "".equals(request.getSession().getAttribute("username")))
        {
            return false;
        }
        return true;
    }

    /**
     * 弹出错误信息
     * @param message
     * @return
     */
    protected String showError(String message)
    {
        return showMessage(message , 1 ,null, "javascript:history(-1);" , 2250);
    }

    /**
     *  弹出错误信息
     * @param message
     * @param code
     * @return
     */
    protected String showError(String message , int code)
    {
        return showMessage(message , code , null,"javascript:history(-1);" , 2250);
    }

    /**
     * 弹出错误信息
     * @param message
     * @param url
     * @return
     */
    protected String showError(String message , String url)
    {
        return showMessage(message , 1 ,null, url , 2250);
    }

    /**
     * 弹出成功信息
     * @param data
     * @return
     */
    protected String showSuccess(Object data )
    {
        return showMessage(null , 0 ,data, request.getHeader("referer") , 2250);
    }




    /**
     * 弹出成功信息
     * @param data
     * @param url
     * @return
     */
    protected String showSuccess(String data , String url)
    {
        return showMessage(null , 0 ,data, url , 2250);
    }


}
