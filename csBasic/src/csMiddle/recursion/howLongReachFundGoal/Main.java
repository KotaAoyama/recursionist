package csMiddle.recursion.howLongReachFundGoal;

public class Main {
    public static int howLongToReachFundGoalHelper(int year, double capitalMoney, double goalMoney, int interest) {
        if (year >= 80) return 80;
        if (capitalMoney >= goalMoney) return year;

        capitalMoney = capitalMoney * (100 + interest) / 100;
        if (year % 2 == 0) {
            goalMoney = goalMoney * 1.02;
        } else {
            goalMoney = goalMoney * 1.03;
        }

        return howLongToReachFundGoalHelper(++year, capitalMoney, goalMoney, interest);

    }

    public static int howLongToReachFundGoal(int capitalMoney, int goalMoney, int interest){
        return howLongToReachFundGoalHelper(0, capitalMoney, goalMoney, interest);
    }

    public static int howLongToReachFundGoalForVer(int capitalMoney, int goalMoney, int interest) {
        int year = 0;

        while (capitalMoney < goalMoney) {
            if (year >= 80) return 80;

            double inflationRate = (year % 2 == 0) ? 0.02 : 0.03;

            capitalMoney *= 1 + interest/100;
            goalMoney *= 1 + inflationRate;

            year++;
        }

        return year;
    }

    public static void main(String[] args) {
        System.out.println(howLongToReachFundGoal(5421,10421,5));
        System.out.println(howLongToReachFundGoal(5421,30,30));
        System.out.println(howLongToReachFundGoal(600,10400,7));
    }
}
