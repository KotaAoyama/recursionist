package csMiddle.recursion.swapPosition;

public class Main {
    public static String swapPositionHelper(String s, int index) {
        if (index+2 > s.length()) return s;

        char oddStr = s.charAt(index);
        char evenStr = s.charAt(index+1);
        String replaced = s.substring(0, index) + evenStr + oddStr + s.substring(index+2);

        return swapPositionHelper(replaced, index+2);
    }

    public static String swapPosition(String s){
        return swapPositionHelper(s, 0);
    }
}
