package csMiddle.list.asciiComparison;

public class Main{

    public static boolean isMarcusLarger(String stringOperand1,String stringOperand2){
        // 2つの文字列を文字コードに変換し、どちらが大きいか比べます
        return getAscii(stringOperand1) > getAscii(stringOperand2);
    }

    // 文字を文字コードに変換する関数
    public static int getAscii(String string){
        int sumOfAscii = 0;
        // 文字列を小文字に変換し、1文字ずつ文字コードへ変換します
        string = string.toLowerCase();
        for (int i = 0; i < string.length(); i++){
            // 文字コードを足していきます
            sumOfAscii += (int) string.charAt(i);
        }
        return sumOfAscii;
    }

    public static void main(String args[]){
        System.out.println(isMarcusLarger("Fantastic","Bridge"));
        System.out.println(isMarcusLarger("Bridge","Fantastic"));
        System.out.println(isMarcusLarger("hello","HelLo"));
        System.out.println(isMarcusLarger("Appearances may deceive","I think so too"));
    }
}