package csMiddle.list.insersionSort;

import java.util.Arrays;

public class Main {
    public static void insertionSort(int[] list) {
        int n = list.length;

        for (int i = 1; i < n; i++){
            int currentValue = list[i];

            // currentValue の左側を探索し、挿入できる箇所を探索します
            for (int j = i - 1; j >= 0; j--){
                // currentValue が小さい場合は、値を入れ替えていきます
                if (currentValue <= list[j]){
                    list[j+1] = list[j];
                    list[j] = currentValue;
                }
                // currentValue が大きい場合は、、それは正しい位置にあるので、ループを終了して i+1 に移動します
                else break;
            }
        }
    }

    public static void main(String[] args){
        int[] arr = new int[]{34,4546,32,3,2,8,6,76,56,45,34,566,1};
        System.out.println(Arrays.toString(arr));
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
