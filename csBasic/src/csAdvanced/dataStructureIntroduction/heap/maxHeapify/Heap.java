package csAdvanced.dataStructureIntroduction.heap.maxHeapify;

import java.util.List;

class Heap {
    public static int left(int i) {
        return 2*i + 1;
    }

    public static int right(int i) {
        return 2*i + 2;
    }

    public static void maxHeapify(List<Integer> arr, int i) {

        int l = Heap.left(i);
        int r = Heap.right(i);

        int biggest = i;
        if(l < arr.size() && arr.get(l) > arr.get(biggest)) biggest = l;
        if(r < arr.size() && arr.get(r) > arr.get(biggest)) biggest = r;

        if (biggest != i) {
            int temp = arr.get(i);
            arr.set(i, arr.get(biggest));
            arr.set(biggest, temp);
            Heap.maxHeapify(arr, biggest);
        }
    }
}
