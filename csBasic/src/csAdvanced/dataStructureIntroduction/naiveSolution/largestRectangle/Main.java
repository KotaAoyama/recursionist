package csAdvanced.dataStructureIntroduction.naiveSolution.largestRectangle;

public class Main{
    public static int largestRectangle(int[] h){
        int[] results = new int[h.length];

        // nested for loops, O(n^2)
        for (int i = 0; i < h.length; i++) {
            int j = i - 1;
            int total = 1;
            int curr = h[i];
            while (j >= 0 && curr <= h[j]) {
                total += 1;
                j -= 1;
            }
            j = i + 1;
            while (j < h.length && curr <= h[j]) {
                total += 1;
                j += 1;
            }
            results[i] = total * curr;
        }
        int maxValue = 0;
        for(Integer num: results) {
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