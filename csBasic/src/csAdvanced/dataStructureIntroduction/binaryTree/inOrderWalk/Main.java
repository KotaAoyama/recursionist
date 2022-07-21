package csAdvanced.dataStructureIntroduction.binaryTree.inOrderWalk;

import java.util.Arrays;

class BinaryTree<E> {
    private final int data;
    private final BinaryTree<E> left;
    private final BinaryTree<E> right;

    public BinaryTree(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public BinaryTree(int data, BinaryTree<E> left, BinaryTree<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public void printInOrder() {
        this.inOrderWalk(this);
        System.out.println("");
    }

    public void inOrderWalk(BinaryTree<E> root) {
        if (root != null) {
            this.inOrderWalk(root.left);
            System.out.print(root.data + " ");
            this.inOrderWalk(root.right);
        }
    }
}

class BinarySearchTree<E> {

    private BinaryTree<E> root;

    public BinarySearchTree(int[] arr) {
        Arrays.sort(arr);
        this.root = sortedArrayToBST(arr);
    }

    private BinaryTree<E> sortedArrayToBST(int[] arr) {
        if (arr.length == 0) return null;
        return sortedArrayToBSTHelper(arr, 0, arr.length - 1);
    }

    private BinaryTree<E> sortedArrayToBSTHelper(int[] arr, int start, int end) {
        if (start == end) return new BinaryTree<E>(arr[start], null, null);

        int mid = (int) Math.floor((start + end) / 2);

        BinaryTree<E> left = null;
        if (mid - 1 >= start) left = sortedArrayToBSTHelper(arr, start, mid - 1);

        BinaryTree<E> right = null;
        if (mid + 1 <= end) right = sortedArrayToBSTHelper(arr, mid + 1, end);

        BinaryTree<E> root = new BinaryTree<>(arr[mid], left, right);
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
