package com.sl.tackout.pojo;

import lombok.Data;

import java.util.Date;

/**
 * Created by happy on 2019/8/21.
 */
@Data
public class UserTable {
    private int userId;//用户id
    private String userName;//用户名
    private String userPwd;//用户密码
    private String userPhone;//用户手机号
    private Date userCreatTime;//用户创建时间
    private String userPhoto;//用户头像

    @Override
    public String toString() {
        return "UserTable{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userCreatTime=" + userCreatTime +
                ", userPhoto='" + userPhoto + '\'' +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Date getUserCreatTime() {
        return userCreatTime;
    }

    public void setUserCreatTime(Date userCreatTime) {
        this.userCreatTime = userCreatTime;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public UserTable(int userId, String userName, String userPwd, String userPhone, Date userCreatTime, String userPhoto) {

        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userPhone = userPhone;
        this.userCreatTime = userCreatTime;
        this.userPhoto = userPhoto;
    }

    public UserTable() {

    }
}
