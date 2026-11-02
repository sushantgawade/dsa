package p04_intervals;

import java.util.Arrays;
import java.util.Collections;

public class P002_Medium_InsertInterval {

    /*

    Solution: Insert Interval
Statement
You are given a list of non-overlapping intervals, intervals, where each interval is represented as [starti, endi] and the list is sorted in ascending order by the start of each interval (starti). You are also given another interval, newInterval = [start, end].

Your task is to insert newInterval into the list of intervals such that the list remains sorted by starting times and still contains no overlapping intervals. If any intervals overlap after the insertion, merge them accordingly.

Return the updated list of intervals.

Note: You don’t need to modify intervals in place. You can make a new array and return it.

Constraints:

0
≤
0≤
 intervals.length
≤
1
0
4
≤10
4


intervals[i].length, newInterval.length
=
=
2
==2

0
≤
0≤
 starti
<
<
 endi
≤
1
0
4
≤10
4


The list of intervals is sorted in ascending order based on the start time.

Solution
So far, you’ve probably brainstormed some approaches and have an idea of how to solve this problem. Let’s explore some of these approaches and figure out which one to follow based on considerations such as time complexity and any implementation constraints.

Naive approach
The naive approach involves iterating through the list of intervals and checking for overlaps with a new interval. If overlap occurs, the new interval merges with the existing one. After iterating the entire list, if no overlap occurs, append the new interval. Finally, we sort the list based on the start times of the intervals to ensure the correct order of intervals.

Iterating through the intervals to merge or append the new interval based on overlaps takes
O
(
n
)
O(n)
 time, where
n
n
 represents the number of intervals. Then, sorting the output list takes
O
(
n
log
⁡
n
)
O(nlogn)
 time. Therefore, the overall time complexity of this solution is
O
(
n
log
⁡
n
)
O(nlogn)
 due to sorting being the dominant factor.

Optimized approach using the intervals pattern
The optimized approach avoids unnecessary sorting by leveraging the fact that the input list is already sorted and non-overlapping. We traverse the list once: first, we copy all intervals that end before the new interval starts — these cannot overlap and are added directly to the result. Next, we check for an overlap between the new interval and the last interval added. If there is no overlap, we simply append the new interval. Otherwise, we merge them by updating the end boundary to the maximum of the two. We then continue scanning the remaining intervals: if an interval does not overlap with the last one in the result, it is appended as is; if it overlaps, we merge it by updating the end boundary. This approach performs all operations in a single linear pass, resulting in an efficient
O
(
n
)
O(n)
 time complexity, which is a significant improvement over the naive solution that requires sorting.

 Step-by-step solution construction
Create an empty output list and traverse the intervals list to add all intervals to the output list, which start before the newInterval. These intervals cannot overlap with newInterval since they end before it starts (as the list is sorted and non-overlapping). They’re directly added to the output list.

If the output list is empty (i.e., no intervals have been added yet) or the end of the last interval in output is less than the start of newInterval (no overlap), then newInterval is simply added to the list.

If the last interval in output overlaps with newInterval (i.e., their ranges intersect), we merge them by updating the end of the last interval to the maximum of its own end and newInterval’s end.

Continue traversing the rest of the intervals starting from where we left off after inserting/merging newInterval:

If the current interval starts after the end of the last interval in output, then there’s no overlap. So, we can safely add the current interval to output.

If the current interval overlaps with the last interval in output, we merge them. This is done by updating the end of the last interval in output to the maximum of its own end and the current interval’s end.

Solution summary
Append all intervals that end before the start of the new interval to the output list.

If the new interval overlaps with the last interval in the output list, merge them by updating the end. Otherwise, append the new interval as is.

Continue through the rest of the intervals:

Merge them with the last interval in the output if they overlap.

Otherwise, append them directly.

The output list now contains all merged, non-overlapping intervals in sorted order. Return this list.

Time complexity
The time complexity is
O
(
n
)
O(n)
, where n is the number of intervals in the input list. We iterate through the list once, checking and merging intervals as necessary.

Space complexity
The space complexity is
O
(
1
)
O(1)
, since we only use constant space other than the input and output data structures.



 public static int[][] insertInterval(int[][] intervals, int[] newInterval) {
        // Create a result list to store the final set of non-overlapping intervals.
        // Initialize an index pointer to zero to iterate through the input intervals array.

        // Step 1: Process all intervals that occur before the new interval.
        // While the pointer is within bounds and the current interval's end time is less than the start time of the new interval:
            // Add the current interval to the result list as it doesn't overlap.
            // Increment the index pointer to move to the next interval.

        // Step 2: Merge the new interval with all intervals it overlaps with.
        // An overlap exists if the current interval's start time is less than or equal to the new interval's end time.
        // While the pointer is within bounds and there is an overlap:
            // Update the new interval's start to be the minimum of its current start and the overlapping interval's start.
            // Update the new interval's end to be the maximum of its current end and the overlapping interval's end.
            // Increment the index pointer to check the next interval.

        // Append the final merged new interval to the result list.

        // Step 3: Add all remaining intervals that start after the merged new interval ends.
        // Since the input is sorted, these intervals will also be sorted and non-overlapping.
        // Iterate through the rest of the input intervals array from the current pointer position.
            // Add the current interval to the result list.
            // Increment the index pointer.

        // Convert the result list of intervals into a 2D integer array format.
        // Return the final 2D array of merged and inserted intervals.
    }


     */

    private static int[][] insertInterval(int[][] existingInterval, int[] newInterval) {


    }

    public static void main(String[] args) {

        int[][] newIntervals = {
                {5, 7}, {8, 9}, {10, 12}, {1, 3}, {1, 10}
        };

        int[][][] existingIntervals = {
                { {1, 2}, {3, 5}, {6, 8} },
                { {1, 3}, {5, 7}, {10, 12} },
                { {8, 10}, {12, 15} },
                { {5, 7}, {8, 9} },
                { {3, 5} }
        };

        for (int i = 0; i < newIntervals.length; i++) {
            System.out.println((i + 1) + ".\tExisting intervals: " + Arrays.deepToString(existingIntervals[i]));
            System.out.println("\tNew interval: " + Arrays.toString(newIntervals[i]));
            int[][] output = insertInterval(existingIntervals[i], newIntervals[i]);
            System.out.println("\tUpdated intervals: " + Arrays.deepToString(output));
            System.out.println(String.join("", Collections.nCopies(100, "-")));
        }

    }
}
