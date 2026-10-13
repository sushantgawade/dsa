package fastandslowpointers;

import java.util.Arrays;

public class P004_Medium_CircularArrayLoop {

    /*

    Problem: Circular Array Loop
    med
    30 min
    Explore techniques to detect circular loops in an array of integers using fast and slow pointers. Understand how to identify cycles where all steps move in one direction, mastering a common problem pattern for coding interviews.
    Statement
    There is a circular list of non-zero integers called nums. Each number in the list tells you how many steps to move forward or backward from your current position:

    If nums[i] is positive, move nums[i] steps forward.

    If nums[i] is negative, move nums[i] steps backward.

    As the list is circular:

    Moving forward from the last element takes you back to the first element.

    Moving backward from the first element takes you to the last element.

    A cycle in this list means:

    You keep moving according to the numbers, and you end up repeating a sequence of indexes.

    All numbers in the cycle have the same sign (either all positive or all negative).

    The cycle length is greater than 1 (it involves at least two indexes).

    Return true if such a cycle exists in the list or false otherwise.


Solution
So far, you’ve probably brainstormed some approaches and have an idea of how to solve this problem. Let’s explore some of these approaches and figure out which to follow based on considerations such as time complexity and implementation constraints.

Naive approach
The naive approach involves iterating through each element of the input array. In each iteration, we start from the current element and check for cycles in both forward and backward directions. We also keep an additional array to track visited elements. If a cycle is detected during this process, we return TRUE. However, if the direction of the cycle changes at any point, we’ll move to the next iteration. We’ll repeat this until we find the cycle or traverse the complete array.

For each element in the outer loop, there is an inner loop that explores potential cycles, resulting in a time complexity of
O(n 2 ). The space complexity is O(n)  because we use extra space to keep track of the visited elements. This makes it an inefficient approach for large input arrays.

Optimized approach using fast and slow pointers
We can use the fast and slow pointers technique, where traversing at different speeds enables efficient cycle detection. Comparing the signs of values during traversal facilitates correct navigation in both forward and backward directions within the array.

For each element of the array, two pointers, initialized at that specific element, traverse the array, with one taking one step at a time and the other advancing by two steps. The position of each pointer for the next step is determined by the value it is currently pointing to. If any movement results in the pointer pointing to a value with a different sign (indicating a change in direction) or pointing to the same index it was previously pointing to (indicating a self-loop), move to the next element of the array. Do the same if the fast pointer has reached the end of the array and no cycle is detected. However, if there’s a cycle, both pointers eventually catch up. This is because, in the non-cyclic part, the distance between them increases by one index in each iteration. However, upon entering the cyclic part, the fast pointer rapidly closes the gap on the slow pointer, decreasing the distance by one index in each iteration until they meet.

Let's see the workflow of the algorithm. The algorithm involves iterating through each index of nums. For every index, i, perform the following steps:

Initialize fast and slow pointers to the current index i.

Move the slow pointer, either forward or backward, depending on the current value it is pointing to, nums[i]. For example, if the value is −3, the slow pointer is moved three indexes backward. Similarly, if the value is 2, the slow pointer is moved two indexes forward.

Now, check if a valid cycle can be formed. For this, we have two primary checks:If any of the conditions above fail, move to step 4.

If the index of the new value pointed to by slow is the same as the index of the previous value pointed to by slow, that is, the pointer is forming a self-loop, then the next iteration starts.

Observe the sign of the previous value pointed to by slow and the sign of the new value it points to. If both values have different signs, that is, the pointer is not moving in a single direction, then the next iteration starts.

Move the fast pointer twice in a similar fashion, and after every move, check for the validity of the cycle using the same checks as above. If a valid cycle can’t be formed, move to the next index of nums.

Now, check for the existence of the cycle. If the slow and fast pointers meet at the same index, a cycle is detected. Return TRUE in this case. Otherwise, continue moving the pointers until we determine whether or not a cycle exists.

Note: We only move to the next index if a valid cycle cannot be formed with the current index.

If no cycle is detected for any index, return FALSE.

Here’s the demonstration of the steps above:



 public static boolean circularArrayLoop(int[] nums) {
        // Store the size of the input array.

        // Iterate through each index of the array to test it as a potential starting point for a cycle.
            // Initialize both 'slow' and 'fast' pointers to the current index.
            // Determine if the cycle should be moving forward (positive numbers) or backward (negative numbers).

            // Start an infinite loop to move the pointers through the circular array.
                // Move the 'slow' pointer forward by one position using the helper function.

                // Check if the path taken by the 'slow' pointer is invalid (sign change or a cycle of length 1).
                    // If invalid, break the inner loop to start from the next index.

                // Move the 'fast' pointer forward its first step.

                // Check if the movement for the 'fast' pointer is invalid.
                    // If invalid, break the inner loop.

                // Move the 'fast' pointer forward its second step.

                // Check if the movement for the 'fast' pointer's second step is invalid.
                    // If invalid, break the inner loop.

                // If the 'slow' and 'fast' pointers land on the same index:
                    // A valid cycle has been found; return true.

        // If all indices are checked and no valid cycle is found, return false.
    }

    // A function to calculate the next step
    public static int nextStep(int pointer, int value, int size) {
        // Calculate the next index by adding the current value to the current pointer position.
        // Apply the modulo operator with the array size to handle circular wrap-around.
        // If the resulting index is negative, add the array size to ensure it maps to a positive index.
        // Return the normalized index.
    }

    // A function to detect a cycle doesn't exist
    public static boolean isNotCycle(int[] nums, boolean prevDirection, int pointer) {
        // Determine the direction of movement at the current pointer index.

        // Check if the direction at this index is different from the initial path direction,
        // or if moving from this position results in a self-loop (a cycle of length 1).
            // Return true if any of these conditions are met, indicating the cycle is invalid.

        // Otherwise, return false.
    }


     */

    private static boolean circularArrayLoop(int[] nums) {

        int size = nums.length;

        for(int i = 0; i < size; i++ ) {

            int  slow = i;
            int  fast = i;

            boolean forward = nums[i] > 0;

            while(true) {

                slow =  nextStep(slow, nums[slow], size);

                if(isNotCycle(nums, forward, slow)) {
                    return false;
                }

                fast = nextStep(fast, nums[fast], size);

                if(isNotCycle(nums, forward, fast)) {
                    return false;
                }

                fast = nextStep(fast, nums[fast], size);

                if(isNotCycle(nums, forward, fast)) {
                    return false;
                }

                if(slow == fast) {

                    return true;
                }
            }
        }

        return false;
    }

    public static int nextStep(int pointer, int value, int size) {

        int result = (pointer + value)  % size;

        if(result < 0){
            result += size;
        }

        return result;

    }

    public static boolean isNotCycle(int[] nums, boolean prevDirection, int pointer) {

        boolean currentDirection = nums[pointer] > 0 ;

        int size = nums.length;

        if( currentDirection != prevDirection || nums[pointer] % size == 0) {
            return true;
        }

        return false;

    }

    public static void main(String[] args) {

        int[][] input = {
                {-2, -3, -9},
                {-5, -4, -3, -2, -1},
                {-1, -2, -3, -4, -5},
                {2, 1, -1, -2},
                {-1, -2, -3, -4, -5, 6},
                {1, 2, -3, 3, 4, 7, 1},
                {2, 2, 2, 7, 2, -1, 2, -1, -1}
        };

        for (int i = 0; i < input.length; i++) {
            System.out.println((i + 1) + ".\tCircular array = " + Arrays.toString(input[i]) + "\n");
            boolean result = circularArrayLoop(input[i]);
            System.out.println("\tFound Loop = " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }


}
