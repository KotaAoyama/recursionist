package csMiddle.hashMapPractice.hasSameStructure;

import java.util.HashMap;

public class Main{
    public static boolean hasSameStructure(String inputChar,String wordList){
        // 文字列をスペースで区切って配列にします。
        String[] arr = wordList.split(" ");
        // inputCharとarrの長さが違えばfalse
        if (inputChar.length() != arr.length) return false;
        // inputCharの文字をキー、arrの文字列を値としてハッシュマップを作成します。
        HashMap<Character, String> hashmap = new HashMap<>();

        for (int i = 0; i < inputChar.length(); i++) {
            // ハッシュマップにinputChar[i]があるけど、arr[i]がないとき False
            if (hashmap.containsKey(inputChar.charAt(i)) && !hashmap.containsValue(arr[i])) return false;
            // ハッシュマップにinputChar[i]がないけど、arr[i]があるとき False
            if (!hashmap.containsKey(inputChar.charAt(i)) && hashmap.containsValue(arr[i])) return false;
                // それ以外はハッシュマップに追加
            else hashmap.put(inputChar.charAt(i), arr[i]);
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(hasSameStructure("tut","hot mild cold")); // false
        System.out.println(hasSameStructure("aabac","word word dictionary word word")); // false
        System.out.println(hasSameStructure("aabac","word word dictionary word string")); // true
        System.out.println(hasSameStructure("abcabc","soccer baseball tennis soccer baseball tennis")); // true
        System.out.println(hasSameStructure("zabccabcz","book comic phone music music comic phone music book")); // true
        System.out.println(hasSameStructure("zzz","math math math")); // true
    }
}
