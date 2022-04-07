package csMiddle.recursion.lenString;

public class Main {
    public static int lenStringHelper(String originalStr, String left, String currentStr, int count) {
        currentStr = currentStr + left.substring(0,1);
        left = left.substring(1);
        count++;

        if (originalStr.equals(currentStr)) return count;

        return lenStringHelper(originalStr, left, currentStr, count);
    }

    public static int lenString(String string){
        return lenStringHelper(string, string, "", 0);
    }

    public static void main(String[] args) {
        System.out.println(lenString("Hello world!"));
    }
}
