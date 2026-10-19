package fastandslowpointers;

import common.LinkedList;
import common.ListNode;
import common.PrintList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P010_Medium_SplitACircularLinkedList {

    /*

    Problem: Split a Circular Linked List
    med
    30 min
    Understand how to split a circular linked list into two equal halves by applying fast and slow pointer techniques. This lesson helps you identify and implement the approach to divide the list efficiently while maintaining circular structure.
    Statement
    Given a circular linked list, list, of positive integers, split it into two circular linked lists. The first circular linked list should contain the first half of the nodes (exactly ⌈list.length / 2⌉ nodes) in the same order they appeared in the original list, while the second circular linked list should include the remaining nodes in the same order.

    Return an array, answer, of length 2, where:

    answer[0] is the head of the circular linked list representing the first half.

    answer[1] is the head of the circular linked list representing the second half.

    public static ListNode[] splitCircularLinkedList(ListNode head) {
        // Initialize two pointers, slow and fast, at the head of the circular linked list

        // Traverse the circular list using the fast and slow pointer technique to find the midpoint
        // Iterate while the fast pointer's next node is not the head and the node after that is also not the head
            // Move the slow pointer one step forward
            // Move the fast pointer two steps forward

        // Identify the starting points for the two split halves
        // The head of the first half is the original head of the list
        // The head of the second half is the node immediately following the slow pointer

        // Close the first half to make it a circular linked list
        // Set the next pointer of the slow pointer (the end of the first half) to point back to the first head

        // Find the end of the second half to make it circular
        // Initialize a temporary pointer at the head of the second list
        // Traverse the second list until the current node's next pointer points back to the original list head
            // Move the temporary pointer forward one node

        // Close the second half to make it a circular linked list
        // Set the next pointer of the last node of the second half to point back to the second head

        // Return an array containing the heads of the two resulting circular linked lists
        return new ListNode[]{null, null};
    }


     */

    private static ListNode[] splitCircularLinkedList(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null && fast.next.next != null && fast.next != head && fast.next.next != head ){

            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head1 = head;
        ListNode head2 = slow.next;
        slow.next = head1;

        fast = head2;

        while(fast != null && fast.next != null && fast.next != head) {

            fast = fast.next;
        }

        if(fast != null) {
            fast.next = head2;
        }

        return new ListNode[] {head1, head2};
    }


    public static void main(String[] args) {


        int[][] lists = {
                {1, 5, 7},
                {2, 6, 1, 5},
                {3, 1, 4, 2, 5},
                {8, 10, 12, 14, 16, 18},
                {9, 10}
        };

        for (int i = 0; i < lists.length; i++) {
            LinkedList inputLinkedList = new LinkedList();

            List<Integer> intList = Arrays.stream(lists[i])
                    .boxed()
                    .collect(Collectors.toList());

            inputLinkedList.createLinkedList(intList);
            System.out.print((i + 1) + ". Linked list: ");
            PrintList.display(inputLinkedList.head);

            // Get the split lists
            ListNode[] splitLists = splitCircularLinkedList(inputLinkedList.head);
            int[] splitList1 = PrintList.linkedListToArray(splitLists[0]);
            int[] splitList2 = PrintList.linkedListToArray(splitLists[1]);
            System.out.println("\n   Split Lists: [" + java.util.Arrays.toString(splitList1) + ", " + java.util.Arrays.toString(splitList2) + "]");
            System.out.println(new String(new char[100]).replace('\0', '-')); // Printing 100 dashes
        }


    }
}
