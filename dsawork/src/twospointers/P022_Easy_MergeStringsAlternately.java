package twospointers;

public class P022_Easy_MergeStringsAlternately {

    /*

    Statement
    Given two strings word1 and word2, merge them by interleaving their characters in alternating order,
    beginning with the first character of word1. If one string is longer than the other,
    append the remaining characters of the longer string to the end of the merged result.

    Return the resulting merged string.

    Solution
    The key idea is to use two pointers to simultaneously traverse both input strings, picking one character at a time
    from each string in alternating fashion. We initialize one pointer for word1 and another for word2, both starting at index  0
    . In each iteration of a loop, we append the character at the current position of word1 followed by the character
    at the current position of word2 to a result list. Once one of the strings is fully traversed, we simply append all remaining characters from the other string to the end of the result. Finally, we join the result list into a single string and return it.

    Now, let’s look at the solution steps below:

    Initialize two pointers i and j to 0. These will track the current position in word1 and word2, respectively.

    Initialize an empty list result to collect the characters of the merged string.

    Use a while loop that runs as long as both i is less than the length of word1 and j is less than the length of word2:

    Append word1[i] to result.

    Append word2[j] to result.

    Increment both i and j by 1.

    After the first loop ends, one or both strings may have remaining characters.

    Use a second while loop to append any remaining characters from word1:

    While i is less than the length of word1, append word1[i] to result and increment i.

    Similarly, use a third while loop to append any remaining characters from word2:

    While j is less than the length of word2, append word2[j] to result and increment j.

    Join all elements in result into a single string and return it.

     public String mergeAlternately(String word1, String word2) {
        // Initialize two pointers, i and j, to 0 to track positions in word1 and word2.
        // Initialize a string builder to efficiently accumulate the interleaved characters.

        // Iterate while both pointers i and j are within the boundaries of word1 and word2 respectively.
            // Append the character at index i from word1 to the result builder.
            // Append the character at index j from word2 to the result builder.
            // Increment both pointers i and j by 1.

        // If there are remaining characters in word1 after the first loop finishes:
            // Iterate through the rest of word1 starting from the current index i.
                // Append each remaining character to the result builder.
                // Increment the pointer i.

        // If there are remaining characters in word2 after the first loop finishes:
            // Iterate through the rest of word2 starting from the current index j.
                // Append each remaining character to the result builder.
                // Increment the pointer j.

        // Convert the assembled characters in the builder into a final string and return it.
    }

     */



    private String mergeStringAlternately(String w1, String w2) {

        int i = 0, j = 0;

        StringBuilder result = new StringBuilder();

        while(i < w1.length() && j < w2.length() ){

            result.append(w1.charAt(i));
            result.append(w2.charAt(j));
            i++;
            j++;
        }

        while(i < w1.length()) {
            result.append(w1.charAt(i));
            i++;
        }

        while(j < w2.length()) {
            result.append(w2.charAt(j));
            j++;
        }

        return result.toString();

    }

    public static void main(String[] args) {

        P022_Easy_MergeStringsAlternately sol = new P022_Easy_MergeStringsAlternately();

        String[][] testCases = {
                {"x", "y"},
                {"hello", "world"},
                {"a", "bcdef"},
                {"zyxwv", "m"},
                {"cat", "dogs"},
        };

        for (int idx = 0; idx < testCases.length; idx++) {
            String w1 = testCases[idx][0];
            String w2 = testCases[idx][1];
            String result = sol.mergeStringAlternately(w1, w2);
            System.out.println((idx + 1) + ".\tInput array: [\"" + w1 + "\", \"" + w2 + "\"]");
            System.out.println("\tResult: \"" + result + "\"");
            System.out.println("-".repeat(100));
        }
    }



}
