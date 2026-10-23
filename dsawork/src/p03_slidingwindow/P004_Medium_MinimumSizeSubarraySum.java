package p03_slidingwindow;

import java.util.Arrays;

public class P004_Medium_MinimumSizeSubarraySum {

    /*

    Problem: Minimum Size Subarray Sum
    med
    30 min
    Explore how to apply the sliding window technique to find the smallest contiguous subarray whose sum meets or exceeds a given target. This lesson helps you understand problem constraints and develop an efficient solution for common coding interview challenges.
    Statement
    Given an array of positive integers, nums, and a positive integer, target, find the minimum length of a contiguous subarray whose sum is greater than or equal to the target. If no such subarray is found,


    Solution
    The idea is to traverse the array using a sliding window, calculate the sum of elements in it, and compare the sum with the target value. If the sum is greater than or equal to the target value, store the size of this window. Repeat this process to find the minimum size subarray.

    We perform the following steps to implement the algorithm:

    We start by initializing a variable, windowSize, with positive infinity to store the size of the minimum subarray. In addition, we initialize sum with 0.
    We use the start and end variables to track the left and right end of the subarray, respectively. Initially, we set both variables to  0.
    We slide the window over the input array using these two variables. In each iteration, we increment end and add the new element of the window into the sum. If sum is greater than or equal to target, we increment start.
    If sum exceeds or equals the target, we compare the current subarray size with windowSize. The smaller of the two values will be stored in windowSize.
    We repeat steps 3 and 4 to find the smallest subarray.
    Finally, if windowSize is positive infinity, we come to know that there was no subarray whose sum was equal to or greater than target. Therefore, we return  0.
     Otherwise, we return windowSize as the length of the minimum size subarray.

    Let’s have a look at code below for the solution:

    Time complexity
    The time complexity of this solution is  O(n).

    Space complexity
    The space complexity of this solution is  O(1) , since we are not using any extra space.

     public static int minSubArrayLen(int target, int[] nums) {
        // Initialize 'windowSize' to the largest possible integer value to represent an initial infinity.
        // Initialize 'currSubArrSize' to 0 to store the size of the current sliding window.
        // Initialize 'start' to 0, which acts as the left pointer of the sliding window.
        // Initialize 'sum' to 0 to track the total value of elements within the window.

        // Iterate through the array using an 'end' pointer to represent the right boundary of the window.
            // Add the element at the current 'end' position to the 'sum'.

            // While the current 'sum' is greater than or equal to the 'target':
                // Calculate 'currSubArrSize' as the difference between the 'end' and 'start' indices plus 1.
                // Update 'windowSize' with the minimum of its current value and 'currSubArrSize'.
                // Subtract the value at the 'start' index from the 'sum' to prepare for shrinking the window.
                // Increment the 'start' pointer to move the left boundary forward.

        // If 'windowSize' has been updated from its initial maximum value:
            // Return 'windowSize' as the minimum length found.

        // Otherwise, return 0 to indicate that no such contiguous subarray exists.
    }



     */

    private static int minSubArrayLen(int target, int[] nums) {

        int windowSize = Integer.MAX_VALUE;
        int currentSubArraySize  = 0;
        int sum = 0;

        int start = 0;

        for(int end = 0; end < nums.length; end++) {

            sum += nums[end];

            while(sum >= target) {

                currentSubArraySize = (end + 1) -  start;

                windowSize = Math.min(windowSize, currentSubArraySize);

                sum -= nums[start];

                start += 1;

            }

        }

        if(windowSize != Integer.MAX_VALUE) {

            return windowSize;
        }

        return 0;

    }

    public static void main(String[] args) {

        int[] target = {7, 4, 11, 10, 5, 15};
        int[][] inputArr = {
                {2, 3, 1, 2, 4, 3},
                {1, 4, 4},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 2, 3, 4},
                {1, 2, 1, 3},
                {5, 4, 9, 8, 11, 3, 7, 12, 15, 44}
        };
        for (int i = 0; i < target.length; i++) {
            int windowSize = minSubArrayLen(target[i], inputArr[i]);
            System.out.print((i + 1) + ".\tInput array: " + Arrays.toString(inputArr[i]));
            System.out.print("\n\tTarget: " + target[i]);
            System.out.println("\n\tMinimum Length of Subarray: " + windowSize);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }


}
