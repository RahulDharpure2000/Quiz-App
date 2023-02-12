/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.pojo;


public class UserProfile {
    private static String UserName;
    private static String UserType;

    public static String getUserName() {
        return UserName;
    }

    public static void setUserName(String UserName) {
        UserProfile.UserName = UserName;
    }

    public static String getUserType() {
        return UserType;
    }

    public static void setUserType(String UserType) {
        UserProfile.UserType = UserType;
    }
}
