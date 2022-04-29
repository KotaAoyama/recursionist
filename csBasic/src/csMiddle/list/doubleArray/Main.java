package csMiddle.list.doubleArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static List<Integer> doubledArrayHelper(List<Integer> list, int start, int end) {
        if (start == end) {
            List<Integer> baseList = new ArrayList<Integer>(){};
            baseList.add(list.get(start) * 2);
            return baseList;
        }

        int middle = (start + end) / 2;

        List<Integer> left = doubledArrayHelper(list, start, middle);
        List<Integer> right = doubledArrayHelper(list, middle+1, end);

        left.addAll(right);

        return left;
    }

    public static int[] doubledArray(int[] arr){
        List<Integer> list = new ArrayList<>();
        for (int j : arr) {
            list.add(j);
        }
        list = doubledArrayHelper(list, 0, arr.length-1);
        int[] resultArr = new int[list.size()];
        for (int i = 0; i < resultArr.length; i++) {
            resultArr[i] = list.get(i);
        }
        return resultArr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(doubledArray(new int[]{2, 1, 6, 8, 11})));
    }
}
