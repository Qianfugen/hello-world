package cn.qianfg.dao.util;
/**
 * 工具类,减少重复代码
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {
    //饿汉模式
    /*
    private static JDBCUtil instance=new JDBCUtil();
    private JDBCUtil(){
    }
    public static JDBCUtil getInstance(){
        return instance;
    }
     */
    //懒汉模式
    private static JDBCUtil instance;

    private JDBCUtil() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static synchronized JDBCUtil getInstance() {
        if (instance == null) {
            instance = new JDBCUtil();
        }
        return instance;
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@10.1.13.44:1522:orcl", "qianfg", "123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
