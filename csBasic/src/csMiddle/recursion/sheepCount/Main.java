package csMiddle.recursion.sheepCount;

public class Main {
    public static String sheeps(int count){
        // helper関数を利用します
        return sheepsHelper(count, "");
    }

    // helper関数を作成して引数を増やします
    // stringに文字列を追加していき、ベースケースになったときに返します
    public static String sheepsHelper(int count, String string){
        if (count <= 0) return string;
        // stringの先頭に、count + " sheep ~ " を追加します
        return sheepsHelper(count - 1, String.valueOf(count) + " sheep ~ " + string);
    }

    public static void main(String[] args){

        System.out.println(sheeps(2));
        System.out.println(sheeps(4));
        System.out.println(sheeps(5));
        System.out.println(sheeps(10));
    }
}
