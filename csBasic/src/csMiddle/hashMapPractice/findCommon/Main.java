package csMiddle.hashMapPractice.findCommon;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class Main{
    public static String findCommon(char[] charArr1,char[] charArr2){
        // ハッシュマップを作成します。
        Map<Character, Integer> hashmap = new HashMap<>();
        // 暫定の最小値としてminScoreにInteger.MAX_VALUEを代入しておきます。Integer.MAX_VALUEはintに設定可能な最大値2^31-1を保持する定数。
        int minScore = Integer.MAX_VALUE;
        // 答えのコマンドを入れるための変数。
        String commonChar = "";
        // プレイヤー1と2のインデックスの和を入れるための変数。
        int curr = 0;

        // charArr1 の文字をキー、そのインデックスを値としてハッシュマップに入れます。
        for (int i = 0; i < charArr1.length; i++) {
            if (hashmap.get(charArr1[i]) == null) hashmap.put(charArr1[i], i);
        }
        // charArr2をループします。
        for (int i = 0; i < charArr2.length; i++) {
            // charArr2 の文字がハッシュマップに存在したら、その値と現在のインデックスを足してcurrに代入します。
            if (hashmap.get(charArr2[i]) != null) {
                curr = hashmap.get(charArr2[i]) + i;
                // currとminScoreを比較し、currが小さかったらminScoreを更新します。
                // minScoreとcurrが同じだった場合も同様にminScoreを更新します。
                if (minScore >= curr) {
                    minScore = curr;
                    // minScoreを更新したらその時の文字をcommonCharに保存しておきます。
                    commonChar = String.valueOf(charArr2[i]);
                }
            }
        }

        // 同じコマンドがない場合は、minScoreの値がInteger.MAX_VALUEのままです。
        return minScore == Integer.MAX_VALUE? "no common" : commonChar;
    }

    public static void main(String[] args){
        System.out.println(findCommon(new char[]{'a','b','c','d'},new char[]{'e','c','b','g'})); // b
        System.out.println(findCommon(new char[]{'b','b','b','b'},new char[]{'b','b','b','b'})); // b
        System.out.println(findCommon(new char[]{'a','b','c','d'},new char[]{'e','f','a'})); // a
        System.out.println(findCommon(new char[]{'a','b','c','d'},new char[]{'e','c','g','b'})); // c
        System.out.println(findCommon(new char[]{'a','b','c','d'},new char[]{'e','f','g','h'})); // no common
        System.out.println(findCommon(new char[]{'b','c','a','d'},new char[]{'b','c','e','g'})); // b
        System.out.println(findCommon(new char[]{'c','d','a','b'},new char[]{'b','c','e','g'})); // c
        System.out.println(findCommon(new char[]{'b','b','c','d'},new char[]{'b','c','e','g'})); // b
        System.out.println(findCommon(new char[]{'b','c','d','b'},new char[]{'e','c','b','g'})); // b
        System.out.println(findCommon(new char[]{'b','d','b','c'},new char[]{'e','c','b','c'})); // b
        System.out.println(findCommon(new char[]{'b','b','c','d'},new char[]{'c','c','b','b'})); // b
        System.out.println(findCommon(new char[]{'a','b','c','d'},new char[]{'e','c','g','b','f'})); // c
        System.out.println(findCommon(new char[]{'a','b','c','d','v','b','c'},new char[]{'e','c','g','b','f','b'})); // c
    }
}

