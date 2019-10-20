package com.example.takeout.entity;

import java.io.Serializable;

/**
 * admin
 * @author 
 */
public class Admin implements Serializable {
    private Integer adminId;

    private String adminUser;

    private String adminPass;

    private static final long serialVersionUID = 1L;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(String adminUser) {
        this.adminUser = adminUser;
    }

    public String getAdminPass() {
        return adminPass;
    }

    public void setAdminPass(String adminPass) {
        this.adminPass = adminPass;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Admin other = (Admin) that;
        return (this.getAdminId() == null ? other.getAdminId() == null : this.getAdminId().equals(other.getAdminId()))
            && (this.getAdminUser() == null ? other.getAdminUser() == null : this.getAdminUser().equals(other.getAdminUser()))
            && (this.getAdminPass() == null ? other.getAdminPass() == null : this.getAdminPass().equals(other.getAdminPass()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAdminId() == null) ? 0 : getAdminId().hashCode());
        result = prime * result + ((getAdminUser() == null) ? 0 : getAdminUser().hashCode());
        result = prime * result + ((getAdminPass() == null) ? 0 : getAdminPass().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", adminId=").append(adminId);
        sb.append(", adminUser=").append(adminUser);
        sb.append(", adminPass=").append(adminPass);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}