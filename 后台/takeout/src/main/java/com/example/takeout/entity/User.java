package com.example.takeout.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * user
 * @author 
 */
public class User implements Serializable {
    /**
     * 用户主键
     */
    private Integer userId;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户邮箱
     */
    private String userEmail;

    /**
     * 用户密码
     */
    private String userPass;

    /**
     * 用户级别
     */
    private Integer userLevel;

    /**
     * 用户状态
     */
    private int userStatus;

    /**
     *
     */
    private BigDecimal balance;

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPass='" + userPass + '\'' +
                ", userLevel=" + userLevel +
                ", userStatus=" + userStatus +
                ", balance=" + balance +
                '}';
    }
}