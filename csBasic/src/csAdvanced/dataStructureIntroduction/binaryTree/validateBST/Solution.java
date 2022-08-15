package csAdvanced.dataStructureIntroduction.binaryTree.validateBST;

class Solution {
    private static boolean validateBST(BinaryTree<Integer> root) {
        if (root == null) return true;
        return validateBSTHelper(root, null, null);
    }

    private static boolean validateBSTHelper(BinaryTree<Integer> root, Integer low, Integer high) {
        if (root == null) return true;

        if (low != null && root.data < low) return false;
        if (high != null && root.data > high) return false;

        boolean left = validateBSTHelper(root.left, low, root.data);
        boolean right = validateBSTHelper(root.right, root.data, high);

        return left && right;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> root1 = new BinaryTree<>(15,
                new BinaryTree<>(10, new BinaryTree<>(8), new BinaryTree<>(12)),
                new BinaryTree<>(20, new BinaryTree<>(16), new BinaryTree<>(25)));
        System.out.println(validateBST(root1));

        BinaryTree<Integer> root2 = new BinaryTree<>(5,
                new BinaryTree<>(3, new BinaryTree<>(1), new BinaryTree<>(6)),
                new BinaryTree<>(9, new BinaryTree<>(8), null));
        System.out.println(validateBST(root2));
    }
}
