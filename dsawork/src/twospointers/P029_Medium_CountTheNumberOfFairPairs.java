package twospointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P029_Medium_CountTheNumberOfFairPairs {

    /*
    Problem: Count the Number of Fair Pairs
    med
    30 min
    Try to solve the Count the Number of Fair Pairs problem.
    Statement
    Given an integer array nums and two integers lower and upper, count how many index pairs (i, j) satisfy all of the following:
    the indices are distinct with i < j, and the sum nums[i] + nums[j] lies within the inclusive range from lower to upper.

    Return the total number of such pairs.

    Solution
    The key idea is to sort nums so we can count pairs efficiently with two pointers. Instead of directly counting sums in the inclusive range [lower, upper], we count how many pairs have sum at most a value targetSum, using a helper countPairsAtMost. Then the answer is the difference between pairs with sum at most upper and pairs with sum at most lower - 1, which converts the inclusive range into two prefix style counts.

    Now, let’s look at the solution steps below:

    countPairsAtMost(targetSum) returns the number of index pairs (i, j) with i < j and nums[i] + nums[j] <= targetSum.

    Initialize left to 0.

    Initialize right to len(nums) - 1.

    Initialize totalPairs to 0.

    While left < right, compute the sum nums[left] + nums[right].

    If nums[left] + nums[right] <= targetSum, then for this fixed left, every index from left + 1 through right forms a valid pair with left.

    Add right - left to totalPairs.

    Increment left by 1 to count pairs starting from the next left value.

    Otherwise, decrement right by 1 to reduce the sum and try again.

    Return totalPairs.

    countFairPairs(nums, lower, upper) returns the number of index pairs (i, j) with i < j and lower <= nums[i] + nums[j] <= upper.

    Sort nums to enable a monotonic two pointers scan.

    Compute the final result as countPairsAtMost(upper) - countPairsAtMost(lower - 1).

    Let’s look at the following illustration to get a better understanding of the solution:

    public long countFairPairs(int[] nums, int lower, int upper) {
        // Sort the array 'nums' in non-decreasing order to enable the two-pointer calculation.

        // The count of fair pairs in the range [lower, upper] can be found using the prefix sum principle:
        // result = countPairsWithSumAtMost(upper) - countPairsWithSumAtMost(lower - 1).

        // Define logic to count the number of pairs (i, j) such that i < j and nums[i] + nums[j] <= target:
            // Initialize the 'left' pointer at the beginning of the sorted array.
            // Initialize the 'right' pointer at the end of the sorted array.
            // Initialize a long variable 'totalCount' to store the number of valid pairs.

            // Iterate as long as 'left' is less than 'right':
                // Calculate the sum of elements at the 'left' and 'right' pointers.
                // If the sum is less than or equal to the 'target':
                    // Since the array is sorted, every element from index 'left + 1' up to 'right'
                    // forms a valid pair with the element at 'left'.
                    // Add the count of these indices (right - left) to 'totalCount'.
                    // Move the 'left' pointer forward to explore the next set of pairs.
                // Otherwise (if the sum exceeds 'target'):
                    // The element at 'right' is too large to satisfy the condition with 'nums[left]'.
                    // Move the 'right' pointer backward to reduce the sum.

            // The logic concludes by returning the 'totalCount' of pairs for that 'target'.

        // Compute the result by finding the pair counts for 'upper' and 'lower - 1'.
        // Return the difference between the two counts as the total number of fair pairs.
    }

     */

    private long countFairPairs(int[] nums, int lower, int upper) {
    }

    public static void main(String[] args) {

        List<Object[]> testCases = new ArrayList<>();
        testCases.add(new Object[]{new int[]{-2, 0, 1, 3, 5}, 1, 4});
        testCases.add(new Object[]{new int[]{10, -10, 2, 8, -3, 7}, -1, 9});
        testCases.add(new Object[]{new int[]{4, 4, 4, 4, 4}, 8, 8});
        testCases.add(new Object[]{new int[]{-5, -1, -2, 6, 9, 0}, -3, 4});
        testCases.add(new Object[]{new int[]{1000000000, -1000000000, 0, 1, -1}, -1, 1});
        P029_Medium_CountTheNumberOfFairPairs sol = new P029_Medium_CountTheNumberOfFairPairs();
        for (int i = 0; i < testCases.size(); i++) {
            Object[] tc = testCases.get(i);
            int[] nums = (int[]) tc[0];
            int lower = (int) tc[1];
            int upper = (int) tc[2];
            int[] numsForPrint = Arrays.copyOf(nums, nums.length);
            long result = sol.countFairPairs(nums, lower, upper);
            System.out.println((i + 1) + ".\tInput array: " + Arrays.toString(numsForPrint));
            System.out.println("\tTarget: " + lower + ", " + upper);
            System.out.println("\tResult: " + result);
            System.out.println("-".repeat(100));
        }

    }


}
