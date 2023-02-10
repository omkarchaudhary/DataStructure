package datastructure;

public class LinkedListPalindrome {
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
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    public Node getMiddle(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast= fast.next.next;
        }
        return slow;
    }

    public Node reverseNode(Node head){
        Node cur = head;
        Node prev = null;
        while(cur != null){
            Node temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        LinkedListPalindrome llr = new LinkedListPalindrome();
        llr.addNode(2);
        llr.addNode(3);
        llr.addNode(4);
        llr.addNode(5);
        llr.addNode(4);
        llr.addNode(3);
        llr.addNode(2);
        Node firstNode = llr.head;
        Node middleNode = llr.getMiddle(llr.head);
        Node lastNode = llr.reverseNode(middleNode);
        while(lastNode != null){
            if( firstNode.data !=  lastNode.data){
                System.out.println("The list is not palindrome");
            }
            firstNode = firstNode.next;
            lastNode = lastNode.next;
        }
        System.out.println("The list is palidrome. ");
    }
}
