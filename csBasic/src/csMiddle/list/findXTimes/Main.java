package csMiddle.list.findXTimes;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static boolean findXTimes(String teams){
        Map<Character, Integer> hashmap = new HashMap<>();
        // ハッシュマップを作成し、teamsの要素をキー、その数を値として保存します。
        for (int i = 0; i < teams.length(); i++) {
            char c = teams.charAt(i);
            if (hashmap.get(c) == null) hashmap.put(c, 1);
            else hashmap.put(c, hashmap.get(c) + 1);
        }
        // hashmapの値のみを取得するにはvalue()を使います。
        // Collectionsのmax(),min()で最大値と最小値を取得し、同じならtrueです。
        return Collections.max(hashmap.values()) == Collections.min(hashmap.values());
    }

    public static void main(String[] args){
        System.out.println(findXTimes("bacddc")); // false
        System.out.println(findXTimes("babcddc")); // false
        System.out.println(findXTimes("babacddc")); // true
        System.out.println(findXTimes("aaabbbcccddd")); // true
        System.out.println(findXTimes("aaabbccdd")); // false
        System.out.println(findXTimes("zadbchvwxbwhdxvcza")); // true
        System.out.println(findXTimes("zadbchvwxbwhdxvczb")); // false
        System.out.println(findXTimes("zab")); // true
        System.out.println(findXTimes("z")); // true
    }
}
