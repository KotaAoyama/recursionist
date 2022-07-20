package csAdvanced.dataStructureIntroduction.binaryTree.postOrderWalk;

import java.util.Arrays;

class BinaryTree{
    public int data;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(int data){ this.data = data;}
    public BinaryTree(int data, BinaryTree left, BinaryTree right){
        this.data = data;
        this.left = left;
        this.right = right;

    }

    public void printInOrder(){
        this.inOrderWalk(this);
        System.out.println("");
    }

    public void printPreOrder(){
        this.preOrderWalk(this);
        System.out.println("");
    }

    public void printPostOrder(){
        this.postOrderWalk(this);
        System.out.println("");
    }

    // 間順 (in-order) (LNR)
    public void inOrderWalk(BinaryTree tRoot){
        if(tRoot!=null){
            this.inOrderWalk(tRoot.left);
            System.out.print(tRoot.data + " ");
            this.inOrderWalk(tRoot.right);
        }
    }

    // 前順（pre-order）（NLR）
    public void preOrderWalk(BinaryTree tRoot){
        if(tRoot!=null){
            System.out.print(tRoot.data + " ");
            this.preOrderWalk(tRoot.left);
            this.preOrderWalk(tRoot.right);
        }
    }

    // 後順（post-order）（LRN）
    public void postOrderWalk(BinaryTree tRoot){
        if(tRoot!=null){
            this.postOrderWalk(tRoot.left);
            this.postOrderWalk(tRoot.right);
            System.out.print(tRoot.data + " ");
        }
    }

}

class BinarySearchTree{
    public BinaryTree root;

    public BinarySearchTree(int[] arr){
        Arrays.sort(arr);
        this.root = sortedArrayToBSTHelper(arr, 0, arr.length-1);
    }


    private static BinaryTree sortedArrayToBSTHelper(int[] arr, int start, int end){
        if(start == end) return new BinaryTree(arr[start], null, null);

        int mid = (int)Math.floor((start+end)/2);

        BinaryTree left = null;
        if(start <= mid-1) left = sortedArrayToBSTHelper(arr, start, mid-1);

        BinaryTree right = null;
        if(end >= mid+1) right = sortedArrayToBSTHelper(arr, mid+1, end);

        BinaryTree root = new BinaryTree(arr[mid], left, right);

        return root;
    }

    public boolean keyExist(int key){
        BinaryTree iterator = this.root;
        while(iterator != null){
            if(iterator.data == key) return true;
            if(iterator.data < key) iterator = iterator.right;
            else iterator = iterator.left;
        }
        return false;
    }

    public BinaryTree search(int key){
        BinaryTree iterator = this.root;
        while(iterator != null){
            if(iterator.data == key) return iterator;
            if(iterator.data < key) iterator = iterator.right;
            else iterator = iterator.left;
        }
        return null;
    }

    public void printSorted(){
        this.root.printPostOrder();
    }
}

public class Main{
    public static void main(String[] args){
        BinarySearchTree balancedBST = new BinarySearchTree(new int[]{1,2,3,4,5,6,7,8,9,10,11});
        BinarySearchTree balancedBST2 = new BinarySearchTree(new int[]{4,43,36,46,32,7,97,95,34,8,96,35,85,1010,232});
        balancedBST.printSorted();
        balancedBST2.printSorted();
    }
}