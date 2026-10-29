package p04_intervals;

import java.util.*;

public class P001_Medium_MergeIntervals {

    /*

    Problem: Merge Intervals
    75
    med
    30 min
    Explore how to merge overlapping intervals by evaluating their start and end times. This lesson helps you understand
    the problem constraints and develop efficient solutions to return non-overlapping intervals. Gain practice in
    analyzing interval problems commonly encountered in coding interviews.
    Statement
    We are given an array of closed intervals called intervals, where each interval has a start time and an end time
    and is represented as intervals[i] = [starti, endi]. Your task is to merge all the overlapping intervals and return
    an array of the resulting non-overlapping intervals that cover all the intervals in the input.

    Solution
So far, you’ve probably brainstormed some approaches and have an idea of how to solve this problem. Let’s explore some of these approaches and figure out which one to follow, based on considerations such as time complexity and any implementation constraints.

Naive approach
The naive approach to merging intervals involves comparing each interval with all the intervals that come after it. If two intervals overlap, they are merged into a single interval by updating the start to the minimum of both start times and the end to the maximum of both end times. After merging, the second interval (the one being compared) is removed from the list, as its range is now included in the updated interval. The algorithm then checks for further overlaps with the updated interval from the same position. This process repeats until all overlapping intervals have been merged, resulting in a final list of non-overlapping intervals.

This process continues until all overlapping intervals are merged. While this method is easy to understand and doesn’t require extra space, it can be inefficient for large inputs because it compares each interval with many others, leading to a time complexity of
O
(
n
2
)
O(n
2
 )
.

Optimized approach using the intervals pattern
The optimized approach starts by sorting the intervals in ascending order based on their start times. This step ensures overlapping intervals are positioned next to each other, making identifying and merging them easier. Once sorted, the algorithm initializes a result list with the first interval. It then iterates through the remaining intervals one by one, comparing each to the last interval in the result list.

If the current interval overlaps with the last one in the result (i.e., its start time is less than or equal to the end time of the last interval), the two intervals are merged by updating the end time to the maximum of both intervals’ end times. If there is no overlap, the current interval is added to the result list as a new entry. This process continues until all intervals have been processed. In the end, the result list contains the merged, non-overlapping intervals.

Step-by-step solution construction
The first step is to sort the list of intervals based on their start times. This ensures that we are processing the intervals in the correct order, from the earliest start time to the latest, to easily detect overlapping intervals as we move through the list.

After sorting, we initialize a result list and add the first interval from the sorted list to it. This result list will eventually contain all the merged intervals.

The code below implements the steps above:


Next, we iterate through the remaining intervals in the input list, starting from the second one. For each interval, we compare its start time with the end time of the last interval currently in the result list:

If the current interval’s start time is less than or equal to the end time of the last interval in the result list (intervals[i][0] <= result.getLast()[1]), this means the current interval overlaps with the last interval in result.

In this case, we merge them by updating the end time of the last interval in the result list to be the maximum of its current end time and the end time of the overlapping interval .i.e, result.getLast()[1] = max(intervals[i][1], result.getLast()[1]).

If the current interval’s start time is greater than the end time of the last interval in the result list, it means there is no overlap.

So, we simply add the current interval to the result list, i.e., result.add([intervals[i][0], intervals[i][1]]).

By the end of this iteration, all overlapping intervals will be merged, and the result list will contain the final set of non-overlapping intervals.

Just the code
Here’s the complete solution to this problem:

Solution summary
To recap, the solution to this problem can be divided into the following two parts:

Sort the intervals list according to the start time.

Add the first interval from the sorted list to the output list.

Then, iterate through the remaining intervals one by one. For each interval, check if it overlaps with the last interval in the output list:

If they overlap, merge them by updating the end time to the maximum of both end times, and update the last interval in the output list.

If they don’t overlap, simply append the current interval to the output list as a separate entry.

Time complexity
The time complexity of this solution is
O
(
n
log
⁡
n
)
O(nlogn)
, where
n
n
 is the number of intervals in the input list.

Space complexity
The output array has a space complexity of
O
(
n
)
O(n)
. However, we do not count the space used merely for input and output in the space complexity calculation. Apart from the space required by the built-in sorting algorithm, the space complexity is
O
(
1
)
O(1)
.

     */

    private static int[][] mergeIntervals(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        LinkedList<int[]> result = new LinkedList<>();
        result.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++) {

            //overlapping
            if(intervals[i][0] <= result.getLast()[1]) {

                result.getLast()[1] = Math.max(intervals[i][1], result.getLast()[1]);

            }
            else { //non-overlapping

                result.add(new int[] { intervals[i][0], intervals[i][1] });
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {


        int[][][] all_intervals = {
                {{3, 7}, {1, 5}, {4, 6}},
                {{1, 5}, {6, 8}, {4, 6}, {11, 15}},
                {{3, 7}, {10, 12}, {6, 8}, {11, 15}},
                {{1, 5}},
                {{1, 9}, {4, 4}, {3, 8}},
                {{1, 2}, {8, 8}, {3, 4}},
                {{1, 5}, {1, 3}},
                {{1, 5}, {6, 9}},
                {{0, 0}, {1, 18}, {1, 3}}
        };

        for (int i = 0; i < all_intervals.length; i++) {
            System.out.println((i + 1) + ".\tIntervals to merge: " + Arrays.deepToString(all_intervals[i]));
            int[][] result = mergeIntervals(all_intervals[i]);
            System.out.println("\tMerged intervals:\t" + Arrays.deepToString(result));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }
}
