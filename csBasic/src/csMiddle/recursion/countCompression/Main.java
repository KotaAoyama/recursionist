package csMiddle.recursion.countCompression;

public class Main {
    public static String stringCompression(String s){
        return stringCompressionHelper(s, 0, 0, "");
    }

    // helper関数で引数を増やします
    // right: leftの右側にある文字, left: 連続の始まりの文字, output: 出力する文字を格納する
    public static String stringCompressionHelper(String s, int right, int left, String output) {

        // leftが文字列の長さ以上になったら再帰を終了し、文字を格納してきたoutputを返します。
        if (left >= s.length()) return output;
        // rightが文字列の長さ未満かつ、rightの文字とleftの文字が等しい場合、次の文字の比較に移ります
        if (right < s.length() && s.charAt(right) == s.charAt(left)) return stringCompressionHelper(s, right + 1, left, output);

        // rightの文字とleftの文字が等しくない場合と、rightが文字列のサイズ以上の値になった場合(最後の文字の比較が終わった後の場合)

        // right - left で連続した値を出します
        int count = right - left;

        // outputに文字を加えます。文字が2以上連続していれば数字も加えます
        if (count > 1) output += s.charAt(left) + String.valueOf(count);
        else output += s.charAt(left);

        // rightをleftに格納することで、連続の始まりの値を変更します。
        left = right;
        // 再帰
        return stringCompressionHelper(s, right, left, output);
    }

    public static void main(String[] args) {
        System.out.println(stringCompression("aaaBBBccDDDD"));
    }
}
