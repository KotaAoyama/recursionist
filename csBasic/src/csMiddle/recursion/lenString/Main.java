package csMiddle.recursion.lenString;

public class Main {
    public static int lenStringHelper(String string, String currentStr, int count) {
        if (string == null || string.equals(currentStr)) return count;

        return lenStringHelper(string, currentStr + string.charAt(count), count+1);
    }

    public static int lenString(String string){
        return lenStringHelper(string, "", 0);
    }

    public static void main(String[] args) {
        System.out.println(lenString("Hello world!"));
    }
}
