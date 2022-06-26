package csAdvanced.dataStructureIntroduction.queue.minWindowArrK;

import java.util.*;

class Solution{
    // TODO: Fix comments
    public static int[] minWindowArrK(int[] intArr, int k){
        List<Integer> results = new ArrayList<>();
        if(k > intArr.length) return new int[]{};

        Deque<Integer> deque = new ArrayDeque<>();

        // サイズKのウィンドウを作ります。
        for (int i=0; i < k; i++){
            // 新しい値とdequeの最後尾の値を比較して、新しい値より大きい値は全て削除します。
            while(!deque.isEmpty() && intArr[deque.peekLast()] >= intArr[i]){
                // pollLast()は後ろから削除します。
                deque.pollLast();
            }
            // 新しい値をdequeに入れます。
            deque.addLast(i);
        }

        // Kからスタートし、残りの要素をウィンドウへ入れていきます。
        for(int i=k; i < intArr.length; i++){
            // 先頭の値をresultsにpushします。先頭はサイズkのウィンドウの中で最小値になっています。
            results.add(intArr[deque.peekFirst()]);
            // ウィンドウの左端からはみ出た要素は取り除きます。pop()は先頭を削除します。
            while(!deque.isEmpty() && deque.peekFirst() <= i-k) deque.pop();
            // 新しい値とdequeの最後尾を比較します。新しい値より大きい値はdequeから削除します。
            while(!deque.isEmpty() && intArr[deque.peekLast()] >= intArr[i]) deque.pollLast();
            // 新しい値をdequeに入れます。
            deque.addLast(i);
        }

        // 最後のウィンドウの分の最小値をresultsに追加します。
        results.add(intArr[deque.peekFirst()]);
        // 固定配列に変換
        int[] resultArr = new int[results.size()];
        for (int i = 0; i < results.size(); i++) resultArr[i] = results.get(i);

        return resultArr;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution.minWindowArrK(new int[]{2, 3, 1, 1, 12, 3, 10}, 1))); // --> [2,3,1,1,12,3,10]
        System.out.println(Arrays.toString(Solution.minWindowArrK(new int[]{2, 3, 1, 1, 12, 3, 10}, 3))); // --> [1,1,1,1,3]
        System.out.println(Arrays.toString(Solution.minWindowArrK(new int[]{2, 3, 1, 1, 12, 3, 10}, 4))); // --> [1,1,1,1]
        System.out.println(Arrays.toString(Solution.minWindowArrK(new int[]{3, 9, 10, 2, 4, 5}, 3))); // --> [3,2,2,2]
        System.out.println(Arrays.toString(Solution.minWindowArrK(new int[]{3, 9, 10, 2, 4, 5}, 5))); // --> [2,2]
        System.out.println(Arrays.toString(Solution.minWindowArrK(new int[]{30, 50, 60, 20, 30, 64, 80}, 3))); // --> [30,20,20,20,30]
        System.out.println(Arrays.toString(Solution.minWindowArrK(new int[]{30, 50, 60, 20, 30, 64, 80}, 2))); // --> [30,50,20,20,30,64]
        System.out.println(Arrays.toString(Solution.minWindowArrK(new int[]{24, 5, 67, 60, 24, 64, 23, 536, 345}, 3))); // --> [5,5,24,24,23,23,23]
    }
}
