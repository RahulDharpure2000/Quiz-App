
package techquizapp.pojo;


public class User {
    private String UserId;
    private String Password;
    private String UserType;

    @Override
    public String toString() {
        return "User{" + "UserId=" + UserId + ", Password=" + Password + ", UserType=" + UserType + '}';
    }
   

    public User() {
    }

    public User(String UserName, String Password, String UserType) {
        this.UserId = UserName;
        this.Password = Password;
        this.UserType = UserType;
    }
    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String UserType) {
        this.UserType = UserType;
    }
   
    
}
