package fastandslowpointers;

import common.LinkedList;
import common.ListNode;
import common.PrintList;

import java.util.Arrays;
import java.util.List;

public class P003_Easy_MiddleOfTheLinkedList {

    /*
    Problem: Middle of the Linked List
    easy
    15 min
    Explore how to identify the middle node in a singly linked list by applying the fast and slow pointer method. Understand how to correctly return the second middle node when the list has an even number of nodes. Learn to approach this common linked list problem with an efficient, step-by-step technique.
    Statement
    Given the head of a singly linked list, return the middle node of the linked list. If the number of nodes in the linked list is even, there will be two middle nodes, so return the second one.

    Solution
    So far, you have probably brainstormed some approaches and have an idea of how to solve this problem. Let’s explore some of these approaches and figure out which one to follow based on considerations such as time complexity and any implementation constraints.

    Naive approach
    In the naive approach, we use an external array to store the elements of the linked list, and then we return the element present at the index array.length ​  ⌋ as the
    middle node of the linked list. The time and space complexity of this approach is
    O(n), where n is the number of nodes in the linked list. Let’s see if we can solve this problem with better time and space complexity.

    Optimized approach using fast and slow pointers
    We can use the fast and slow pointers technique to efficiently find the midpoint of the list by just leveraging the relative speeds of the pointers—one moving at a slower pace than the other. Both pointers initially point to the head of the linked list. As the pointers traverse the list, the slow pointer advances one node at a time while the fast pointer moves two nodes at a time. This ensures that when the fast pointer reaches the last node of the linked list (for the odd-numbered list) or NULL (for the even-numbered list), it has traversed twice the number of nodes as the slow pointer. Consequently, for odd-numbered lists, the slow pointer will be positioned precisely at the middle node, while for even-numbered lists, it will be positioned at the second node out of the two middle nodes. This approach minimizes space complexity and completes the task in a single pass through the linked list.

    Let's go over the workflow of the algorithm:

    Initialize two pointers, slow and fast, at the head of the linked list, slow = head and fast = head.

    Traverse the linked list by moving the slow pointer one step forward, slow = slow.next, and the fast pointer two steps forward, fast = fast.next.next.

    When the fast pointer reaches the last element of the linked list, or becomes equal to NULL, the slow pointer, at that time, will point to the middle node. Return the node that the slow pointer points to.

    The slides below help to understand the solution in a better way.

  public static ListNode middleNode(ListNode head) {

        // Initialize two pointers, 'slow' and 'fast', both starting at the head of the linked list.
        // The 'slow' pointer moves one step at a time, while the 'fast' pointer moves two steps.

        // Loop through the list as long as the 'fast' pointer and the node following it are not null.
        // This ensures we can move the 'fast' pointer two steps ahead in each iteration.

            // Move the 'slow' pointer one node forward.

            // Move the 'fast' pointer two nodes forward.

        // When the 'fast' pointer reaches the end of the list (or the last node in case of odd length),
        // the 'slow' pointer will be positioned at the middle node.
        // For even-length lists, the 'slow' pointer will point to the second of the two middle nodes.

        // Return the node currently pointed to by the 'slow' pointer.
        return null; // Placeholder return to maintain structure
    }


     */

    private static ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {

        List<List<Integer>> inputs = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(3, 2, 1),
                Arrays.asList(10),
                Arrays.asList(1, 2)
        );

        for(int i=0; i<inputs.size(); i++){
            System.out.print(i+1);
            LinkedList inputLinkedList = new LinkedList(inputs.get(i));
            System.out.print(".\tInput linked list:  ");
            PrintList.display(inputLinkedList.head);
            System.out.print("\tMiddle of the linked list is:  " );
            System.out.println(middleNode(inputLinkedList.head).val);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }



}
