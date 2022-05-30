package csAdvanced.singlyLinkedList1;

class Node{
    public int data;
    public Node next;

    public Node(int data){
        this.data = data;
    }
}

class SinglyLinkedList{
    // 配列が渡されるようにします。片方向リストの初期化を行います。
    public Node head;

    public SinglyLinkedList(int[] arr){
        // 連結リストは先頭が必要です。もし配列に要素が存在しなれば、nullを初期値とします。
        this.head = arr.length > 0 ? new Node(arr[0]) : null;

        Node currentNode = this.head;
        System.out.print("[ ");
        System.out.print(currentNode.data + " ");
        for(int i = 1; i < arr.length; i++){
            currentNode.next = new Node(arr[i]);
            currentNode = currentNode.next;
            System.out.print(currentNode.data + " ");
        }
        System.out.println("]");
    }

    public Node at(int index){
        Node iterator = this.head;
        // 与えられたインデックスまでリストの中を反復します。
        // nullになったところは反復の範囲外になります。
        for(int i = 0; i < index; i++){
            // もしnextがnullの場合、nullを返します。これはインデックスが範囲外にあることを示します。
            iterator = iterator.next;
            if(iterator == null) return null;
        }
        return iterator;
    }
}

class Main{
    public static void main(String[] args){
        int[] arr = new int[]{35,23,546,67,86,234,56,767,34,1,98,78,555};
        SinglyLinkedList numList = new SinglyLinkedList(arr);
        // 連結リストを反復します。
        System.out.println(numList.at(2).data);
        System.out.println(numList.at(12).data);

        // System.out.println(numList.at(13).data); // a(13)はnullを返すので、エラーになります。
    }
}