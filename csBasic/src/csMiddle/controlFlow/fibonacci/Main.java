package csMiddle.controlFlow.fibonacci;

public class Main {
    public static int fibonacci(int n){
        if (n == 0) return 0;
        if (n == 1) return 1;

        int f1 = 0;
        int f2 = 1;
        int output = 0;

        for (int i = 2; i <= n; i++) {
            output = f1 + f2;
            f1 = f2;
            f2 = output;
        }

        return output;

//        int fn1 = 0;
//        int fn2 = 1;
//
//        for (int i = 0; i < n; i++) {
//            int prevFn1 = fn1;
//            fn1 = fn2;
//            fn2 = prevFn1 + fn2;
//        }
//
//        return fn1;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(45));
    }
}
