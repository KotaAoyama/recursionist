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

        // str 型 + str 型
        // str 型 + char 型でも問題なく動作します
        System.out.println("Hello" + "World");
        System.out.println("Hello" + ' ' + "World");
        System.out.println("S" + '.' + "J");

        // Javaでは、str 型 + number 型 = str 型になります。
        System.out.println("A" + 234);

        // 注意
        // char 型　+ char 型 = int 型になります
        System.out.println('a' + 'b');
        System.out.println((int)'a');
        System.out.println((int)'b');

        System.out.println('ぬ' + 'ぬ');
        System.out.println((int)'ぬ');
    }
}
