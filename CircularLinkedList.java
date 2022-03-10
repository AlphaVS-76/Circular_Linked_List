package com.company;

public class CircularLinkedList {
    private Node head;
    private Node tail;
    private int size;
    public CircularLinkedList(){
        this.head = null;
        this.tail = null;
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        if(head == null){
            head = node;
            tail = node;
            return;
        }

        node.next = head;
        tail.next = node;
        head = node;

        size++;
    }

    public void insertLast(int val){
        Node node = new Node(val);
        if(head == tail){
            insertFirst(val);
            return;
        }

        node.next = head;
        tail.next = node;
        tail = node;

        size++;
    }

    public void insertIndex(int val , int index){
        if(index==0){
            insertFirst(val);
            return;
        }
        if(index==size-1){
            insertLast(val);
            return;
        }
        Node before = get(index-1);
        Node temp = new Node(val);

        temp.next = before.next;
        before.next = temp;

        size++;
    }

    public void display(){
        Node temp = head;

        do{
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        } while(temp != head);

        System.out.print("Head");
    }

    public Node get(int index) {
        Node node = head;

        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
    }

    public void deleteFirst(){
        if(head==null){
            System.out.println("Already Empty");
            return;
        }
        tail.next = head.next;
        head.next = head;

        size--;
    }

    public void deleteLast(){
        if(head == tail){
            deleteFirst();
            return;
        }
        Node before = get(size-3);

        before.next = head;
        before = tail;

        size--;
    }

    public void deleteIndex(int index){
        if (index == 0){
            deleteFirst();
            return;
        }
        if(index == size-1){
            deleteLast();
            return;
        }
        Node before = get(index-1);
        Node target = get(index);

        before.next = target.next;

        size--;
    }

    private class Node{
        private Node next;
        private int val;

        public Node(){
            this.val = 0;
        }

        public Node(int val){
            this.val = val;
        }

        public Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }
}
//------------------------------------------------------------------------------
//Main Function
//------------------------------------------------------------------------------
package com.company;

public class Practice {
    public static void main(String[] args) {
        CircularLinkedList list1 = new CircularLinkedList();

        list1.insertFirst(1);
        list1.insertFirst(2);
        list1.insertFirst(3);
        list1.insertFirst(4);
        list1.insertFirst(5);
        list1.insertLast(0);

        list1.display();

        System.out.println();

        list1.insertIndex(69, 3);
        list1.display();
    }
}
