package p04_intervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P005_Medium_Meeting_Rooms_II {


    /*
    Problem: Meeting Rooms II
75
med
30 min
Meeting Rooms II gives an array of meeting intervals and asks for the minimum number of rooms needed to host them all, with an interval's end time treated as exclusive.
Statement
We are given an input array of meeting time intervals, intervals, where each interval has a start time and an end time. Your task is to find the minimum number of meeting rooms required to hold these meetings.

An important thing to note here is that the specified end time for each meeting is exclusive.

Solution summary
To recap, the solution to this problem can be divided into the following four parts:

We sort the meeting intervals based on their start times.

We maintain a min-heap and insert the end time of the first meeting.

For each meeting, we check the following:

If the minimum end time is less than or equal to the start time of a new meeting, then a room is available.

If a meeting room is unavailable, a new room is allocated for the meeting.

The size of the heap after all meetings have been processed is equal to the minimum number of rooms required to accommodate all meetings.

Time complexity
Since we are sorting the intervals and also maintaining the heap, we have to take the time taken by these two processes into account. The sorting of the meeting intervals according to the start time takes
O
(
n
×
log
⁡
(
n
)
)
O(n×log(n))
. Now, for the heap, we know that we add the end time of a meeting if there is no room available for the meeting. Since the cost of adding an element to a heap is
O
(
log
⁡
(
s
i
z
e
o
f
h
e
a
p
)
)
O(log(sizeofheap))
, in the worst case, the cost of adding to the heap grows in the following way:

log
⁡
(
1
)
+
log
⁡
(
2
)
+
log
⁡
(
3
)
+
.
.
.
+
log
⁡
(
n
)
log(1)+log(2)+log(3)+...+log(n)
According to Stirling’s approximation, the sum of the above equation is
O
(
n
×

l
o
g
⁡
(
n
)
)
O(n× log⁡(n))
. So, the total time complexity becomes
O
(
n
×

l
o
g
⁡
(
n
)
+
n
×

l
o
g
⁡
(
n
)
)
O(n× log⁡(n)+n× log⁡(n))
, that is,
O
(
n
×
l
o
g
⁡⁡
(
n
)
)
O(n×log⁡⁡(n))
.

Space complexity
The space complexity of this solution is
O
(
n
)
O(n)
. This is because we are building a min-heap that, in the worst case, can have all the input elements. Therefore, the space required to compute this solution would be
O
(
n
)
O(n)
.


 public static int findSets(int[][] intervals) {
        // Check if the input intervals array is null or empty.
            // If no meetings are scheduled, return 0 as no rooms are required.

        // Sort the meeting intervals in ascending order based on their start times.
            // Sorting by start time allows us to handle each meeting as it begins chronologically.

        // Initialize a min-priority queue (min-heap) to track the end times of ongoing meetings.
            // The top of the heap will always hold the earliest time a room becomes available.

        // Add the end time of the first meeting to the min-heap.
            // This initializes the first meeting room.

        // Iterate through the remaining meetings starting from the second interval:
            // Retrieve the start time of the current meeting.
            // Check if this start time is greater than or equal to the earliest finish time in the heap.

            // If the current meeting starts after or exactly when the earliest room is vacated:
                // The room is now free and can be reused.
                // Remove the top element (the earliest finish time) from the heap.

            // Regardless of whether a room was reused or a new one is required:
                // Add the current meeting's end time to the heap to mark it as occupied.

        // After processing all meetings, the number of entries in the heap reflects the total rooms needed.
        // Return the final size of the min-heap.
    }


     */

    private static int findSets(int[][] intervals) {

        if(intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));

        PriorityQueue<Integer> endTimestamp = new PriorityQueue<>();

        endTimestamp.offer(intervals[0][1]);

        for(int i = 1; i < intervals.length; i++) {

            if(intervals[i][0] >= endTimestamp.peek()) {
                endTimestamp.poll();
            }

            endTimestamp.offer(intervals[i][1]);
        }

        return endTimestamp.size();
    }

    public static void main(String[] args) {

        int[][][] scheduleMeetings = {
                {{0, 10}, {2, 10}, {11, 30}},
                {{3, 7}, {2, 12}, {10, 20}, {8, 24}},
                {{1, 9}, {5, 8}, {4, 14}, {3, 10}, {11, 25}},
                {{1, 4}, {3, 8}, {8, 11}, {3, 17}, {9, 15}, {16, 18}},
                {{4, 12}, {5, 11}, {4, 9}, {2, 12}, {9, 22}}
        };

        for (int i = 0; i < scheduleMeetings.length; i++) {
            System.out.println((i + 1) + ".\tScheduled meetings: " + Arrays.deepToString(scheduleMeetings[i]));
            System.out.println("\tRooms required: " + findSets(scheduleMeetings[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }
}
