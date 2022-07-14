package csMiddle.list.sumOfArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static int sumOfArrayHelper(List<Integer> arr, int start, int end) {
        if (start == end) return arr.get(start);

        int middle = (start + end) / 2;

        int sumOfRightList = sumOfArrayHelper(arr, middle+1, end);
        int sumOfLeftList = sumOfArrayHelper(arr, start, middle);

        return sumOfLeftList + sumOfRightList;
    }

    public static int sumOfArray(List<Integer> arr){
        return sumOfArrayHelper(arr, 0, arr.size()-1);
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(2,4,6,8,10,12));
        System.out.println(sumOfArray(arr));
    }
}
