package csMiddle.list.samePattern;

import java.util.ArrayList;

public class Main {
// 別解
//    public static boolean hasSamePattern(String string){
//        // 文字列を2倍にします
//        String doubleString = string + string;
//
//        // 先頭と末尾から1文字ずつ削除したものに、元の文字列が含まれるかどうかチェックします
//        return doubleString.substring(1,doubleString.length() - 1).indexOf(string) != -1;
//    }

    public static boolean hasSamePattern(String string) {
        // 1文字の場合、繰り返しはありません
        if (string.length() < 2) return false;

        // 約数の配列を取得します
        ArrayList<Integer> divisors = getDivisors(string.length());

        // 約数を1つずつテストします
        for (int divisor : divisors) {
            String sub = string.substring(0, divisor);
            String repeat = "";
            for (int j = 1; j <= string.length() / divisor; j++) {
                repeat += sub;
            }
            // subのX倍が本体に等しいかチェックします。本体と等しいsubが1回でもあればtrueを返します
            if (repeat.equals(string)) return true;
        }

        return false;
    }

    // n未満の約数を配列で返す関数
    public static ArrayList<Integer> getDivisors(int n) {
        ArrayList<Integer> divisors = new ArrayList<Integer>();
        divisors.add(1);

        // nの平方根まで調べれば、約数は全て調べられることになります
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                divisors.add(n / i);
                divisors.add(i);
            }
        }

        return divisors;
    }

    public static void main(String[] args) {
        System.out.println(hasSamePattern("abcabc"));
        System.out.println(hasSamePattern("abc"));
        System.out.println(hasSamePattern("abcdabcd"));
        System.out.println(hasSamePattern("abababab"));
        System.out.println(hasSamePattern("aaaa"));
        System.out.println(hasSamePattern("eightheightheightheightheightheighth"));
    }
}
