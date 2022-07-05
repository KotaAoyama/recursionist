package csAdvanced.dataStructureIntroduction.binaryTree.keyExists;


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

    // BSTリストの中にキーが存在かどうかによって、true、falseを返します。
    // 再帰
    public static boolean keyExistRecursiveVer(int key, BinaryTree bst){
        if(bst == null) return false;
        if(bst.data == key) return true;

        // 現在のノードよりキーが小さければ左に、大きければ右に辿ります。
        if(bst.data > key) return keyExistRecursiveVer(key, bst.left);
        else return keyExistRecursiveVer(key, bst.right);
    }
    // loop
    public static boolean keyExistLoopVer(int key, BinaryTree bst){
        BinaryTree iterator = bst;
        while(iterator != null){
            if(iterator.data == key) return true;
            // 現在のノードよりキーが小さければ左に、大きければ右に辿ります。
            if(iterator.data > key) iterator = iterator.left;
            else iterator = iterator.right;
        }

        return false;
    }

    public static void main(String[] args){
        BinaryTree balancedBST = sortedArrayToBST(new int[]{1,2,3,4,5,6,7,8,9,10,11});
        System.out.println(keyExistRecursiveVer(6, balancedBST));
        System.out.println(keyExistRecursiveVer(10, balancedBST));
        System.out.println(keyExistRecursiveVer(45, balancedBST));
        System.out.println(keyExistLoopVer(6, balancedBST));
        System.out.println(keyExistLoopVer(10, balancedBST));
        System.out.println(keyExistLoopVer(45, balancedBST));
    }
}