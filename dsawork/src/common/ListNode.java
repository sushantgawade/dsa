package common;

public class ListNode {

    public int val;
    public ListNode next;

    // Constructor
    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public ListNode(int val, ListNode head) {
        this.val = val;
        this.next = head;
    }

}
