package csMiddle.gafa.isSortedByAlphabet;

import java.util.Map;
import java.util.HashMap;

public class Main {
    public static boolean isSortedByAlphabet(String[] stringList, String alphabet) {
        if (stringList.length <= 1) return true;

        Map<Character, Integer> alphabetOrderMap = new HashMap<>();
        alphabetOrderMap.put(' ', 0);
        for (int i = 1; i <= alphabet.length(); i++) {
            alphabetOrderMap.put(alphabet.charAt(i - 1), i);
        }

        int maxLength = 0;
        for (String word : stringList) {
            if (maxLength < word.length()) maxLength = word.length();
        }
        for (int i = 1; i < stringList.length; i++) {
            int diff = maxLength - stringList[i].length();
            if (diff > 0) {
                stringList[i] = stringList[i] + " ".repeat(diff);
            }
        }

        boolean[] compareCache = new boolean[stringList.length - 1];
        for (int i = 0; i < compareCache.length - 1; i++) {
            compareCache[i] = false;
        }


        for (int i = 0; i < stringList[0].length(); i++) {
            for (int j = 1; j < stringList.length; j++) {
                if (compareCache[j - 1]) continue;
                if (alphabetOrderMap.get(stringList[j].charAt(i)) - alphabetOrderMap.get(stringList[j - 1].charAt(i)) > 0) {
                    compareCache[j - 1] = true;
                }
                if (alphabetOrderMap.get(stringList[j].charAt(i)) - alphabetOrderMap.get(stringList[j - 1].charAt(i)) < 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isSortedByAlphabet(new String[]{"hello", "world"}, "hwabcdefgijklmnopqrstuvxyz"));// --> true

        System.out.println(isSortedByAlphabet(new String[]{"hello", "world", "apple", "bear", "pear"}, "hwabcdefgijklmnopqrstuvxyz"));// --> true

        System.out.println(isSortedByAlphabet(new String[]{"aa", "a"}, "abcdefghijklmnopqrstuvwxyz"));// --> false

        System.out.println(isSortedByAlphabet(new String[]{"engine", "engineer"}, "abcdefghijklmnopqrstuvwxyz"));// --> true

        System.out.println(isSortedByAlphabet(new String[]{"lore", "lorke", "role"}, "lorkeabcdfghijmnpqstuvwxyz"));// --> false

        System.out.println(isSortedByAlphabet(new String[]{"kuvp", "q", "qavi", "qavik"}, "ngxlkthsjuoqcpavbfdermiywz"));// --> true

        System.out.println(isSortedByAlphabet(new String[]{"adipisci", "autem", "cum", "et", "ex", "magnam", "nam", "nihil", "non", "odit", "officiis", "qui", "saepe", "sint", "suscipit", "tempore", "totam", "vel", "voluptatem", "voluptatem"}, "abcdefghijklmnopqrstuvwxyz"));// --> true
    }
}