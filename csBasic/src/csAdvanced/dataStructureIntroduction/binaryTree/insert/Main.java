package csAdvanced.dataStructureIntroduction.binaryTree.insert;

import java.util.Arrays;

class BinaryTree{
    public int data;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(int data){
        this.data = data;
    }

    public BinaryTree(int data, BinaryTree left, BinaryTree right){
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public void printInOrder(){
        this.inOrderwalk(this);
        System.out.println("");
    }

    public void inOrderwalk(BinaryTree tRoot){
        if(tRoot != null){
            inOrderwalk(tRoot.left);
            System.out.print(tRoot.data+ " ");
            inOrderwalk(tRoot.right);
        }
    }
}

class BinarySearchTree{
    public BinaryTree root;

    public BinarySearchTree(int[] arr){
        Arrays.sort(arr);
        this.root = sortedBSTHelper(arr, 0, arr.length-1);
    }

    public static BinaryTree sortedBSTHelper(int[] arr, int start, int end){
        if(start == end) return new BinaryTree(arr[start], null, null);

        int mid = (int)Math.floor((start+end)/2);
        BinaryTree left=null;
        if(start<mid) left = sortedBSTHelper(arr, start, mid-1);
        BinaryTree right=null;
        if(end>mid) right = sortedBSTHelper(arr, mid+1, end);
        BinaryTree root = new BinaryTree(arr[mid], left, right);
        return root;
    }

    public boolean existKey(int key){
        BinaryTree iterator = this.root;
        while(iterator != null){
            if(iterator.data == key) return true;
            else if(iterator.data > key) iterator = iterator.left;
            else iterator = iterator.right;
        }
        return false;
    }

    public BinaryTree search(int key){
        BinaryTree iterator = this.root;
        while(iterator != null){
            if(iterator.data == key) return iterator;
            if(iterator.data > key) iterator = iterator.left;
            else iterator = iterator.right;
        }
        return null;
    }

    // insert
    public void insert(int val){
        BinaryTree iterator = this.root;
        while(iterator != null){
            if(iterator.data > val && iterator.left != null) iterator = iterator.left;
            if(iterator.data > val && iterator.left == null) {
                iterator.left = new BinaryTree(val);
                break;
            }
            if(iterator.data < val && iterator.right != null) iterator = iterator.right;
            if(iterator.data < val && iterator.right == null) {
                iterator.right = new BinaryTree(val);
                break;
            }
        }
    }

    public void printSorted(){
        this.root.printInOrder();
    }
}

class Main{
    public static void main(String[] args){

        BinarySearchTree balancedBST = new BinarySearchTree(new int[]{4,43,36,46,32,7,97,95,34,8,96,35,85,1010,232});
        balancedBST.printSorted();
        balancedBST.insert(5);
        balancedBST.printSorted();
        balancedBST.insert(47);
        balancedBST.printSorted();
        balancedBST.insert(0);
        balancedBST.printSorted();
        balancedBST.insert(811);
        balancedBST.printSorted();
    }
}