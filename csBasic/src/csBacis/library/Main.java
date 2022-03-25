package csBacis.library;

public class Main {
    // ライブラリと関数の組み合わせ
    public static double pythagoreanTheorem(double a, double b){
        // sqrt 関数(平方根を計算する関数)
        return Math.sqrt(a*a + b*b);
    }

    public static double hypotenuse(int width, int height) {
        return Math.sqrt(width*width + height*height);
    }

    public static double exponentialOfTwo(int n) {
        return Math.pow(2, n);
    }

    public static void main(String[] args) {
        // Math ライブラリ
        // 小数点以下切り捨て
        System.out.println(Math.floor(3.3));
        System.out.println(Math.floor(10.9));

        // 小数点以下切り上げ
        System.out.println(Math.ceil(3.3));
        System.out.println(Math.ceil(10.9));

        // 累乗を計算することができる pow 関数
        // 3^4 を計算 (3 * 3 * 3 * 3)
        System.out.println(Math.pow(3,4));

        // 2^5 を計算 (2 * 2 * 2 * 2 * 2)
        System.out.println(Math.pow(2,5));

        // (3^2 + 4^2) の平方根を出力(√25)
        System.out.println(pythagoreanTheorem(3,4));
        // (3^2 + 10^2) の平方根を出力(√109)
        System.out.println(pythagoreanTheorem(3,10));

        // 例題 1
        // 式　3 * 4 / 5 の結果に対して小数点以下の切り捨てを行い、出力してください (2)
        // 式 3 * 4 / 5 の結果に対して小数点以下の切り上げを行い、出力してください (3)
        System.out.println(Math.floor(3.0 * 4 / 5));
        System.out.println(Math.ceil(3.0 * 4 / 5));

        // 例題 2
        // 直角三角形において、横、縦の長さを受け取って、斜辺の長さを返す、hypotenuse という関数を sqrt 関数を使って、定義してください
        // 横 4、高さ 3 を関数に入力して、コンソールに結果を出力してください (5.0)
        System.out.println(hypotenuse(4, 3));

        // 例題 3
        // ある整数を受け取って、2^x を計算する、exponentialOfTwo という関数を pow 関数を使って作成してください
        // 3 を関数に入力して、コンソールに結果を出力してください (8.0)
        // 10 を関数に入力して、コンソールに結果を出力してください (1024.0)
        System.out.println(exponentialOfTwo(3));
        System.out.println(exponentialOfTwo(10));
    }
}
