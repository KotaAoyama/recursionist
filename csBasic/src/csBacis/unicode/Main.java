package csBacis.unicode;

public class Main {
    public static void main(String[] args) {
        // コンピュータに文字と認識してもらうために、文字にはシングルクオテーション(')を使います
        // Java では、文字型は 16 ビット（2 バイト）です。つまり 0 から 65535 までの値に各文字を割り振っています
        // また Java では Unicode を採用しているので、国が違っても同じ文字は同じビットを指します
        System.out.println('s');
        System.out.println('あ');

        // Unicode のコードポイントを使って、文字を出力することができます
        // 表で、「ぁ」 が U+3041 であることを確かめましょう
        System.out.println('\u3041');
    }
}
