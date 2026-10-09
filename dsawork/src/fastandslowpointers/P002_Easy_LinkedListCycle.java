package fastandslowpointers;

import common.LinkedList;
import common.ListNode;
import common.PrintList;

import java.util.Arrays;

import java.util.List;

public class P002_Easy_LinkedListCycle {

    /*


    Solution: Linked List Cycle
    Statement
    Given the head of a linked list, determine whether the list contains a cycle. A cycle exists if
    a node in the list can be revisited by continuously following the next pointers. Return TRUE if
    a cycle is present; otherwise, return FALSE.


    Solution
    So far, you’ve probably brainstormed some approaches and have an idea of how to solve this problem. Let’s explore some of these approaches and figure out which one to follow, based on considerations such as time complexity and any implementation constraints.

    Naive approach
    The naive approach is to traverse the linked list and store the current node in a set. At each iteration, we check if the current node is already present in the set. If it is, we’ve found a cycle and return TRUE. Otherwise, we add the node to the set. If the traversal has been completed, return FALSE, since we’ve reached the end of the linked list without encountering a cycle.

    The time complexity is  O(n)
    , since we only traverse the linked list once, where n
     represents the total number of nodes in a linked list. The space complexity of the naive approach is also O(n)
    , since in the worst case, we store n
     nodes in the set.

    Optimized approach using fast and slow pointers
    We can use the fast and slow pointers technique to find whether a cycle exists in a linked list without requiring multiple traversals or additional data structures. This technique detects the cycle by leveraging the pointers’ relative speeds—one moving faster than the other. Both pointers initially point to the head of the linked list. As the pointers traverse the list, if there’s a cycle, the faster pointer will eventually catch up to the slower one. This is because the distance between the pointers increases by one node in each iteration in the noncyclic part of the linked list. However, once both pointers enter the cyclic part, the faster pointer starts closing the gap on the slower pointer, decreasing the distance by one node in each iteration until they meet. Conversely, if there’s no cycle, the faster pointer will reach the end of the list. This approach minimizes space complexity and completes the task in a single pass through the linked list.

    The following steps can be performed to implement the algorithm above:

    We initialize two pointers, fast and slow, which point to the head of the linked list.

    We traverse the linked list using these two pointers. They move in the following way:

    The slow pointer moves only one node forward in each iteration.

    The fast pointer moves two nodes forward in each iteration, which means that it skips a node.

    If the fast pointer becomes NULL, we have reached the end of the linked list. Since no cycle exists, return FALSE.

    If both slow and fast pointers become equal to each other, return TRUE, since a cycle exists in the linked list.

    Here’s a demonstration of the algorithm above:

    Here's the coded solution:

Solution summary
To recap, the solution to this problem can be divided into the following three parts:

Initialize both the slow and fast pointers to the head node.
Move both pointers at different rates, i.e. the slow pointer will move one step ahead whereas the fast pointer will move two steps.
If both pointers are equal at some point, we know that a cycle exists.
Time complexity
The time complexity of the algorithm is O(n)
, where
n
n
 is the number of nodes in the linked list.

Space complexity
The space complexity of the algorithm above is O(1)
.

 public static boolean detectCycle(ListNode head) {
        // Check if the input head is null.
            // If it is null, return false as an empty list cannot have a cycle.

        // Initialize two pointers, 'slow' and 'fast', both starting at the head of the list.
        // The 'slow' pointer will move one step at a time.
        // The 'fast' pointer will move two steps at a time.

        // Traverse the linked list using a loop as long as the 'fast' pointer and its next node are not null.
            // Advance the 'slow' pointer to its next node.
            // Advance the 'fast' pointer two steps forward (to the next of its next node).

            // Compare the memory addresses of the 'slow' and 'fast' pointers.
            // If the 'slow' pointer meets the 'fast' pointer:
                // This indicates that a cycle exists in the linked list, so return true.

        // If the traversal finishes because the 'fast' pointer reaches the end of the list (null),
        // then the list is acyclic.
        // Return false.
    }

     */


    private static boolean detectCycle(ListNode head) {

        if(head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {

        List<List<Integer>> inputList = Arrays.asList(
                Arrays.asList(2, 4, 6, 8, 10, 12),
                Arrays.asList(1, 3, 5, 7, 9, 11),
                Arrays.asList(0, 1, 2, 3, 4, 6),
                Arrays.asList(3, 4, 7, 9, 11, 17),
                Arrays.asList(5, 1, 4, 9, 2, 3)
        );

        int[] pos = {0, -1, 1, -1, 2};
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
            System.out.println("\n\tDetected Cycle =  " + detectCycle(list.head));
            System.out.println(new String(new char[100]).replace('\0', '-'));

        }

    }

}

