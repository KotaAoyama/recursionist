public class FloatingPointNumber {
    public static void main(String[] args) {
        // Java では、小数に特に何も指定しない場合は double 型として扱われます
        System.out.println(10.4);

        // E 表記を使うことも可能です
        System.out.println(1.23456E-3);
        System.out.println(1.23456E4);

        // double 型を超える数値
        // コメントアウトを削除して、実行してみましょう。エラーが発生します
        // System.out.println(1.23456E-400);


        // float 型を使いたい場合、f を末尾につけます
        // ただ double 型の方が精度が高いので、float 型へ変換することは滅多にありません
        System.out.println(10.4f);

        // float 型を超える範囲で、float 型で指定するとエラーになります
        // コメントアウトを削除して、実行してみましょう。エラーが発生します
        // System.out.println(3.8E49f);
    }
}
