package csBacis.functionPractice.javaScriptComment;

public class Main {
    public static boolean isCommentOutValid(String s) {
        return s.replace("/**/", "//")
                .replace("//", "")
                .equals("");
//        return s.matches("(//|/\\*\\*/)+"); // this is also valid
    }

    public static void main(String[] args) {
        System.out.println(isCommentOutValid("//")); // --> true
        System.out.println(isCommentOutValid("///")); // --> false
        System.out.println(isCommentOutValid("////")); // --> true
        System.out.println(isCommentOutValid("/**/")); // --> true
        System.out.println(isCommentOutValid("/*/*/")); // --> false
        System.out.println(isCommentOutValid("/*//*/")); // --> false
        System.out.println(isCommentOutValid("/**//////**/")); // --> true
        System.out.println(isCommentOutValid("//////////////**")); // --> false
        System.out.println(isCommentOutValid("//**////**/")); // --> false
    }
}
