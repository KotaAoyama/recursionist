public class maxInt {
    public static void main(String[] args) {
        // プログラムの中で整数を扱う際は、Java の中では特に指定がない場合、数値は int 型として扱われました
        // Java では int 型は、32ビット（4 バイト）です
        // つまり、-2,147,483,648 ～ 2,147,483,647 までしか扱うことができません

        // int 型の最大値
        System.out.println(2147483647);

        // int 型の最小値
        System.out.println(-2147483648);

        // int 型で 2147483647 を超えるとエラーが発生します
        // 以下のステートメントから // を削除し、実行ボタンをクリックしてみましょう

        // System.out.println(2147483648);

        // integer number too large とエラーメッセージが表示されます
        // これは文字通り整数の値が大きすぎることを意味します
    }
}
