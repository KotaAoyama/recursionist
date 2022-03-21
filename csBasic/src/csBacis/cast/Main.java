package csBacis.cast;

public class Main {
    public static void main(String[] args) {

        // Java の場合、データ型の領域は以下のようになります
        // byte < short < int < long < float < double
        // 値を代入するときに、小さい型から大きい型へは自動で変換されますが、大きい型から小さい型へは自動では変換されません

        // 浮動小数点型から整数型へは変換できません
        double doubleNumA = 1.321;
        // int intNumA = doubleNumA; // エラー

        // 整数型から小数点型へも変換可能ですが、データの欠損が生じる可能性があります
        int intNumB = 1333223313;
        double doubleNumB = intNumB;
        float floatNumB = intNumB;
        System.out.println(doubleNumB);
        System.out.println(floatNumB); // float 型は有効数字が約 7 桁なので、8 桁目以降は有効ではない数値です

        // なお、下記式の数値リテラルは整数なので、代入時に暗黙の変換が行われています
        double doubleNumC = 1678;
        System.out.println(doubleNumC);



        // 計算時の変換
        // int 同士の場合は、int で出力されます。小数点以下は切り捨てます
        System.out.println(5 / 3);

        // double 同士の場合は、double で出力されます
        System.out.println(5.0 / 3.0);

        // double と int の場合は、double で出力されます
        System.out.println(5.0 / 3);

        // double と int が混在する演算では、int を double へ格上げして計算します
        //int intNum = 5.0 / 3.0 - 1 // エラー double を int へは格納できない
        double doubleNum = 5.0 / 3.0 - 1;
        System.out.println(doubleNum);



        // 変数の前に（変換したい型名）を記述することで、型を強制的に変換します
        int intNum = 1;

        System.out.println(typeOf(intNum)); // int 型
        System.out.println(typeOf((double)intNum)); // double 型

        // 型変換の例
        // int 型同士の計算ですが、小数点以下まで計算してみます
        int int5 = 5;
        int int3 = 3;

        // 暗黙の型変換だけの場合
        double doubleNumD = int5 / int3;
        System.out.println(doubleNumD);
        System.out.println(typeOf(doubleNumD));
        // double 型にはなりましたが、小数点以下が切り捨てられた 1.0 が出力されます

        // 行われていること
        // int5 / int3 で　int 同士の計算 --> int 型の 1
        // int 型の 1 を double 型の doubleNumA に代入する際に、暗黙の型変換が行われる --> double 型の 1.0
        // 上記結果を doubleNumD に代入

        // 明示的な型変換を行った場合
        double doubleNumE = (double)int5 / int3;
        System.out.println(doubleNumE);
        System.out.println(typeOf(doubleNumE));
        // 小数点以下まで計算されます

        // 行われていること
        // int5 を double にキャストする
        // double 型にキャストされた int5 と int 型の int4 の計算 -> double 型の 1.6666666666666667
        // 上記結果を doubleNumE に代入

        // キャストのタイミングに注意
        double doubleNumF = (double)(int5 / int3);
        System.out.println(doubleNumF);
        System.out.println(typeOf(doubleNumF));
        // double 型にはなりましたが、小数点以下が切り捨てられ 1.0 が出力されます

        // 行われていること
        // (int5 / int3) の結果である int 型の 1 を double 型にキャストする -> double 型の 1
        // 上記結果を doubleNumF に代入
    }


    // 型を調べるメソッド
    public static String typeOf(Object number) {
        String type = number.getClass().getSimpleName();

        if (type.equals("Integer")) return "int";
        else if (type.equals("Double")) return "double";
        else return "";
    }
}
