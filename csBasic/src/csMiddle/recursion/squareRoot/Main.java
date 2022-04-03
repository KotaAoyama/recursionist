package csMiddle.recursion.squareRoot;

import java.lang.Math;

public class Main{

    // isSquareRootCloseEnough(a,b) は相対誤差を計算する関数です
    // 相対誤差が 0.01% 未満であれば、true, 0.01％ 以上であれば false を返します
    public static boolean isSquareRootCloseEnough(double a, double b){

        // 誤差 |a-b| を計算するために、abs 関数を使います。abs(x) は x の絶対値を返します
        return 100 * Math.abs((a - b) / b) < 0.01;
    }

    // 可読性を高めるために、近似値を guess、新しい近似値を newGuess とします
    public static double squareRootHelper(double x, double guess){

        // 新しい近似値は、2 つの近似値の平均から求めます
        double newGuess = (guess + x/guess)/2;

        System.out.println("guess : " + String.valueOf(guess));
        System.out.println("newGuess : " + String.valueOf(newGuess));

        // 相対誤差が 0.01 未満であることがベースケースです
        if(isSquareRootCloseEnough(newGuess,guess)) return guess;

        // 再帰的に計算を繰り返します
        return squareRootHelper(x,newGuess);
    }

    // 平方根の近似値を求める関数
    public static double squareRoot(double x){
        // 近似値の初期値として 1 を設定します
        // 引数を増やして、squareRootHelper　関数で再帰処理を行います
        return squareRootHelper(x, 1);
    }

    // 関数の呼び出し
    // 65 の平方根を計算します
    public static void main(String[] args){
        System.out.println(squareRoot(65));
    }

}
