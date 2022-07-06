package csAdvanced.dataStructureIntroduction.binaryTree.search;

import java.util.Arrays;

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

class BinarySearchTree{
    public BinaryTree root;

    public BinarySearchTree(int[] arr){
        //平衡二分探索木を作成する前に、配列をソートします。
        Arrays.sort(arr);
        this.root = sortedArrayToBSTHelper(arr, 0, arr.length-1);
    }

    public boolean keyExist(int key){
        BinaryTree iterator =this.root;
        while(iterator != null){
            if(iterator.data == key) return true;
            // 現在のノードよりキーが小さければ左に、大きければ右に辿ります。
            if(iterator.data > key) iterator = iterator.left;
            else iterator = iterator.right;
        }

        return false;
    }

    public BinaryTree search(int key){
        BinaryTree iterator =this.root;
        while(iterator != null){
            if(iterator.data == key) return iterator;
            // 現在のノードよりキーが小さければ左に、大きければ右に辿ります。
            if(iterator.data > key) iterator = iterator.left;
            else iterator = iterator.right;
        }

        return null;
    }

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
}

public class Main{

    public static void main(String[] args){
        BinarySearchTree balancedBST = new BinarySearchTree(new int[]{1,2,3,4,5,6,7,8,9,10,11});
        System.out.println(balancedBST.keyExist(6));
        System.out.println(balancedBST.search(6));
        System.out.println(balancedBST.keyExist(2));
        System.out.println(balancedBST.search(2));
        System.out.println(balancedBST.search(34));
    }
}