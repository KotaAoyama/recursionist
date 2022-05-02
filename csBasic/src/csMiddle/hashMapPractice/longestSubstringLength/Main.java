//package csMiddle.hashMapPractice.longestSubstringLength;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class Main {
//    public static int longestSubstringLength(String password){
//        Map<Character, List<Integer>> charIndexMap = new HashMap<>();
//
//        for (int i = 0; i < password.length(); i++) {
//            Character ch = password.charAt(i);
//            if (charIndexMap.get(ch) == null) {
//                List<Integer> indexList = new ArrayList<>();
//                indexList.add(i);
//                charIndexMap.put(ch, indexList);
//            } else {
//                List<Integer> indexList = charIndexMap.get(ch);
//                indexList.add(i);
//                charIndexMap.replace(password.charAt(i), indexList);
//            }
//        }
//        System.out.println(charIndexMap);
//        System.out.println();
//
//        int maxLength = 0;
//        int startIndex = 0;
//        int currentLength = 0;
//
//        for (int i = 0; i < password.length(); i++) {
//            System.out.println("i: " + i);
//            System.out.println("password.charAt(i): " + password.charAt(i));
//            System.out.println("startIndex: " + startIndex);
//            System.out.println("currentLength1: " + currentLength);
//            System.out.println("maxLength1: " + maxLength);
//
//
//
//            Character ch = password.charAt(i);
//            List<Integer> charIndexList = charIndexMap.get(ch);
//            System.out.println("charIndexList1: " + charIndexList);
//            if (charIndexList.get(0) < startIndex) charIndexList.remove(0);
////            System.out.println("charIndexList2: " + charIndexList);
//
//            if (charIndexList.get(0) == i) {
//                currentLength++;
//            } else {
//                if (maxLength < currentLength) maxLength = currentLength;
//                currentLength = 1;
//                startIndex = i;
//                while (charIndexList.get(0) < startIndex) {
//                    charIndexList.remove(0);
//                }
//                System.out.println("charIndexList2: " + charIndexList);
////                if (charIndexList.get(0) < startIndex) charIndexList.remove(0);
//            }
//            charIndexMap.replace(ch, charIndexList);
//            System.out.println("currentLength2: " + currentLength);
//            System.out.println("maxLength2: " + maxLength);
//            System.out.println("--------------");
//        }
//        if (maxLength < currentLength) maxLength = currentLength;
//
//
//
//        return maxLength;
//    }
//}
