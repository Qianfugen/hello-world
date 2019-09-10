package cn.qianfg.dao;
/**
 * 增删改查接口
 */

import cn.qianfg.pojo.Emp;
import cn.qianfg.pojo.Query;

import java.util.ArrayList;

public interface EmpDao {
    /**
     * 添加员工
     */
    public int addEmp(Emp emp);

    /**
     * 根据empno删除员工
     */
    public int deleteEmp(int empno);

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
    public ArrayList<Emp> queryAllEmp();
    /**
     * 根据ename模糊查询员工
     */
    public ArrayList<Emp> queryEmpByLike(Query query);

}
