package csAdvanced.queue.dequeue;

class Node{
    public int data;
    public Node prev;
    public Node next;

    public Node(int data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class Deque{
    public Node head;
    public Node tail;

    public Deque(){
        this.head = null;
        this.tail = null;
    }

    public Integer peekFront(){
        if (this.head == null) return null;
        return this.head.data;
    }

    public Integer peekBack(){
        if (this.tail == null) return peekFront();
        return this.tail.data;
    }

    public void enqueueFront(int data){
        if (this.head == null) {
            this.head = new Node(data);
        } else if (this.head.next == null) {
            Node temp = this.head;
            this.head = new Node(data);
            this.head.next = temp;
            this.tail = this.head.next;
            this.tail.prev = this.head;
        } else {
            Node temp = this.head;
            this.head = new Node(data);
            this.head.next = temp;
            temp.prev = this.head;
        }
    }

    public void enqueueBack(int data){
        if (this.head == null) {
            this.head = new Node(data);
        } else if (this.head.next == null) {
            this.head.next = new Node(data);
            this.tail = this.head.next;
            this.tail.prev = this.head;
        } else {
            Node temp = this.tail;
            this.tail = new Node(data);
            this.tail.prev = temp;
            temp.next = this.tail;
        }
    }

    public Integer dequeueFront(){
        if (this.head == null) {
            return null;
        } else if (this.head.next == null) {
            Node temp = this.head;
            this.head = null;
            return temp.data;
        } else {
            Node temp = this.head;
            this.head = temp.next;
            this.head.prev = null;
            return temp.data;
        }
    }

    public Integer dequeueBack(){
        if (this.head == null) {
            return null;
        } else if (this.head.next == null) {
            Node temp = this.head;
            this.head = null;
            return temp.data;
        } else {
            Node temp = this.tail;
            this.tail = temp.prev;
            this.tail.next = null;
            return temp.data;
        }
    }
}

class MyClass{
    public static void main(String[] args){
        Deque q = new Deque();
        q.enqueueBack(4);
        q.enqueueBack(50);
        System.out.println(q.peekFront()); // 4
        System.out.println(q.peekBack()); // 50
        q.enqueueFront(36);
        q.enqueueFront(96);
        System.out.println(q.peekFront()); // 96
        System.out.println(q.peekBack()); // 50
        System.out.println(q.dequeueBack()); // 50
        System.out.println(q.dequeueBack()); // 4
        System.out.println(q.peekFront()); // 96
        System.out.println(q.peekBack()); // 36
    }
}
