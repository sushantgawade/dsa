package p03_slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P001_Medium_RepeatedDnaSequences {


    /*
    Problem: Repeated DNA Sequences

    med
    30 min
    Explore how to detect repeated 10-letter sequences in DNA strings using the sliding window approach. This lesson helps you understand substring identification and efficient string manipulation to solve pattern recognition problems common in coding interviews.
    Statement
    A DNA sequence consists of a series of nucleotides, each represented by one of the characters 'A', 'C', 'G', or 'T'.

    Given a string s representing a DNA sequence, find and return all
    10
    10
    -letter-long substrings that appear more than once within s. The result may be returned in any order.

    Solution
    The key idea is to use a sliding window of fixed size 10 to scan through the DNA string and identify all 10
    -letter substrings that occur more than once. We slide a window of length 10 across the string, extracting each
    substring and tracking how many times it has been seen using a hash map (seen). Whenever a substring is encountered for
    exactly the second time, we add it to our result list. By only appending when the count equals 2 , we naturally avoid adding duplicates to the output.

    Now, let’s look at the solution steps below:

    Initialize an empty hash map seen to store each 10
    -letter substring as a key and its occurrence count as the value.

    Initialize an empty list result to collect all substrings that appear more than once.

    Iterate through the string s using an index i from 0 to s.length - 1 (inclusive). This defines the starting position of each sliding window of size 10.

    Extract the current 10 -letter substring starting at index i.

    Update the count of substring in the seen hash map by incrementing it by 1 . If the substring has not been seen before, initialize its count to  1 .

    If the count of substring in seen equals exactly 2 , append substring to result. This ensures each repeated substring is added only once, regardless of how many additional times it appears.

    Return the result list containing all 10 -letter substrings that appear more than once in s.

Let’s look at the following illustration to get a better understanding of the solution:

Let’s look at the code for this solution below:

Time complexity
The time complexity of the solution is
O(n)  where n is the length of the string s. We iterate through the string once with a sliding window, and at each position we extract a substring of constant length 10
 and perform a hash map lookup and insertion, both of which take  O(10) O(1)
 amortized time per step.

Space complexity
The space complexity of the solution is  O(n)
 because in the worst case, the seen hash map can store up to n−9
 distinct  10 -letter substrings, each of length 10 . The result list can also hold up to O(n)
 entries. Thus the overall space usage is proportional to n.

    public List<String> findRepeatedDnaSequences(String s) {
        // Check if the input string length is less than the required window size of 10.
            // If the string is too short, return an empty list as no 10-letter substrings exist.

        // Initialize a data structure (like a Set) to keep track of every 10-letter substring encountered.
        // Initialize another data structure (like a Set) to store substrings that have been identified as repeats.
        // Note: Using a set for results prevents adding the same repeated sequence multiple times.

        // Iterate through the string from the beginning to the point where the last 10-letter substring starts.
        // This is typically from index 0 up to s.length() - 10.

            // Extract the current substring of length 10 starting at the current iteration index.

            // Check if the 'seen' data structure already contains this 10-letter substring.

                // If it is already present, this indicates a repeat.
                // Add the substring to the 'repeated' data structure.

                // Otherwise, if this is the first time encountering this substring:
                // Add the substring to the 'seen' data structure for future reference.

        // After checking all possible windows, convert the collection of repeated sequences into a list.
        // Return the list of repeated DNA sequences.
        return new ArrayList<>();
    }

     */

    private List<String> findRepeatedDnaSequences(String str) {

        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for(int i =0; i < str.length() - 10; i++ ) {

            String subString = str.substring(i, i + 10);

            map.put(subString, map.getOrDefault(subString, 0) + 1);

            if(map.get(subString) == 2) {
                list.add(subString);
            }

        }

        return  list;

    }

    public static void main(String[] args) {

        P001_Medium_RepeatedDnaSequences sol = new P001_Medium_RepeatedDnaSequences();
        String[] testCases = {
                "ACGTACGTACGTACGT",
                "AAAAAAAAAAAAAAAAAAAA",
                "ACGTACGTACACGTACGTAC",
                "GAGAGAGAGAGAGAGAGAGA",
                "ATCGATCGATCGATCGATCGATCG",
        };
        for (int idx = 0; idx < testCases.length; idx++) {
            List<String> result = sol.findRepeatedDnaSequences(testCases[idx]);
            System.out.println((idx + 1) + ".\ts: \"" + testCases[idx] + "\"");
            System.out.println("\tResult: " + result);
            System.out.println("-".repeat(100));
        }

    }
}
