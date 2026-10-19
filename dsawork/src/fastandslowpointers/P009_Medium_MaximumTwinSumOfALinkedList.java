package fastandslowpointers;

import common.LinkedList;
import common.ListNode;
import common.PrintList;

import java.util.Arrays;
import java.util.List;

public class P009_Medium_MaximumTwinSumOfALinkedList {


    /*

    Problem: Maximum Twin Sum of a Linked List
    med
    30 min
    Explore how to calculate the maximum twin sum in an even-length linked list by pairing nodes from opposite ends
    using fast and slow pointer techniques. This lesson helps you understand the problem and implement an efficient
    solution suitable for coding interviews.

    Statement
    In a linked list with an even number of nodes (n), each node at position i
     (using 0 − based indexing) is paired with the node at position (n−1−i). These pairs are called twins for all 0≤i<n/2.

    For example, if n=4, the twin pairs are:

    The node at index  0 pairs with the node at index 3 .

    The node at index 1 pairs with the node at index 2.

    The twin sum is the sum of a node’s value and its twin’s value. Given the head of a linked list with an
    even number of nodes, return the maximum twin sum among all pairs.


        public static int twinSum(ListNode head) {
            // Initialize two pointers, slow and fast, at the head of the list to find the midpoint.
            // Iterate while the fast pointer and its next node are not null.
                // Advance the slow pointer by one node.
                // Advance the fast pointer by two nodes to reach the end twice as fast.

            // The slow pointer now reaches the start of the second half of the list.
            // Prepare to reverse the second half of the linked list to allow easy pairing with the first half.
            // Initialize a 'prev' pointer as null and a 'curr' pointer at the slow pointer's position.

            // Iterate while the 'curr' pointer is not null to reverse the second half.
                // Store the reference to the next node in a temporary variable to avoid losing the rest of the list.
                // Redirect the 'curr' node's next pointer to the 'prev' node, effectively reversing the link.
                // Shift the 'prev' pointer forward to the 'curr' node.
                // Shift the 'curr' pointer forward to the stored next node.

            // After the loop, 'prev' points to the head of the reversed second half.
            // Initialize a variable to track the maximum twin sum found, starting at zero.
            // Use a separate pointer to traverse the first half of the list, starting from the head.

            // Iterate while the pointer for the reversed second half is not null.
                // Calculate the twin sum by adding the value of the current node from the first half and the reversed second half.
                // Update the maximum sum if this calculated twin sum is larger than the current maximum.
                // Advance the first half pointer to its next node.
                // Advance the reversed second half pointer to its next node.

            // Return the final maximum twin sum identified during the traversal.
            return -1;
        }

     */




    private static int twinSum(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode curr = slow;
        ListNode prev = null;
        ListNode next = null;

        while(curr != null) {

            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        curr = head;
        int maxSum = 0;

        while(prev != null) {

            maxSum = Math.max(maxSum, curr.val+ prev.val);

            curr = curr.next;
            prev = prev.next;
        }

        return maxSum;

    }

    public static void main(String[] args) {

        List<List<Integer>> lists = Arrays.asList(
                Arrays.asList(2, 3, 5, 7),
                Arrays.asList(81, 144, 64, 121, 25, 49),
                Arrays.asList(4, 5, 6, 7),
                Arrays.asList(1, 1000),
                Arrays.asList(11, 77, 44, 99, 22, 66, 55, 88)
        );

        for (int i = 0; i < lists.size(); ++i) {
            LinkedList inputLinkedList = new LinkedList(lists.get(i));
            System.out.print((i + 1) + ".\tLinked list: ");
            PrintList.display(inputLinkedList.head);
            System.out.println("\tMaximum twin sum: " + twinSum(inputLinkedList.head));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }



    }
}
