package com.qianfg.dao;

import com.qianfg.pojo.Emp;
import com.qianfg.pojo.Query;

import java.util.List;

public interface EmpDao {
    /**
     * 添加员工
     */
    public int addEmp(Emp emp);
    /**
     * 根据empno删除员工
     */
    public int deleteEmp(int empNo);
    /**
     * 根据empno修改员工
     */
    public int updateEmp(Emp emp);
    /**
     * 根据empno查询员工
     */
    public Emp queryEmpById(int empNo);
    /**
     * 查询所有员工
     */
    public List<Emp> queryAllEmp();
    /**
     * 根据ename模糊查询员工,根据入职日期范围查询
     *      多个条件的解决方式:
     *          1. 提供一个专门做为查询条件的对象
     *          2. 使用Map集合
     */
    public List<Emp> queryEmpByLike(Query query);
}
