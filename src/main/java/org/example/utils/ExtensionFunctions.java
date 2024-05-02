package org.example.utils;

public class ExtensionFunctions {

    // ANSI escape code for blue color
    public static final String ANSI_BLUE = "\u001B[34m";
    // ANSI escape code to reset color
    public static final String ANSI_RESET = "\u001B[0m";

    public static void logDebug(String message) {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String[] callingClassNameParts = stackTraceElements[2].getClassName().split("\\.");
        String callingClassName = callingClassNameParts[callingClassNameParts.length - 1];
        System.out.println(ANSI_BLUE + "LOG: [" + callingClassName + "] " + message + ANSI_RESET);
    }
}
