package csAdvanced.dataStructureIntroduction.binaryTree.symmetricTree;

final class Solution{
    static boolean symmetricTree(BinaryTree<Integer> root){

        if (root == null) return true;

        return symmetricTreeHelper(root.left, root.right);
    }

    static boolean symmetricTreeHelper(BinaryTree<Integer> leftNode, BinaryTree<Integer> rightNode) {
        // ベースケース
        if (leftNode == null && rightNode == null) return true;
        if (leftNode == null || rightNode == null) return false;

        if (!leftNode.data.equals(rightNode.data)) return false;

        return symmetricTreeHelper(leftNode.left, rightNode.right) && symmetricTreeHelper(leftNode.right, rightNode.left);
    }
}