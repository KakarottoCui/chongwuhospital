package util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取前端提交的参数
 */
public class Request {

    /**
     * 获取HttpServletRequest 类的实体
     * @return
     */
    static public HttpServletRequest getRequest()
    {
        return ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
    }
    /**
     * 获取HttpServletResponse 类的实体
     * @return
     */
    static public HttpServletResponse getResponse()
    {
        return ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getResponse();
    }


    /**
     * 获取参数
     * @param name
     * @return
     */
    static public String get(String name)
    {
        String[] value = getRequest().getParameterValues(name);
        return value == null || value.length==0 ? "" : StringUtil.join(",",value);
    }
    /**
     * 获取URL 整数参数，默认为0
     * @param name
     * @return
     */
    static public int getInt(String name)
    {
        String value = get(name , "0");
        return value.equals("") ? 0 : Integer.valueOf(value).intValue();
    }
    /**
     * 获取URL 整数参数，默认为0
     * @param name
     * @param def 默认值
     * @return
     */
    static public int getInt(String name , int def)
    {
        String value = get(name , String.valueOf(def));
        return value.equals("") ? def : Integer.valueOf(value).intValue();
    }

    /**
     * 获取URL 浮点数参数
     * @param name
     * @return
     */
    static public double getDouble(String name)
    {
        String value = get(name , "0");
        return value.equals("") ? 0.0f : Double.valueOf(value).doubleValue();
    }

    /**
     * 获取URL 浮点数参数
     * @param name
     * @param def 默认值
     * @return
     */
    static public double getDouble(String name , double def)
    {
        String value = get(name , String.valueOf(def));
        return value.equals("") ? 0.0f : Double.valueOf(value).doubleValue();
    }



    /**
     * 获取Url 字符串参数
     * @param name
     * @param def 默认值
     * @return
     */
    static public String get(String name, String def)
    {
        if(def == null)
        {
            def = "";
        }
        String[] value = getRequest().getParameterValues(name);
        return value == null || value.length==0 ? def : StringUtil.join(",",value);
    }
}
