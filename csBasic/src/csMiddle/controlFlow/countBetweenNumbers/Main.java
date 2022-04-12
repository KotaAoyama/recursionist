package csMiddle.controlFlow.countBetweenNumbers;

public class Main {
    public static int countBetweenNumbers(int digit, int idStart, int idEnd){

        int countInt = 0;

        for (int i = idStart; i <= idEnd; i++) {
            int currentNum = i;
            while(currentNum != 0) {
                if (currentNum % 10 == digit) countInt++;
                currentNum = currentNum / 10;
            }
        }

        return countInt;
    }

    public static void main(String[] args) {
        System.out.println(countBetweenNumbers(1,1,20)); //  --> 12
    }
}
