package csBacis.functionPractice.howMuchIsYourDebt;

public class Main {
    public static int howMuchIsYourDebt(int year) {
        double interest = 0.2;
        int initialDebt = 10000;

        return (int) (initialDebt * Math.pow(1+interest, year));
    }

    public static void main(String[] args) {
        System.out.println(howMuchIsYourDebt(2)); // 14400
    }
}
