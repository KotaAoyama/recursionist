package csMiddle.recursion.addition;

public class Main {
    public static int recursiveAddition(int m, int n){
        if (n == 0 && m == 0) return 0;
        if (n == 0) return recursiveAddition(m-1, 0) + 1;
        if (m == 0) return recursiveAddition(0, n-1) + 1;

        return recursiveAddition(m-1, n-1) + 2;
    }

    public static void main(String[] args) {
        System.out.println(recursiveAddition(571,974)); // 1545
    }
}
