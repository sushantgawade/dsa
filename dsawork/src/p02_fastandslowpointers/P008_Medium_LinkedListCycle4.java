package p02_fastandslowpointers;

import common.LinkedList;
import common.ListNode;
import common.PrintList;

import java.util.Arrays;
import java.util.List;

public class P008_Medium_LinkedListCycle4 {

    /*
    Explore how to detect and remove cycles in a singly linked list using the fast and slow pointer technique.
    This lesson helps you understand the problem constraints, implement an in-place cycle removal function, and
    ensure the linked list remains acyclic without altering node order. Gain hands-on experience to apply this pattern effectively in coding interviews.
    Statement
    Given the head of a singly linked list, implement a function to detect and remove any cycle present in the list.
    A cycle occurs when a node's next pointer links back to a previous node, forming a loop within the list.

    The function must modify the linked list in place, ensuring it remains acyclic while preserving the original
    node order. If no cycle is found, return the linked list as is.


    Solution
    The Floyd’s Cycle Detection method is used to identify and eliminate cycles efficiently. It begins by initializing two pointers at the head of the linked list. The slow pointer moves one step, and the fast moves two steps to traverse the list. If the two pointers meet, a cycle is detected; otherwise, if fast reaches NULL, the list is cycle-free. To determine the cycle’s starting node, slow is reset to the head, and both pointers move one step at a time until they meet again. Once the cycle’s entry point is found, the algorithm traverses the loop to identify the last node in the cycle, which is the node whose next pointer refers back to the cycle start. Finally, the cycle is removed by setting this last node next to NULL, restoring the linked list to a proper linear structure.

    The steps of the algorithm are as follows:

    Initialize two pointers, slow and fast, to the head node.

    Traverse the linked list using slow and fast pointers to detect a cycle:

    Move slow, one step forward.

    Move fast, two steps forward.

    If slow == fast, a cycle is detected, and we break out of the loop.

    If fast reaches NULL, the list is cycle-free and return head.

    Once a cycle is detected, we need to determine where it begins:

    Reset slow to head.

    Move both slow and fast, one step at a time, until they meet again. The meeting point is the starting node of the cycle.

    To break the cycle, we must locate the last node in the loop:

    Start from fast, which is now at the cycle’s starting node.

    Move forward through the cycle until fast.next == slow (this identifies the last node in the cycle).

    Set fast.next = NULL to break the cycle and restore the linked list to a linear structure.

    Return the head of the modified linked list.

    Let’s look at the illustration below to better understand the solution.

     public static ListNode removeCycle(ListNode head) {
        // Handle the base case where the input head is null.

        // Initialize slow and fast pointers to the head of the linked list.

        // Traverse the list with the pointers to detect if a cycle is present:
            // Advance the slow pointer by one node.
            // Advance the fast pointer by two nodes.

            // If the slow and fast pointers meet at the same node, a cycle exists; break the loop.

        // If the traversal reached the end of the list (fast pointer or its next is null), no cycle exists:
            // Return the head of the original list.

        // To find the entry node of the cycle:
            // Reset the slow pointer to the head of the list while keeping the fast pointer at the meeting point.
            // Iterate while the slow and fast pointers are not at the same node:
                // Move both pointers forward by one node at a time.
            // The meeting node is the start of the cycle.

        // To remove the cycle, identify the node that completes the loop:
            // Starting from the current fast pointer, traverse the cycle.
            // Continue until the node whose next pointer is the start of the cycle (the slow pointer) is found.

        // Break the cycle by setting the next pointer of the identified tail node to null.

        // Return the modified, acyclic linked list head.
    }

     */


    private static ListNode removeCycle(ListNode head) {

        if(head == null) {
            return  head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                break;
            }
        }

        if( fast == null || fast.next == null) {
            return head;
        }

        slow = head;

        while(slow != fast) {

            slow = slow.next;
            fast = fast.next;
        }

        while (fast.next != slow ) {
            fast = fast.next;
        }

        fast.next = null;

        return head;
    }

    public static void main(String[] args) {

        List<List<Integer>> inputList = Arrays.asList(
                Arrays.asList(2, 4, 6, 8, 10, 12),
                Arrays.asList(1, 3, 5, 7, 9, 11),
                Arrays.asList(0, 1, 2, 3, 4, 6),
                Arrays.asList(3, 4, 7, 9, 11, 17),
                Arrays.asList(5, 1, 4, 9, 2, 3)
        );
        int[] pos = { 0, -1, 1, -1, 2 };
        for (int i = 0; i < inputList.size(); i++) {
            LinkedList list = new LinkedList(inputList.get(i));
            System.out.print(i + 1 + ".\tInput:");
            System.out.print("\t");
            if (pos[i] == -1) {
                PrintList.display(list.head);
            } else {
                PrintList.displayLoop(list.head);
            }
            System.out.println("\n\tpos: " + pos[i]);

            if (pos[i] != -1) {
                int length = list.getLength(list.head);
                ListNode lastNode = list.getNode(list.head, length - 1);
                lastNode.next = list.getNode(list.head, pos[i]);
            }
            System.out.print("\n\tAfter Cycle Removed = ");
            PrintList.display(removeCycle(list.head));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }


}
