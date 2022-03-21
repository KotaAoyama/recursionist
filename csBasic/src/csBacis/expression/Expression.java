package csBacis.expression;

public class Expression {
    public static void main(String[] args) {
        // 足し算
        System.out.println(12 + 5);
        System.out.println(12.0 + 5.0);

        // 引き算
        System.out.println(12 - 5);
        System.out.println(12.0 - 5.0);

        // 掛け算
        System.out.println(12 * 5);
        System.out.println(12.0 * 5.0);

        // 割り算
        // 算数では 12 / 5 は 2.4 ですが、C++ や Java では 小数点以下を切り捨てた int 型で返されます。
        // Java, C++ : 2
        // JavaScript, PHP, Python : 2.4
        System.out.println(12 / 5);
        System.out.println(12 / 3);
        System.out.println(12.0 / 5.0);

        // Java　や　C++　には、冪乗演算子（**）はない
        // Python　にのみ、割り切り演算子（//）がある
        // 12 / 5 は 2.4 だが、12 // 5 は 2

        // int 型同士の割り算には十分に注意が必要です
        System.out.println(1 / 30000000);

        // 有効数字 16 桁で 17 桁目が以降を丸めた数になります
        System.out.println(1.0 / 30000000);

        // 0 で割ると、エラーが発生してしまいます
        // System.out.println(1 / 0);

        // 練習問題 1
        // 14 / 3 の結果を予測して、コンソールに出力してみましょう
        // 4
        System.out.println(14 / 3);

        // 練習問題 2
        // 52 / 5 の結果を予測して、コンソールに出力してみましょう
        // 10
        System.out.println(52 / 5);
    }
}
