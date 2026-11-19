package p04_intervals;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class P004_Medium_TaskScheduler {

    /*

        Task Scheduler gives you CPU tasks and a cooling period between identical tasks. Return the minimum intervals needed to run every task, including any required idle time.
    Statement
    You are given an array of CPU tasks represented by uppercase letters (A to Z) and an integer n, which denotes the cooling period required between any two identical tasks. Each task takes exactly one CPU interval to execute. Therefore, each CPU interval can either perform a task or remain idle. Tasks can be executed in any order, but the same task must be separated by at least n intervals.

    Determine the minimum number of CPU intervals required to complete all tasks.

Solution
The core idea of this solution is to minimize the number of CPU intervals by strategically scheduling tasks based on their frequency. To optimize scheduling, we schedule the most frequent task first, ensuring that its occurrences are separated by n units of time. This guarantees maximum spacing, creating idle slots that can be filled with less frequent tasks. In the end, the total time required is determined by the sum of all tasks and any remaining idle slots, giving the minimum number of CPU intervals needed to complete all tasks.

Using the intuition above, we implement the algorithm as follows:

Initialize an array, frequencies, of size
26
26
 to store the frequency of each task.

Count the occurrences of each task in the tasks array and store them in frequencies.

Sort frequencies in descending order.

Compute the maximum number of gaps, maxGaps, by subtracting 1 from the frequency of the most frequent task. This represents the number of gaps between the tasks after scheduling the most frequent task.

Compute idleSlots as maxGaps * n, representing the the maximum number of spare slots available after scheduling the most frequent task.

Iterate over the remaining task frequencies (excluding the most frequent task) and reduce idleSlots by the minimum of maxGaps and the current frequency. We take the minimum because if multiple tasks share the same maximum frequency, an extra idle slot is subtracted, even though one instance of that task will not be scheduled in the idle gaps but rather after the already scheduled most frequent task.

Ensure that idleSlots is not negative after the loop terminates, as it is being decremented within the loop.

Return the sum of the length of the tasks array and idleSlots as the minimum number of CPU intervals required to complete all tasks.

Let’s look at the following slides to get a better understanding of the solution:


Let’s look at the code for the algorithm we just discussed.

Time complexity
The time complexity of counting task frequencies is
O
(
n
)
O(n)
, where
n
n
 is the total number of tasks. Sorting and iterating the frequencies takes
O
(
1
)
O(1)
 because the number of unique tasks is at most
26
26
 (for English alphabet letters). All other operations run in constant time. Thus, the overall time complexity remains
O
(
n
)
O(n)
.

Space complexity
The space complexity is
O
(
1
)
O(1)
 since we only store task frequencies in a fixed-size array of
26
26
 elements.



    public static int leastInterval(char[] tasks, int n) {
        // Initialize an array of size 26 to store the frequency of each task (A to Z).

        // Iterate through the tasks array to populate the frequency counts.
            // For each character in tasks, increment its corresponding index in the frequency array.

        // Sort the frequency array in descending order.
        // This helps identify the tasks with the maximum occurrences to establish the schedule backbone.

        // Determine the maximum frequency found in the frequency array.
        // Calculate the number of idle gaps created by the most frequent task.
        // This is equal to the maximum frequency minus one.

        // Calculate the initial number of idle slots available.
        // This is the number of gaps multiplied by the cooling period 'n'.

        // Iterate through the remaining task frequencies starting from the second most frequent.
            // For each task, fill the available idle slots.
            // The number of slots that can be filled is the minimum of the gap count or the current task's frequency.
            // Subtract the filled slots from the total idle slots.

        // Ensure the remaining idle slots value does not drop below zero.

        // The total number of intervals is the sum of the total tasks and the remaining idle slots.
        // Return this total as the final answer.
    }

     */

    private static int leastInterval(char[] tasks, int n) {

        int[] frequencies = new int[26];

        for(int task : tasks) {

            frequencies[task - 'A']++;
        }

        frequencies = Arrays.stream(frequencies)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer :: intValue)
                .toArray();

        int maxGaps =  frequencies[0] - 1;

        int idleSlots = maxGaps * n;

        for(int i = 1; i< 26; i++) {

            idleSlots -= Math.min(maxGaps, frequencies[i]);
        }

        idleSlots = Math.max(0, idleSlots);

        return tasks.length + idleSlots;
    }

    public static void main(String[] args) {

        char[][] allTasks = {
                {'A', 'A', 'B', 'B'},
                {'A', 'A', 'A', 'B', 'B', 'C', 'C'},
                {'S', 'I', 'V', 'U', 'W', 'D', 'U', 'X'},
                {'M', 'A', 'B', 'M', 'A', 'A', 'Y', 'B', 'M'},
                {'A', 'K', 'X', 'M', 'W', 'D', 'X', 'B', 'D', 'C', 'O', 'Z', 'D', 'E', 'Q'}};

        int[] allNs = {2, 1, 0, 3, 3};

        for (int i = 0; i < allTasks.length; i++) {
            System.out.print((i + 1) + ".\tTasks: ");
            char[] tasks = allTasks[i];
            for(int j = 0; j < tasks.length; j++) {
                System.out.print(tasks[j]);
                if (j != tasks.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("\n\tn: " + allNs[i]);

            int minTime = leastInterval(allTasks[i], allNs[i]);
            System.out.println("\tMinimum time required to execute the tasks: " + minTime);
            System.out.println('-' + String.join("", Collections.nCopies(100, "-")) + '\n');
        }
    }
}
