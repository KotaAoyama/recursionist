package csAdvanced.dataStructureIntroduction.queue.minWindowArrK;

import java.util.*;

class Solution{
    // TODO: Fix comments
    public static int[] minWindowArrK(int[] intArr, int k){
        List<Integer> results = new ArrayList<>();
        if(k > intArr.length) return new int[]{};

        Deque<Integer> deque = new ArrayDeque<>();

        // dequeの初期化
        for (int i=0; i < k; i++){
            // 新しい値と既存の値を比較して、新しい値以上の既存の値は全て削除するので、dequeの末尾は新しい値より小さい値になります。
            // dequeの末尾は最小値です。(新しい値より小さいので削除されないから。)
            while(deque.peekLast() != null && intArr[deque.peekLast()] >= intArr[i]){
                deque.removeLast();
            }
            deque.addLast(i);

        }

        for(int i=k; i < intArr.length; i++){
            // dequeの先頭は最小値
            results.add(intArr[deque.peekFirst()]);

            // ウィンドウ外にある要素は取り除きます。
            while(deque.peekFirst() != null && deque.peekFirst() <= i-k) deque.removeFirst();
            // 現在の値とそれより大きい全てのdequeの値をチェック
            while(deque.peekLast() != null && intArr[deque.peekLast()] >= intArr[i]) deque.removeLast();
            deque.addLast(i);
        }

        // 最後のmin
        results.add(intArr[deque.peekFirst()]);

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
