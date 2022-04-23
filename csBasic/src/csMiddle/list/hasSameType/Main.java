package csMiddle.list.hasSameType;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static boolean hasSameType(String user1,String user2){

        // 文字列の長さが違う場合を最初に除きます。
        if (user1.length() != user2.length()) return false;
        // ハッシュマップを作成します
        Map<Character, Character> hashmap = new HashMap<>();

        String res = "";

        for (int i = 0; i < user1.length(); i++) {

            // user1,user2それぞれのi番目の文字が、どちらもハッシュマップにまだなかったら保存します。
            if (!hashmap.containsKey(user1.charAt(i)) && !hashmap.containsValue(user2.charAt(i))) {
                hashmap.put(user1.charAt(i), user2.charAt(i));
            }

            // ハッシュマップに存在したらresに対応する値を追加します。
            if (hashmap.containsKey(user1.charAt(i))) res += hashmap.get(user1.charAt(i));
        }
        // できたresとuser2が同じ文字列ならtrueです。
        return res.equals(user2);
    }

    public static void main(String[] args){

        System.out.println(hasSameType("aabb","yyza")); // false
        System.out.println(hasSameType("aappl","bbtte")); // true
        System.out.println(hasSameType("aappl","bbttb")); // false
        System.out.println(hasSameType("aappl","bktte")); // false
        System.out.println(hasSameType("aaapppl","bbbttke")); // false
        System.out.println(hasSameType("abcd","tso")); // false
        System.out.println(hasSameType("abcd","jklm")); // true
        System.out.println(hasSameType("aaabbccdddaa","jjjddkkpppjj")); // true
        System.out.println(hasSameType("aaabbccdddaa","jjjddkkpppjd")); // false
    }
}
