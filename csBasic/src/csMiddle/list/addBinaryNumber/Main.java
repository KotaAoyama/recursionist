package csMiddle.list.addBinaryNumber;

import java.util.ArrayList;
import java.util.List;

public class Main{
    public static String addBinaryNumber(String bits1,String bits2){
        // 扱いやすいように配列へ変更します。
        List<String> b1 = stringToList(bits1);
        List<String> b2 = stringToList(bits2);

        String ans = "";
        int carry = 0;

        // 配列が存在する場合(長さが0より多い）、あるいは繰り上がりが存在する場合にwhileを使ってループします。
        while (b1.size() > 0 || b2.size() > 0 || carry > 0) {
            // popは配列の一番最後を取り出します。数字へ変換してcarryへ足します。
            if (b1.size() > 0) carry += Integer.parseInt(b1.remove(b1.size()-1));
            if (b2.size() > 0) carry += Integer.parseInt(b2.remove(b2.size()-1));

            // carryは0-3の範囲を取る可能性があります。
            // carryが0,2の場合はansに0を追加、carryが1,3の場合はansに1を追加します。
            ans = carry % 2 + ans;

            // carryが0,1の場合は繰り上がりがないのでcarryを0として次の桁の計算へ、2,3の場合はcarryを1として次の桁の計算へ移ります。
            carry = (int)Math.floor(carry / 2);
        }
        // 不必要な0を排除して文字列へ戻します
        return Integer.parseInt(ans)+"";
    }

    public static List<String> stringToList(String str){
        List<String> list = new ArrayList<>();
        for(int i = 0; i < str.length(); i++){
            list.add(str.charAt(i) +"");
        }
        return list;
    }

    public static void main(String[] args){
        System.out.println(addBinaryNumber("100","0"));
        System.out.println(addBinaryNumber("100","1"));
        System.out.println(addBinaryNumber("100","10"));
        System.out.println(addBinaryNumber("100","101"));
        System.out.println(addBinaryNumber("1111","110"));
        System.out.println(addBinaryNumber("101","111"));
        System.out.println(addBinaryNumber("1","1"));
        System.out.println(addBinaryNumber("1011","110"));
        System.out.println(addBinaryNumber("1011","11011"));
        System.out.println(addBinaryNumber("000011","0"));
        System.out.println(addBinaryNumber("000010","1"));
    }
}
