package csMiddle.recursion.powerOfN;

public class Main {

    public static double powerXOfN(double x, int n) {
        return (Math.floor(powerXOfNHelper(x, n) * 10)) / 10;
    }

    public static double powerXOfNHelper(double x, int n){
        if (n==0){
            return 1;
        }
        if (n>0){
            return x * powerXOfNHelper(x,n-1);
        } else {
            return (1/x) * powerXOfNHelper(x,n+1);
        }
    }

        public static void main(String[] args) {
            System.out.println(powerXOfN(8.1,9));
        }
}
