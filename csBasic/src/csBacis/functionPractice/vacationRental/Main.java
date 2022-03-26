package csBacis.functionPractice.vacationRental;

public class Main {
    public static int vacationRental(int people, int day){
        final double CLEANING_FEE = 1.12;
        final double TAX = 1.08;
        int sum = 0;

        if (day <= 3) {
            sum = (int) Math.floor(people * day * 80 * CLEANING_FEE * TAX);
        } else if (day <= 9) {
            sum = (int) Math.floor(people * day * 60 * CLEANING_FEE * TAX);
        } else {
            sum = (int) Math.floor(people * day * 50 * CLEANING_FEE * TAX);
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(vacationRental(2,8));
    }
}
