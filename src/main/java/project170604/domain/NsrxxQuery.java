package project170604.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;

/**
 * Created by lyp on 2017/6/8.
 */
public class NsrxxQuery {

    private String nsrsbh;
    private String nsrmc;
    private String dept;
    private String lrr;

    private String sfwj;

    private Date lrrq;

    public String getNsrsbh() {
        return nsrsbh;
    }

    public void setNsrsbh(String nsrsbh) {
        this.nsrsbh = nsrsbh;
    }

    public String getNsrmc() {
        return nsrmc;
    }

    public void setNsrmc(String nsrmc) {
        this.nsrmc = nsrmc;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getLrr() {
        return lrr;
    }

    public void setLrr(String lrr) {
        this.lrr = lrr;
    }

    public String getSfwj() {
        return sfwj;
    }

    public void setSfwj(String sfwj) {
        this.sfwj = sfwj;
    }

    public Date getLrrq() {
        return lrrq;
    }

    public void setLrrq(Date lrrq) {
        this.lrrq = lrrq;
    }

    public NsrxxQuery() {
    }

    public NsrxxQuery(String nsrsbh, String nsrmc, String dept, String lrr, String sfwj, Date lrrq) {
        this.nsrsbh = nsrsbh;
        this.nsrmc = nsrmc;
        this.dept = dept;
        this.lrr = lrr;
        this.sfwj = sfwj;
        this.lrrq = lrrq;
    }
}
