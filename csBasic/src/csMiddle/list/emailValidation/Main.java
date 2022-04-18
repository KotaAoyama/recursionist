//package csMiddle.list.emailValidation;
//
//import java.util.ArrayList;
//
//public class Main {
//    public static boolean isEmailValid(String email) {
//        boolean hasOneAtMark = false;
//        int atMarkCount = 0;
//        for (int i = 0; i < email.length(); i++) {
//            if (email.charAt(i) == '@') atMarkCount++;
//        }
//        hasOneAtMark = atMarkCount == 1 ? true : false;
//
////        boolean hasPoint = email.split("@")[1].find(".") != -1 ? true : false;
//
////        return hasOneAtMark && hasPoint;
//    }
//
//    public static String[] validEmailList(String[] emailList){
//        ArrayList<String> output = new ArrayList<>();
//
//        for (String email : emailList) {
//            if (isEmailValid(email)) {
//                output.add(email);
//            }
//        }
//
//        return output.toArray(new String[0]);
//    }
//}
