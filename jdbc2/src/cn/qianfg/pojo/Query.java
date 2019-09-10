package cn.qianfg.pojo;

import java.util.Date;

public class Query {
    private String qeName;
    private Date startHiredate;
    private Date endHiredate;

    public String getQeName() {
        return qeName;
    }

    public void setQeName(String qeName) {
        this.qeName = qeName;
    }

    public Date getStartHiredate() {
        return startHiredate;
    }

    public void setStartHiredate(Date startHiredate) {
        this.startHiredate = startHiredate;
    }

    public Date getEndHiredate() {
        return endHiredate;
    }

    public void setEndHiredate(Date endHiredate) {
        this.endHiredate = endHiredate;
    }
}
