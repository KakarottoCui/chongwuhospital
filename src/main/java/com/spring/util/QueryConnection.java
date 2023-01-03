package com.spring.util;

import com.spring.BootApplication;
import net.jntoo.annotation.JdbcConnection;
import net.jntoo.annotation.RequestJdbcConnection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;

@JdbcConnection
public class QueryConnection {

    static private Connection conn = null;
    // 让jntoo-query 获取链接
    @RequestJdbcConnection
    public Connection getConnect()
    {
        try{
            if(conn == null || conn.isClosed()){
                DataSource source = BootApplication.content.getBean(DataSource.class);
                Connection connection = source.getConnection();

                //System.out.println(connection);
                conn = connection;
            }
        }catch (Exception e){
            System.err.println("链接数据库出错");
        }
        return conn;
    }
}
