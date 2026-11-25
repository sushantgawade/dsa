package p04_intervals;

import java.util.Arrays;
import java.util.List;

public class P008_Medium_CarPooling {


    /*

    Solution: Car Pooling
Statement
You are given a car with a fixed number of seats, denoted by an integer capacity. The car only travels in one direction — eastward — and does not make any U-turns.

You are also provided with an array, trips, where each element trips[i]
=
[
numPassengers
i
,
from
i
,
to
i
]
=[numPassengers
i
​
 ,from
i
​
 ,to
i
​
 ]
 represents a group of
numPassengers
i
numPassengers
i
​

 that must be picked up at location
from
i
from
i
​

 and dropped off at location
to
i
to
i
​

. All locations are measured in kilometers east of the starting point.

Your task is to determine whether it is possible to complete all the trips without exceeding the car’s capacity at any point in time.

Return TRUE if all trips can be completed successfully, or FALSE otherwise.


Solution
The core intuition behind this solution is to simulate the journey of the car using a timeline, tracking when passengers get in and get out. This approach aligns with the merge intervals pattern, where we focus on events happening at specific points in time, rather than handling each trip separately in isolation. The idea is to accumulate and monitor the number of passengers in the car at any moment using a difference array (also known as a prefix sum technique).

In the context of this problem, each trip defines a passenger change over a specific interval — passengers are picked up at
from
from
 and dropped off at
to
to
. Instead of iterating over the entire interval (which is inefficient), we can track just the start and end of the interval using a fixed-size timeline array.

This strategy is built on two key observations:

Each trip contributes a net passenger change at exactly two locations:

Increase at the pickup location (
from
from
)

Decrease at the drop-off location (
to
to
)

The car’s capacity must never be exceeded at any point on the journey, so we monitor the cumulative passenger count as we move forward in time.

This strategy leverages the difference array pattern, which is a version of merge intervals. Rather than merging overlapping intervals explicitly, it simulates all trips together via a timeline of passenger changes.

Let’s break down the steps:

A list timestamp of size
1001
1001
 (based on constraints) is created to track changes in passenger counts at each kilometer point.

For each trip
[
numPassengers
i
,
from
i
,
to
i
]
[numPassengers
i
​
 ,from
i
​
 ,to
i
​
 ]
in trips:

Add numPassengers at timestamp[
from
i
from
i
​

]

Subtract numPassengers at timestamp[
to
i
to
i
​

]

This marks the start and end of each passenger interval without iterating over the full range.

To simulate the trip and track capacity, initialize a variable used_capacity = 0.

Iterate through the timestamp list, adding the passenger changes at each point. If at any point used_capacity > capacity, return FALSE immediately— the car is overloaded.

If the full timeline is processed without exceeding capacity, return TRUE, indicating that all trips can be accommodated.

Let’s look at the following illustration to get a better understanding of the solution:


Let’s look at the code for the solution we just discussed.

Time complexity
The overall time complexity of the solution is
O
(
n
)
O(n)
 because:

The trips list is scanned once to record passenger changes at pickup and drop-off points.

Each trip results in two constant-time operations: one increment and one decrement in the timeline array.

The timestamp array (of fixed length
1001
1001
) is traversed once to simulate the journey and check capacity constraints.

As the length of timestamp is constant and independent of input size, it contributes
O
(
1
)
O(1)
 time. So, the total operations scale linearly with the number of trips.

Space complexity
The space complexity of the solution is
O
(
1
)
O(1)
 because a fixed-size array timestamp of length
1001
1001
 is used regardless of the input size.

 // Function to determine if all trips can be completed without exceeding capacity
    public boolean carPooling(int[][] trips, int capacity)
    {
        // Create an array to track the net change in passengers at each kilometer location.
        // Since locations are measured from 0 to 1000, an array of size 1001 is sufficient.

        // Iterate through each trip in the trips array:
            // Extract the number of passengers, the pickup location, and the drop-off location.
            // Add the number of passengers to the pickup location index in the tracking array.
            // Subtract the number of passengers from the drop-off location index in the tracking array.

        // Initialize a variable to keep track of the current number of passengers in the car.

        // Traverse the tracking array from the first kilometer to the last:
            // Update the current passenger count by adding the net change stored at the current kilometer.
            // Check if the updated passenger count exceeds the car's maximum capacity.
            // If the capacity is exceeded at any point:
                // Return false because the trips cannot be completed.

        // If the entire journey is traversed without exceeding the capacity:
            // Return true.
    }


     */


    private boolean carPooling(int[][] trips, int capacity) {

        int[] passengerChanges = new int[1000];

        for(int[] trip : trips) {

            int passenger_count  = trip[0];
            int start  = trip[1];
            int end  = trip[2];

            passengerChanges[start] += passenger_count;
            passengerChanges[end] -= passenger_count;
        }

        int used_capacity = 0;

        for(int passengerChange : passengerChanges) {

            used_capacity += passengerChange;

            if(used_capacity > capacity) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        List<Object[]> testCases = Arrays.asList(
            new Object[]{ new int[][]{ {2, 1, 5}, {3, 3, 7} }, 4 },
            new Object[]{ new int[][]{ {2, 1, 5}, {3, 3, 7} }, 5 },
            new Object[]{ new int[][]{ {3, 2, 6}, {1, 4, 7}, {2, 5, 8} }, 5 },
            new Object[]{ new int[][]{ {1, 0, 4}, {2, 2, 6}, {3, 5, 8} }, 6 },
            new Object[]{ new int[][]{ {4, 1, 5}, {1, 3, 7}, {2, 6, 8} }, 5 }
        );

        int i = 1;
        for (Object[] testCase : testCases) {
            int[][] trips = (int[][]) testCase[0];
            int capacity = (Integer) testCase[1];
            System.out.print(i + ".\tInput: trips = [");
            for (int j = 0; j < trips.length; j++) {
                System.out.print(Arrays.toString(trips[j]));
                if (j != trips.length - 1) System.out.print(", ");
            }
            System.out.println("], capacity = " + capacity);
            P008_Medium_CarPooling obj = new P008_Medium_CarPooling();
            boolean result = obj.carPooling(trips, capacity);
            System.out.println("\tCan complete all trips? " + result);
            System.out.println(new String(new char[100]).replace("\0", "-"));
            i++;
        }

    }
}
