package dao;

import com.spring.util.QueryConnection;
import net.jntoo.db.Query;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 数据库操作类
 */
public class CommDAO {
    /**
     * 获取链接类
     * @return
     */
    static public Connection getConn()
    {
        return new QueryConnection().getConnect();
    }

    /**
     * 根据sql语句查询一行数据
     * @param sql
     * @return
     */
    public HashMap find(String sql) {
        HashMap map = new HashMap();

        //List<HashMap> list = new ArrayList();
        try {
            Statement st = getConn().createStatement();
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                //HashMap map = new HashMap();
                int i = rsmd.getColumnCount();
                for (int j = 1; j <= i; j++) {
                    if (!rsmd.getColumnName(j).equals("ID")) {
                        String str = rs.getString(j) == null ? "" : rs.getString(j);
                        if (str.equals("null")) str = "";
                        map.put(rsmd.getColumnName(j), str);
                    } else
                        map.put("id", rs.getString(j));
                }
                //list.add(map);
                break;
            }
            rs.close();
            st.close();
            System.out.println(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
            int code = e.getErrorCode();
            String message = e.getMessage();
            System.err.println("SQL execute Error："+sql);
            System.err.println("code:"+code);
            System.err.println("Message:"+message);
        }
        return map;
    }

    /**
     * 执行sql
     * @param sql
     * @return
     */
    public long commOper(String sql) {

        long autoInsertId = -1;
        try {
            Statement st = getConn().createStatement();
            st.executeUpdate(sql , Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = st.getGeneratedKeys();
            while(rs.next()){
                autoInsertId = rs.getLong(1);
            }
            rs.close();
            st.close();
            System.out.println(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
            int code = e.getErrorCode();
            String message = e.getMessage();
            System.err.println("SQL execute Error："+sql);
            System.err.println("code:"+code);
            System.err.println("Message:"+message);
        }
        return autoInsertId;
    }


    /**
     *
     * @param sql
     * @return
     */
    public List<HashMap> select(String sql) {

        List<HashMap> list = new ArrayList();
        try {
            Statement st = getConn().createStatement();
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();

            while (rs.next()) {
                HashMap map = new HashMap();
                int i = rsmd.getColumnCount();
                for (int j = 1; j <= i; j++) {
                    if (!rsmd.getColumnName(j).equals("ID")) {
                        String str = rs.getString(j) == null ? "" : rs.getString(j);
                        if (str.equals("null")) str = "";
                        map.put(rsmd.getColumnName(j), str);
                    } else
                        map.put("id", rs.getString(j));
                }
                list.add(map);
            }
            rs.close();
            st.close();
            System.out.println(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            if (sql.equals("show tables"))
                list = select("select table_name from   INFORMATION_SCHEMA.tables");
            else{
                int code = e.getErrorCode();
                String message = e.getMessage();
                System.err.println("SQL execute Error："+sql);
                System.err.println("code:"+code);
                System.err.println("Message:"+message);
            }
            //e.printStackTrace();
        }
        return list;
    }
}
