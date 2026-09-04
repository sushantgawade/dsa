package twospointers;

import common.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P003_Medium_RemoveNthLastNode {

      /*
    Explore how to remove the nth node from the end of a singly linked list using the two pointers approach. This lesson helps you understand and implement an efficient single-pass solution, apply linear data structure manipulation, and practice coding in a hands-on environment.
    Statement
    Given the head of a singly linked list, remove the
            n
    t
            h
    n
            th

    node from the end of the list and return the head of the modified list.
    */





    // Create a dummy node and set its next pointer to the head of the list.
    // This dummy node simplifies the removal logic, especially when removing the head node.

    // Initialize two pointers, 'fast' and 'slow', both starting at the dummy node.

    // Move the 'fast' pointer n + 1 steps forward.
    // This creates a gap of n nodes between the 'slow' and 'fast' pointers.
    // Advance the 'fast' pointer to its next node.

    // Iterate while the 'fast' pointer has not reached the end of the list (is not null).
    // Advance the 'fast' pointer one step forward.
    // Advance the 'slow' pointer one step forward.

    // After the loop, the 'slow' pointer is positioned at the node immediately
    // preceding the nth node from the end.

    // Remove the target node by updating the 'next' reference of the 'slow' node.
    // Set slow.next to point to the node after the target (slow.next.next).

    // Return the 'next' node of the dummy, which is the head of the modified list.

    private ListNode removeNthLastNode(ListNode head, int n) {

        ListNode dummy = new ListNode(0, head);

        ListNode fast = dummy;
        ListNode slow = dummy;

        for(int i =0; i < n + 1; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;

    }

    private ListNode buildList(int[] values) {

        ListNode dummy = new ListNode(0);

        ListNode current = dummy;

        for (int val : values) {

            current.next = new ListNode(val);
            current = current.next;
        }

        return dummy.next;
    }

    private List<Integer> toList(ListNode result) {

       List<Integer> list = new ArrayList<>();

       while(result != null) {

           list.add(result.val);
           result = result.next;
       }

       return list;
    }

    public static void main(String[] args) {


        P003_Medium_RemoveNthLastNode sol = new P003_Medium_RemoveNthLastNode();

        int[][][] testCases = {
                {{10, 20, 30, 40, 50}, {1}},
                {{5, 10, 15}, {3}},
                {{7, 14, 21, 28}, {2}},
                {{0, 1, 2, 3, 4, 5, 6}, {4}},
                {{99, 50}, {2}},
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] values = testCases[i][0];
            int n = testCases[i][1][0];
            ListNode head = sol.buildList(values);
            ListNode result = sol.removeNthLastNode(head, n);
            System.out.println((i + 1) + ".\tInput array: " + Arrays.toString(values));
            System.out.println("\tTarget: " + n);
            System.out.println("\tResult: " + sol.toList(result));
            System.out.println("-".repeat(100));
        }

    }


}

