package csAdvanced.dataStructureIntroduction.heap.maxHeapify;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Heap {
    private final List<Integer> arr;

    Heap(List<Integer> arr) {
        this.arr = arr;
    }

    int left(int i) {
        return 2*i + 1;
    }

    int right(int i) {
        return 2*i + 2;
    }

    void printArr() {
        System.out.println(arr);
    }

    void maxHeapify(int i) {

        int l = left(i);
        int r = right(i);

        int biggest = i;
        if(l < arr.size() && arr.get(l) > arr.get(biggest)) biggest = l;
        if(r < arr.size() && arr.get(r) > arr.get(biggest)) biggest = r;

        if (biggest != i) {
            int temp = arr.get(i);
            arr.set(i, arr.get(biggest));
            arr.set(biggest, temp);
            maxHeapify(biggest);
        }
    }
}

class Main {
    public static void main(String[] args) {

        Heap heap1 = new Heap(new ArrayList<>(Arrays.asList(2,42,11,30,10,7,6,5,9)));
        heap1.printArr();
        heap1.maxHeapify(1);// 根ノードが2で、2 < 42のため、最大ヒープではない。
        heap1.printArr();

        Heap heap2 = new Heap(new ArrayList<>(Arrays.asList(56,4,51,10,12,5,12,4,6,5)));
        heap2.printArr();
        heap2.maxHeapify(1);// インデックス1が4で、4 < 10のため、最大ヒープではない。
        heap2.printArr();
    }
}
