package csBacis.string;

public class Main {
    public static void main(String[] args) {
        // コンピュータに文字と認識してもらうために、文字列にはダブルクオテーション(")を使います
        // 文字列型
        System.out.println("abcd");
        System.out.println("abcdef");

        // 文字であっても、ダブルクオテーションを使うことによって、文字列として認識されます
        System.out.println("a");

        System.out.println("The earth was bluish.");
        System.out.println("");
        System.out.println(1 + 1);
        System.out.println("1" + "1");

        // Java では、charAt メソッドが使われます
        // String.charAt(int)
        // 文字型が返されます
        // Python JavaScriptなどだと、文字列[インデックス]
        System.out.println("Recursion".charAt(0));
        System.out.println("Recursion".charAt(4));
        System.out.println("Recursion".charAt(8));
    }
}
