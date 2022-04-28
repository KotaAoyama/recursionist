package csMiddle.list.insersionSort;

import java.util.Arrays;

public class Main {
    public static void selectionSort(int[] list) {
        int n = list.length;
        for (int i = 0; i < n; i++){
            // i 番目の値を暫定の最小値とします
            int minIndex = i;
            // i 番目より後ろから最小値を探します
            for (int j = i + 1; j < n; j++){
                // 暫定の最小値以下なら最小値を更新
                if (list[j] <= list[minIndex]){
                    minIndex = j;
                }
            }
            // 最小値と先頭を in-place で入れ替え
            int temp = list[i];
            list[i] = list[minIndex];
            list[minIndex] = temp;
        }
    }

    public static void main(String[] args){
        int[] arr = new int[]{34,4546,32,3,2,8,6,76,56,45,34,566,1};
        System.out.println(Arrays.toString(arr));
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
