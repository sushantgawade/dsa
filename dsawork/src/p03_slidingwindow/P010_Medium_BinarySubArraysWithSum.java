package p03_slidingwindow;

public class P010_Medium_BinarySubArraysWithSum {


    /*

    Problem: Binary Subarrays With Sum
    med
    30 min
    Explore how to solve the problem of counting binary subarrays that sum to a given goal. Understand applying the sliding window technique to
    optimize solutions, enabling you to efficiently tackle similar interview challenges.
    Statement
    You are given a binary array, nums, and an integer, goal. Your task is to return the number of non-empty subarrays with a sum that meets the goal.

    Solution
    This problem asks us to find the count of contiguous subarrays within a binary array that sum up to a specific goal.
    As the array consists only of 0 s and 1 s, we can utilize a sliding window pattern.
    This pattern works well because the sum inside the window only ever increases by  0 or 1, allowing predictable expansion and contraction.
    The method also cleverly utilizes the fact that leading zeros within a valid window do not alter the sum but do expand the number of valid subarrays.
    This allows us to count multiple subarrays efficiently without having to restart from scratch for each endpoint.

    The core idea is to maintain a window [left, right] that represents a subarray. As we expand the window to the right, the sum increases.
    If the sum exceeds the goal, we must shrink the window from the left.

    The specific challenge in this problem is handling zeros; a subarray summing to the goal might be preceded by several zeros (e.g.,
    [0,0,1] has the same sum as [1]). To handle this efficiently, whenever our window sum matches the goal, we shrink the left side past any leading zeros, counting them as we go.

    The number of valid subarrays ending at the current right position is then 1
     (the minimal subarray summing to the goal) plus the number of leading zeros we just counted.

    Here’s the detailed algorithm that we’ll use to solve the given problem:

    We initialize the left boundary of the sliding window using a start variable.

    Next, we create a counter, called prefixZeros, to track the number of zeros that appear at the beginning of a valid window, and we maintain a running window sum using the variable currentSum.

    We also need to keep a total count of all valid subarrays, so we use totalCount, which begins at 0.

    As we iterate over the array using the right boundary (end), we add the current element to currentSum to reflect the expanded window:

    If expanding the window causes currentSum to become greater than the target sum (goal):

    We shift the left boundary forward by incrementing start and subtracting the element at that position from currentSum as we proceed.

    We reset prefixZeros because once the window shrinks past its previous leading zeros, those zeros are no longer relevant for counting subarrays.

    While the element at the start position is zero and start is still behind end, each such zero represents a new valid starting point. Moreover, when currentSum equals the target sum, goal, we examine the left side of the window:

    For every such zero, we increase prefixZeros, subtract the zero from currentSum (which keeps the sum unchanged), and move start forward.

    After handling prefix zeros, if the adjusted window still has a sum equal to the target:

    We add 1 + prefixZeros to totalCount.

    The 1 accounts for the default window, and prefixZeros accounts for all additional subarrays formed by shifting the start position across leading zeros.

    We continue this process until the right boundary, end, has scanned the entire array, and we finally return totalCount as the total number of subarrays whose sum matches the goal.

    Let’s look at the following illustration to get a better understanding of the solution:

    Time complexity
    The solution above processes each element, at most twice: once when expanding the window,
    and once when contracting it. So, the total work scales linearly with the array size, giving a time complexity of O(n)
    .

    Space complexity
    The solution uses only a fixed number of integer variables regardless of input size, so the space complexity remains O(1)
    .

    public int numSubarraysWithSum(int[] nums, int goal) {
        // Initialize 'start' pointer to track the beginning of the sliding window.
        // Initialize 'prefixZeros' to count zeros at the start of a valid window.
        // Initialize 'currentSum' to track the cumulative sum within the window.
        // Initialize 'totalCount' to store the total number of subarrays found.

        // Iterate through the array using an 'end' pointer to expand the window.
            // Add the value at 'nums[end]' to the 'currentSum'.

            // Shrink the window from the left if the 'currentSum' exceeds the 'goal'.
            // Iterate while 'start' is within the window bounds AND 'currentSum' is greater than 'goal'.
                // Subtract the value at 'nums[start]' from 'currentSum'.
                // Increment 'start' to move the window forward.
                // Reset 'prefixZeros' to zero since the window boundary has shifted.

            // If the sum matches the goal, count leading zeros to identify additional valid subarrays.
            // Iterate while 'start' is before 'end', 'nums[start]' is 0, and 'currentSum' equals 'goal'.
                // Increment 'prefixZeros' to track these extra starting points.
                // Subtract the value at 'nums[start]' (which is 0) from 'currentSum'.
                // Increment 'start' forward.

            // Check if the current window sum satisfies the requirement.
            // If 'currentSum' is equal to 'goal' and 'start' is valid:
                // Add the count of prefix zeros plus 1 (the current subarray) to 'totalCount'.

        // Return the final count of valid subarrays.
        return 0;
    }


    Let's slow right down and look at this with a simple picture,
    because this is easily one of the trickiest edge cases in sliding window problems.The core reason
    this code is weird is because zeros have no value, but they create extra winning answers.
    The Core Problem with ZerosImagine your array is nums = [0, 0, 1] and your goal is 1.
    If you ask, "Where does a subarray sum up to 1?", there are actually three different answers
    depending on where you start:Starting at index 0: [0, 0, 1] (Sum = 1) ✅Starting at index 1: [0, 1] (Sum = 1)
     ✅Starting at index 2: [1] (Sum = 1) ✅If you use a standard sliding window, it will find the first one ([0, 0, 1]).
     But when you try to shrink the window from the left, a standard window would just jump straight past both zeros
     and completely miss [0, 1] and [1]!How the Code Solves It Step-by-StepWhen end lands on the 1, your window sum is 1
     (which matches your goal).Instead of just recording +1 and moving on, the code says: "Wait, let's look at the left edge.
     Are there leading zeros sitting there?"nums[start] == 0: It checks if the left edge is a 0. Since it is, it knows:
     "Hey, this 0 means we can chop it off and still have a valid sum!"prefixZeros++: It records that it found a leading
     zero and keeps track of how many consecutive zeros it has peeled off so far.totalCount += 1 + prefixZeros;:
     This is the magic formula.The 1 counts the main window ([0, 0, 1]).The prefixZeros counts the bonus valid subarrays
     you get by stripping away those leading zeros one by one ([0, 1] and [1]).SummaryprefixZeros is just a memory counter.
      Because zeros don't change the sum, every leading zero at your left boundary multiplies your valid starting points.
      Tracking them lets you scoop up all those extra combinations in one go without breaking the $O(N)$ speed!


     */

    private int numSubarraysWithSum(int[] nums, int goal) {

        int prefixesZero = 0;
        int currentSum = 0;
        int totalCount = 0;

        int start = 0;

        for(int end = 0; end < nums.length; end++) {

            currentSum += nums[end];

            while(start <= end && currentSum > goal) {

                currentSum -= nums[start];

                start++;

                prefixesZero = 0;
            }

            while(start < end && nums[start] == 0 &&  currentSum == goal) {

                currentSum -= nums[start];

                start++;

                prefixesZero++;
            }

            if(start < end && currentSum == goal) {

                totalCount += 1 + prefixesZero;
            }
        }

        return totalCount;
    }

    public static void main(String[] args) {

        P010_Medium_BinarySubArraysWithSum sol = new P010_Medium_BinarySubArraysWithSum();

        int[][] arrays = {
                {1,0,1,0,1},
                {0,0,0,0,0},
                {1,1,1},
                {0,1,0,1,0,1},
                {1}
        };

        int[] goals = {2, 0, 2, 2, 1};

        for (int i = 0; i < arrays.length; i++) {
            int res = sol.numSubarraysWithSum(arrays[i], goals[i]);
            System.out.println((i+1) + ".\tnums: " + java.util.Arrays.toString(arrays[i]));
            System.out.println("\tgoal: " + goals[i]);
            System.out.println("\tNumber of subarrays with sum = " + goals[i] + " are " + res + ".");
            System.out.println("-".repeat(100));
        }

    }

}
