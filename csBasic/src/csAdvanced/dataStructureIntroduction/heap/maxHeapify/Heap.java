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

    int parent(int i) { return (int)Math.floor((i-1)/2); }

    void printArr() {
        System.out.println(arr);
    }

    private void maxHeapify(int i) {

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

    void buildMaxHeap() {
        int middle = parent(arr.size()-1);
        for (int j = middle; j >= 0; j--) {
            maxHeapify(j);
        }
    }
}

class Main {
    public static void main(String[] args) {

        Heap heap1 = new Heap(new ArrayList<>(Arrays.asList(2,42,11,30,10,7,6,5,9)));
        heap1.printArr();// 根ノードが2で、2 < 42のため、最大ヒープではない。
        heap1.buildMaxHeap();//　根ノードが最大値となり木全体が最大ヒープになる。
        heap1.printArr();// 42, 30, 11, 9, 10, 7, 6, 5, 2

        Heap heap2 = new Heap(new ArrayList<>(Arrays.asList(56,4,51,10,12,5,12,4,6,5)));
        heap2.printArr();// インデックス1が4で、4 < 10のため、最大ヒープではない。
        heap2.buildMaxHeap();//　根ノードが最大値となり木全体が最大ヒープになる。
        heap2.printArr();// 56, 12, 51, 10, 5, 5, 12, 4, 6, 4
    }
}
