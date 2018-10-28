package cn.pzhu.util;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Properties;

public class DBCPUtil {

    private static DataSource ds = null;

    static {
        /*DBCPUtil.class.getClassLoader().getResourceAsStream("dbcpconfig.properties")*/
        Properties prop = new Properties();
        try {
            prop.load(DBCPUtil.class.getClassLoader().getResourceAsStream("dbcpconfig.properties"));
            ds = BasicDataSourceFactory.createDataSource(prop);

        } catch (Exception e) {
            //throw new ExceptionInInitializerError("初始化错误，请检查配置文件！");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
           // System.out.println("Connection:"+ds);
            return ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("服务器忙");
        }
    }

    public static void release(Connection conn, Statement stmt, ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if(stmt!=null){
            try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            stmt = null;
        }
        if(conn!=null){
            try {
                conn.close();//关闭
            } catch (Exception e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }
}
