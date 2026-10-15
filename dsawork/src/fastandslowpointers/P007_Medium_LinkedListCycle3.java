package fastandslowpointers;

import common.LinkedList;
import common.ListNode;
import common.PrintList;

import java.util.Arrays;
import java.util.List;

public class P007_Medium_LinkedListCycle3 {


    /*

    Solution: Linked List Cycle III
    Statement
    Given the head of a linked list, determine the length of the cycle present in the linked list. If there is no cycle, return 0.

    A cycle exists in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.

    Solution
    The fast and slow pointers technique is an efficient method for detecting cycles in a linked list. In this approach, the fast pointer advances two steps at a time, while the slow pointer moves one step at a time. If the list has no cycle, the fast pointer will eventually reach the end (NULL) without meeting the slow pointer. However, if a cycle exists, the fast pointer will eventually catch up to the slow pointer, confirming the presence of a cycle. Once the two pointers meet inside the cycle, this meeting point can be used to determine the cycle’s length. By keeping one pointer fixed at the meeting point and moving the other through the loop one node at a time, we can count the number of steps until the moving pointer returns to the meeting point. This count represents the length of the cycle in the linked list.

    The steps of the algorithm are as follows:

    Initialize two pointers, fast and slow, pointing at the linked list’s head.

    To detect the cycle in the linked list, perform the below steps:

    Move the slow pointer one step forward.

    Move the fast pointer two steps forward.

    If the fast pointer reaches NULL or fast.next is NULL, no cycle exists in the list.

    If the slow and fast pointers meet, a cycle has been detected.

    After finding the cycle, determine the length of the cycle by performing the following steps:

    When a cycle is detected, we fix one pointer at the meeting point (fast).

    The slow pointer moves one step forward, initializing length = 1 to count the first step.

    The slow pointer continues, moving within the cycle one step at a time. The loop continues until slow reaches the meeting point (fast) again. Each step increments the length counter.

    When slow meets fast again, a full traversal of the cycle is complete, length contains the total number of nodes in the cycle. Return this value.

    If no cycle is found, return 0.

    Let’s look at the illustration below to better understand the solution.


     public static int countCycleLength(ListNode head) {
        // Initialize two pointers, slow and fast, at the head of the linked list.

        // Traverse the linked list using the fast and slow pointer strategy.
        // Iterate as long as the fast pointer and its next node are not null.
            // Move the slow pointer forward by one step.
            // Move the fast pointer forward by two steps.

            // If the slow pointer meets the fast pointer, a cycle is confirmed.
                // Initialize a variable to track the length of the cycle, starting at 1.
                // Move the slow pointer forward by one node.

                // Iterate while the slow pointer has not reached the fast pointer again.
                    // Increment the cycle length counter.
                    // Move the slow pointer forward by one node.

                // Return the total count representing the length of the cycle.

        // If the traversal completes without the pointers meeting, no cycle exists.
        // Return 0.
        return 0;
    }

     */


    private static int countCycleLength(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {

            slow =  slow.next;
            fast =  fast.next.next;

            if(slow == fast) {

                int length = 1;
                slow = slow.next;

                while(slow != fast) {

                    length++;

                    slow = slow.next;
                }

                return length;
            }
        }
        return 0;
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
            System.out.println("\n\tCycle length = " + countCycleLength(list.head));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }

}
