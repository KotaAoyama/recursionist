package csMiddle.list.mergeSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static List<Integer> mergeSort(List<Integer> arr){
        return mergeSortHelper(arr, 0, arr.size() - 1);
    }

    public static List<Integer> mergeSortHelper(List<Integer> arr, int start, int end){
        // 配列が 1 つになるまで再帰的に分割していきます
        // 1 つになったらマージ作業へ移ります
        if(start == end) return new ArrayList<>(Arrays.asList(arr.get(start)));

        // 配列が 2 つ以上の時には leftArray と rightArray に分割し続けます
        int middle = (int)Math.floor((start+end)/2);

        List<Integer> leftArr = mergeSortHelper(arr, start, middle);
        List<Integer> rightArr = mergeSortHelper(arr, middle+1, end);

        // leftArr と rightArr それぞれの最後に int 型の最大値を入れておくことで、ソートが完了するまで比較し続けることができます
        leftArr.add(Integer.MAX_VALUE);
        rightArr.add(Integer.MAX_VALUE);

        int l = leftArr.size() + rightArr.size() - 2;
        int li = 0;
        int ri = 0;

        // 右と左がソートされた後、結合されます
        List<Integer> merged = new ArrayList<>();

        // leftArray と rightArray を比較して、どちらが先に merged に入るか決めます
        while(li+ri < l){
            if(leftArr.get(li) <= rightArr.get(ri)){
                merged.add(leftArr.get(li));
                li++;
            }else {
                merged.add(rightArr.get(ri));
                ri++;
            }
        }

        // leftArray と rightArray の全ての値が merged に入るまで繰り返します
        return merged;
    }

    public static void main (String[] args) {
        List<Integer> arr1 =  new ArrayList<>(Arrays.asList(34,4546,32,3,2,8,6,76,56,45,34,566,1));
        System.out.println(arr1);
        System.out.println(mergeSort(arr1));
    }
}
