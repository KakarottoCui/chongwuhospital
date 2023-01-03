package util.tld;

import dao.CommDAO;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;

/**
 * jsp 页面ssm:sql 执行SQL语句
 */
public class QuerySql extends SimpleTagSupport {

    private String var;
    private String type;
    public String getVar() {
        return var;
    }
    public void setVar(String var) {
        this.var = var;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspFragment jf = this.getJspBody();
        PageContext context = (PageContext)jf.getJspContext();
        StringWriter sw = new StringWriter();
        jf.invoke(sw);
        String sql = sw.getBuffer().toString();


        if(type.equals("select")){
            List<HashMap> list = new CommDAO().select(sql);
            context.setAttribute(var , list , PageContext.REQUEST_SCOPE);
        }else if(type.equals("find")){
            HashMap list = new CommDAO().find(sql);
            context.setAttribute(var , list , PageContext.REQUEST_SCOPE);
        }
        //jf.invoke(null);
    }
}
