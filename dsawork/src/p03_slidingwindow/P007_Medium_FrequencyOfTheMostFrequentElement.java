package p03_slidingwindow;

import java.util.Arrays;

public class P007_Medium_FrequencyOfTheMostFrequentElement {


    /*
    Problem: Frequency of the Most Frequent Element
    med
    30 min
    Explore how to apply the sliding window technique to maximize the frequency of an element in an integer array by
    incrementing values within a set limit. Understand how to efficiently solve problems involving frequency calculation
    and constraints to improve your coding interview skills.
    Statement
    You are given an integer array, nums, and an integer k, representing the maximum number of operations you can perform.
    In each operation, you may select any index in nums and increment its value by 1.

    Your task is to determine the maximum possible frequency of a single element in the final array after performing
    at most k operations. You can choose to increase any elements in a way that results in one particular element
    appearing as often as possible (within k operations). For example, if nums = [2, 2, 3] and k = 4, you can
    increment the first and the second element, 2, once to match the third element, 3, achieving a maximum frequency of 3.

    Return the highest frequency that can be achieved for any element in nums after at most k operations.

    The frequency of an element is the number of times it appears in an array.

    Solution
    The best way to solve this problem is to convert smaller numbers into the largest possible number while using the least number of operations. To achieve this, we use the sliding window technique, which maintains a group of numbers that can be adjusted to match a target value (the largest number in the window). The window size is increased or decreased dynamically based on the sum of its elements, allowing us to quickly determine whether we can increase all numbers in the window to match the target value within the allowed k operations. The largest window where this condition holds gives us the maximum possible frequency.

    In this solution, we first sort nums so that we always transform smaller numbers first, which requires fewer operations than modifying larger ones. This makes it easier to maintain a valid window where all elements can be equal to the rightmost (largest) element.

    For any particular window, we decide to expand it further or shrink it based on the following condition:


    window  size×target  value
    window sum +  k

    This means that for a window to be valid, the total sum (if all elements were target) should not exceed the actual sum of elements in the current window plus k allowed operations.

    If the condition is true and the window is valid, we add the next element of nums to the current window.

    Otherwise, if the condition is false, we shrink the window.

    This process continues until we find the largest valid window within which all numbers can be equal. The illustration below helps us understand the concept better.


    Now, let’s look at the algorithm steps of this solution:

    Sort the array nums.

    Initialize the following variables:

    The left pointer of the sliding window is left = 0. The right pointer will be initialized later because right expands the window dynamically as we iterate over nums.

    A variable maxFreq = 0 that stores the maximum frequency found so far.

    A variable windowSum = 0, which keeps track of the sum of elements within the current window.

    Iterate through nums using a sliding window (the right pointer is initialized here):

    Calculate the target value, which is the rightmost element in the current window, target = nums[right].

    Expand the window by adding nums[right] to windowSum.

    Check if the current window gives us the maximum frequency we are looking for using the condition (right - left + 1) * target > windowSum + k. If it’s true, it means we need more than k operations to make all elements equal to the target, so we must shrink the window as follows:

    Subtracting nums[left] from windowSum

    Incrementing left to move the left boundary forward.

    After adjusting the window, update maxFreq.

    Once we have traversed the nums completely, return the maximum frequency found.

    Let’s look at the following illustration to get a better understanding of the solution:


    Let’s look at the code for the algorithm we just discussed.

    Time complexity
    Let’s break down and analyze the time complexity of this solution:

    Sorting the array takes O(nlogn), where n is the length of nums.

    The sliding window traversal takes O(n) time because the right pointer moves from 0 to n−1.

    During the sliding window traversal, the left pointer only moves forward when needed, ensuring each element is processed at most once. In the worst case, left moves n
     times across all iterations.

    If we sum these up, the overall time complexity simplifies to:

    O(n)+O(nlogn)=O(nlogn)

    Space complexity
    Java's sort() method typically requires  O(logn)
     space. Additionally, a few variables using constant space are used. Therefore, the overall space complexity is O(logn) .




    public static int maxFrequency(int[] nums, int k) {
        // Sort the array in non-decreasing order to group smaller values together.

        // Initialize a 'left' pointer to mark the beginning of the sliding window.
        // Initialize 'maxFreq' to zero to track the largest frequency achieved.
        // Initialize 'windowSum' to zero (using a long type for safety) to maintain the sum of values in the window.

        // Iterate through the array using a 'right' pointer to expand the window:
            // Set the value at 'right' as the target element we want to reach in this window.
            // Add the value of the current element to the 'windowSum'.

            // Determine if the current window is valid by calculating the operations needed.
            // The window is invalid if the required increments (window size * target - windowSum) exceed 'k'.
            // Mathematically, check if: (right - left + 1) * target > windowSum + k.

            // While the operations required are greater than 'k':
                // Remove the value at the 'left' pointer from the 'windowSum'.
                // Increment the 'left' pointer to shrink the window from the left.

            // Once the window is valid, calculate the current frequency as (right - left + 1).
            // Update 'maxFreq' if this current frequency is the highest found so far.

        // Return the final 'maxFreq' representing the maximum possible frequency of a single element.
    }


     */


    private static int maxFrequency(int[] testCase, int kValue) {

    }

    public static void main(String[] args) {

        int[][] testCases = {
                {1, 2, 4},
                {1, 4, 8, 13},
                {3, 6, 9},
                {2, 3, 5},
                {1, 1, 2},
                {4, 6, 8, 10},
                {10, 12, 5, 1, 15, 20, 13, 4, 7, 3, 9, 14, 2, 8, 6, 16, 11, 18, 19, 17},
                {5, 5, 5, 5, 6, 7, 8, 9, 10, 10, 10, 10, 10, 11, 12, 13, 14, 15, 16, 17}
        };
        int[] kValues = {5, 5, 2, 3, 2, 7, 50, 30};

        for (int i = 0; i < testCases.length; i++) {
            System.out.println((i + 1) + ".\tnums = " + Arrays.toString(testCases[i]));
            System.out.println("\tk = " + kValues[i]);
            System.out.println("\n\tOutput = " + maxFrequency(testCases[i], kValues[i]));
            System.out.println("-" + new String(new char[100]).replace('\0', '-') + "\n");
        }

    }
}
