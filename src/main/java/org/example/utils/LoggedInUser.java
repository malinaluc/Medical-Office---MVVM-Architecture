package org.example.utils;

public class LoggedInUser {
    private Integer idUserLoggedIn;
    private String username;
    private String password;

    public LoggedInUser(Integer idUserLoggedIn, String username, String password) {
        this.idUserLoggedIn = idUserLoggedIn;
        this.username = username;
        this.password = password;
    }

    public Integer getIdUserLoggedIn() {
        return idUserLoggedIn;
    }

    public void setIdUserLoggedIn(Integer idUserLoggedIn) {
        this.idUserLoggedIn = idUserLoggedIn;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
