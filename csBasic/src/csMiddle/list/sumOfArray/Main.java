package csMiddle.list.sumOfArray;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static int sumOfArrayHelper(List<Integer> list, int start, int end) {
        if (start == end) return list.get(start);

        int middle = (start + end) / 2;

        int sumOfRightList = sumOfArrayHelper(list, middle+1, end);
        int sumOfLeftList = sumOfArrayHelper(list, start, middle);

        return sumOfLeftList + sumOfRightList;
    }

    public static int sumOfArray(int[] arr){
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        return sumOfArrayHelper(list, 0, list.size()-1);
    }

    public static void main(String[] args) {
        System.out.println(sumOfArray(new int[]{2,4,6,8,10}));
    }
}
