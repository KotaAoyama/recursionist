package csAdvanced.dataStructureIntroduction.binaryTree.symmetricTree;

import static csAdvanced.dataStructureIntroduction.binaryTree.symmetricTree.Solution.symmetricTree;

public class Main {
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
