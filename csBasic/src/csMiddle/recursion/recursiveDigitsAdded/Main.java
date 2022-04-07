package csMiddle.recursion.recursiveDigitsAdded;

public class Main {
    public static int splitAndAdd(long digits) {
        if (digits <= 0) return 0;

        return (int) (splitAndAdd((long) Math.floor(digits / 10)) + digits % 10);
    }

    public static int recursiveDigitsAddedHelper(long digits, int previous) {
        if (digits < 10) return previous;

        int current = splitAndAdd(digits);
        return recursiveDigitsAddedHelper(current, previous + current);
    }

    public static int recursiveDigitsAdded(long digits){
        if (digits < 10) return (int) digits;
        else return recursiveDigitsAddedHelper(digits, 0);
    }

    public static void main(String[] args) {
        System.out.println(recursiveDigitsAdded(8)); // --> 8
        System.out.println(recursiveDigitsAdded(12)); // --> 3
        System.out.println(recursiveDigitsAdded(3528)); // --> 27
        System.out.println(recursiveDigitsAdded(68305823053330L)); // --> 66
    }
}
