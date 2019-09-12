package com.qianfg;

import com.qianfg.dao.EmpDao;
import com.qianfg.dao.impl.EmpDaoImpl;
import com.qianfg.pojo.Emp;
import java.util.Date;
public class Test {
    public static void main(String[] args) {
        EmpDao ed=new EmpDaoImpl();
        Emp e=new Emp();
        e.setEmpNo(8883);
        e.setHireDate(new Date());
        e.setJob("学生");
        e.seteName("王小五");
        System.out.println(ed.addEmp(e));
    }
}
