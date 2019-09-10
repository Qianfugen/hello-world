package cn.qianfg.menu;

import cn.qianfg.dao.EmpDao;
import cn.qianfg.dao.impl.EmpDaoImpl;
import cn.qianfg.pojo.Emp;
import cn.qianfg.pojo.Query;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    EmpDao ed = new EmpDaoImpl();
    Scanner input = new Scanner(System.in);

    public void mainMenu() {
        System.out.println("************员工管理系统*************");
        System.out.println("1.添加员工\n2.删除员工\n3.修改信息\n4.查询员工\n0.退出");
        System.out.println("请输入您的选择(0-4):");
        int option = input.nextInt();
        switch (option) {
            case 1:
                addMenu();
                break;
            case 2:
                deleteMenu();
                break;
            case 3:
                updateMenu();
                break;
            case 4:
                queryMenu();
                break;
            case 0:
                System.exit(0);
            default:
                break;
        }
    }

    /**
     * 增加菜单
     */
    public void addMenu() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Emp emp = new Emp();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入编号:");
        emp.setEmpNo(input.nextInt());
        System.out.println("请输入姓名:");
        emp.setEName(input.next());
        System.out.println("请输入岗位:");
        emp.setJob(input.next());
        System.out.println("请输入上司编号:");
        emp.setMgr(input.nextInt());
        System.out.println("请输入入职日期(yyyy-mm-dd):");
        try {
            emp.setHireDate(sdf.parse(input.next()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("请输入薪资:");
        emp.setSal(input.nextDouble());
        System.out.println("请输入奖金:");
        emp.setComm(input.nextDouble());
        System.out.println("请输入部门编号:");
        emp.setDeptno(input.nextInt());

        int flag = ed.addEmp(emp);
        if (flag > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    /**
     * 删除菜单
     */
    public void deleteMenu() {
        System.out.println("请输入要删除的员工编号");
        int empNo = input.nextInt();
        int flag = ed.deleteEmp(empNo);
        if (flag > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    /**
     * 修改菜单
     */
    public void updateMenu() {
        System.out.println("请输入要修改的员工编号");
        int empNo = input.nextInt();
        Emp emp = ed.queryEmpById(empNo);
        System.out.println("修改前:");
        System.out.println(emp);
        System.out.println("请输入要修改的工资:");
        double sal = input.nextDouble();
        emp.setSal(sal);
        int flag = ed.updateEmp(emp);
        if (flag > 0) {
            System.out.println("修改成功");
            System.out.println("修改后的信息");
            System.out.println(emp);
        } else {
            System.out.println("修改失败");
        }
    }

    public void queryMenu() {
        System.out.println("请输入要采用哪种查询:");
        System.out.println("1.编号查询\n2.查询所有\n3.模糊查询\n0.退出");
        int option = input.nextInt();
        switch (option) {
            case 1:
                System.out.println("请输入要查询的员工编号");
                int empNo = input.nextInt();
                Emp emp = ed.queryEmpById(empNo);
                System.out.println(emp);
                break;
            case 2:
                ArrayList<Emp> empList = new ArrayList<Emp>();
                empList = ed.queryAllEmp();
                for (Emp e : empList) {
                    System.out.println(e);
                    System.out.println("********************************");
                }
                break;
            case 3:
                ArrayList<Emp> empList2 = new ArrayList<Emp>();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Query query = new Query();
                System.out.println("姓名包含那个字:");
                String s = input.next();
                query.setQeName(s);
                System.out.println("开始日期(yyyy-MM-dd):");
                String startDate = input.next();
                System.out.println("结束日期(yyyy-MM-dd):");
                String endDate = input.next();
                try {
                    query.setStartHiredate(sdf.parse(startDate));
                    query.setEndHiredate(sdf.parse(endDate));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                empList2 = ed.queryEmpByLike(query);
                System.out.println("共查询到人数:" + empList2.size());
                for (Emp emp2 : empList2) {
                    System.out.println(emp2);
                    System.out.println("**************************************");
                }
            case 0:
                System.exit(0);
            default:
                break;
        }
    }

}
