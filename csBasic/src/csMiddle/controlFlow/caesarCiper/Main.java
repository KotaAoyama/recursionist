package csMiddle.controlFlow.caesarCiper;

public class Main {
    public static String caesarCiper(String message,int n){
        final String string = message.replaceAll(" ","");    // 空白を消します
        String res = "";

        // 1文字ずつシフトさせていきます
        for (int i = 0; i < string.length(); i++) {
            // 文字は26種類なので、1文字分シフトさせた文字と27文字分シフトさせた文字は同じになります
            // そのため、26で割った余りで文字をシフトさせます
            res += converter(string.charAt(i), n % 26);
        }

        return res;
    }

    // 文字をシフトさせる関数
    public static char converter(char character, int n) {
        // 文字を文字コードに変えて、n文字分だけシフトさせます
        // zの文字コードである122を超えた場合は、26を引いてaから数えられるようにします
        int ascii = (int)character;
        int shifted = ascii + n > 122 ? ascii + n - 26 : ascii + n;

        return (char)shifted;
    }

    public static void main(String[] args){
        System.out.println(caesarCiper("i love you",0));
        System.out.println(caesarCiper("i love you",1));
        System.out.println(caesarCiper("i love you",2));
        System.out.println(caesarCiper("the future belongs to those who believe in the beauty of their dreams",2));
    }
}
