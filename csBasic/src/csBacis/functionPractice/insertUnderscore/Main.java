package csBacis.functionPractice.insertUnderscore;

public class Main {
    public static String insertUnderscoreAt(String s, int i){
        if (s.length() <= i) return s;
        return s.substring(0, i) + "_" + s.substring(i);
    }

    public static void main(String[] args) {
        System.out.println(insertUnderscoreAt("Yes we can!", 3));
    }
}
