package csAdvanced.dataStructureIntroduction.stack.stack2;

import java.util.ArrayList;

class Node{
    public int data;
    public Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

class Stack {
    public Node head;

    public Stack(){
        this.head = null;
    }

    public void push(int data){
        Node temp = this.head;
        this.head = new Node(data);
        this.head.next = temp;
    }

    public Integer pop(){
        if (this.head == null) return null;
        Node temp = this.head;
        this.head = this.head.next;
        return temp.data;
    }

    public Integer peek(){
        if (this.head == null) return null;
        return this.head.data;
    }
}

public class Main{

    // リストを受け取り、単調減少している部分リストを返す関数を実装します。
    // リストの途中で単調増加する部分が出現したら、部分リストをリセットします。
    public static int[] consecutiveWalk(int[] arr){
        Stack stack = new Stack();
        stack.push(arr[0]);
        for(int i = 1; i < arr.length; i++){
            // スタックの上にある要素より、arr[i]が大きい場合、スタックをリセットします。
            if(stack.peek() <= arr[i]){
                // スタックがnullになるまで繰り返されます。
                while(stack.pop() != null);
            }
            // スタックにプッシュします。スタックは常に単調減少になっています。
            stack.push(arr[i]);
        }

        ArrayList<Integer> resultDynamic = new ArrayList<>();
        // resultsは逆向きになっています。
        // add(0, num)は、配列の先頭にnumを追加します。
        while(stack.peek() != null) resultDynamic.add(0,stack.pop());
        // 固定配列に入れ替えます。
        int[] results = new int[resultDynamic.size()];
        for (int i = 0; i < resultDynamic.size(); i++) results[i] = resultDynamic.get(i);
        return results;
    }

    public static void printList(int[] arr){
        System.out.print("[");
        for(Integer num: arr){
            System.out.print(num + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args){

        // [5,3,2]
        printList(consecutiveWalk(new int[]{3,4,20,45,56,6,4,3,5,3,2}));
        // [64,3,0,-34,-54]
        printList(consecutiveWalk(new int[]{4,5,4,2,4,3646,34,64,3,0,-34,-54}));
        // [4]
        printList(consecutiveWalk(new int[]{4,5,4,2,4,3646,34,64,3,0,-34,-54,4}));
    }
}