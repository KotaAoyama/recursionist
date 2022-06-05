package csAdvanced.singlyLinkedList.singlyLinkedList8Reverse;

class Node{
    public int data;
    public Node next;

    public Node(int data){
        this.data = data;
    }

    public void addNextNode(Node newNode){
        Node tempNode = this.next;
        this.next = newNode;
        newNode.next = tempNode;
    }
}

class SinglyLinkedList{
    public Node head;

    public SinglyLinkedList(int[] arr){
        this.head = arr.length > 0? new Node(arr[0]) : null;

        Node currentNode = this.head;
        for(int i=1; i < arr.length; i++){
            currentNode.next = new Node(arr[i]);
            currentNode = currentNode.next;
        }
    }

    public Node at(int index){
        Node iterator = this.head;
        for(int i=1; i < index; i++){
            iterator = iterator.next;
            if(iterator == null) return null;
        }
        return iterator;
    }

    public void preappend(Node newNode){
        newNode.next = this.head;
        this.head = newNode;
    }

    public void popFront(){
        this.head = this.head.next;
    }

    public void delete(int index){
        if (index == 0) this.popFront();
        Node iterator = this.head;
        for(int i = 0; i < index-1; i++){
            if(iterator.next == null) return;
            iterator = iterator.next;
        }
        iterator.next = iterator.next.next;
    }

    // ここから開発してください。


    public void printList(){
        Node iterator = this.head;
        String str = "";
        while(iterator != null){
            str += iterator.data + " ";
            iterator = iterator.next;
        }
        System.out.println(str);
    }
}

class Main{

    public static void main(String[] args){

        int[] arr = new int[]{35,23,546,67,86,234,56,767,34,1,98,78,555};
        SinglyLinkedList numList = new SinglyLinkedList(arr);

        // 逆側に表示してみましょう。

    }
}