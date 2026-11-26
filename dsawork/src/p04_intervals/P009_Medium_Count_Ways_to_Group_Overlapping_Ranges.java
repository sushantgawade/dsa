package p04_intervals;

import java.util.Arrays;

public class P009_Medium_Count_Ways_to_Group_Overlapping_Ranges {

    /*

    Statement
You are given a
2
e
x
t
D
2extD
 integer array ranges where ranges[i] = [start_i, end_i] represents an inclusive range from start_i to end_i.

You want to partition ranges into
2
2
 groups, where each group may be empty, such that:

Each range belongs to exactly one group.

Any two overlapping ranges must belong to the same group.

Two ranges overlap if they have at least one common number.

Return the total number of ways to split ranges into
2
2
 groups. Since the answer may be large, return it modulo
1
0
9
+
7
10
9
 +7
.


Solution
This is a connected component counting problem on an overlap graph. Treat each range as a node, with overlapping ranges connected to one another. After sorting the ranges by their starting points, a single scan can identify where one connected component ends and another begins. Because ranges are inclusive, a range belongs to the current component whenever its start is at most the farthest end seen so far. Each independent component can be assigned to either of the
2
2
 groups, so if there are componentCount components, the answer is
2
e
x
t
c
o
m
p
o
n
e
n
t
C
o
u
n
t
2
extcomponentCount

 modulo
1
0
9
+
7
10
9
 +7
.

Now, let’s look at the solution steps below:

Compute sortedRanges by sorting ranges according to their starting points.

Initialize componentCount to
1
1
 and currentEnd to the ending point of the initial range.

Iterate through each remaining [start, end] in sortedRanges:

Check if start is greater than currentEnd:

Assign componentCount to componentCount + 1 because this range starts a new disconnected component.

Assign currentEnd to end.

Check if start is at most currentEnd:

Assign currentEnd to the larger of currentEnd and end to extend the current component as far as possible.

Assign the final answer to the modular value of
2
2
 raised to componentCount, using modulus
1
0
9
+
7
10
9
 +7
.

Let’s look at the following illustration to get a better understanding of the solution:

Let’s look at the code for this solution below:

Time complexity
The time complexity of the solution is
O
(
n
log
⁡
n
)
O(nlogn)
 because sorting ranges dominates the single scan, where n is the number of ranges.

Space complexity
The space complexity of the solution is
O
(
n
)
O(n)
 because sortedRanges stores the sorted ranges.

public int countWays(int[][] ranges) {
        // Sort the ranges by their start time.
        // If two ranges have the same start time, their relative order does not strictly matter for the core logic,
        // but sorting by end time is common for consistency.

        // Initialize componentCount to 1, since the input contains at least one range.
        // Initialize currentEnd to the end coordinate of the first range in the sorted array.

        // Iterate through the sorted ranges starting from the second range (index 1):
            // Extract the start and end values of the current range.

            // Compare the start of the current range with the currentEnd of the merged component:
                // If the start of the current range is greater than currentEnd:
                    // There is no overlap, so this range starts a new disjoint component.
                    // Increment the componentCount.
                    // Update currentEnd to the end of this new range.
                // Otherwise, the ranges overlap (touching endpoints also count as overlap):
                    // Merge the current range into the existing component.
                    // Update currentEnd to be the maximum of its current value and the end of the current range.

        // Since each disjoint component can be independently assigned to one of the two groups,
        // the total number of ways to group them is 2 raised to the power of componentCount.

        // Perform modular exponentiation to calculate (2^componentCount) modulo 1,000,000,007:
            // Initialize the result to 1 and the base to 2.
            // While componentCount is greater than 0:
                // If componentCount is odd, update result as (result * base) % 1,000,000,007.
                // Square the base: update base as (base * base) % 1,000,000,007.
                // Divide componentCount by 2.

        // Return the resulting value cast to an integer.
    }


     */


    private int countWays(int[][] ranges) {

        int[][] sortedRanges = ranges.clone();
        Arrays.sort(sortedRanges, (a, b) -> {

            if(a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            else {
                return Integer.compare(a[1], b[1]);
            }

        } );

        int componentCount = 1;
        int currentEnd = sortedRanges[0][1];

        for(int i = 1; i < sortedRanges.length; i++ ) {

            int start = sortedRanges[i][0];
            int end = sortedRanges[i][1];

            if(start > currentEnd ) {

                componentCount++;
                currentEnd = end;
            }
            else {
                currentEnd = Math.max(end, currentEnd);
            }
        }

        long mod = 1_000_000_007L;
        long result = 1;
        long base = 2;
        int exponent = componentCount;

        while(exponent > 0) {

            if(exponent % 2 == 1) {

                result = (result * base) % mod;
            }

            base = (base * base) % mod;

            exponent /= 2;
        }

        return  (int)result;

    }

    public static void main(String[] args) {


        int[][][] testCases = {
                {{0, 0}, {1, 1}},
                {{0, 5}, {5, 7}, {8, 9}},
                {{10, 12}, {1, 2}, {3, 4}, {20, 30}},
                {{2, 100}, {3, 4}, {50, 60}, {101, 101}},
                {{7, 7}}
        };

        P009_Medium_Count_Ways_to_Group_Overlapping_Ranges solution = new P009_Medium_Count_Ways_to_Group_Overlapping_Ranges();

        for (int i = 0; i < testCases.length; i++) {
            int[][] ranges = testCases[i];
            int result = solution.countWays(ranges);

            System.out.println((i + 1) + ".\tranges = " + Arrays.deepToString(ranges));
            System.out.println("\t");
            System.out.println("\tOutput: " + result);
            System.out.println("-".repeat(100));
        }
    }

}
