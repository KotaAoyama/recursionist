package csAdvanced.dataStructureIntroduction.naiveSolution.largestRectangle;

public class Main{
    public static int largestRectangle(int[] h){
        int[] tempMaxArr = new int[h.length];
        for (int i = 0; i < h.length; i++) {
            int maxWidth = 1;
            for (int j = i+1; j < h.length; j++) {
                if (h[j] >= h[i]) maxWidth++;
                else break;
            }
            for (int j = i-1; j >= 0; j--) {
                if (h[j] >= h[i]) maxWidth++;
                else break;
            }
            tempMaxArr[i] = h[i] * maxWidth;
        }

        int max = Integer.MIN_VALUE;
        for (int tempMax : tempMaxArr) {
            if (max < tempMax) max = tempMax;
        }

        return max;
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