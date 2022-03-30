package csBacis.functionPractice.functionDecomposition;

public class Main {
    public static double stateTax(String state) {
        if (state.equals("AZ")) return 4.9;
        if (state.equals("CA")) return 8.84;
        if (state.equals("TX")) return 0;
        if (state.equals("NC")) return 2.5;
        return 5;
    }

    public static double calcurateTax(double taxRate, int profit) {
        return profit * taxRate / 100;
    }

    public static boolean isLeapYear(int year) {
        return year % 4 == 0;
    }

    public static int calculateCorporationTax(String state, int year, int profit){
        double federalTaxRate = 21;
        double stateTaxRate = stateTax(state);

        double totalTax;
        if (isLeapYear(year)) {
            totalTax = calcurateTax(stateTaxRate, profit);
        } else {
            totalTax = calcurateTax(federalTaxRate, profit) + calcurateTax(stateTaxRate, profit);
        }

        return (int) Math.ceil(totalTax);
    }

    public static void main(String[] args) {
        System.out.println(calculateCorporationTax("CA", 2020, 100000));
    }
}
