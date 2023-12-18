package datastructure;

public class LinkedListReverse {
    Node head;
    static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addNode(int data){
        Node  node = new Node(data);
        node.next = head;
        head = node;
    }

    public Node reverseLinkedList(Node node){
        Node prev = null;
        Node curr = node;
        while(curr != null){
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        //return prev;
        while(prev != null){
            System.out.println(prev.data);
            prev = prev.next;
        }
        return prev;
    }

    public Node reversRecursive(Node head){
        if(head == null|| head.next == null) return head;
         Node newHead = reversRecursive(head.next);
         Node headNext = head.next;
         headNext.next = head;
         head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        LinkedListReverse llr = new LinkedListReverse();
        llr.addNode(2);
        llr.addNode(3);
        llr.addNode(4);
        llr.addNode(5);
        Node node = llr.reverseLinkedList(llr.head);
        //Node node = llr.reversRecursive(llr.head);
        System.out.println("---Recursive reverse ---");
        while(node != null){
            System.out.println(node.data);
            node = node.next;
        }
    }
}
