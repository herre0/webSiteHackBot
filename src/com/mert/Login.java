package com.mert;


import java.util.ArrayList;
import java.util.List;

public class Login {
    String username;
    String paswd;

    public Login() {
    }

    public Login(String username, String paswd) {
        this.username = username;
        this.paswd = paswd;
    }

    public static List<Login> getSqlInjectionCredentials() {
        List<Login> sqlCredentials = new ArrayList<>();
        sqlCredentials.add(new Login("1' OR 1=1 #","123456"));

        return sqlCredentials;
    }

      public static String getBaseUrlByIndex(int index) {
        List<String> baseUrls = new ArrayList<>();
        baseUrls.add("file:///C:/Users/mert/Desktop/Projects/LoginPage/login.html");
        baseUrls.add("https://pusula.beykent.edu.tr/giris.html");
        baseUrls.add("https://github.com/login");
        baseUrls.add("https://www.hackerrank.com/auth/login?h_l=body_middle_left_button&h_r=login");

        return baseUrls.get(index);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPaswd() {
        return paswd;
    }

    public void setPaswd(String paswd) {
        this.paswd = paswd;
    }

























































    public static List<Login> getLoginCredentials() {
        List<Login> loginCredentials = new ArrayList<>();
        loginCredentials.add(new Login("mertkabadayii@hotmail.com","Xperiamiro1+"));//github
        loginCredentials.add(new Login("mert12@gmail.com","123456"));
        loginCredentials.add(new Login("mertkabadayii@hotmail.com","xperiamiro1"));//hackerrank
        loginCredentials.add(new Login("17030220011","Zbeyn10."));//pusula
        loginCredentials.add(new Login("zbeyn2015@hotmail.com","xperiamiro"));//udemy
        loginCredentials.add(new Login("tarikgidis@gmail.com","123456"));
        loginCredentials.add(new Login("torosmahal_33@gmail.com","123456"));
        loginCredentials.add(new Login("cahitsokak2@gmail.com","123456"));
        loginCredentials.add(new Login("alikaplan33@gmail.com","123456"));
        loginCredentials.add(new Login("17deppjo@gmail.com","123456"));
        loginCredentials.add(new Login("admin","12345"));

        return loginCredentials;
    }
}
