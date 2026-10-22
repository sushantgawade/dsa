package p02_fastandslowpointers;

import common.LinkedList;
import common.LinkedListReversal;
import common.ListNode;
import common.PrintList;

import java.util.Arrays;
import java.util.List;

public class P006_Easy_PalindromeLinkedList {

    /*
    Problem: Palindrome Linked List
    easy
    15 min
    Explore how to identify whether a linked list is a palindrome by using fast and slow pointers. This lesson guides you through implementing a solution that retains the original list structure, preparing you to tackle similar coding interview challenges efficiently.
    Statement
    Given the head of a linked list, your task is to check whether the linked list is a palindrome or not. Return TRUE if the linked list is a palindrome; otherwise, return FALSE.

     Solution
    Checking whether a sequence is a palindrome typically involves using two pointers—one at the start and the other at the end—comparing elements while moving toward the center. While this approach is intuitive, it is not directly feasible for a singly linked list, as it only has next pointers and lacks previous pointers for backward traversal. To overcome this limitation, we solve the problem in four key steps: find the midpoint of the given linked list using a slow and fast pointer technique. Next, we reverse the second half of the list so that we can compare it directly with the first half. Reversing the second half allows us to bring the last elements to the front, aligning them with the first half for direct comparison using only the next pointers. If the values in both halves match during this step, the linked list is a palindrome. Finally, we reverse the second half again to restore the list to its original order, ensuring the data structure remains unchanged after the check.

    The algorithm has the following workflow:

    First, we will find the middle node of the linked list. To do this, we’ll traverse the linked list using two pointers, where the slow pointer will move one step forward, and the fast pointer will move two steps forward. We’ll do this until the fast pointer reaches the end of the list or a null node. At this point, the slow pointer will be pointing at the middle node of the list.

    Next, we’ll reverse the secondHalf of the linked list, starting from the node after the middle node. To reverse the list, we will call the function reverseLinkedList, passing the slow node as a parameter, representing the head of the secondHalf of the linked list. We will follow these steps in the reverseLinkedList function:

    Initialize three pointers: prev, next, and curr. The prev and next pointers are initialized as NULL, while curr is initialized to the head of the linked list.

    Iterate over the linked list. While iterating, perform the following steps:

    Before changing the next of curr, store the next node using the following line of code: next = curr.next.

    Now, we will update the next pointer of curr with the prev pointer. This will reverse the pointer of the current node from forward to backward, eventually aiding the reversal of the linked list.

    After reversing the pointer, we will update prev as curr and curr as next, using the following lines of code: prev = curr and curr = next.

    Let’s look at the following illustration to get a better understanding of reversing the linked list:

    Now, we compare every element of the firstHalf of the linked list with the corresponding element in the secondHalf of the reversed linked list. To do this, we call the helper function compareTwoHalves, passing the heads of the two linked lists:

We compare the nodes of each list from start to end. The list is a palindrome if they are the same, and we’ll return TRUE. Otherwise, we’ll return FALSE.
Finally, we reverse the second_half of the list again to restore its original structure, ensuring the linked list remains unchanged after the palindrome check.

Let’s look at the following illustration to get a better understanding of the solution:

Let’s implement the algorithm as discussed above:

Time complexity
The algorithm’s time complexity is
O(n)
, where
n
 is the total number of nodes in the linked list.

Space complexity
The space complexity of the algorithm above is
O(1)
, because it does not use any extra space in memory.


 public static boolean palindrome(ListNode head) {
        // Initialize 'slow' and 'fast' pointers at the head node of the linked list.

        // Find the middle of the linked list to divide it into two segments:
        // Iterate while the 'fast' pointer and its next node are not null.
            // Advance 'slow' one step forward.
            // Advance 'fast' two steps forward.

        // Prepare the second half for comparison:
        // Reverse the nodes starting from the 'slow' pointer to the end of the list.
        // Store the head of this reversed sub-list for the comparison step.

        // Verify if the list sequence is identical from both ends:
        // Compare the first half of the original list with the reversed second half.
        // Capture whether they match in a boolean variable.

        // Ensure the original list structure is preserved:
        // Reverse the second half again to restore the initial order.

        // Return the stored result of the palindrome check.
    }

    public static boolean compareTwoHalves(ListNode firstHalf, ListNode secondHalf) {
        // Iterate through both halves as long as both pointers are referencing valid nodes:
            // Check if the value of the current node in the first half is different from the second half.
                // If they differ, the list is not a palindrome; return false.
            // Otherwise, continue the traversal:
                // Advance the 'firstHalf' pointer to the next node.
                // Advance the 'secondHalf' pointer to the next node.

        // If no mismatches were found during the loop, the halves are identical; return true.
    }




     */

    private static boolean palindrome(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode  reversed = LinkedListReversal.reverseLinkedList(slow);

        boolean check = compareTwoHalves(head, reversed);

        LinkedListReversal.reverseLinkedList(reversed);

        if(check) {

            return true;
        }
        else {
            return false;
        }

    }

    public static boolean compareTwoHalves(ListNode firstHalf, ListNode secondHalf) {

        while(firstHalf != null && secondHalf != null){

            if(firstHalf.val != secondHalf.val) {
                return false;
            }
            else {
                firstHalf =  firstHalf.next;
                secondHalf = secondHalf.next;
            }
        }

        return true;

    }


    public static void main(String[] args) {

        List<List<Integer>> inputList = Arrays.asList(
                Arrays.asList(2, 4, 6, 4, 2),
                Arrays.asList(0, 3, 5, 5, 0),
                Arrays.asList(9, 27, 4, 4, 27, 9),
                Arrays.asList(5, 4, 7, 9, 4, 5),
                Arrays.asList(5, 10, 15, 20, 15, 10, 5)
        );

        for(int i=0; i<inputList.size(); i++){
            System.out.print(i+1);
            LinkedList list = new LinkedList(inputList.get(i));
            System.out.print(".\tLinked list:  ");
            PrintList.display(list.head);
            System.out.print("\tIs it a palindrome?  ");
            boolean result = palindrome(list.head);
            if(result){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }
}
