package csMiddle.recursion.reverseString;

public class Main {
    public static String reverseString(String string){
        if (string.length() <= 1) return string;

        String left = string.substring(0, string.length()-1);
        return string.charAt(string.length()-1) + reverseString(left);
    }

    public static void main(String[] args) {
        System.out.println(reverseString("We can do it!"));
    }
}
