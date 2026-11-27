package p04_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P010_Medium_AddBoldTagInString {

    /*

    Problem: Add Bold Tag in String
med
30 min
Add Bold Tag in String wraps every occurrence of a substring from a given array in bold HTML tags, merging overlapping or adjacent matches into one bold section.
Statement
Given a string s and an array of strings words, wrap all occurrences of any substring in s that appears in words with the bold tags <b> and </b>.

If two substrings overlap or are directly consecutive, they should be merged and enclosed within a single pair of bold tags.

Return the modified string after adding the bold tags.


Solution
This is an interval merging task: first identify every range in s covered by a word, then combine ranges that overlap or touch. Each match is represented as a half open interval [start, end), so end points just after the matched substring. After merging, the string can be rebuilt by adding bold tags around each merged interval while preserving all unmatched text.

The important detail is to find every occurrence of every word, including overlapping occurrences. Once all intervals are collected and sorted by their starting positions, an interval belongs to the current merged range whenever its start is no greater than the current end. This condition also merges directly consecutive matches, because one interval can begin exactly where the previous one ends.

Now, let’s look at the solution steps below:

Initialize intervals as an empty list to store every matching interval.

Iterate through each word in words:

Compute the first start position where word occurs in s.

Check whether start represents a valid match:

Assign (start, start + length of word) to intervals.

Compute the next start position by searching from the position immediately after the current match’s beginning, which allows overlapping matches to be found.

Check whether intervals is empty:

Assign s as the result because no bold tags are needed.

Compute the sorted order of intervals using their starting positions.

Initialize mergedIntervals as an empty list and assign the first interval’s endpoints to currentStart and currentEnd.

Iterate through each remaining (start, end) interval:

Check whether start is less than or equal to currentEnd:

Assign currentEnd to the larger of currentEnd and end to extend the current merged interval when necessary.

Assign (currentStart, currentEnd) to mergedIntervals, then assign start to currentStart and end to currentEnd because the interval is separate from the current merged range.

Assign the final (currentStart, currentEnd) interval to mergedIntervals.

Initialize result as an empty list and previousEnd as
0
0
.

Iterate through each (start, end) interval in mergedIntervals:

Assign the unmatched substring from previousEnd through start to result.

Assign the opening tag <b> to result.

Assign the substring from start through end to result.

Assign the closing tag </b> to result.

Assign end to previousEnd.

Assign the remaining suffix of s, beginning at previousEnd, to result.

Assign the concatenation of all parts in result as the final answer.

Let’s look at the following illustration to get a better understanding of the solution:


Let’s look at the code for this solution below:

Time complexity
The time complexity of the solution is
O
(
∣
w
o
r
d
s
∣
⋅
∣
s
∣
+
k
log
⁡
k
+
∣
s
∣
)
O(∣words∣⋅∣s∣+klogk+∣s∣)
 because the algorithm searches for matches for every word, sorts the k collected intervals, merges them, and constructs the result. Here, k is the total number of matches found.

Space complexity
The space complexity of the solution is
O
(
k
+
∣
s
∣
)
O(k+∣s∣)
 because intervals and mergedIntervals store match ranges, while result stores the pieces of the final string.


 public String addBoldTag(String s, String[] words) {
        // Initialize a collection to store the starting and ending indices of substrings matching words in the dictionary.

        // Iterate through each word provided in the words array:
            // Search for the first occurrence of the current word in the string s.

            // Repeat while an occurrence of the word is found in s:
                // Record the matching range [current_index, current_index + word_length] in the intervals collection.
                // Search for the next occurrence of the current word starting from the subsequent position.

        // If no intervals were recorded (meaning no matches were found):
            // Return the original string s as no bolding is required.

        // Sort all recorded intervals based on their start index to prepare for merging.
        // For intervals with the same start index, sort by the end index to ensure consistency.

        // Initialize a list to store merged intervals that cover overlapping or adjacent bold segments.
        // Initialize tracking variables for the 'start' and 'end' of a potential bold segment using the first interval.

        // Iterate through the sorted list of intervals starting from the second one:
            // Get the start and end of the current interval.

            // If the start of the current interval is less than or equal to the end of the tracked segment:
                // The intervals overlap or are consecutive; expand the tracked segment's end to the maximum of the two ends.
            // Otherwise, the current interval is separate from the tracked segment:
                // Add the completed segment [tracked_start, tracked_end] to the merged intervals list.
                // Update the tracked segment's start and end to match the current interval.

        // Add the final tracked segment to the merged intervals list.

        // Initialize a string builder to construct the resulting string efficiently.
        // Maintain a pointer to track the index of the character in s that was last processed.

        // Iterate through each interval in the merged list:
            // Append the plain text segment from the last processed index to the start of the bold interval.
            // Append the opening bold tag "<b>".
            // Append the substring of s corresponding to the bolded range (from start to end index).
            // Append the closing bold tag "</b>".
            // Update the last processed index to the end of the bold interval.

        // Append any remaining characters of s from the last processed index to the end of the string.

        // Return the final string constructed with the appropriate bold tags.
    }





     */


    private String addBoldTag(String s, String[] words) {

        List<int[]> intervals = new ArrayList<>();

        for(String word : words) {

            int start = s.indexOf(word);

            if(start != -1) {

                intervals.add(new int[] {start, start + word.length()});

                start = s.indexOf(word, start + 1);
            }
        }

        if(intervals.isEmpty()) {
            return s;
        }

        intervals.sort(Comparator.comparingInt((int[] interval) -> interval[0])
                .thenComparing(interval ->  interval[1])
        );


        List<int[]> mergedIntervals = new ArrayList<>();
        int currentStart = intervals.get(0)[0];
        int currentEnd = intervals.get(0)[1];

        for(int i = 1; i < intervals.size(); i++) {

            int start = intervals.get(i)[0];
            int end = intervals.get(i)[0];

            if(start <= currentEnd ) {

                currentEnd = Math.max(currentEnd, end);
            }
            else {
                mergedIntervals.add(new int[]{currentStart, currentEnd});
                currentStart = start;
                currentEnd = end;
            }
        }

        mergedIntervals.add(new int[]{currentStart, currentEnd});

        StringBuilder result = new StringBuilder();
        int previousEnd = 0;

        for(int[] mergedInterval : mergedIntervals) {

            int start = mergedInterval[0];
            int end = mergedInterval[1];

            result.append(s, previousEnd, start);
            result.append("<b>");
            result.append(s, start, end);
            result.append("</b>");
            previousEnd = end;
        }

        result.append(s.substring( previousEnd ));

        return result.toString();


    }

    public static void main(String[] args) {


        String[][] testCases = {
                {"mississippi", "issi", "sip"},
                {"a1b2c3", "1b", "c3"},
                {"hello123hello", "hello", "23"},
                {"zzzz", "zz", "zzz"},
                {"A0B00", "0B", "00"}
        };

        for (int i = 0; i < testCases.length; i++) {
            String s = testCases[i][0];
            String[] words = Arrays.copyOfRange(testCases[i], 1, testCases[i].length);
            P010_Medium_AddBoldTagInString solution = new P010_Medium_AddBoldTagInString();
            String result = solution.addBoldTag(s, words);

            System.out.println((i + 1) + ".\ts = '" + s + "'");
            System.out.println("\twords = " + Arrays.toString(words));
            System.out.println();
            System.out.println("\tOutput: " + result);
            System.out.println("-".repeat(100));
        }
    }


}
