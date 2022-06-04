package csAdvanced.singlyLinkedList.singlyLinkedList3Insert;

class Node{
    public int data;
    public Node next;

    public Node(int data){
        this.data = data;
    }
}

class SinglyLinkedList{
    public Node head;
    public int[] arr;

    public SinglyLinkedList(int[] arr){
        this.head = arr.length > 0? new Node(arr[0]) : null;
        this.arr = arr;

        Node currentNode = this.head;
        for(int i=1; i < arr.length;i++){
            currentNode.next = new Node(arr[i]);
            currentNode = currentNode.next;
        }
    }

    public Node at(int index){
        Node iterator = this.head;
        for(int i=0; i < index;i++){
            iterator = iterator.next;
            if(iterator == null) return null;
        }
        return iterator;
    }

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
        System.out.println(numList.at(2).data);
        System.out.println(numList.at(3).data);
        System.out.println(numList.at(4).data);
        numList.printList();

        // インデックス2と3の間に40という値を挿入します。
        Node thirdEle = numList.at(2);
        Node tempNode = thirdEle.next;
        Node newNode = new Node(40);
        thirdEle.next = newNode;
        newNode.next = tempNode;

        System.out.println(numList.at(2).data);
        System.out.println(numList.at(3).data);
        System.out.println(numList.at(4).data);
        numList.printList();
    }
}