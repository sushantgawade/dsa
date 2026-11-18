package p04_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P003_Medium_IntervalListIntersections {


    /*

    Problem: Interval List Intersections
    med
    30 min
    Interval List Intersections compares two sorted lists of disjoint closed intervals and returns every interval where a pair from the lists overlaps.
    Statement
    Given two lists of closed intervals, intervalLista and intervalListb, return the intersection of the two interval lists.

    Each interval in the lists has its own start and end time and is represented as [start, end]. Specifically:

    intervalLista[i] = [starti, endi]

    intervalListb[j] = [startj, endj]

    The intersection of two closed intervals i and j is either:

    An empty set, if they do not overlap, or

    A closed interval [max(starti, startj), min(endi, endj)] if they do overlap.

    Also, each list of intervals is pairwise disjoint and in sorted order.

Solution
So far, you’ve probably brainstormed some approaches and have an idea of how to solve this problem. Let’s explore some of these approaches and figure out which one to follow based on considerations such as time complexity and any implementation constraints.

Naive approach
The naive approach for this problem is to use a nested loop for finding intersecting intervals.

The outer loop will iterate for every interval in intervalLista and the inner loop will search for any intersecting interval in the intervalListb.

If such an interval exists, we add it to the intersections list.

Since we are using nested loops, the time complexity for this naive approach will be
O
(
n
∗
m
)
O(n∗m)
, where
n
n
 is the length of intervalsA and
m
m
 is the length of intervalsB.

Optimized approach using intervals
The essence of this approach is to leverage two key advantages: first, the lists of intervals are sorted, and second, the result requires comparing intervals to check for overlap. The algorithm works by iterating through both sorted lists of intervals simultaneously, identifying intersections between intervals from the two lists. At each step, it compares the current intervals from both lists and determines whether there is an intersection by examining the endpoints of the intervals. It adds the intersecting interval to the result list if an intersection exists. To efficiently navigate through the intervals, the algorithm adjusts pointers based on the positions of the intervals’ endpoints, ensuring that it covers all possible intersections. The algorithm accurately computes the interval list intersection by systematically traversing the lists, identifying intersections, and adding them to the results list, the algorithm accurately computes the interval list intersection.

The algorithm to solve this problem is as follows:

We’ll use two indexes, i and j, to iterate through the intervals in both lists, interval_list_a and interval_list_b, respectively.

To check whether there’s any intersecting point among the given intervals:

Take the starting times of the first pair of intervals from both lists and check which occurs later, storing it in a variable, say start.

Also, compare the ending times of the same pair of intervals from both lists and store the minimum end time in another variable, say, end.


Next, we will check if intervalLista[i] and intervalListb[j] overlap by comparing the start and end times.

If the times overlap, then the intersecting time interval will be added to the resultant list, that is, intersections.

After the comparison, we need to move forward in one of the two input lists. The decision is taken based on which of the two intervals being compared ends earlier. If the interval that ends first is in intervalLista, we move forward in that list, else, we move forward in intervalListb.

The slide deck below illustrates the key steps of the solution.


Let’s look at the code for this solution below:

Solution summary
Let’s briefly discuss the approach that we have used to solve the above mentioned problem:

Set two pointers, i and j, at the beginning of both lists, respectively, for their iteration.

While iterating, find the latest starting time and the earliest ending time for each pair of intervals intervalLista[i] and intervalListb[j] .

If the latest starting time is less than or equal to the earliest ending time, store it as an intersection.

Increment the pointer (i or j) of the list having the smaller end time of the current interval.

Keep iterating until either list is fully traversed.

Return the list of intersections.

Time complexity
The time complexity is
O
(
n
+
m
)
O(n+m)
, where
n
n
 and
m
m
 are the number of meetings in intervalLista and intervalListb, respectively.

Space complexity
The space complexity is
O
(
n
)
O(n)
.


    public static int[][] intervalsIntersection(int[][] intervalLista, int[][] intervalListb) {
        // Initialize an empty collection to store the resulting intersection intervals.
        // Initialize two index pointers, i and j, to start at the first interval of each list.

        // Iterate through both lists while both pointers are within bounds:
            // Calculate the start of a possible intersection by taking the maximum of the start times of the current intervals.
            // Calculate the end of a possible intersection by taking the minimum of the end times of the current intervals.

            // If the calculated start time is less than or equal to the calculated end time:
                // An intersection exists; append the interval [start, end] to the result collection.

            // Compare the end times of the current intervals to decide which pointer to advance.
            // If the interval in the first list ends before the interval in the second list:
                // Increment the first list's pointer to move to its next interval.
            // Otherwise:
                // Increment the second list's pointer to move to its next interval.

        // Convert the collection of intersections into a 2D array and return it.
    }






     */




    private static int[][] intervalsIntersection(int[][] intervalLista, int[][] intervalListb) {

        List<int[]> intersections = new ArrayList<>();

        int i = 0;
        int j = 0;

        while(i < intervalLista.length && j < intervalListb.length) {

            int start = Math.max(intervalLista[i][0], intervalListb[j][0]);
            int end = Math.min(intervalLista[i][1], intervalListb[j][1]);

            if(start < end) {
                intersections.add(new int[]{start, end});
            }
            if(intervalLista[i][1] < intervalListb[j][1]) {

                i++;
            }
            else {
                j++;
            }

        }

        return intersections.toArray(new int[0][]);


    }

    public static void main(String[] args) {

        int[][][] inputIntervalLista = {
                {{1, 2}},
                {{1, 4}, {5, 6}, {9, 15}},
                {{3, 6}, {8, 16}, {17, 25}},
                {{4, 7}, {9, 16}, {17, 28}, {39, 50}, {55, 66}, {70, 89}},
                {{1, 3}, {5, 6}, {7, 8}, {12, 15}}
        };

        int[][][] inputIntervalListb = {
                {{1, 2}},
                {{2, 4}, {5, 7}, {9, 15}},
                {{2, 3}, {10, 15}, {18, 23}},
                {{3, 6}, {7, 8}, {9, 10}, {14, 19}, {23, 33}, {35, 40}, {45, 59}, {60, 64}, {68, 76}},
                {{2, 4}, {7, 10}}
        };

        for (int i = 0; i < inputIntervalLista.length; i++) {
            System.out.println(i + 1 + ".\t Interval List A: " + Arrays.deepToString(inputIntervalLista[i]));
            System.out.println("\t Interval List B: " + Arrays.deepToString(inputIntervalListb[i]));
            System.out.println("\t Intersecting intervals in 'A' and 'B' are: " +
                    Arrays.deepToString(intervalsIntersection(inputIntervalLista[i], inputIntervalListb[i])));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }

}
