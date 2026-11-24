package p04_intervals;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class P007_Medium_CountDayWithoutMeeting {


    /*

    Problem: Count Days Without Meetings
med
30 min
Count Days Without Meetings asks you to count workdays from day 1 through the total available days that are not covered by any meeting, including overlapping schedules.
Statement
You are given a positive integer, days, which represents the total number of days an employee is available for work, starting from day
1
1
. You are also given a 2D array, meetings, where each entry meetings[i]
=
[
s
t
a
r
t
i
,
e
n
d
i
]
=[start
i
​
 ,end
i
​
 ]
 indicates that a meeting is scheduled from day
s
t
a
r
t
i
start
i
​

 to day
e
n
d
i
end
i
​

 (both inclusive).

Your task is to count the days when the employee is available for work but has no scheduled meetings.

Note: The meetings may overlap.

Solution
The core idea of this solution is to merge overlapping meetings into continuous intervals to efficiently track the occupied days. We begin by sorting the meetings to process them sequentially. As we iterate, we merge overlapping meetings while counting the occupied days whenever gaps appear. Finally, subtracting the total occupied days from the available days gives the number of free days.

Using the intuition above, we implement the algorithm as follows:

First, sort the meetings based on their start time to process them in order.

Initialize a variable, occupied, with
0
0
 to count the days when the employee has scheduled meetings.

Initialize two variables, start and end, with the first meeting’s start and end times. These variables define the beginning and end of the merged meeting interval to efficiently track continuously occupied periods.

Iterate through the remaining meetings:

If a meeting overlaps with the current merged meeting, extend the end time to merge it into the existing interval.

Otherwise, add the days of the merged meeting to occupied as
o
c
c
u
p
i
e
d
=
o
c
c
u
p
i
e
d
+
(
e
n
d
−
s
t
a
r
t
+
1
)
occupied=occupied+(end−start+1)
. Then, update the start and end for the next interval.

After the loop, add the days of the last merged interval to occupied.

Return the difference between days and occupied (
d
a
y
s
−
o
c
c
u
p
i
e
d
days−occupied
), representing the number of days when the employee is available for work but has no scheduled meetings.

Let’s look at the following illustration to get a better understanding of the solution:


Let’s look at the code for the algorithm we just discussed.

Time complexity
The algorithm’s time complexity is
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
 is the size of the meetings array. This is due to the sorting step, which dominates the overall complexity while merging the intervals runs in
O
(
n
)
O(n)
.

Space complexity
The algorithm’s space complexity is constant,
O
(
1
)
O(1)
.

public int countDays(int days, int[][] meetings) {
        // Sort the meetings array based on the start day of each meeting to process them in chronological order.

        // Initialize a variable to track the total count of days where the employee is in a meeting.

        // Set tracking variables for the 'start' and 'end' of the current continuous meeting block.
        // Initialize these boundaries using the start and end of the first meeting in the sorted list.

        // Iterate through the remaining meetings in the sorted array:
            // If the current meeting starts within or exactly at the end of the current tracked block:
                // The meetings overlap or are contiguous. Update the block's end boundary to the
                // maximum of its current end and the current meeting's end day.

            // Otherwise, if the current meeting starts after the current block has ended:
                // The current block is finished. Calculate its duration (end - start + 1)
                // and add it to the total count of occupied days.

                // Reset the tracked 'start' and 'end' boundaries to the current meeting's duration.

        // After all meetings are processed, add the duration of the final tracked block to the total occupied days.

        // Determine the number of free days by subtracting the total occupied days from the total available days.
        // Return the resulting count of free days.
    }


     */


    private int countDays(int days, int[][] meetings) {

        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        int occupied = 0;

        int start = meetings[0][0];
        int end = meetings[0][1];

        for(int i = 1; i< meetings.length; i++) {

            if(meetings[i][0] <= end ) {

                end = Math.max(end, meetings[i][1]);
            }
            else {
                occupied += end - start + 1;

                start = meetings[i][0];
                end = meetings[i][1];
            }
        }

        occupied += end - start + 1;

        return days - occupied;
    }

    public static void main(String[] args) {

        int[] inputDays = {12, 6, 100000, 3136, 786};
        int[][][] inputMeetings = {
                {{5, 6}, {9, 11}, {1, 3}},
                {{2, 4}, {5, 5}},
                {{1, 100000}},
                {{361, 570}, {420, 1225}, {72, 144}, {987, 1444}},
                {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}, {11, 12}}
        };

        P007_Medium_CountDayWithoutMeeting sol = new P007_Medium_CountDayWithoutMeeting();

        for (int i = 0; i < inputDays.length; i++) {
            System.out.println((i + 1) + ".\tdays: " + inputDays[i]);
            System.out.println("\tmeetings: " + Arrays.deepToString(inputMeetings[i]));
            System.out.println("\n\tNumber of free days: " + sol.countDays(inputDays[i], inputMeetings[i]));
            System.out.println(String.join("", Collections.nCopies(100, "-")));
        }


    }
}
