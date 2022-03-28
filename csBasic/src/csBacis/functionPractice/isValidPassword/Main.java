package csBacis.functionPractice.isValidPassword;

import java.util.regex.Pattern;

public class Main {
    public static boolean isValidPassword(String password) {
        boolean spaceCondition = !password.contains(" ");
        boolean lengthCondition = password.length() >= 6;
        boolean numberCondition = Pattern.matches("(.*)(\\d+)(.*)", password);
        boolean caseCondition = !password.equals(password.toUpperCase()) && !password.equals(password.toLowerCase());

        return spaceCondition && lengthCondition && numberCondition && caseCondition;
    }

    public static void main(String[] args) {
        System.out.println(isValidPassword("Aa 12E4")); // --> false
        System.out.println(isValidPassword("abe12cd")); // --> false
        System.out.println(isValidPassword("ABE12CD")); // --> false
        System.out.println(isValidPassword("AaBbCcD")); // --> false
        System.out.println(isValidPassword("Aa1")); // --> false
        System.out.println(isValidPassword("AaBbcC23")); // --> true
        System.out.println(isValidPassword("AaBbcC123")); // --> true
    }
}
