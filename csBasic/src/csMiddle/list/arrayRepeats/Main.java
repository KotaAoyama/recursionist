package csMiddle.list.arrayRepeats;

import java.util.*;

public class Main {
    public static int[] intersectionOfArraysRepeats(int[] intList1,int[] intList2){
        HashMap<Integer, Integer> hashmap = new HashMap<>(); // key - value, O(1)

        for (int i = 0; i < intList2.length; i++) {
            if (hashmap.get(intList2[i]) == null) hashmap.put(intList2[i], 1);
            else hashmap.put(intList2[i], hashmap.get(intList2[i])+ 1);
        }

        ArrayList<Integer> numList = new ArrayList<>();

        for (int i = 0; i < intList1.length; i++) {
            if (hashmap.get(intList1[i]) != null && hashmap.get(intList1[i])> 0) {
                numList.add(intList1[i]);
                hashmap.put(intList1[i], hashmap.get(intList1[i]) - 1);
            }
        }

        int[] results = new int[numList.size()];
        for(int i = 0; i < numList.size(); i++){
            results[i] = numList.get(i);
        }
        // in-place
        Arrays.sort(results);

        return results;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(intersectionOfArraysRepeats(new int[]{3,2,1},new int[]{3,2,1}))); // [1,2,3]
        System.out.println(Arrays.toString(intersectionOfArraysRepeats(new int[]{1,1,1},new int[]{1,2,3,2,1}))); // [1,1]
        System.out.println(Arrays.toString(intersectionOfArraysRepeats(new int[]{3,2,2,2,1,10,10},new int[]{3,2,10,10,10}))); // [2,3,10,10]
        System.out.println(Arrays.toString(intersectionOfArraysRepeats(new int[]{2,19,11,2,6,8},new int[]{10,23,5,8,19}))); // [8,19]
        System.out.println(Arrays.toString(intersectionOfArraysRepeats(new int[]{4,22,100,88,6,8},new int[]{1,2,3}))); // []
        System.out.println(Arrays.toString(intersectionOfArraysRepeats(new int[]{-1,-2,-1,-1},new int[]{-1,-1,-2,-2}))); // [-2,-1,-1]
        System.out.println(Arrays.toString(intersectionOfArraysRepeats(new int[]{1,2,2,1},new int[]{2,2,2,1}))); // [1,2,2]
        System.out.println(Arrays.toString(intersectionOfArraysRepeats(new int[]{4,9,5},new int[]{9,4,9,8,4}))); // [4,9]
    }
}
