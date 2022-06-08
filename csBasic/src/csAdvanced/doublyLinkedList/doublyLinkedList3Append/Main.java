package csAdvanced.doublyLinkedList.doublyLinkedList3Append;

class Node{
    public int data;
    public Node prev;
    public Node next;

    public Node(int data){
        this.data = data;
    }
}

class DoublyLinkedList{
    public Node head;
    public Node tail;

    public DoublyLinkedList(int[] arr){
        if(arr.length <= 0){
            this.head = null;
            this.tail = this.head;
            return;
        }

        this.head = new Node(arr[0]);
        Node currentNode = this.head;
        for(int i=1; i < arr.length; i++){
            currentNode.next = new Node(arr[i]);
            currentNode.next.prev = currentNode;
            currentNode = currentNode.next;
        }
        this.tail = currentNode;
    }

    public Node at(int index){
        Node iterator = this.head;
        for(int i=0; i < index; i++){
            iterator = iterator.next;
            if(iterator == null) return null;
        }
        return iterator;
    }

    // リストの先頭に追加します。
    public void preappend(Node newNode){
        this.head.prev = newNode;
        newNode.next = this.head;
        newNode.prev = null;
        this.head = newNode;
    }

    // リストの最後に追加します
    public void append(Node newNode){
        this.tail.next = newNode;
        newNode.prev = this.tail;
        newNode.next = null;
        // 末尾をアップデート
        this.tail = newNode;
    }

    // 与えられたノードの次に追加します。必要であれば末尾を更新してください。
    // 処理を紙に書いて確認しましょう。オブジェクトなので、=はメモリアドレスを指します。
    public void addNextNode(Node node, Node newNode){
        Node tempNode = node.next;
        node.next = newNode;
        newNode.next = tempNode;
        newNode.prev = node;

        // もし与えられたノードが末尾なら、その後ろに新しいノードが追加されるので、末尾をアップデートしてください。
        // それ以外の場合は、tempNodeの前をnewNodeに設定してください。
        if(node == this.tail) this.tail = newNode;
        else tempNode.prev = newNode;
    }

    public void reverse(){
        Node reverse = this.tail;
        Node iterator = this.tail.prev;

        Node currentNode = reverse;
        while(iterator != null){
            currentNode.next = iterator;

            iterator = iterator.prev;
            if(iterator != null) iterator.next = null;

            currentNode.next.prev = currentNode;
            currentNode = currentNode.next;

        }
        this.tail = currentNode;
        this.head = reverse;
        this.head.prev = null;
    }

    public void printInReverse(){
        String str = "";
        Node iterator = this.tail;
        while(iterator != null){
            str += iterator.data + " ";
            iterator = iterator.prev;
        }
        System.out.println("[" + str + "]");
    }

    public void printList(){
        Node iterator = this.head;
        String str = "";
        while(iterator != null){
            str += iterator.data + " ";
            iterator = iterator.next;
        }
        System.out.println("[" + str + "]");
    }
}

public class Main{

    public static void main(String[] args){
        int[] arr = new int[]{35,23,546,67,86,234,56,767,34,1,98,78,555};
        DoublyLinkedList numList = new DoublyLinkedList(arr);

        numList.printList();

        // 45をpreappend
        numList.preappend(new Node(45));
        System.out.println(numList.head.data);
        numList.printList();

        // 71をappend
        numList.append(new Node(71));
        System.out.println(numList.tail.data);
        numList.printList();

        // ノードの後に新しいノードを追加
        numList.addNextNode(numList.at(3), new Node(4));
        numList.printList();
        System.out.println(numList.tail.data);

        numList.addNextNode(numList.at(15), new Node(679));
        numList.printList();
        System.out.println(numList.tail.data);

        numList.printInReverse();
    }
}