package twospointers;

public class P025_Medium_LongestSubArrayOfOnesAfterDeletingOneElement {


     /*
        Statement
        Given a binary array nums, remove exactly one element from it. Return the length of the longest
        non-empty subarray consisting entirely of 1's in the resulting array. If no such subarray exists, return 0

    Solution
    The key insight is that deleting exactly one element from the binary array is equivalent to allowing a sliding window to contain at most 1 zero.
    A window [left, right] that contains at most one 0 represents a subarray where deleting that single 0 (or any 1 if there are no zeros) yields a contiguous run of
    1 's. The answer is the window size minus 1, because one element must always be removed. We use two pointers, left and right,
    to maintain this window dynamically, shrinking it from the left whenever the zero count exceeds 1, and tracking the maximum valid length throughout.

    Now, let’s look at the solution steps below:

    Initialize left to0, zeroCount to 0 , and maxLen to 0.

    left marks the start of the current window, zeroCount tracks how many zeros are inside the window, and maxLen stores the best answer seen so far.

    Iterate right from 0 to the end of nums, expanding the window one element at a time.

    If nums[right] equals 0, increment zeroCount.

    While zeroCount exceeds 1, shrink the window from the left.

    If nums[left] equals 0, decrement zeroCount.

    Increment left to move the window boundary rightward.

    This loop continues until the window contains at most one 0
    , ensuring the window always represents a valid candidate after one deletion.

    Update maxLen with the expression right - left.

    The current window spans indices left through right, giving a size of right - left + 1, but since exactly one element must be deleted, the effective length of 1's is right - left.

    After the loop completes, return maxLen as the length of the longest subarray of 1
    's achievable after exactly one deletion.

         */

    public static void main(String[] args) {



    }
}
