package csMiddle.list.shuffledArr;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static int[] shuffledPositions(int[] arr, int[] shuffledArr){
        int[] result = new int[arr.length];
        Map<Integer, Integer> shuffledArrIndexMap = new HashMap<>();

        for (int i = 0; i < shuffledArr.length; i++) {
            shuffledArrIndexMap.put(shuffledArr[i], i);
        }

        for (int i = 0; i < arr.length; i++) {
            result[i] = shuffledArrIndexMap.get(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        printArr(shuffledPositions(new int[]{2,32,45},new int[]{45,32,2}));// --> [2,1,0]
        printArr(shuffledPositions(new int[]{10,11,12,13},new int[]{12,10,13,11}));// --> [1,3,0,2]
        printArr(shuffledPositions(new int[] {10,11,12,13}, new int[]{10,11,12,13}));// --> [0,1,2,3]
        printArr(shuffledPositions(new int[]{1350,181,1714,375,1331,943,735}, new int[]{1714,1331,735,375,1350,181,943}));// --> [4,5,0,3,1,6,2]
    }

    public static void printArr(int[] arr) {
        String output = "";
        for (int j : arr) {
            output += j + ",";
        }
        System.out.println("[" + output.substring(0, output.length()-1) + "]");
    }
}
