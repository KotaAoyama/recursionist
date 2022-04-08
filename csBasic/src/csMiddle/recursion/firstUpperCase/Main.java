package csMiddle.recursion.firstUpperCase;

public class Main {
    public static String firstUppercase(String s){
        // スペースを削除した文字列をhelper関数に渡します
        return firstUppercaseHelper(s.replace(" ", ""), 0);
    }

    // インデックスを追跡する引数indexを追加します
    public static String firstUppercaseHelper(String s, int index){
        // indexが文字列サイズ以上になったら再帰終了です
        if (index >= s.length()) return "No upper";
        // 元の文字とupper関数で大文字に変換した文字が一致した場合、その文字を返します
        if (s.charAt(index) == s.toUpperCase().charAt(index)) return String.valueOf(s.charAt(index));
        // indexに1を加えて再帰します
        return firstUppercaseHelper(s, index + 1);
    }
}
