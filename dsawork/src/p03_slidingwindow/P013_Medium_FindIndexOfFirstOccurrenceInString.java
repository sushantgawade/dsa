package p03_slidingwindow;

public class P013_Medium_FindIndexOfFirstOccurrenceInString {


    /*

    Problem: Find the Index of the First Occurrence in a String
    med
    30 min
    Explore how to apply the sliding window pattern to identify the first occurrence index of a substring in a given string. This lesson helps you understand substring search problems, constraints, and how to implement an efficient solution using Python.
    Statement
    Given two strings haystack and needle, return the index of the first occurrence of needle within haystack. If needle does not exist as a substring of haystack, return
    −
    1
    −1
    .

    Solution
    The key intuition behind this solution is to use a fixed-size sliding window of length equal to needle and slide it across haystack one character at a time, comparing the contents of each window against needle. As soon as a matching window is found, the starting index is returned immediately. If no match is found after exhausting all possible window positions,
    −
    1
    −1
     is returned. This approach avoids any complex data structures and leverages direct substring comparison within each window.

    Now, let’s look at the solution steps below:

    Store the lengths of haystack and needle in haystackLen and needleLen, respectively.

    Perform an early exit check if needleLen is greater than haystackLen, as needle cannot possibly be a substring. Return
    −
    1
    −1
     immediately.

    Iterate startIdx from
    0
    0
     to haystackLen
    −
    −
     needleLen (inclusive), which covers every valid starting position for a window of size needleLen inside haystack.

    At each position, extract the window haystack[startIdx : startIdx + needleLen] and compare it directly to needle.

    If the window matches needle exactly, return startIdx as the index of the first occurrence.

    If the loop completes without finding a match, return
    −
    1
    −1
     to indicate that needle is not present in haystack.

     Time complexity
The time complexity of the solution is
O
(
n
×
m
)
O(n×m)
 because for each of the
O
(
n
−
m
)
O(n−m)
 window positions in haystack (where
n
n
 = haystackLen and
m
m
 = needleLen), a substring comparison of up to
m
m
 characters is performed, giving an overall worst-case cost of
O
(
(
n
−
m
+
1
)
×
m
)
O((n−m+1)×m)
, which simplifies to
O
(
n
×
m
)
O(n×m)
.

Space complexity
The space complexity of the solution is
O
(
m
)
O(m)
 because at each step a temporary substring slice of length needleLen (
m
m
) is created for comparison, and no other auxiliary data structures proportional to the input size are used.


    public int strStr(String haystack, String needle)
    {
        // Retrieve the lengths of the haystack and the needle strings to determine search boundaries.

        // Perform a preliminary check: if the needle is longer than the haystack, a match is impossible.
        // In such a case, return -1 immediately to satisfy the problem constraints.

        // Initialize a loop to iterate through potential starting positions in the haystack.
        // The iteration should only go up to (haystack.length - needle.length) to ensure enough characters remain for a full match.

            // Extract a portion of the haystack starting at the current index with a length equal to the needle.
            // Compare this substring against the target needle string.

            // If the substring and the needle are found to be identical:
                // Return the current starting index as it represents the first occurrence.

        // If the loop completes without finding any matching sequence:
        // Return -1 to indicate that the needle does not exist within the haystack.
    }


     */


    private int strStr(String haystack, String needle) {
    }

    public static void main(String[] args) {


        P013_Medium_FindIndexOfFirstOccurrenceInString sol = new P013_Medium_FindIndexOfFirstOccurrenceInString();

        String[][] testCases = {
                {"helloworld", "world"},
                {"abcdefgh", "xyz"},
                {"mississippi", "issi"},
                {"aaaaaab", "aab"},
                {"programming", "gram"},
        };

        for (int idx = 0; idx < testCases.length; idx++) {
            String haystack = testCases[idx][0];
            String needle = testCases[idx][1];
            int result = sol.strStr(haystack, needle);

            System.out.println("\thaystack: \"" + haystack + "\"");
            System.out.println("\tneedle: \"" + needle + "\"");
            System.out.println("\n\tResult: " + result);
            System.out.println("-".repeat(100));
        }
    }


}
