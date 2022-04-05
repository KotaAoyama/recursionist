package csMiddle.recursion.divideBy3Count;

public class Main {
    public static int divideBy3Count(int n){
        // 末尾再帰を行うために引数を増やします
        return divideBy3CountHelper(n, 0);
    }

    public static int divideBy3CountHelper(int n, int count){
        // nを3で割る数が1より小さい時がベースケースです。今まで加算してきたcountを返します
        if (n/3 < 1) return count;
            // nを3で割る数が1以上の時、nを3で割り、countを1増やします
        else return divideBy3CountHelper(n/3, count+1);
    }

    public static void main(String[] args){
        System.out.println(divideBy3Count(1));
        System.out.println(divideBy3Count(3));
        System.out.println(divideBy3Count(27));
        System.out.println(divideBy3Count(729));
        System.out.println(divideBy3Count(6561));
    }
}
