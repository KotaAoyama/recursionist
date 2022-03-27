package csBacis.functionPractice.grouping;

public class Main {
    public static char divideEmployees(int num){
        // グループを文字列にします。
        String s = "ABCDEEDCBA";
        // Java ではcharAt()で文字を取得します。
        // 文字列[-1]は使えないので、num % 10 が 0 になるときを場合分けします。

        if (num % 10 == 0) return s.charAt(s.length()-1);
        else return s.charAt(num % 10 -1);
    }

    public static void main(String[] args){
        System.out.println(divideEmployees(1)); // A
        System.out.println(divideEmployees(5)); // E
        System.out.println(divideEmployees(6)); // E
        System.out.println(divideEmployees(8)); // C
        System.out.println(divideEmployees(31)); // A
        System.out.println(divideEmployees(100)); // A
        System.out.println(divideEmployees(105)); // E
    }
}
