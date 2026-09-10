package twospointers;

import java.util.Arrays;

public class P011_Easy_SquaresOfASortedArray {

    /*

    Explore how to apply the two pointers approach to transform a sorted integer array by squaring its elements and
    maintaining sorted order. Understand the problem constraints and develop a solution that handles edge cases
    efficiently, preparing you for coding interview challenges.

    Statement
    You are given an integer array, nums, sorted in non-decreasing order. Your task is to return a new array containing
    the squares of each number, also sorted in non-decreasing order.


    As the input array is already sorted in non-decreasing order, we can solve this problem more efficiently than simply squaring all elements and sorting again (which would take
    O(nlogn)

    The key observation is that the largest square will always come from either the most negative number (at the far left) or the largest positive number (at the far right).

    To take advantage of this, we use a two pointer technique: one pointer starts at the beginning of the array and the other at the end. At each step, we compare the absolute values at these two positions. The larger absolute value produces the larger square, which we place at the current last available position in the result array. We then move the pointer corresponding to the chosen value inward and continue the process.

    By filling the result array from right to left, we ensure all elements are squared and placed in sorted order in a single pass, giving an optimal solution.

    The steps of the algorithm are as follows:

    Initialize two pointers: left = 0 at the start and right = n - 1 at the end of the array.

    Create a result array res of the same size to store the sorted squares.

    Set a position marker pos = n - 1 to fill res from the back.

    While left <= right:

    Compare abs(nums[left]) and abs(nums[right]).

    Square the larger one and place it at res[pos].

    Move the corresponding pointer inward (left++ or right--).

    Decrement pos to move leftward in the result array.

    Once the iteration finishes, res contains all squares in sorted non-decreasing order.

    Let’s look at the following illustration to get a better understanding of the solution:

     */

    private static int[] sortedSquares(int[] nums) {

        // Determine the total length of the input array.
        // Initialize a result array of the same size to store the sorted squares.

        // Set a 'left' pointer at the beginning of the input array (index 0).
        // Set a 'right' pointer at the end of the input array (index n - 1).
        // Initialize a 'pos' pointer at the last index of the result array to fill it from back to front.

        // Iterate while the 'left' pointer is less than or equal to the 'right' pointer.
        // Compare the absolute value of the element at the 'left' pointer with the absolute value of the element at the 'right' pointer.

        // If the magnitude of the number at 'left' is greater than the magnitude of the number at 'right':
        // Square the number at 'left' and place the result into the current 'pos' index of the result array.
        // Move the 'left' pointer one step forward to the next element.
        // Otherwise (if the magnitude at 'right' is greater than or equal to 'left'):
        // Square the number at 'right' and place the result into the current 'pos' index of the result array.
        // Move the 'right' pointer one step backward to the previous element.

        // Decrement the 'pos' pointer to prepare for the next largest square in the resulting array.

        // Return the final result array which now contains the squared values in non-decreasing order.

        int n =  nums.length;

        int[] arr = new int[n];

        int pos = n - 1;

        int left  = 0;
        int right  = n - 1;

        while (left <= right) {

            if(Math.abs(nums[left]) > Math.abs(nums[right])) {

                arr[pos] = nums[left] * nums[left];
                left++;
            }
            else {

                arr[pos] = nums[right] * nums[right];
                right--;
            }

            pos--;
        }
        return arr;
    }


    public static void main(String[] args) {

        // 5 test cases
        int[][] testCases = {
                {-4, -1, 0, 3, 10},    // mix of negatives and positives
                {-7, -3, 2, 3, 11},    // another mix
                {0, 1, 2, 3, 4},       // all non-negative
                {-5, -4, -3, -2, -1},  // all negative
                {1}                    // single element
        };

        for (int i = 0; i < testCases.length; i++) {
            System.out.println((i + 1) + ".\tnums = " + Arrays.toString(testCases[i]));
            System.out.println("\tOutput = " + Arrays.toString(sortedSquares(testCases[i])));
            System.out.println("----------------------------------------------------------------------------------------------------");
        }
    }


}
