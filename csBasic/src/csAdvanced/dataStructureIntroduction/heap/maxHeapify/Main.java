package csAdvanced.dataStructureIntroduction.heap.maxHeapify;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {
    public static void main(String[] args) {

        List<Integer> heap1 = new ArrayList<>(Arrays.asList(new Integer[]{2,42,11,30,10,7,6,5,9}));

        System.out.println(heap1);
        Heap.maxHeapify(heap1,0);// 根ノードが2で、2 < 42のため、最大ヒープではありません。
        System.out.println(heap1);

        List<Integer> heap2 = new ArrayList<>(Arrays.asList(new Integer[]{56,4,51,10,12,5,12,4,6,5}));
        System.out.println(heap2);
        Heap.maxHeapify(heap2,1);// インデックス1が4で、4 < 10のため、最大ヒープではありません。
        System.out.println(heap2);

    }
}
