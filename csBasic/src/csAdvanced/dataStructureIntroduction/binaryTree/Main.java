package csAdvanced.dataStructureIntroduction.binaryTree;

class BinaryTree{
    public int data;
    // 左二分木
    public BinaryTree left;
    // 右二分木
    public BinaryTree right;

    public BinaryTree(int data){
        this.data = data;
    }
}

public class Main{
    public static void main(String[] args){
        BinaryTree binaryTree = new BinaryTree(1);
        BinaryTree node2 = new BinaryTree(2);
        BinaryTree node3 = new BinaryTree(3);

        binaryTree.left = node2;
        binaryTree.right = node3;

        System.out.println("Root: " + binaryTree.data);
        System.out.println("Left: " + binaryTree.left.data);
        System.out.println("Right: " + binaryTree.right.data);
    }
}