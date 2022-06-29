package csAdvanced.dataStructureIntroduction.stack.largestRectangle;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main{
    public static int[] stackCounter(int[] arr) {

        Deque<Integer> stack = new ArrayDeque<>(); // 両端キュー
        int[] results = new int[arr.length]; // 配列
        int i = 0;
        for (Integer x: arr) {
            int total = 1;
            while (stack.size() != 0 && arr[stack.peek()] >= x) {
                int j = stack.pop();
                total += results[j];
            }

            stack.push(i);
            results[i] = total;
            i++;

        }
        return results;
    }

    public static int[] reverse(int[] arr) {
        int[] newArr = new int[arr.length];
        for (int i = arr.length-1, j = 0; i >= 0; i--, j++) {
            newArr[j] = arr[i];
        }
        return newArr;
    }

    public static int largestRectangle(int[] h){

        int[] left = stackCounter(h);
        int[] right = reverse(stackCounter(reverse(h)));
        int[] total = new int[h.length];

        for(int i = 0; i < h.length; i++) {
            total[i] = (left[i] + right[i]-1) * h[i];
        }

        int maxValue = 0;
        for(Integer num: total) {
            maxValue = Math.max(num, maxValue);
        }
        return maxValue;
    }

    public static void main(String[] args){
        System.out.println(largestRectangle(new int[]{3,2,3})); // 6
        System.out.println(largestRectangle(new int[]{1,2,5,2,3,4})); // 10
        System.out.println(largestRectangle(new int[]{1,2,3,4,5})); // 9
        System.out.println(largestRectangle(new int[]{3,4,5,8,10,2,1,3,9})); // 16
        System.out.println(largestRectangle(new int[]{1,2,1,3,5,2,3,4})); // 10
        System.out.println(largestRectangle(new int[]{11,11,10,10,10})); // 50
        System.out.println(largestRectangle(new int[]{8979,4570,6436,5083,7780,3269,5400,7579,2324,2116})); // 26152
    }
}
