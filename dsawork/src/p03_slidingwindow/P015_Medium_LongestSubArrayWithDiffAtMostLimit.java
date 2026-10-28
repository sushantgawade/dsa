package p03_slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class P015_Medium_LongestSubArrayWithDiffAtMostLimit {

    /*

    Problem: Longest Subarray With Diff At Most Limit
    med
    30 min
    Explore how to apply the sliding window approach to find the longest subarray in an integer array where the absolute difference between any two elements does not exceed a given limit. This lesson helps develop efficient problem-solving skills for array constraints using Python.
    Statement
    Given an integer array nums and an integer limit, return the size of the longest non-empty subarray such that the absolute difference between any two elements within that subarray is less than or equal

Solution
The key insight is that for any subarray to be valid, the absolute difference between its maximum and minimum elements must be within limit. We use a sliding window approach with two monotonic deques — maxDeque and minDeque — to efficiently track the current window’s maximum and minimum values in
O
(
1
)
O(1)
 time. As the right pointer expands the window by including a new element, both deques are updated to maintain their ordering invariants. Whenever the difference between the tracked maximum and minimum exceeds limit, the left pointer is advanced to shrink the window until the condition is satisfied again. At every step, the current valid window size is compared against the best found so far.

Now, let’s look at the solution steps below:

Initialize two deques, maxDeque and minDeque, both storing indices. maxDeque will hold indices in decreasing order of their corresponding values (so the front always points to the current maximum), and minDeque will hold indices in increasing order of their corresponding values (so the front always points to the current minimum). Also initialize left to
0
0
 and maxLen to
0
0
.

Iterate right from
0
0
 to the end of nums, treating each index as the right boundary of the sliding window:

Before appending right, remove all indices from the back of maxDeque whose corresponding values are less than or equal to nums[right], since they can never be the maximum of any future window that includes right. Then append right to maxDeque.

Similarly, remove all indices from the back of minDeque whose corresponding values are greater than or equal to nums[right], since they can never be the minimum of any future window that includes right. Then append right to minDeque.

While the difference between nums[maxDeque[0]] (current window maximum) and nums[minDeque[0]] (current window minimum) exceeds limit, increment left to shrink the window from the left. After incrementing left, if the front index of maxDeque is now less than left, remove it from the front. Do the same for minDeque.

Compute the current window size as right minus left plus
1
1
, and update maxLen if this value is larger.

After the loop completes, return maxLen as the length of the longest valid subarray found.

Let’s look at the following illustration to get a better understanding of the solution:

Time complexity
The time complexity of the solution is
O
(
n
)
O(n)
 because each element in nums is added to and removed from both maxDeque and minDeque at most once, making all deque operations amortized
O
(
1
)
O(1)
 per element. The single pass of the right pointer over
n
n
 elements, combined with the amortized constant work per element for window shrinking and deque maintenance, gives an overall linear time complexity.

Space complexity
The space complexity of the solution is
O
(
n
)
O(n)
 because in the worst case, both maxDeque and minDeque can each hold up to
n
n
 indices simultaneously, for example when all elements are strictly increasing for minDeque or strictly decreasing for maxDeque.

    public int longestSubarray(int[] nums, int limit) {
        // Initialize two double-ended queues (deques) to track indices of the elements in the current window.
        // One deque (maxDeque) will maintain indices in a way that the value at the front is the maximum.
        // The other deque (minDeque) will maintain indices such that the value at the front is the minimum.

        // Initialize a left pointer to define the start of the sliding window.
        // Initialize a variable to keep track of the maximum length of any valid subarray found.

        // Iterate through the array using a right pointer to expand the sliding window:
            // Maintain the maxDeque in monotonic decreasing order:
            // While the maxDeque is not empty and the current element is greater than the element at the back of maxDeque:
                // Remove the index from the back of the maxDeque.
            // Add the current right index to the back of the maxDeque.

            // Maintain the minDeque in monotonic increasing order:
            // While the minDeque is not empty and the current element is smaller than the element at the back of minDeque:
                // Remove the index from the back of the minDeque.
            // Add the current right index to the back of the minDeque.

            // Check if the current window violates the limit constraint:
            // While the absolute difference between the maximum value and the minimum value in the current window exceeds the limit:
                // Increment the left pointer to shrink the window from the left.
                // If the index at the front of the maxDeque is now outside the window (less than the left pointer):
                    // Remove it from the front of the maxDeque.
                // If the index at the front of the minDeque is now outside the window (less than the left pointer):
                    // Remove it from the front of the minDeque.

            // Update the global maximum length using the size of the current valid window (right - left + 1).

        // Return the maximum length recorded during the iteration.
    }



     */


    private int longestSubarray(int[] nums, int limit) {


        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();

        int left = 0;
        int maxLen = 0;

        for(int right =0; right < nums.length; right++){

            while(!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[right]) {

                maxDeque.pollLast();
            }

            maxDeque.offerLast(right);

            while(!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[right]) {

                minDeque.pollLast();
            }

            minDeque.offerLast(right);

            while(nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {

                left++;

                if(maxDeque.peekFirst() < left) {

                    maxDeque.pollFirst();
                }

                if(minDeque.peekFirst() < left) {

                    minDeque.pollFirst();
                }
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return  maxLen;
    }

    public static void main(String[] args) {

        P015_Medium_LongestSubArrayWithDiffAtMostLimit sol = new P015_Medium_LongestSubArrayWithDiffAtMostLimit();

        int[][][] testNums = {
                {{1, 5, 6, 7, 8, 10, 6}},
                {{3, 3, 3, 3, 3}},
                {{1, 100, 1, 100, 1}},
                {{5, 10, 15, 20, 25}},
                {{1000000000, 1, 1000000000, 1}}
        };
        int[] limits = {4, 0, 99, 10, 999999999};

        for (int i = 0; i < testNums.length; i++) {
            int[] nums = testNums[i][0];
            int limit = limits[i];
            int result = sol.longestSubarray(nums, limit);

            System.out.print((i + 1) + ".\tInput array: [");
            for (int j = 0; j < nums.length; j++) {
                System.out.print(nums[j]);
                if (j + 1 < nums.length) System.out.print(", ");
            }
            System.out.println("]");
            System.out.println("\tTarget: " + limit);
            System.out.println("\tResult: " + result);
            System.out.println("-".repeat(100));
        }


    }

}
