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

    }
}

