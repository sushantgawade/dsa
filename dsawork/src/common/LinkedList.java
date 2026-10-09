package common;

import java.util.List;

public class LinkedList {

    public ListNode head;

    // Default constructor
    public LinkedList() {
        head = null;
    }

    // Constructor to initialize from a list of values
    public LinkedList(List<Integer> values) {
        head = null;
        createLinkedList(values);
    }


    private void createLinkedList(List<Integer> values) {

        if(null == values || values.isEmpty()) {
            return;
        }

        head = new ListNode(values.get(0));

        ListNode current = head;

        for(int i = 1; i < values.size(); i++) {

            current.next = new ListNode(values.get(i));

            current = current.next;
        }

    }

    public static int getLength(ListNode head) {

        int count = 0;

        ListNode current =  head;

        while (current != null) {

            count++;

            current = current.next;
        }

        return count;
    }

    public static ListNode getNode(ListNode head, int pos){

        ListNode ptr = head;

        if(pos != -1) {

            int p = 0;

            while (p < pos) {

                ptr = ptr.next;

                p++;
            }

            return ptr;
        }

        return ptr;
    }

}

