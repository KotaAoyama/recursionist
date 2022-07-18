package csAdvanced.dataStructureIntroduction.binaryTree.inOrderWalk;

import java.util.Arrays;

class BinaryTree<Integer> {
    private final int data;
    private final BinaryTree<Integer> left;
    private final BinaryTree<Integer> right;

    public BinaryTree(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public BinaryTree(int data, BinaryTree<Integer> left, BinaryTree<Integer> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public void printInOrder() {
        this.inOrderWalk(this);
        System.out.println("");
    }

    public void inOrderWalk(BinaryTree<Integer> root) {
        if (root != null) {
            this.inOrderWalk(root.left);
            System.out.println(root.data);
            this.inOrderWalk(root.right);
        }
    }
}

class BinarySearchTree<Integer> {

    private BinaryTree<Integer> root;

    public BinarySearchTree(int[] arr) {
        Arrays.sort(arr);
        this.root = sortedArrayToBST(arr);
    }

    private BinaryTree<Integer> sortedArrayToBST(int[] arr) {
        if (arr.length == 0) return null;
        return sortedArrayToBSTHelper(arr, 0, arr.length - 1);
    }

    private BinaryTree<Integer> sortedArrayToBSTHelper(int[] arr, int start, int end) {
        if (start == end) return new BinaryTree<Integer>(arr[start], null, null);

        int mid = (int) Math.floor((start + end) / 2);

        BinaryTree<Integer> left = null;
        if (mid - 1 >= start) left = sortedArrayToBSTHelper(arr, start, mid - 1);

        BinaryTree<Integer> right = null;
        if (mid + 1 <= end) right = sortedArrayToBSTHelper(arr, mid + 1, end);

        BinaryTree<Integer> root = new BinaryTree<Integer>(arr[mid], left, right);
        return root;
    }

    public void printSorted() {
        this.root.printInOrder();
    }
}

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> balancedBST = new BinarySearchTree<>(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11});
        balancedBST.printSorted();
        BinarySearchTree<Integer> balancedBST2 = new BinarySearchTree<>(new int[]{4,43,36,46,32,7,97,95,34,8,96,35,85,1010,232});
        balancedBST2.printSorted();
    }
}
