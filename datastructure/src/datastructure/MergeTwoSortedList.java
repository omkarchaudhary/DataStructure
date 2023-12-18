package datastructure;

public class MergeTwoSortedList {
    
    Node head;
    static class Node{
        int data;
        Node next;
        public Node(){}
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public MergeTwoSortedList(){
        head = null;
    }

    public void addNode(int data){
        Node node = new Node(data);
        if(head == null){
            head= node;
        }
        else{
            head.next = node;
            head = node;
        }
    }

    public Node mergeTwoLists(Node list1, Node list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        Node cur = new Node();
        Node result = cur;
        while(list1 != null && list2 != null){
            if(list1.data < list2.data){
                cur.next = list1;
                list1 = list1.next;
            }else{
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if(list1 != null){
            cur.next = list1;
        }
        if(list2 != null){
            cur.next = list2;
        }

        return result.next;
    }


    public static void main(String[] args) {
        MergeTwoSortedList llr = new MergeTwoSortedList();
        llr.addNode(2);
        llr.addNode(3);
        llr.addNode(5);

        MergeTwoSortedList ll2 = new MergeTwoSortedList();
        ll2.addNode(1);
        ll2.addNode(4);
        ll2.addNode(6);
        Node node = llr.mergeTwoLists(llr.head, ll2.head);
        //Node node = llr.reversRecursive(llr.head);
        System.out.println("---Recursive reverse ---");
        while(node != null){
            System.out.println(node.data);
            node = node.next;
        }
    }
}
