package csAdvanced.dataStructureIntroduction.queue.minWindowArrK;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution{
    // TODO: Fix comments
    public static int[] minWindowArrK(int[] intArr, int k){
        List<Integer> results = new ArrayList<>();
        if(k > intArr.length) return new int[]{};

        Deque<Integer> deque = new ArrayDeque<>();

        // dequeの初期化
        for (int i=0; i < k; i++){
            // 新しい値と既存の値を比較して、新しい値以上は全て削除するので、dequeの末尾は新しい値より小さい値になります。
            // dequeの先頭は最小値です。(新しい値より小さいので削除されないから。)
            while(deque.peekLast() != null && intArr[deque.peekLast()] >= intArr[i]){
                deque.removeLast();
            }
            deque.addLast(i);

        }

        for(int i=k; i < intArr.length; i++){
            // dequeの先頭は最大値
            results.add(intArr[deque.peekFirst()]);

            // ウィンドウ外にある要素は取り除きます。
            while(deque.peekFirst() != null && deque.peekFirst() <= i-k) deque.removeFirst();
            // 現在の値とそれより大きい全てのdequeの値をチェック
            while(deque.peekLast() != null && intArr[deque.peekLast()] >= intArr[i]) deque.removeLast();
            deque.addLast(i);
        }

        // 最後のmax
        results.add(intArr[deque.peekFirst()]);

        int[] resultArr = new int[results.size()];
        for (int i = 0; i < results.size(); i++) resultArr[i] = results.get(i);

        return resultArr;
    }
}

public class Main {
}
