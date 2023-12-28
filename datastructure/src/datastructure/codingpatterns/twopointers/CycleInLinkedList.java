package datastructure.codingpatterns.twopointers;

class ListNode{
    int value;
    ListNode next;
    ListNode(int value){
        this.value = value;
    }
}
public class CycleInLinkedList {
    public static void main(String[] args) {
        CycleInLinkedList cycleInLinkedList = new CycleInLinkedList();
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(2);
        head.next = node;
        node.next = new ListNode(3);
        node.next.next = new ListNode(4);
        node.next.next.next = node;
        System.out.println("Is cycle in linked list: " + cycleInLinkedList.hasCycle(head));
    }

    private boolean hasCycle(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if(slowPointer == fastPointer){
                return true;
            }
        }
        return false;
    }
}
