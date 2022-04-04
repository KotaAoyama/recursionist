package csMiddle.recursion.fibonacci;

public class Main {
    //　末尾最適
    public static int fibonacciHelper(int f1, int f2, int n) {
        if (n == 0) return f1;
        return fibonacciHelper(f2, f1+f2, n-1);
    }

    public static int fibonacci(int n){
        return fibonacciHelper(0, 1, n);
    }

    public static int fibonacciFor(int n) {
        int fn1 = 0;
        int fn2 = 1;
        int i = 0;

        while (i < n) {
            int prevFn1 = fn1;
            fn1 = fn2;
            fn2 = prevFn1 + fn2;
            i++;
        }

        return fn1;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(45));
    }
}
