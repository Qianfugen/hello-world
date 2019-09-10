package cn.qianfg.dao.impl;

import cn.qianfg.basedao.BaseDao;
import cn.qianfg.dao.EmpDao;
import cn.qianfg.pojo.Emp;
import cn.qianfg.pojo.Query;

import java.util.ArrayList;

public class EmpDaoImpl extends BaseDao implements EmpDao {
    /**
     * 添加员工
     */
    @Override
    public int addEmp(Emp emp) {
        ArrayList<Object> args = new ArrayList<Object>();
        String sql = "insert into emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) values(?,?,?,?,?,?,?,?)";
        args.add(emp.getEmpNo());
        args.add(emp.getEName());
        args.add(emp.getJob());
        args.add(emp.getMgr());
        args.add(new java.sql.Date(emp.getHireDate().getTime()));
        args.add(emp.getSal());
        args.add(emp.getComm());
        args.add(emp.getDeptno());
        return update(sql, args);
    }

    /**
     * 根据empno删除员工
     */
    public int deleteEmp(int empno) {
        ArrayList<Object> args = new ArrayList<Object>();
        String sql = "delete from emp where empno=?";
        args.add(empno);
        return update(sql, args);
    }

    /**
     * 根据empno修改员工
     */
    public int updateEmp(Emp emp) {
        ArrayList<Object> args = new ArrayList<Object>();
        String sql = "update emp set ename=?,job=?,mgr=?,hiredate=?,sal=?,comm=?,deptno=? where empno=?";
        args.add(emp.getEName());
        args.add(emp.getJob());
        args.add(emp.getMgr());
        args.add(new java.sql.Date(emp.getHireDate().getTime()));
        args.add(emp.getSal());
        args.add(emp.getComm());
        args.add(emp.getDeptno());
        args.add(emp.getEmpNo());
        return update(sql, args);
    }

    /**
     * 根据empno查询员工
     */
    @Override
    public Emp queryEmpById(int empNo) {
        Emp emp = null;
        ArrayList<Object> args = new ArrayList<Object>();
        ArrayList<Emp> empList = new ArrayList<Emp>();
        String sql = "select * from emp where empno=?";
        args.add((Object) empNo);
        empList = queryEmp(sql, args);
        if (empList != null && empList.size() != 0) {
            emp = empList.get(0);
        }
        return emp;
    }

    /**
     * 查询所有员工
     */
    @Override
    public ArrayList<Emp> queryAllEmp() {
        String sql = "select * from emp";
        return queryEmp(sql, null);
    }

    /**
     * 根据ename模糊查询员工
     */
    public ArrayList<Emp> queryEmpByLike(Query query) {
        ArrayList<Object> args = new ArrayList<Object>();
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

        return queryEmp(sql, args);
    }
}

