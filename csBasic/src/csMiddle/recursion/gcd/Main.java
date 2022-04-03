package csMiddle.recursion.gcd;

public class Main {
    public static int maximumPeople(int x, int y){
        if(x % y == 0) return y;
        return maximumPeople(y, x % y);
    }

    public static void main(String[] args) {
        System.out.println(maximumPeople(1029,1071)); // 21
        System.out.println(maximumPeople(3180,1908)); // 636
    }
}
