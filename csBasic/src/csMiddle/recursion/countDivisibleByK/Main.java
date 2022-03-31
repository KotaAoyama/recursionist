package csMiddle.recursion.countDivisibleByK;

public class Main {
//    public static int countDivisibleByKHelper(int n, int k, int count) {
//        if (n % k != 0) return count;
//
//        return countDivisibleByKHelper(n / k, k, count+1);
//    }
//
//    public static int countDivisibleByK(int n, int k) {
//        return countDivisibleByKHelper(n, k, 0);
//    }

    public static int countDivisibleByK(int n, int k) {
        if (n % k != 0) return 0;

        return countDivisibleByK(n / k, k) + 1;
    }

    public static void main(String[] args) {
        System.out.println(countDivisibleByK(1024,2));
    }
}
