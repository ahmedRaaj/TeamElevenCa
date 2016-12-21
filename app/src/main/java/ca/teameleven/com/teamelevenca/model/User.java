package ca.teameleven.com.teamelevenca.model;

/**
 * Created by ahmedraaj on 21/12/16.
 */

public class User {
    private int userId;
    private  String userName;
    private String userType;

    public User(int userId, String userName, String userType) {
        this.userId = userId;
        this.userName = userName;
        this.userType = userType;
    }

    public int getuserId() {
        return userId;

    }

    public void setuserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }
}
