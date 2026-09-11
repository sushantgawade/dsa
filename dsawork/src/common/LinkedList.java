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
}

