package csBacis.stringMethods;

public class Main {
    public static String toUpperCase(String s){
        return s.toUpperCase();
    }

    public static String toLowerCase(String s) {
        return s.toLowerCase();
    }

    public static String deleteAt(String s, int i){
        if (i > s.length() || i == 0) return s;
        else if (i == s.length()) return s.substring(0, i-1);
        else return s.substring(0, i-1) + s.substring(i);
    }

    public static int getAtLocation(String email) {
        return email.contains("@") ? email.indexOf("@") + 1 : email.indexOf("@");
    }

    public static String replaceWithChar(String s, char letter) {
        String strLetter = String.valueOf(letter);
        return s.replace(strLetter, "");
    }

    public static void main(String[] args) {
        System.out.println(toUpperCase("Albert"));
        System.out.println(toLowerCase("Albert"));
        System.out.println(deleteAt("abcdefg", 3));
        System.out.println(deleteAt("abcdefg", 11));
        System.out.println(deleteAt("abcdefg", 7));
        System.out.println(getAtLocation("yeah@example.com"));
        System.out.println(getAtLocation("yeah"));
        System.out.println(replaceWithChar("Yeahhhhhh!!", 'h'));
    }
}
