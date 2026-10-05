package twospointers;

import common.ListNode;

import java.util.Arrays;
import java.util.List;

public class P030_Medium_RemoveDuplicatesFromSortedList2 {

    /*
    Problem: Remove Duplicates from Sorted List II
    med
    30 min
    Try to solve the Remove Duplicates from Sorted List II problem.
    Statement
    Given the head node head of a singly linked list sorted in ascending order,
    remove every value that appears more than once so that only values that occur exactly once remain in the list.
    Return the head of the modified linked list.


    Solution
    Because the linked list is sorted, any duplicates appear as one contiguous block. The idea is to
    scan the list with currNode, detect whether the current value repeats, and if it does,
    remove the entire block by rewiring the next pointer of the last confirmed unique node prevNode.
    A dummyHead is used so deletions at the original head are handled uniformly.
    Now, let’s look at the solution steps below:

    Create a dummyHead node that points to head, then set prevNode to dummyHead and currNode to head.

    Traverse the list while currNode exists.
    Set a boolean flag hasDuplicate to False for the current value.
    While currNode.next exists and currNode.val equals currNode.next.val, keep moving currNode forward and set hasDuplicate to True.
    If hasDuplicate is True, bypass the entire duplicate block by setting prevNode.next to currNode.next.
    Otherwise, the current node is unique, so advance prevNode to prevNode.next.
    Move currNode to currNode.next to continue scanning.

    Return dummyHead.next as the new head of the modified list.

     public ListNode deleteDuplicates(ListNode head) {
        // Create a dummy node that points to the head of the list.
        // This dummy node helps manage deletions at the start of the list easily.

        // Initialize a pointer 'prevNode' to the dummy node.
        // This will always point to the last confirmed unique node in the resulting list.

        // Initialize a pointer 'currNode' to the head of the list to begin traversal.

        // Iterate through the list as long as 'currNode' is not null.

            // Check if 'currNode' is the start of a duplicate sequence.
            // A duplicate sequence exists if the next node has the same value as 'currNode'.

            // If duplicates are detected:
                // Keep advancing 'currNode' until it reaches the last node of the sequence with that specific value.
                // Skip the entire duplicate sequence by connecting 'prevNode.next' directly to 'currNode.next'.

            // Otherwise, if 'currNode' is unique:
                // Advance 'prevNode' to 'currNode', as this node is now part of the final unique list.

            // Move 'currNode' to its next node to continue scanning the list.

        // Return the node following the dummy node, which represents the new head of the filtered list.
    }

    */

    public ListNode deleteDuplicates(ListNode head) {

        return null;
    }

    public static ListNode buildLinkedList(List<Integer> values) {

        return null;
    }

    public static List<Integer> linkedListToList(ListNode head) {

        return null;
    }

    public static void main(String[] args) {

        List<List<Integer>> testCases = Arrays.asList(
                Arrays.asList(),
                Arrays.asList(1, 1),
                Arrays.asList(-3, -2, -2, -1, 0, 0, 1),
                Arrays.asList(0, 1, 1, 2, 3, 3, 4),
                Arrays.asList(-1, 0, 1, 2, 3)
        );

        P030_Medium_RemoveDuplicatesFromSortedList2 sol = new P030_Medium_RemoveDuplicatesFromSortedList2();

        for (int i = 0; i < testCases.size(); i++) {
            List<Integer> arr = testCases.get(i);
            ListNode head = buildLinkedList(arr);
            ListNode resultHead = sol.deleteDuplicates(head);

            System.out.println((i + 1) + ".\tInput list: " + arr);
            System.out.println("\tResult: " + linkedListToList(resultHead));
            System.out.println("-".repeat(100));
        }

    }
}
