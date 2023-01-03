package com.spring.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import dao.Query;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import util.Info;

import java.util.Map;

public class TokenInterceptor implements  HandlerInterceptor {
    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        String token = request.getHeader("token");
        if(token != null && !token.equals("") && request.getSession().getAttribute("id") == null)
        {
            HttpSession session = request.getSession();
            //处理session
            Map<String , String> tokenInfo = Query.make("token").where("token" , token).where("token_time" , ">" , Info.getDateStr()).find();
            if(!tokenInfo.isEmpty()){
                session.setAttribute("cx" , tokenInfo.get("cx"));
                session.setAttribute("login" , tokenInfo.get("login"));
                session.setAttribute("username" , tokenInfo.get("username"));
                session.setAttribute("id" , tokenInfo.get("id"));
                JSONObject session1 = JSON.parseObject(tokenInfo.get("session"));
                for( Map.Entry<String , Object> entry :session1.entrySet())
                {
                    session.setAttribute(entry.getKey() , entry.getValue());
                }
            }
        }
        return true;//如果设置为false时，被请求时，拦截器执行到此处将不会继续操作
        //如果设置为true时，请求将会继续执行后面的操作
    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
//         System.out.println("执行了TestInterceptor的postHandle方法");
    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
//        System.out.println("执行了TestInterceptor的afterCompletion方法");
    }
}
