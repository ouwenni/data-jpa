package project170604.domain;

import javax.persistence.*;

/**
 * Created by lyp on 2017/6/3.
 */

@Entity
public class SysUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String username;
    private String cname;
    private String password;
    private String dept;
    private String role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public SysUser(String username, String cname, String password, String dept,String role) {
        this.username = username;
        this.cname = cname;
        this.password = password;
        this.dept = dept;
        this.role = role;
    }

    public SysUser() {
    }
}
