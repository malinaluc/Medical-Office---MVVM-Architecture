package org.example.utils;

public class SessionManager {
    private static LoggedInUser loggedInUser;

    public static void loginUser(Integer loggedInUserID, String username, String password) {
        loggedInUser = new LoggedInUser(loggedInUserID, username, password);
    }

    public static LoggedInUser getLoggedInUser() {
        return loggedInUser;
    }


    public static void logOutUser() {
        loggedInUser = null;
    }

}
