package csAdvanced.dataStructureIntroduction.binaryTree.symmetricTree;

class Solution{
    private static boolean symmetricTree(BinaryTree<Integer> root){

        if (root == null) return true;

        return symmetricTreeHelper(root.left, root.right);
    }

    private static boolean symmetricTreeHelper(BinaryTree<Integer> leftNode, BinaryTree<Integer> rightNode) {
        // ベースケース
        if (leftNode == null && rightNode == null) return true;
        if (leftNode == null || rightNode == null) return false;

        if (!leftNode.data.equals(rightNode.data)) return false;

        return symmetricTreeHelper(leftNode.left, rightNode.right) && symmetricTreeHelper(leftNode.right, rightNode.left);
    }

    public static void main(String[] args) {
        BinaryTree<Integer> root1 = new BinaryTree<>(1,
                new BinaryTree<>(2, new BinaryTree<>(3), new BinaryTree<>(4)),
                new BinaryTree<>(2, new BinaryTree<>(4), new BinaryTree<>(3)));
        System.out.println(symmetricTree(root1));

        BinaryTree<Integer> root2 = new BinaryTree<>(1,
                new BinaryTree<>(2, new BinaryTree<>(2), new BinaryTree<>(null)),
                new BinaryTree<>(2, new BinaryTree<>(2), null));
        System.out.println(symmetricTree(root2));
    }
}