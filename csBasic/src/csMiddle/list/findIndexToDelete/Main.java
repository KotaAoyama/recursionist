package csMiddle.list.findIndexToDelete;

public class Main {
    public static int findIndexToDelete(String password){
        int left = 0;
        int right = password.length()-1;

        while (left < right) {
            if (password.charAt(left) != password.charAt(right)) {
                // left
                if (isPalindrome(password, left+1, right)) {

                    while(left > 0 && password.charAt(left) == password.charAt(left-1)) left--;

                    return left;
                }

                //right
                if (isPalindrome(password, left, right-1)) {
                    return right;
                }

                return -2;
            }
            left++;
            right--;
        }

        return -1;
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args){

        System.out.println(findIndexToDelete("aaab"));
        System.out.println(findIndexToDelete("forkayak"));
        System.out.println(findIndexToDelete("baa"));
        System.out.println(findIndexToDelete("abca"));
        System.out.println(findIndexToDelete("aaa"));
        System.out.println(findIndexToDelete("englishsilgne"));
        System.out.println(findIndexToDelete("abckktkcba"));
        System.out.println(findIndexToDelete("kkkckk"));
        System.out.println(findIndexToDelete("kkkkckkk"));
    }
}


