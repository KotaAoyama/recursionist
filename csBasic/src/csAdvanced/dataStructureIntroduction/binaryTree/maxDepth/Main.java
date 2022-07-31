package csAdvanced.dataStructureIntroduction.binaryTree.maxDepth;

import java.util.Arrays;

class BinaryTree<E>{
    public int data;
    public BinaryTree<E> left;
    public BinaryTree<E> right;

    public BinaryTree(int data){ this.data = data;}
    public BinaryTree(int data, BinaryTree<E> left, BinaryTree<E> right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

class BinarySearchTree<E>{
    private final BinaryTree<E> root;

    public BinarySearchTree(int[] arr){
        Arrays.sort(arr);
        this.root = sortedArrayToBSTHelper(arr, 0, arr.length-1);
    }


    private BinaryTree<E> sortedArrayToBSTHelper(int[] arr, int start, int end){
        if(start == end) return new BinaryTree<E>(arr[start], null, null);

        int mid = (int)Math.floor((start+end)/2);

        BinaryTree<E> left = null;
        if(start <= mid-1) left = sortedArrayToBSTHelper(arr, start, mid-1);

        BinaryTree<E> right = null;
        if(end >= mid+1) right = sortedArrayToBSTHelper(arr, mid+1, end);

        return new BinaryTree<E>(arr[mid], left, right);
    }

    public int maxDepth(){
        if (this.root == null) return 0;
        if (this.root.left == null && this.root.right == null) return 1;
        return maxDepthHelper(this.root, 0);
    }

    private int maxDepthHelper(BinaryTree<E> root, int depth) {
        if (root == null) return depth;

        if (maxDepthHelper(root.left, depth) > maxDepthHelper(root.right, depth)) {
            return maxDepthHelper(root.left, depth+1);
        } else {
            return maxDepthHelper(root.right, depth+1);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(new int[]{90,50,150,20,75,95,175,5,25,66,80,92,111,166,200});
        System.out.println(bst.maxDepth());
    }
}
