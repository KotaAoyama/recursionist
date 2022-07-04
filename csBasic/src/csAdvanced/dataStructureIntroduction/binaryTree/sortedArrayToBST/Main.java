package csAdvanced.dataStructureIntroduction.binaryTree.sortedArrayToBST;

class BinaryTree{
    public int data;
    public BinaryTree left;
    public BinaryTree right;
    // オーバーローディング
    public BinaryTree(int data){ this.data = data; }
    public BinaryTree(int data, BinaryTree left, BinaryTree right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

public class Main{
    public static BinaryTree sortedArrayToBSTHelper(int[] arr, int start, int end) {
        if(start == end) return new BinaryTree(arr[start], null,null);

        int mid = (int) Math.floor((start+end)/2);

        BinaryTree left = null;
        if(mid-1 >= start) left = sortedArrayToBSTHelper(arr, start, mid-1);

        BinaryTree right = null;
        if(mid+1 <= end) right = sortedArrayToBSTHelper(arr, mid+1, end);

        BinaryTree root = new BinaryTree(arr[mid], left, right);
        return root;
    }

    public static BinaryTree sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        return sortedArrayToBSTHelper(nums, 0, nums.length-1);
    }

    public static void main(String[] args){
        BinaryTree balancedBST = sortedArrayToBST(new int[]{1,2,3,4,5,6,7,8,9,10,11});


        //                 6
        //         3              　9
        //      1     4         7      10
        //   null 2 null 5  null  8  null  11


        System.out.println(balancedBST.data);
        System.out.println(balancedBST.left.data);
        System.out.println(balancedBST.left.left.data);
        System.out.println(balancedBST.left.left.right.data);
        System.out.println(balancedBST.left.right.data);
        System.out.println(balancedBST.left.right.right.data);

        System.out.println(balancedBST.right.data);
        System.out.println(balancedBST.right.left.data);
        System.out.println(balancedBST.right.left.right.data);
        System.out.println(balancedBST.right.right.data);
        System.out.println(balancedBST.right.right.right.data);
    }
}
