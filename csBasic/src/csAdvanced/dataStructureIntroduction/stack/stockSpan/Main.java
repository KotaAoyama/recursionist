package csAdvanced.dataStructureIntroduction.stack.stockSpan;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Deque; // インターフェース
import java.util.ArrayDeque; // スタックとして使う両端キュー

public class Main{
    public static int[] stockSpan(int[] stocks){
        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> dResults = new ArrayList<>();

        for(int i = 0; i < stocks.length; i++) {
            int current = stocks[i];
            int counter = 1;

            while(!stack.isEmpty() && stocks[stack.peek()] < current) counter += dResults.get(stack.pop());
            // 動的配列ArrayListは後ろからadd
            dResults.add(counter);
            // 両端キューstackには先頭からpush
            stack.push(i);
        }
        // 固定配列に変換します。
        int[] results = new int[dResults.size()];
        for(int i = 0; i < dResults.size(); i++) {
            results[i] = dResults.get(i);
        }
        return results;
    }

//    public static int[] stockSpan(int[] stocks){
//        int[] resArr = new int[stocks.length];
//
//        for (int i = 0; i < stocks.length; i++) {
//            int count = 0;
//            for (int j = 0; j <= i; j++) {
//                if (stocks[i] >= stocks[j]) count++;
//                else count = 0;
//            }
//            resArr[i] = count;
//        }
//
//        return resArr;
//    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(stockSpan(new int[]{30,50,60,20,30,64,80}))); // [1,2,3,1,2,6,7]
        System.out.println(Arrays.toString(stockSpan(new int[]{24,5,67,60,24,64,23,536,345}))); // [1,1,3,1,1,3,1,8,1]
        System.out.println(Arrays.toString(stockSpan(new int[]{200,85,40,60,40,65,90}))); // [1,1,1,2,1,4,6]
        System.out.println(Arrays.toString(stockSpan(new int[]{30,45,20,100,235,300,4500,40,100}))); // [1,2,1,4,5,6,7,1,2]
        System.out.println(Arrays.toString(stockSpan(new int[]{34,640,100,234,56,34,25,200,1020,160}))); // [1,2,1,2,1,1,1,4,9,1]
    }
}
