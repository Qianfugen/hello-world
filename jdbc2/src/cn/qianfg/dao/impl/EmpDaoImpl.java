package cn.qianfg.dao.impl;

import cn.qianfg.dao.EmpDao;
import cn.qianfg.pojo.Emp;
import cn.qianfg.pojo.Query;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class EmpDaoImpl implements EmpDao {
    private Connection conn;//连接oracle
    private PreparedStatement ps;//sql语句
    private ResultSet rs;//返回结果集


    /**
     * 添加员工
     */
    @Override
    public int addEmp(Emp emp) {
        int flag = -1;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@10.1.13.44:1522:orcl", "qianfg", "123456");
            String sql = "insert into emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) values(?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, emp.getEmpNo());
            ps.setString(2, emp.getEName());
            ps.setString(3, emp.getJob());
            ps.setInt(4, emp.getMgr());
            ps.setDate(5, new java.sql.Date(emp.getHireDate().getTime()));
            ps.setDouble(6, emp.getSal());
            ps.setDouble(7, emp.getComm());
            ps.setInt(8, emp.getDeptno());
            flag = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
        return flag;
    }

    /**
     * 根据empno删除员工
     */
    public int deleteEmp(int empno) {
        int flag = -1;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@10.1.13.44:1522:orcl", "qianfg", "123456");
            String sql = "delete from emp where empno=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, empno);
            flag = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
        return flag;
    }

    /**
     * 根据empno修改员工
     */
    public int updateEmp(Emp emp) {
        int flag = -1;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@10.1.13.44:1522:orcl", "qianfg", "123456");
            String sql = "update emp set ename=?,job=?,mgr=?,hiredate=?,sal=?,comm=?,deptno=? where empno=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, emp.getEName());
            ps.setString(2, emp.getJob());
            ps.setInt(3, emp.getMgr());
            ps.setDate(4, new java.sql.Date(emp.getHireDate().getTime()));
            ps.setDouble(5, emp.getSal());
            ps.setDouble(6, emp.getComm());
            ps.setInt(7, emp.getDeptno());
            ps.setInt(8, emp.getEmpNo());
            flag = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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

        return flag;
    }

    /**
     * 根据empno查询员工
     */
    @Override
    public Emp queryEmpById(int empNo) {
        Emp emp = new Emp();
        try {
            //第一步:加载驱动类
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //第二步:发送用户名密码,获取数据库连接
            conn = DriverManager.getConnection("jdbc:oracle:thin:@10.1.13.44:1522:orcl", "qianfg", "123456");
            //第三步:发送sql语句,处理执行结果,?表示占位符
            String sql = "select * from emp where empno=?";
            ps = conn.prepareStatement(sql);
            //给sql中的占位符绑定值
            ps.setInt(1, empNo);
            //接收返回结果
            rs = ps.executeQuery();
            rs.next();
            //创建Emp对象,用来承载该行数据
            emp.setEmpNo(rs.getInt("empno"));
            emp.setEName(rs.getString("ename"));
            emp.setJob(rs.getString("job"));
            emp.setMgr(rs.getInt("mgr"));
            emp.setHireDate(rs.getDate("hiredate"));
            emp.setSal(rs.getDouble("sal"));
            emp.setComm(rs.getDouble("comm"));
            emp.setDeptno(rs.getInt("deptno"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
        return emp;
    }

    /**
     * 查询所有员工
     */
    @Override
    public ArrayList<Emp> queryAllEmp() {
        ArrayList<Emp> empList = new ArrayList<Emp>();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@10.1.13.44:1522:orcl", "qianfg", "123456");
            String sql = "select * from emp";
            ps = conn.prepareStatement(sql);
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
        return empList;
    }

    /**
     * 根据ename模糊查询员工
     */
    public ArrayList<Emp> queryEmpByLike(Query query) {
        ArrayList<Object> args = new ArrayList<Object>();
        ArrayList<Emp> empList = new ArrayList<Emp>();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@10.1.13.44:1522:orcl", "qianfg", "123456");
            String sql = "select * from emp where 1=1 ";
            if (query.getQeName() != null && !"".equals(query.getQeName())) {
                sql += " and ename like concat('%',concat(?,'%'))";
                args.add(query.getQeName());
            }
            if (query.getStartHiredate() != null) {
                sql += " and hiredate>?";
                args.add(new java.sql.Date(query.getStartHiredate().getTime()));
            }
            if (query.getEndHiredate() != null) {
                sql += " and hiredate<?";
                args.add(new java.sql.Date(query.getEndHiredate().getTime()));
            }
            System.out.println(sql);
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.size(); i++) {
                ps.setObject(i + 1, args.get(i));
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
        return empList;
    }
}

