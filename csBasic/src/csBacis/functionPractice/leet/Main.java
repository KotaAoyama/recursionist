package csBacis.functionPractice.leet;

import java.util.HashMap;

public class Main {
    public static String leetify(String stringInput){
        String output = "";

        // 文字に対応する数字を連想配列に格納します
        // 大文字も小文字も同じ数字になるため、ここでは全て大文字をキーとして格納します
        HashMap<Character, String> table = new HashMap<>();
        table.put('A',"4");
        table.put('B',"8");
        table.put('E',"3");
        table.put('L',"1");
        table.put('O',"0");
        table.put('S',"5");
        table.put('T',"7");
        table.put('Z',"2");

        // 各文字を大文字にして、連想配列に文字が存在していれば数字に変換
        for (int i = 0; i < stringInput.length(); i++){
            char c = Character.toUpperCase(stringInput.charAt(i));
            if (table.get(c) != null) output += table.get(c);
            else output += stringInput.charAt(i);
        }

        return output;
    }

    public static void main(String[] args) {
        System.out.println(leetify("leetcode"));
        System.out.println(leetify("LEETCODE"));
        System.out.println(leetify("LeeTCoDE"));
        System.out.println(leetify("apple"));
        System.out.println(leetify("APPLE"));
        System.out.println(leetify("ApPlE"));
    }
}
