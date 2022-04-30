package csMiddle.hashMapPractice.charFrequency;

import java.util.*;

public class Main {
    public static String[] charFrequency(String message) {
        message = message.replace(" ", "");
        // HashMapではキーの順番を保証しないのに対して、TreeMapではキーを自動的にソートし、順序を保証します。
        Map<Character, Integer> charCountMap = new TreeMap<>();
        for (int i = 0; i < message.length(); i++) {
            Character c = message.charAt(i);
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        List<String> dynamicArr = new ArrayList<>();
        for (Character key : charCountMap.keySet()) {
            dynamicArr.add(String.format("%s : %s", key, charCountMap.get(key)));
        }

        String[] result = dynamicArr.toArray(new String[dynamicArr.size()]);

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(charFrequency("i love you")));
    }
}
