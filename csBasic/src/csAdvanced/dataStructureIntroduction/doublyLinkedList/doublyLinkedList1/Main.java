package csAdvanced.dataStructureIntroduction.doublyLinkedList.doublyLinkedList1;

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
        // 片方向リストと同じ処理
        for(int i=0; i < index; i++){
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
        System.out.println("[" + str + "]");
    }
}

public class Main{
    public static void main(String[] args){
        int[] arr = new int[]{35,23,546,67,86,234,56,767,34,1,98,78,555};
        DoublyLinkedList numList = new DoublyLinkedList(arr);

        numList.printList();
        System.out.println(numList.at(0).data);
        System.out.println(numList.at(2).data);
        System.out.println(numList.at(12).data);

    }
}