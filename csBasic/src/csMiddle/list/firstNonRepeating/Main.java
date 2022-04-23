package csMiddle.list.firstNonRepeating;

import java.util.*;

public class Main {
    public static int firstNonRepeating(String s){
        // s の文字をキー、その数を値としてハッシュマップを作成します。
        Map<Character, Integer> charCountMap = new HashMap<>();
        // 当てはまる文字がない場合に返す-1を入れておきます。
        int ans = -1;

        for (int i = 0; i < s.length(); i++) {
            charCountMap.put(s.charAt(i), charCountMap.getOrDefault(s.charAt(i), 0)+1);
        }

        // s をループして、ハッシュマップの値が1のキーを探します。
        for (int i = 0; i < s.length(); i++) {
            // 最初に出てくる文字を発見したら break でループを抜けます。
            if (charCountMap.get(s.charAt(i)) == 1) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeating("aabbcdddeffg")); // 4
        System.out.println(firstNonRepeating("abcdabcdf")); // 8
        System.out.println(firstNonRepeating("abcddaebcdf")); // 6
        System.out.println(firstNonRepeating("aabbbccdd")); // -1
        System.out.println(firstNonRepeating("ddecdfgf")); // 2
        System.out.println(firstNonRepeating("abcdeeff")); // 0
        System.out.println(firstNonRepeating("zzcbdefghafhgbbcd")); // 5
    }
}
