package csBasic.flaotingPointNumber;

public class Main {
    public static void main(String[] args) {
        // Java の浮動小数点型には、float 型と double 型が存在します
        // 浮動小数点リテラルを用いた時、何も指定しない場合、double 型と指定されます
        // Java では、小数に特に何も指定しない場合は double 型として扱われます
        System.out.println(10.4);
        // float 型を指定する場合、f を末尾につけます
        System.out.println(3.8f);


        // E 表記を使うことも可能です
        System.out.println(1.23456E-3);
        System.out.println(1.23456E4);

        System.out.println(3.14);
        System.out.println(Math.round(2E3));
        System.out.println(5E-2);

        // double 型を超える数値
        // コメントアウトを削除して、実行してみましょう。エラーが発生します
        // System.out.println(1.23456E-400);

        // float 型を使いたい場合、f を末尾につけます
        // ただ double 型の方が精度が高いので、float 型へ変換することは滅多にありません
        System.out.println(10.4f);

        // float 型を超える範囲で、float 型で指定するとエラーになります
        // コメントアウトを削除して、実行してみましょう。エラーが発生します
        // System.out.println(3.8E49f);


        // float 型は 32 ビットです
        // float 型の最大値
        System.out.println(Float.MAX_VALUE);

        // float 型の最小値
        System.out.println(Float.MIN_VALUE);

        // double 型は 64 ビットです
        // double 型の最大値
        System.out.println(Double.MAX_VALUE);

        // double 型の最小値
        System.out.println(Double.MIN_VALUE);
    }
}
