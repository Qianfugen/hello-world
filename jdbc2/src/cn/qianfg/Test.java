package cn.qianfg;

import cn.qianfg.dao.EmpDao;
import cn.qianfg.dao.impl.EmpDaoImpl;
import cn.qianfg.pojo.Emp;
import cn.qianfg.pojo.Query;

import java.net.StandardSocketOptions;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        EmpDao ed = new EmpDaoImpl();
        //测试queryEmpById
//        Emp emp = ed.queryEmpById(7396);
//        System.out.println(emp);

        //查询所有员工
//        ArrayList<Emp> empList = new ArrayList<Emp>();
//        empList = ed.queryAllEmp();
//        for (Emp e : empList) {
//            System.out.println(e);
//            System.out.println("********************************");
//        }

        //添加
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Emp emp = new Emp();
//        Scanner input = new Scanner(System.in);
//        System.out.println("请输入编号:");
//        emp.setEmpNo(input.nextInt());
//        System.out.println("请输入姓名:");
//        emp.setEName(input.next());
//        System.out.println("请输入岗位:");
//        emp.setJob(input.next());
//        System.out.println("请输入上司编号:");
//        emp.setMgr(input.nextInt());
//        System.out.println("请输入入职日期(yyyy-mm-dd):");
//        try {
//            emp.setHireDate(sdf.parse(input.next()));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        System.out.println("请输入薪资:");
//        emp.setSal(input.nextDouble());
//        System.out.println("请输入奖金:");
//        emp.setComm(input.nextDouble());
//        System.out.println("请输入部门编号:");
//        emp.setDeptno(input.nextInt());
//
//        int flag = ed.addEmp(emp);
//        if (flag > 0) {
//            System.out.println("添加成功");
//        } else {
//            System.out.println("添加失败");
//        }

        //删除员工
//        int flag = ed.deleteEmp(1000);
//        if (flag > 0) {
//            System.out.println("删除成功");
//        } else {
//            System.out.println("删除失败");
//        }

        //修改员工
//        Emp emp = ed.queryEmpById(7369);
//        System.out.println(emp);
//        emp.setSal(1000.00);
//        int flag = ed.updateEmp(emp);
//        if (flag > 0) {
//            System.out.println("修改成功");
//        } else {
//            System.out.println("修改失败");
//        }

        //模糊查询
        ArrayList<Emp> empList = new ArrayList<Emp>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Query query = new Query();
        query.setQeName("S");
        try {
            query.setStartHiredate(sdf.parse("1980-01-01"));
            query.setEndHiredate(sdf.parse("1982-01-01"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        empList = ed.queryEmpByLike(query);
        System.out.println("共查询到人数:" + empList.size());
        for (Emp emp : empList) {
            System.out.println(emp);
            System.out.println("**************************************");
        }


    }
}
