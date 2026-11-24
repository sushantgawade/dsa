package p04_intervals;

import java.util.Arrays;

public class P006_Medium_Remove_Covered_Intervals {

    /*

    Problem: Remove Covered Intervals
med
30 min
Remove Covered Intervals gives an array of unique half-open intervals. Return how many remain after discarding every interval fully contained within another.
Statement
Given an array of intervals, where each interval is represented as intervals[i]
=
[
l
i
,
r
i
)
=[l
i
​
 ,r
i
​
 )
 (indicating the range from
l
i
l
i
​

 to
r
i
r
i
​

, inclusive of
l
i
l
i
​

 and exclusive of
r
i
r
i
​

), remove all intervals that are completely covered by another interval in the list. Return the count of intervals that remain after removing the covered ones.

Note: An interval
[
a
,
b
)
[a,b)
 is considered covered by another interval
[
c
,
d
)
[c,d)
 if and only if
c
<
=
a
c<=a
 and
b
<
=
d
b<=d
.

Solution
The first step is to simplify the process by sorting the intervals. Sorting by the start point in ascending order is straightforward and simplifies the iteration process. However, an important edge case arises when two intervals share the same start point. In such scenarios, sorting solely by the start point would fail to correctly identify covered intervals. To handle this, we sort intervals with the same start point by their endpoint in descending order, ensuring that longer intervals come first. This sorting strategy guarantees that if one interval covers another, it will be positioned earlier in the sorted list. Once the intervals are sorted, we iterate through them while keeping track of the maximum endpoint seen so far. If the current interval’s end point exceeds this maximum, it is not covered, so we increment the count and update the maximum end. The interval is covered and skipped if the endpoint is less than or equal to the maximum. After completing the iteration, the final count reflects the remaining non-covered intervals.

Now, let’s look at the solution steps below:

If the start points are the same, sort the intervals by the start point in ascending order, otherwise, sort by the endpoint in descending order to prioritize longer intervals.

Initialize the count with zero to track the remaining (non-covered) intervals.

Initialize prevEnd with zero to track the maximum end value we’ve seen..

Start iterating through intervals for each interval [start, end] in the sorted list:

If end > prevEnd, any previous interval does not cover the interval.

Increment count by
1
1
.

Update prevEnd to end.

Else:

A previous interval covers the interval, so we skip it.

After iterating through all the intervals, the return count is the final value, representing the remaining intervals.

Let’s look at the following illustration to get a better understanding of the solution:


Let’s look at the code for the solution we just discussed.

Time complexity
The time complexity of the solution is
O
(
n

l
o
g
n
)
O(n logn)
, where
n
n
 is the number of intervals. This is because sorting the intervals takes
O
(
n

l
o
g
n
)
O(n logn)
 time, and the subsequent iteration through the intervals takes
O
(
n
)
O(n)
 time. Therefore, the overall time complexity is dominated by the sorting step, resulting in
O
(
n

l
o
g
n
)
O(n logn)
.

Space complexity
The sorting operation has a space complexity of
O
(
l
o
g

n
)
O(log n)
 in the worst case due to additional memory required for temporary arrays during the sorting process. Apart from the space used by the built-in sorting algorithm, the algorithm’s space complexity is constant,
O
(
1
)
O(1)
. Therefore, the overall space complexity of the solution is
O
(
l
o
g

n
)
O(log n)
.


 public int removeCoveredIntervals(int[][] intervals) {
        // Sort the intervals array using a custom comparator:
        // 1. Sort by the start point in ascending order.
        // 2. If the start points are identical, sort by the end point in descending order.
        // This ensures that if multiple intervals start at the same point, the longest one is processed first.

        // Initialize a variable to store the count of remaining (non-covered) intervals.
        // Initialize a variable to keep track of the maximum end point reached by any previously kept interval.

        // Iterate through each interval in the sorted collection:
            // Get the end coordinate of the current interval.

            // Compare the current end coordinate with the maximum end coordinate seen so far:
            // If the current end is strictly greater than the previous maximum end:
                // This interval is not covered because its end extends beyond the reach of previous intervals
                // (and we know its start is greater than or equal to previous starts due to sorting).

                // Increment the count of remaining intervals.
                // Update the maximum end coordinate to be the current interval's end.

            // Otherwise, if the current end is less than or equal to the maximum end:
                // This interval is completely covered by a previous interval because:
                // - Its start is >= previous starts (due to sorting).
                // - Its end is <= previous maximum end.
                // We do nothing and skip this interval.

        // Return the final count of intervals that were not removed.
    }

     */


    private int removeCoveredIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> {

            if(a[0] == b[0]) {
                return b[1] - a[1];
            }
            else {

                return a[0] -b[0];
            }
        } );

        int end = 0;
        int prevEnd = 0;
        int count = 0;


        for(int[] intterval : intervals) {

            end = intterval[1];

            if(end > prevEnd) {

                count++;
                prevEnd = end;

            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[][][] testCases = {
                {{1, 4}, {3, 6}, {2, 8}},
                {{1, 2}, {1, 4}, {3, 4}},
                {{1, 10}, {2, 9}, {3, 8}, {4, 7}},
                {{1, 3}, {4, 6}, {7, 9}},
                {{1, 5}, {2, 3}, {4, 6}}
        };

        P006_Medium_Remove_Covered_Intervals solution = new P006_Medium_Remove_Covered_Intervals();

        for (int i = 0; i < testCases.length; i++) {
            int[][] intervals = testCases[i];
            System.out.print((i + 1) + ".\tIntervals: [");
            for (int j = 0; j < intervals.length; j++) {
                System.out.print("[" + intervals[j][0] + ", " + intervals[j][1] + "]");
                if (j != intervals.length - 1) System.out.print(", ");
            }
            System.out.println("]");

            int result = solution.removeCoveredIntervals(intervals);
            System.out.println("\tResult: " + result);
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }

    }
}
