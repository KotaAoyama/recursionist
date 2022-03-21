package csBacis.flaotingPointNumber;

public class Main {
    public static void main(String[] args) {
        // Java の浮動小数点型には、float 型と double 型が存在します
        // 浮動小数点リテラルを用いた時、何も指定しない場合、double 型と指定されます
        System.out.println(10.4);

        // E 表記を使うことも可能です
        System.out.println(1.23456E-3);
        System.out.println(1.23456E4);

        System.out.println(3.14);
        System.out.println(Math.round(2E3));
        System.out.println(5E-2);

        // double 型を超える数値
        // コメントアウトを削除して、実行してみましょう。エラーが発生します
        // System.out.println(1.23456E-400);


        // float 型を指定する場合、f を末尾につけます
        // ただ double 型の方が精度が高いので、float 型へ変換することは滅多にありません
        System.out.println(3.8f);

        // float 型を超える範囲で、float 型で指定するとエラーになります
        // コメントアウトを削除して、実行してみましょう。エラーが発生します
        // System.out.println(3.8E49f);


        System.out.println("**************************************************");


        // double 型は 64 ビットです
        // double 型の最大値
        System.out.println(Double.MAX_VALUE);

        // double 型の最小値
        System.out.println(Double.MIN_VALUE);

        // float 型は 32 ビットです
        // float 型の最大値
        System.out.println(Float.MAX_VALUE);

        // float 型の最小値
        System.out.println(Float.MIN_VALUE);


        System.out.println("**************************************************");


        // 0.1 が 2 進数へと変換され、2 進数　が　10 進数へ変換され、コンソールに表示されます
        // 2 進数へ変換した際に近似されるため、10 進数に戻した時には正確には 0.1000000000000000055511151231257827021181583404541015625 になります
        // Java は値を丸めて表示します

        System.out.println(0.1);

        // 0.1 を 2 進数へ、0.2 を 2 進数へ直したとき、循環小数になるので、Java が途中で計算を打ち切ります
        // 打ち切った際に誤差が発生してしまいます
        // つまり、計算を行う前からすでに誤差が発生してることになります
        System.out.println(0.1 + 0.2);
    }
}
