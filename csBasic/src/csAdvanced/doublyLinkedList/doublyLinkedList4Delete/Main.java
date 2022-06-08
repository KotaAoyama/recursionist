package csAdvanced.doublyLinkedList.doublyLinkedList4Delete;

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

    public void preappend(Node newNode){
        this.head.prev = newNode;
        newNode.next = this.head;
        newNode.prev = null;
        this.head = newNode;
    }

    public void append(Node newNode){
        this.tail.next = newNode;
        newNode.prev = this.tail;
        newNode.next = null;
        this.tail = newNode;
    }

    public void addNextNode(Node node, Node newNode){
        Node tempNode = node.next;
        node.next = newNode;
        newNode.next = tempNode;
        newNode.prev = node;

        if(node == this.tail) this.tail = newNode;
        else tempNode.prev = newNode;
    }

    // リストの先頭から要素をpopします。O(1)
    public void popFront(){
        this.head = this.head.next;
        this.head.prev = null;
    }

    // リストの末尾から要素をpopします。O(1)
    public void pop(){
        this.tail = this.tail.prev;
        this.tail.next = null;
    }

    // 与えられたノードをO(1)で削除します。
    public void deleteNode(Node node){
        if(node == this.tail) this.pop();
        else if(node == this.head) this.popFront();
        else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
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

class Main{

    public static void main(String[] args){
        int[] arr = new int[]{35,23,546,67,86,234,56,767,34,1,98,78,555};
        DoublyLinkedList numList = new DoublyLinkedList(arr);

        numList.printList();

        // pop
        numList.popFront();
        numList.pop();

        numList.printList();
        numList.printInReverse();

        // 要素を削除します
        System.out.println("Deleting in O(1)");
        numList.deleteNode(numList.at(3));
        numList.deleteNode(numList.at(9));
        numList.deleteNode(numList.at(0));

        numList.printList();
        numList.printInReverse();

    }
}