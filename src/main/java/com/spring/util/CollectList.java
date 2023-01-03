package com.spring.util;

import net.jntoo.annotation.QueryCollect;
import net.jntoo.db.Collect;
import util.Request;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * 根据库jntoo-query.jar要求写代码
 */
@QueryCollect
public class CollectList extends Collect {

    protected HttpServletRequest request;

    public CollectList(Long count, Integer pagesize) {
        super(count , pagesize);
    }

    public CollectList(Long count, Integer pagesize, Integer page)
    {
        super(count, pagesize, page);
    }

    /**
     * 获取url 规则
     * @return
     */
    @Override
    protected String getRequestUrlPath() {
        request = Request.getRequest();
        String queryString = request.getQueryString();
        if(queryString == null){
            queryString = "";
        }
        StringBuffer buffer = new StringBuffer(queryString.length()+16);
        String requestURI = request.getRequestURI();
        buffer.append(requestURI).append("?");
        Map<String,String[]> param = request.getParameterMap();
        String name = "";
        String value = "";
        boolean isSearchPage = false;
        int page = -1;

        for (Map.Entry<String, String[]> entry : param.entrySet()) {
            try{
                name = entry.getKey();
                String[] values = entry.getValue();

                if(name.equals("page")){
                    page = Integer.valueOf(values[0]).intValue();
                    buffer.append(name).append("=").append("{page}").append("&");
                    isSearchPage = true;
                } else if (null == values) {
                    buffer.append(name).append("=").append("&");
                } else if (values.length>1) {
                    for (int i = 0; i < values.length; i++) { //用于请求参数中有多个相同名称
                        value = URLEncoder.encode(values[i] , "UTF-8");
                        buffer.append(name).append("=").append(value).append("&");
                    }
                    //value = value.substring(0, value.length() - 1);
                } else {
                    value = URLEncoder.encode(values[0] , "UTF-8");
                    buffer.append(name).append("=").append(value).append("&");//用于请求参数中请求参数名唯一
                }
            }catch (UnsupportedEncodingException e){
                e.printStackTrace();
            }
        }
        if(this.page == -1){
            this.page = page;
        }
        this.page = Math.max(this.page , 1);

        if(!isSearchPage){
            buffer.append("page={page}&");
        }
        String result = buffer.toString();
        return result.substring(0 , result.length()-1);
    }

    /**
     * 分页渲染完成后处理
     */
    @Override
    protected void readerReady() {
        String info = getInfo();
        HashMap map = new HashMap();
        map.put("info" , info);
        request.setAttribute("page" , map);
        request.setAttribute("totalCount" , count);
    }
}
