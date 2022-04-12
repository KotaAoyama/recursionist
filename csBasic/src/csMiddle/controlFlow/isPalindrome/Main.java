package csMiddle.controlFlow.isPalindrome;

public class Main {
    public static boolean isPalindrome(String stringInput){
        stringInput = stringInput.replace(" ", "").toUpperCase();

        int left = 0;
        int right = stringInput.length()-1;
        while(left <= right/2) {
            if (stringInput.charAt(left) != stringInput.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("kayak"));
        System.out.println(isPalindrome("recursion"));
        System.out.println(isPalindrome("Top spot"));
        System.out.println(isPalindrome("Was it a cat I saw"));
    }
}
