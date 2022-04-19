package csMiddle.list.primeUpToCount;

import java.util.Arrays;

public class Main {
    public static int primesUpToNCount(int n){
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);

        // 0と1を除去するため予め count には2を入れておきます。
        int count = 2;

        for(int i = 2; i * i < n; i++){
            int p = 2;
            while(i*p < n){
                // 約数を持っている数(素数ではない数)をカウントします。
                if (primes[i*p]) count++;
                primes[i*p] = false;
                p++;
            }
        }

        return primes.length - count;
    }

    public static void main(String[] args){
        System.out.println(primesUpToNCount(2)); // 0
        System.out.println(primesUpToNCount(3)); // 1
        System.out.println(primesUpToNCount(5)); // 2
        System.out.println(primesUpToNCount(13)); // 5
        System.out.println(primesUpToNCount(18)); // 7
        System.out.println(primesUpToNCount(89)); // 23
        System.out.println(primesUpToNCount(97)); // 24
        System.out.println(primesUpToNCount(100)); // 25
        System.out.println(primesUpToNCount(367)); // 72
        System.out.println(primesUpToNCount(673)); // 121
        System.out.println(primesUpToNCount(1000)); // 168
        System.out.println(primesUpToNCount(3406)); // 478
        System.out.println(primesUpToNCount(20034)); // 2266
    }
}
