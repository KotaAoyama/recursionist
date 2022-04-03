package csMiddle.recursion.summationOfSummation;

public class Main {
    public static int summation(int n) {
        if (n < 1) return 0;
        return summation(n-1) + n;
    }

    public static int summationOfSummation(int n){
        if (n < 1) return summation(0);
        return summationOfSummation(n-1) + summation(n);
    }

    public static int summationOfSummationForVersion(int n) {
        int total = 0;

        for (int i = 1; i <= n; i++) {
            // 内側のfor文では、他の変数であるjを使います。
            // jがiになった時にループ処理を終了します。

            // iの総和の計算
            int summationOfI = 0;

            for (int j = 1; j <= i; j++) {
                summationOfI += j;
            }

            total += summationOfI;
        }

        return total;
    }

    public static void main(String[] args) {
        System.out.println(summationOfSummation(8));
        System.out.println(summationOfSummationForVersion(8));
    }
}
