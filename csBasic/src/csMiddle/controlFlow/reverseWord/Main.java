package csMiddle.controlFlow.reverseWord;

public class Main {
    public static String reverseWords(String sentence){
        String output = ""; // 出力する文字列
        String word = "";   // 空白が出るまで逆順にする文字列

        // 文字列を逆順にしていきます
        for (int i = 0; i < sentence.length(); i++){
            // 空白が出たら逆順にしていた文字列をoutputに追加し、wordにある文字を消します
            if (sentence.charAt(i) == ' '){
                output += word + " ";
                word = "";
                // 空白でない場合、文字をwordの先頭に置いて逆順の文字列を作ります
            } else {
                word = sentence.charAt(i) + word;
            }
        }

        // 末尾の文字には空白がない場合もあるので、逆順にしていた文字列wordを追加します
        return output + word;
    }

    public static void main(String[] args){
        System.out.println(reverseWords("olleh dlrow"));
        System.out.println(reverseWords("hello world"));
        System.out.println(reverseWords("Please wait outside of the house"));
        System.out.println(reverseWords("He started to believe in ghosts"));
    }
}
