package csAdvanced.dataStructureIntroduction.binaryTree.randomBST;

// 受け取った配列をシャッフルし、insertメソッド使って要素を1つずつ空の二分探索木に挿入していきます。シャッフルすることで、根ノードの選択をランダムにすることができ、平均の高さがO(logn)に近づきます。
// 例えば[1,2,3,4,5]という配列があった時、根ノードを1として順に二分探索木を作成すると、2 から 5 まで全て右側の子となってします。これは高さがO(n)となり非常に効率の悪い構造ですが、このような構造になるのは[1,2,3,4,5]と[5,4,3,2,1]の2通りしかありません。その確率は 2/5! となり要素数が増えるほど低くなります。

import java.util.ArrayList;
import java.util.*;

class BinaryTree {
    public int data;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(int data) {
        this.data = data;
    }

    public BinaryTree(int data, BinaryTree left, BinaryTree right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    void printInOrder() {
        this.inOrderwalk(this);
        System.out.println("");
    }

    private void inOrderwalk(BinaryTree tRoot) {
        if (tRoot != null) {
            inOrderwalk(tRoot.left);
            System.out.print(tRoot.data + " ");
            inOrderwalk(tRoot.right);
        }
    }
}

class BinarySearchTree {
    public BinaryTree root;

    public BinarySearchTree(ArrayList<Integer> arrList) {
        this.generateRandomBST(arrList);
    }

    // 受け取った配列をシャッフルしてBSTを作る関数を作ります。
    private void generateRandomBST(ArrayList<Integer> arrList) {
        if (arrList.isEmpty()) this.root = null;
        else {
            // Collectionsクラスのshuffleメソッドを使います。デフォルトの乱数発生の元を使用して、指定されたリストの順序を無作為に入れ替えます。 あらゆる組み合わせが、ほぼ均等な確率で発生します。
            Collections.shuffle(arrList);
            this.root = new BinaryTree(arrList.get(0));
            for (int i = 0; i < arrList.size(); i++) {
                //　シャッフルした配列の要素を一つずつinsertでBSTに挿入します。
                this.insert(arrList.get(i));
            }
        }
    }

    public BinaryTree insert(int data) {
        BinaryTree iterator = this.root;
        while (iterator != null) {
            if (iterator.data > data && iterator.left == null) iterator.left = new BinaryTree(data);
            else if (iterator.data < data && iterator.right == null) iterator.right = new BinaryTree(data);
            iterator = (iterator.data > data) ? iterator.left : iterator.right;
        }
        return this.root;
    }

    public static int maximumDepth(BinaryTree root) {
        if (root == null) return 0;
        int maxleft = maximumDepth(root.left);
        int maxright = maximumDepth(root.right);
        return (maxleft > maxright) ? maxleft + 1 : maxright + 1;
    }

    public void printSorted() {
        if (this.root == null) return;
        this.root.printInOrder();
    }
}

// 昇順に並んだ配列を作る関数
class RandomContainer {
    public static ArrayList<Integer> generateList(int size) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) list.add(i);
        return list;
    }
}

class Main {
    public static void main(String[] args) {

        ArrayList<Integer> list = RandomContainer.generateList(256);
        BinarySearchTree balancedBST = new BinarySearchTree(list);
        balancedBST.printSorted();
        System.out.println(16 * 16); // 256   要素数が増えると高さが log2n に近づきます。
        System.out.println("MaxDepth: " + BinarySearchTree.maximumDepth(balancedBST.root));

        ArrayList<Integer> list2 = new ArrayList<>();
        BinarySearchTree balancedBST2 = new BinarySearchTree(list2);
        balancedBST2.printSorted();
        System.out.println("MaxDepth: " + BinarySearchTree.maximumDepth(balancedBST2.root));

    }
}