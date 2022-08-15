package csAdvanced.dataStructureIntroduction.binaryTree.validateBST;

class BinaryTree<E> {
    E data;
    BinaryTree<E> left;
    BinaryTree<E> right;

    public BinaryTree() {}
    public BinaryTree(E data) { this.data = data; }
    public BinaryTree(E data, BinaryTree<E> left, BinaryTree<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
