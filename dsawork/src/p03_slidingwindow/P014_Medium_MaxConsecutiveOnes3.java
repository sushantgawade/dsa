package p03_slidingwindow;

import java.util.Arrays;

public class P014_Medium_MaxConsecutiveOnes3 {

    /*


    Problem: Max Consecutive Ones III
    med
    30 min
    Explore how to apply the sliding window technique to determine the longest sequence of consecutive ones in a binary array by flipping at most k zeros. This lesson helps you understand the problem constraints and develop an efficient Python solution to optimize consecutive ones calculation under given limits.
    Statement
    Given a binary array nums and an integer k, return the maximum number of consecutive
    1
    1
    's in nums if you are allowed to flip at most k zeros to ones.


Solution
The key insight is that we want the longest subarray containing at most k zeros, since each zero in the window can be “flipped” to a one. We use a sliding window approach with two pointers, left and right, to maintain a valid window where the count of zeros never exceeds k. As right expands the window element by element, we track how many zeros have entered using zeroCount. Whenever zeroCount exceeds k, we shrink the window from the left until the window becomes valid again. At every step, the current window size represents a valid consecutive sequence of
1
1
s (with at most k flips), and we continuously update the maximum length seen so far.

Now, let’s look at the solution steps below:

Initialize left to
0
0
, zeroCount to
0
0
, and maxLen to
0
0
.

Iterate through the array using a right pointer from index
0
0
 to the end of nums.

If nums[right] equals
0
0
, increment zeroCount by
1
1
 to account for the new zero entering the window.

While zeroCount exceeds k, shrink the window from the left.

If nums[left] equals
0
0
, decrement zeroCount by
1
1
 since a zero is leaving the window.

Increment left by
1
1
 to move the window forward.

After ensuring the window is valid (at most k zeros), compute the current window length as right
−
−
 left
+
+

1
1
 and update maxLen with the larger of its current value and this window length.

After the loop completes, return maxLen as the answer.

Let’s look at the following illustration to get a better understanding of the solution:

Let’s look at the code for this solution below:

Time complexity
The time complexity of the solution is
O
(
n
)
O(n)
 because each element in nums is visited at most twice: once when right expands the window to include it, and at most once more when left shrinks the window past it. Here,
n
n
 is the length of nums.

Space complexity
The space complexity of the solution is
O
(
1
)
O(1)
 because only a fixed number of variables (left, right, zeroCount, and maxLen) are used, regardless of the size of the input array.


    public int longestOnes(int[] nums, int k) {
        // Initialize a pointer for the left boundary of the sliding window.
        // Initialize a variable to keep track of the number of zeros inside the current window.
        // Initialize a variable to store the maximum length of the window found so far.

        // Iterate through the array using a right pointer to expand the sliding window.
            // If the element at the right pointer is a zero:
                // Increment the zero counter.

            // While the number of zeros in the window exceeds the maximum allowed flips 'k':
                // If the element at the left pointer is a zero:
                    // Decrement the zero counter as this zero will now be outside the window.
                // Increment the left pointer to shrink the window from the left side.

            // Calculate the size of the current window (right index - left index + 1).
            // Update the maximum length if the current window size is larger than the recorded maximum.

        // After the right pointer has traversed the entire array, return the maximum length found.
    }




     */


    public static void main(String[] args) {

        P014_Medium_MaxConsecutiveOnes3 sol = new P014_Medium_MaxConsecutiveOnes3();

        int[][][] numsArray = {
                {{1, 0, 1, 1, 0, 1, 1, 1, 0, 1}},
                {{0, 0, 0, 0, 1, 1, 1, 1, 1}},
                {{1, 1, 0, 0, 1, 1, 0, 1, 1, 1}},
                {{0, 1, 0, 1, 0, 1, 0, 1}},
                {{1, 1, 1, 1, 1, 0, 0, 0, 0}},
        };
        int[] kValues = {1, 2, 3, 0, 4};

        for (int i = 0; i < numsArray.length; i++) {
            int[] nums = numsArray[i][0];
            int k = kValues[i];
            int result = sol.longestOnes(nums, k);

            System.out.print((i + 1) + ".\tInput array: " + Arrays.toString(nums) + "\n");
            System.out.println("\tTarget: " + k);
            System.out.println("\tResult: " + result);
            System.out.println("-".repeat(100));
        }

    }

    private int longestOnes(int[] nums, int k) {


    }

}
