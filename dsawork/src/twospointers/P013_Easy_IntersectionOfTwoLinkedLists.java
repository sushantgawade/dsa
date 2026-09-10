package twospointers;

import common.LinkedList;
import common.ListNode;
import common.PrintList;

import java.util.Arrays;
import java.util.List;

public class P013_Easy_IntersectionOfTwoLinkedLists {

    /*

    Explore how to identify the intersection point of two singly linked lists by using the two-pointer approach.
    This lesson helps you understand the problem constraints, assess if two lists share nodes in memory,
    and implement an efficient solution to return the intersection node or null if none exists.

    Statement
    You are given the heads of two singly linked lists, headA and headB, to determine whether the two lists
    intersect. If they intersect, return the node where the intersection begins. Otherwise, return NULL.

    Note: Linked lists intersect if they share a common node in memory, not just a node with the same value.

     */

    // Initialize two pointers, ptrA and ptrB, starting at headA and headB respectively.

    // Traverse both lists simultaneously until the pointers meet at the same node object:
    // If ptrA reaches the end of its current path (is null):
    // Redirect ptrA to headB to synchronize the traversal distance.
    // Otherwise:
    // Advance ptrA to the next node in the list.

    // If ptrB reaches the end of its current path (is null):
    // Redirect ptrB to headA to synchronize the traversal distance.
    // Otherwise:
    // Advance ptrB to the next node in the list.

    // After the pointers switch lists, they will eventually meet at the intersection point.
    // If there is no intersection, they will both reach null at the same time and the loop will terminate.
    // Return ptrA, which represents either the intersection node or null if no intersection was found.

    private ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode ptrA =  headA;

        return ptrA;

    }

    public static void main(String[] args) {

        List<List<Integer>> listA_values = Arrays.asList(
                Arrays.asList(4, 1, 8, 4, 5),
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 2, 3),
                Arrays.asList(2, 6, 4),
                Arrays.asList(1),
                Arrays.asList(2, 3, 6, 21, 5)
        );

        List<List<Integer>> listB_values = Arrays.asList(
                Arrays.asList(5, 6, 6, 8, 4, 5),
                Arrays.asList(4, 5, 6),
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 5, 4),
                Arrays.asList(1),
                Arrays.asList(7, 21, 5)
        );

        int[] skipA = {2, 3, 0, 2, 0, 3};
        int[] skipB = {3, 3, 0, 2, 0, 1};
        int[] intersect_val = {8, 0, 1, 4, 1, 21};

        for (int i = 0; i < listA_values.size(); i++) {
            LinkedList listA = new LinkedList(listA_values.get(i));
            LinkedList listB = new LinkedList(listB_values.get(i));

            // Create intersection if valid
            if (skipA[i] == 0 && skipB[i] == 0) {
                listB.head = listA.head;
            } else if (skipA[i] < listA_values.get(i).size() && skipB[i] < listB_values.get(i).size()) {
                ListNode nodeA = listA.head;
                for (int j = 0; j < skipA[i]; j++) nodeA = nodeA.next;

                ListNode nodeB = listB.head;
                for (int j = 0; j < skipB[i] - 1; j++) nodeB = nodeB.next;

                nodeB.next = nodeA;
            }

            P013_Easy_IntersectionOfTwoLinkedLists sol = new P013_Easy_IntersectionOfTwoLinkedLists();
            ListNode result = sol.getIntersectionNode(listA.head, listB.head);

            System.out.print((i + 1) + ".\tList A: ");
            PrintList.display(listA.head);

            System.out.print("\tList B: ");
            PrintList.display(listB.head);

            System.out.println("\tskipA: " + skipA[i]);
            System.out.println("\tskipB: " + skipB[i]);
            System.out.println("\tintersect_val: " + intersect_val[i]);

            if (result != null)
                System.out.println("\n\tOutput: Intersected at " + result.val);
            else
                System.out.println("\n\tOutput: No intersection");

            System.out.println("-".repeat(100));
        }

    }



}
