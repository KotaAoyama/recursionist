package csBacis.functionPractice.isRationalNumber;

public class Main {
    public static boolean isRationalNumber(int number){
        // 平方根が有理数であるとは、√4 = 2　のように値が整数になることを意味します。
        // √2 = 1.4142... のように割り切れないということは、数値を 1 で割った余りが存在すると言い換えることができます。
        return Math.sqrt(number) % 1 == 0;
    }

    public static void main(String[] args) {
        System.out.println(isRationalNumber(2));
        System.out.println(isRationalNumber(225));
    }
}
