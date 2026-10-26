package p03_slidingwindow;

import java.util.Arrays;
import java.util.List;

public class P009_Easy_DietPlanPerformance {


    /*

    Problem: Diet Plan Performance
    easy
    15 min
    Explore how to use the sliding window pattern to evaluate a dieter's performance based on calorie intake over consecutive days. Understand the problem constraints and implement an efficient solution for tracking performance points according to calorie thresholds.
    Statement
    A dieter consumes calories[i] calories on the i-th day.

    Given an integer k, the dieter reviews their calorie intake over every sequence of k consecutive days (from calories[i] to calories[i+k-1] for all 0 <= i <= n-k). For each sequence, they calculate T, the total calories consumed over those k days:

    If T is less than lower, the dieter performs poorly and loses 1 point.

    If T is greater than upper, the dieter performs better and gains 1 point.

    If T is between lower and upper (inclusive), the dieter’s performance is normal, and their points remain the same.

    The dieter starts with zero points. Return the total points after the dieter follows this routine for all calories.length days. The total points can be negative.

    Solution
    This problem aims to track the dieter’s performance over every sequence of k consecutive days based on their calorie intake. A sliding window approach is ideal because it allows us to calculate the sum of k consecutive days without recalculating the sum from scratch for each new sequence. In the sliding window technique, we maintain a running sum of the current window of k days. As we move the window one day forward, we adjust the sum by subtracting the day’s calorie count, sliding out of the window, and adding the calorie count of the new day entering the window. This approach ensures that we update the sum and assess the dieter’s performance across all possible sequences of k days.

    Here’s the step-by-step explanation of the solution:

    We initialize the points to zero and calculate the sum of the first k days to form the initial window.

    The sum of the initial k days is checked against lower and upper. If it’s less than lower, points decrease by 1. If it’s greater than the upper, points increase by 1 . Otherwise, the points remain the same.

    We iterate over the rest of the array starting from index k, updating the current sum by removing the element that slides out of the window and adding the new element that comes into the window.

    For each updated sum, we adjust the points based on the performance conditions:

    Subtract 1 if the sum is less than the lower.

    Add 1 if the sum is greater than the upper.

    No change if the sum is within [lower, upper].

    After evaluating all possible windows of k days, we return the accumulated points.

    Let’s look at the following illustration to get a better understanding of the solution:

    Time complexity
    The time complexity of this algorithm is O(n), where n is the length of the calories array.

    Space complexity
    The space complexity of this algorithm is  O(1), which means it uses constant space.

     // Function to calculate diet plan performance
        public static int dietPlanPerformance(List<Integer> calories, int k, int lower, int upper) {
            // Initialize a variable to track the total points starting at 0.
            // Initialize a variable to track the sum of calories for the current k-day window.

            // Create the initial calorie sum for the first window of size 'k':
                // Iterate through the list of calories from the first day to the k-th day.
                    // Add each day's calorie count to the current window sum.

            // Assess the performance of the first k-day period:
                // If the initial sum is strictly less than the 'lower' threshold:
                    // Decrement the points counter by 1.
                // Otherwise, if the initial sum is strictly greater than the 'upper' threshold:
                    // Increment the points counter by 1.

            // Review every subsequent sequence of k consecutive days using a sliding window approach:
                // Iterate through the calories list starting from day index 'k' until the final day.
                    // Add the calories from the current day to the window sum.
                    // Subtract the calories from the day that is no longer part of the current k-day window.
                    // (The index to subtract is: current day index - k).

                    // Evaluate the updated calorie sum against the performance thresholds:
                        // If the updated sum is strictly less than 'lower':
                            // Decrement the points counter by 1.
                        // Otherwise, if the updated sum is strictly greater than 'upper':
                            // Increment the points counter by 1.

            // Return the final point total accumulated over all reviewed sequences.
            return 0;
        }

     */

    private static int dietPlanPerformance(List<Integer> calories, int k, int lower, int upper) {


        int points = 0;
        int currentSum = 0;

        for(int i = 0; i < k; i++){

            currentSum += calories.get(i);
        }

        if(currentSum < lower) {
            points -= 1;
        }
        else if(currentSum > upper) {
            points += 1;
        }

        for(int i = k; i < calories.size(); i++) {

            currentSum += calories.get(i) - calories.get(i - k);

            if(currentSum < lower) {
                points -= 1;
            } else if (currentSum > upper) {
                points += 1;
            }
        }

        return points;

    }

    public static void main(String[] args) {

        List<List<Integer>> testCases = Arrays.asList(
                Arrays.asList(3, 5, 8, 2, 6),     // Test Case 1: Mixed performance
                Arrays.asList(1, 1, 1, 1, 1),     // Test Case 2: All sums below lower limit
                Arrays.asList(10, 12, 15, 20, 25), // Test Case 3: All sums above upper limit
                Arrays.asList(5, 10, 15, 20, 25, 30), // Test Case 4: Mix of poor, normal, and good performances
                Arrays.asList(3, 8, 7, 4, 5, 6)   // Test Case 5: Sliding window with variable performance
        );

        int[] ks = {2, 2, 3, 3, 2};
        int[] lowers = {7, 5, 10, 20, 7};
        int[] uppers = {10, 10, 30, 40, 10};

        // Run each test case
        for (int i = 0; i < testCases.size(); i++) {
            System.out.println("Test Case " + (i + 1) + ":");
            System.out.print("\tcalories = [");
            String s = "";
            for (int j = 0; j < testCases.get(i).size(); j++) {
                s += testCases.get(i).get(j);
                if (j != testCases.get(i).size() - 1) {
                    s += ", ";
                }
            }
            System.out.println(s + "]");
            System.out.println("\tk = " + ks[i]);
            System.out.println("\tlower = " + lowers[i]);
            System.out.println("\tupper = " + uppers[i]);
            int result = dietPlanPerformance(testCases.get(i), ks[i], lowers[i], uppers[i]);
            System.out.println("\n\tpoints = " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }
}
