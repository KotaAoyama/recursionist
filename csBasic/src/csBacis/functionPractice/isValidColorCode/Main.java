package csBacis.functionPractice.isValidColorCode;

public class Main {
    public static boolean isValidColorCode(String colorCode) {
        return colorCode.matches("^#[0-9a-fA-F]{6}");
    }

    public static void main(String[] args) {
        System.out.println(isValidColorCode("#9E348B")); // true
        System.out.println(isValidColorCode("#9E348B0")); // false
        System.out.println(isValidColorCode("#9E348Z")); // false
        System.out.println(isValidColorCode("#63 482")); // false
        System.out.println(isValidColorCode("#6390%2")); // false
        System.out.println(isValidColorCode("#63#0E2")); // false
    }
}
