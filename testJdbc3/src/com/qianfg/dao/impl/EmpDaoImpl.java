package com.qianfg.dao.impl;

import com.qianfg.basedao.BaseDao;
import com.qianfg.dao.EmpDao;
import com.qianfg.pojo.Emp;
import com.qianfg.pojo.Query;
import com.qianfg.util.JDBCUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpDaoImpl extends BaseDao implements EmpDao {
    /**
     * 添加员工
     *
     * @param emp
     */
    @Override
    public int addEmp(Emp emp) {
        List<Object> args=new ArrayList<Object>();
        String sql="insert into emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) values(?,?,?,?,?,?,?,?)";
        args.add(emp.getEmpNo());
        args.add(emp.geteName());
        args.add(emp.getJob());
        args.add(emp.getMgr());
        args.add(new java.sql.Date(emp.getHireDate().getTime()));
        args.add(emp.getSal());
        args.add(emp.getComm());
        args.add(emp.getDeptNo());
        return update(sql,args);
    }
    /**
     * 根据empno删除员工
     *
     * @param empNo
     */
    @Override
    public int deleteEmp(int empNo) {
        List<Object> args=new ArrayList<Object>();
        String sql="delete from emp where empno=?";
        args.add(empNo);
        return update(sql,args);
    }
    /**
     * 根据empno修改员工
     *
     * @param emp
     */
    @Override
    public int updateEmp(Emp emp) {
        List<Object> args=new ArrayList<Object>();
        String sql="update emp set ename=?,job=?,mgr=?,hiredate=?,sal=?,comm=?,deptno=? where empno=?";
        args.add(emp.geteName());
        args.add(emp.getJob());
        args.add(emp.getMgr());
        args.add(new java.sql.Date(emp.getHireDate().getTime()));
        args.add(emp.getSal());
        args.add(emp.getComm());
        args.add(emp.getDeptNo());
        args.add(emp.getEmpNo());
        return update(sql,args);
    }
    @Override
    public Emp queryEmpById(int empNo) {// "12345 or 1=1"
        String sql="select * from emp where empno=?";
        List<Object> args=new ArrayList<Object>();
        args.add(empNo);
        List<Emp> es=query(sql,args);
        if(es.size()==1){
            return es.get(0);
        }
        return null;
    }
    /**
     * 查询所有员工
     */
    @Override
    public List<Emp> queryAllEmp() {
        String sql="select * from emp";
        return query(sql,null);
    }
    /**
     * 根据ename模糊查询员工,根据入职日期范围查询
     * 多个条件的解决方式:
     * 1. 提供一个专门做为查询条件的对象
     * 2. 使用Map集合
     */
    @Override
    public List<Emp> queryEmpByLike(Query query) {
        //存放sql语句中的参数
        List<Object> args=new ArrayList<Object>();
        String sql="select * from emp where 1=1";
        if(query.getQeName()!=null && !"".equals(query.getQeName())){
            sql+=" and ename like concat('%',concat(?,'%'))";
            args.add(query.getQeName());
        }
        if(query.getqStartHiredate()!=null){
            sql+=" and hiredate>?";
            args.add(new Date(query.getqStartHiredate().getTime()));
        }
        if(query.getqEndHiredate()!=null){
            sql+=" and hiredate<?";
            args.add(new Date(query.getqEndHiredate().getTime()));
        }
        return query(sql,args);
    }

    /**
     * 在该抽象方法中处理结果集,不同的dao类继承BaseDao都必须要重写该方法
     * 那个dao继承该类,那么结果集中的数据就是那个dao对应的表
     *
     *  1. 如果之类重写的父类中的方法,那么在次调用该方法的时候执行的是之类重写过后的方法
     */
    @Override
    public List<Emp> getResultObject(ResultSet rs) {
        List<Emp> es=new ArrayList<Emp>();
        try {
            while(rs.next()){
                Emp emp=new Emp();
                emp.setEmpNo(rs.getInt(1));//根据字段的序号从结果集中获取数据
                emp.seteName(rs.getString("enAmE"));//根据字段的名称获取结果集中数据
                emp.setJob(rs.getString("job"));
                emp.setMgr(rs.getInt("mgr"));
                emp.setHireDate(rs.getDate("hiredate"));
                emp.setSal(rs.getDouble("sal"));
                emp.setComm(rs.getDouble("comm"));
                emp.setDeptNo(rs.getInt("deptno"));
                es.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.init().close(conn,ps,rs);
        }
        return es;
    }
}
