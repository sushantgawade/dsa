package twospointers;

import java.util.Arrays;

public class P024_Medium_MoveZeroes {

    /*

    Statement
Given an integer array, nums, rearrange the elements such that all 0′s  are moved to the end of the array, while the relative order of all non-zero elements is preserved.

Solution
The key insight is to use two pointers, left and right, to partition the array in a single pass. The right pointer scans every element while the left pointer tracks the next available position for a non-zero element.

Whenever right finds a non-zero value, that value is swapped into the left position. This places the non-zero element into the front portion of the array. If there was a zero at left, that zero is moved toward the back. If left and right are the same index, the swap has no effect.

Because non-zero elements are placed in the same order they are discovered, their relative order is preserved. As a result, all zeroes naturally move to the end of the array without needing an extra pass or auxiliary space.

Now, let’s look at the solution steps below:

Initialize a left pointer at index 0. This pointer always marks the slot where the next non-zero element should be placed.

Iterate through the array with a right pointer from index 0 to the last index (inclusive).

At each position, check whether nums[right] is non-zero.

If it is non-zero, swap nums[left] and nums[right].

This places the non-zero element in the correct front region and moves whatever was at left (a zero or the same element) to the right position.

After the swap, advance left by 1 to point to the next open slot.

If nums[right] is zero, skip it entirely; left stays in place so that this position can be filled by the next non-zero element found later.

Once right has traversed the entire array, all non-zero elements occupy indices 0 through left −1 in their original relative order, and all zeroes occupy indices left through the end of the array.



 public void moveZeroes(int[] nums) {
        // Initialize a pointer 'left' at the beginning of the array to keep track of the index for the next non-zero element.

        // Iterate through the array using a 'right' pointer starting from index 0 to the end of the array.
            // If the element at the current 'right' pointer is not equal to zero:
                // Swap the element at the 'left' pointer with the element at the 'right' pointer.
                // (This operation ensures all non-zero elements are moved to the front while preserving their relative order).

                // Increment the 'left' pointer to move to the next position for a potential non-zero element.
    }
     */

    private void moveZeroes(int[] nums) {
        int left = 0;

        for(int right = 0; right < nums.length; right++) {

            if(nums[right] != 0) {

                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
            }
        }
    }

    public static void main(String[] args) {
        P024_Medium_MoveZeroes sol = new P024_Medium_MoveZeroes();

        int[][] testCases = {
                {4, 0, 5, 0, 0, 3},
                {0, 0, 1},
                {7, 8, 9, 1},
                {0, -5, 0, 2147483647, -2147483648},
                {0, 0, 0, 42},
        };

        for (int idx = 0; idx < testCases.length; idx++) {
            int[] inputDisplay = Arrays.copyOf(testCases[idx], testCases[idx].length);
            sol.moveZeroes(testCases[idx]);
            System.out.println((idx + 1) + ".\tInput array: " + Arrays.toString(inputDisplay));
            System.out.println("\tResult: " + Arrays.toString(testCases[idx]));
            System.out.println("-".repeat(100));
        }
    }


}
