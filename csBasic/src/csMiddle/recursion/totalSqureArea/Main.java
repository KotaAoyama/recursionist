package csMiddle.recursion.totalSqureArea;
import java.lang.Math;

public class Main {
    public static int totalSquareArea(int x){
        // ベースケース
        if (x <= 1) return 1;
        // x^3 + x-1列目までの合計
        return totalSquareArea(x-1) + (int) Math.pow(x,3);
    }

    public static void main(String[] args){

        System.out.println(totalSquareArea(1));
        System.out.println(totalSquareArea(2));
        System.out.println(totalSquareArea(3));
        System.out.println(totalSquareArea(4));
        System.out.println(totalSquareArea(5));
        System.out.println(totalSquareArea(12));
        System.out.println(totalSquareArea(10));
    }
}
