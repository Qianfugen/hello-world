package cn.qianfg.basedao;

/**
 * 基类,减少重复代码
 */

import cn.qianfg.dao.util.JDBCUtil;
import cn.qianfg.pojo.Emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BaseDao {
    protected Connection conn;
    protected PreparedStatement ps;
    protected ResultSet rs;

    /**
     * 增删改公共方法
     *
     * @param sql  sql语句
     * @param args 传入的参数
     * @return -1 执行不成功,>0 执行成功
     */
    public int update(String sql, ArrayList<Object> args) {
        int flag = -1;
        conn = JDBCUtil.getInstance().getConnection();
        try {
            ps = conn.prepareStatement(sql);
            if (args != null && args.size() != 0) {
                for (int i = 0; i < args.size(); i++) {
                    ps.setObject(i + 1, args.get(i));
                }
            }
            flag = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.getInstance().close(conn, ps, rs);
        }
        return flag;
    }


    /**
     * 查询公共方法
     *
     * @param sql  sql语句
     * @param args 传入的参数
     * @return 查询结果集合
     */
    public ArrayList<Emp> queryEmp(String sql, ArrayList<Object> args) {
        ArrayList<Emp> empList = new ArrayList<Emp>();
        conn = JDBCUtil.getInstance().getConnection();
        try {
            ps = conn.prepareStatement(sql);
            if (args != null && args.size() != 0) {
                for (int i = 0; i < args.size(); i++) {
                    ps.setObject(i + 1, args.get(i));
                }
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                Emp emp = new Emp();
                emp.setEmpNo(rs.getInt("empno"));
                emp.setEName(rs.getString("ename"));
                emp.setJob(rs.getString("job"));
                emp.setMgr(rs.getInt("mgr"));
                emp.setHireDate(rs.getDate("hiredate"));
                emp.setSal(rs.getDouble("sal"));
                emp.setComm(rs.getDouble("comm"));
                emp.setDeptno(rs.getInt("deptno"));
                empList.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.getInstance().close(conn, ps, rs);
        }
        return empList;
    }
}
