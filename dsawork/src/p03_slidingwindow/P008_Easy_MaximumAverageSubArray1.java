package p03_slidingwindow;

public class P008_Easy_MaximumAverageSubArray1 {

    /*

    Problem: Maximum Average Subarray I
    easy
    15 min
    Explore how to solve the problem of finding the maximum average of contiguous subarrays of length k using the sliding window pattern. Understand constraints, practice implementation, and apply this core interview pattern to optimize array computations.
    Statement
    Given an array of integers nums, and an integer k, return the maximum average of a contiguous subarray of length k.

    Solution
    The algorithm to find the maximum average of a subarray of length k uses the sliding window pattern. First, It calculates the sum of the first k elements of the array and stores them as the current and maximum sum. Then, it slides the window one element at a time over the array. For each new element that enters the window, the algorithm subtracts the element that leaves the window from the current sum and adds the new element to the current sum. This way, the sum of the window elements is calculated without recalculating the entire sum from scratch. The algorithm then updates the maximum sum with the current sum if the value of the current sum is greater than the previously recorded maximum sum. Finally, the algorithm returns the maximum average by dividing the maximum sum with k.

    The algorithm to solve this problem is as follows:

    Calculate the sum of the first k elements in nums in current_sum.

    Assign the value of the current_sum to max_sum to keep a record of the maximum sum.

    Loop on nums from index k till nums.length and in each iteration of the loop:

    Update current_sum by subtracting the element that leaves the window, i.e., nums[i - k], and adding the new element that just entered the window, i.e., nums[i].

    Check if the value of current_sum is greater than the max_sum; if so, assign the value of current_sum to max_sum.

    After the loop terminates, return the average of the subarray by dividing max_sum with k.

    Let’s look at the following illustration to get a better understanding of the solution:

    Let’s look at the code for the algorithm we just discussed.

    Time complexity
    We are traversing each item of the nums array only once; therefore, the time complexity of the given solution is O(n)
    , where n is the number of elements of the nums array.

    Space complexity
    The space complexity of the solution is O(1)
     because the algorithm only uses a constant amount of extra space.

     // Method to find maximum average of subarray of length k
        public static double findMaxAverage(int[] nums, int k) {
            // Initialize a variable to track the sum of the current sliding window.

            // Iterate through the first 'k' elements of the 'nums' array to calculate the initial window sum.
                // Add the value of each element to the current window sum.

            // Set the initial maximum sum to be the current window sum calculated above.

            // Slide the window across the rest of the array starting from index 'k' to the end of the array.
                // Update the window sum by adding the new element entering from the right.
                // Subtract the element that is now outside the window on the left (at index i - k).

                // Compare the updated window sum with the recorded maximum sum.
                // If the updated window sum is larger than the maximum sum:
                    // Update the maximum sum to be the current window sum.

            // After checking all possible subarrays of length k, divide the maximum sum by k to find the average.
            // Return the resulting maximum average as a double.
            return 0.0;
        }

     */

    private static double findMaxAverage(int[] nums, int k) {

        int currentSum = 0;

        int maxSum = 0;

        for(int i =0; i < k; i++ ) {

            currentSum += nums[i];
        }

        for(int i = k; i < nums.length; i++ ) {

            currentSum += nums[i] - nums[i-k];

            maxSum = Math.max(maxSum, currentSum);
        }


        return (double) maxSum / k;

    }

    public static void main(String[] args) {

        int[][] inputData = {
                {10, 5, 2, -1, 6, 3, -2, -4, 4, 1, -3, -6, -1, -2, -5, -7},
                {7, 3, 1, -2, 6, 2, -1, -3, 4, 1, -2, -5, 2, 0, -4, -6},
                {12, 9, 5, 2, 8, 6, 4, 1, 7, 5, 3, 0, 4, 2, 0, -3},
                {-10, -11, -12, -13, -20, -21, -22, -23, -30, -31, -32, -33, -40, -41, -42, -43},
                {5, 3, -2, -3, 4, 2, -3, -4, 3, 1, -4, -5, 2, 0, -5, -6}
        };

        int k = 4;

        for (int i = 0; i < inputData.length; i++) {
            int[] nums = inputData[i];
            double result = findMaxAverage(nums, k);
            System.out.print((i + 1) + ".\tInput: nums = {");
            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println("}, k = " + k);
            System.out.printf("\tMaximum Average: %.2f%n", result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }
}
