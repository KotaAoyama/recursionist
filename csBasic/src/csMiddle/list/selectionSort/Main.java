package csMiddle.list.selectionSort;

import java.util.Arrays;

public class Main {
    public static int[] selectionSort(int[] arr){

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) minIndex = j;
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(selectionSort(new int[]{2, 12, 5, 10, 9, 8})));
    }
}
