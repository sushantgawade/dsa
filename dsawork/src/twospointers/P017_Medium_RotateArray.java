package twospointers;

import java.util.Arrays;

public class P017_Medium_RotateArray {


    /*

    Statement
    Given an integer array, nums, shift its elements to the right by k positions. In other words, rotate the array to the right by k steps, where k is non-negative.

    Solution
    A straightforward approach might involve repeatedly shifting elements or using an auxiliary array to place elements directly into their rotated positions, but these methods either become inefficient or require extra memory. Instead, we use an in-place strategy based on reversing parts of the array.

    The key insight is that rotating the array by k steps is equivalent to reorganizing the array into two segments: the last k elements (which should appear at the front) and the first n - k elements (which should appear after them). To achieve this rearrangement without extra space, the input array, nums, is reversed in three steps:

    First, the entire array is reversed, placing the elements that must appear at the front into the correct region of the array but in reverse order. For example, if nums = [1, 2, 3, 4] and k = 2, then after the first reversal, nums becomes [4, 3, 2, 1], bringing the last two elements (3 and 4) to the front.

    Next, the first k elements are reversed to correct their internal order, restoring them to the same relative sequence they originally had. Continuing the example, reversing the first two elements turns [4, 3, 2, 1] into [3, 4, 2, 1].

    Finally, the remaining n - k elements are reversed so that the trailing portion of the array also regains its correct internal ordering. Reversing the last two elements produces [3, 4, 1, 2], which is the array rotated right by two steps.

    Each reverse operation uses the two-pointers technique, which makes the process fast and in-place. When reversing any segment, we use two pointers, one starting at the left index and another at the right index. These pointers move toward each other, swapping elements along the way, which efficiently reverses the segment in linear time without needing extra space.

    Let’s look at the algorithm steps:

    Normalize the rotation steps. Compute the length of the array, n, and set k = k % n to handle cases where k is greater than n. This ensures we only rotate by the effective number of steps.

    Reverse the entire array. Set two pointers: left = 0 and right = n - 1. While left < right, swap nums[left] and nums[right], then move the pointers inward (left += 1, right -= 1).

    Reverse the first k elements. Set left = 0 and right = k - 1. While left < right, swap nums[left] and nums[right], then move both pointers inward.

    Reverse the remaining n - k elements. Set left = k and right = n - 1. While left < right, swap nums[left] and nums[right], then move both pointers inward.

    After these three reversals, all elements in nums will have been rotated to the right by k steps in place.

    Let’s look at the following illustration to get a better understanding of the solution:

     */

    // Iterate as long as the starting index is less than the ending index.
    // Store the value at the current left index in a temporary variable.
    // Overwrite the value at the left index with the value from the right index.
    // Assign the temporary variable's value to the right index.

    // Move the left index one step forward.
    // Move the right index one step backward.

    public static void reverse(int[] nums, int left, int right) {

        while (left < right) {

            int temp =  nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }

    // Determine the total number of elements in the array 'n'.
    // Normalize 'k' by calculating k % n to handle cases where k is greater than the array length.

    // Use the triple-reversal approach to rotate the array in-place with O(1) extra space:

    // Step 1: Reverse the entire array from index 0 to n - 1.
    // This moves the elements that should be at the end of the rotation to the front, but in reverse order.

    // Step 2: Reverse only the first 'k' elements (from index 0 to k - 1).
    // This restores the correct relative order of the elements that were shifted to the front.

    // Step 3: Reverse the remaining elements from index 'k' to n - 1.
    // This restores the correct relative order of the elements that were shifted to the back.

    public static void rotate(int[] nums, int k) {

        int n = nums.length;

        k = k % n;

        reverse(nums, 0, n-1);
        reverse(nums,0, k-1);
        reverse(nums,k, n-1);
    }


    public static void main(String[] args) {
        Object[][] testCases = {
                new Object[] { new int[]{1, 2, 3, 4, 5}, 2 },
                new Object[] { new int[]{-35, -29, -7, 8, 6}, 3 },
                new Object[] { new int[]{1}, 5 },
                new Object[] { new int[]{10, 20, 30, 40, 50}, 7 },
                new Object[] { new int[]{0, 0, 0, 0}, 10 },
                new Object[] { new int[]{1, 2}, 1 },
                new Object[] { new int[]{2, 4, 6, 8, 10}, 0 }
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] nums = (int[]) testCases[i][0];
            int k = (int) testCases[i][1];

            System.out.println((i + 1) + ".\tInput:");
            System.out.println("\tnums = " + Arrays.toString(nums));
            System.out.println("\tk = " + k);

            rotate(nums, k);  // perform rotation

            System.out.println("\n\tOutput = " + Arrays.toString(nums));
            System.out.println("-".repeat(100));
        }
    }

}
