package cn.qianfg.pojo;

import java.util.Date;

public class Emp {
    /**
     * emp表对应的实体类
     */
    private int empNo;//编号
    private String eName;//姓名
    private String job;//岗位
    private int mgr;//上司
    private Date hireDate;//入职日期
    private double sal;//薪资
    private double comm;//奖金
    private int deptno;//部门编号

    /**
     * get/set方法
     */
    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getEName() {
        return eName;
    }

    public void setEName(String eName) {
        this.eName = eName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getMgr() {
        return mgr;
    }

    public void setMgr(int mgr) {
        this.mgr = mgr;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public double getComm() {
        return comm;
    }

    public void setComm(double comm) {
        this.comm = comm;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    @Override
    public String toString() {
        return "编号:" + empNo + "\n姓名:" + eName + "\n岗位:" + job + "\n上司:" + mgr
                + "\n入职日期:" + hireDate + "\n薪资:" + sal + "\n奖金:" + comm + "\n部门编号:" + deptno;
    }
}
