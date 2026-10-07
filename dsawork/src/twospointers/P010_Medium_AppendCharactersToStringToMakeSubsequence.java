package twospointers;

public class P010_Medium_AppendCharactersToStringToMakeSubsequence {

    /*
    Problem: Append Characters to String to Make Subsequence
    med
    30 min
    Explore how to determine the minimum characters to append to a source string to
    make a target string its subsequence. Learn to apply two-pointer techniques efficiently
    for solving linear string problems while understanding subsequence concepts and constraints.
    Statement
    You’re given two strings, source and target, made up of lowercase English letters.
    Your task is to determine the minimum number of characters that must be appended to the
    end of the source so that the target becomes a subsequence of the resulting string.

    Solution
    The goal is to determine the minimum number of characters that must be appended to
    a given source string so that the target string becomes a subsequence. Instead of
    transforming or inserting arbitrary characters, we aim to append the fewest possible characters to the source string.

    A small intuition example:

    If source = "abcccb" and target = "cccbaaa", we only need to append "aaa" from target,
    not the whole string. Appending "aaa" makes the source string "abcccbaaa", where the last
    seven characters now act as a subsequence matching the entire target.

    The algorithm will use a greedy two pointer approach to identify how much of the target is
    already present in order within the source. It iterates through both strings using:

    A pointer, sourceIndex, on the source that moves forward at every step.

    A pointer, targetIndex, on the target that moves forward only when a match is found.

    By the end of the loop, the targetIndex pointer indicates how many characters have been matched.
    The remaining characters (targetLength - targetIndex) must be appended to the end of the source.

    This greedy two pointers strategy ensures we match characters as early as possible, avoiding
    unnecessary additions. Even if appending more characters could work, we only append what is required to complete the subsequence.

    Using the intuition above, we implement the algorithm as follows:

    We create two pointers, sourceIndex and targetIndex, initialized to 0.

    We also store the lengths of the strings in sourceLength and targetLength.

    Iterate until sourceIndex is less than the sourceLength and targetIndex is less than the targetLength:

    If during the iteration, source[sourceIndex] becomes equal to target[targetIndex]:

    We increment targetIndex to use the next character of the target.

    Next, we increment sourceIndex to continue scanning the source string.

    Once the loop breaks, we return the result calculated as the difference between targetLength and targetIndex.

    Let’s look at the following illustration to get a better understanding of the solution:


    public int appendCharacters(String source, String target) {
        // Initialize two pointers, 'sourceIndex' and 'targetIndex', both starting at 0.
        // Capture the lengths of the 'source' and 'target' strings for iteration limits.

        // Traverse the 'source' string as long as there are characters left in both strings:

            // Compare the character at the current 'sourceIndex' with the character at the current 'targetIndex'.

            // If the characters match:
                // Increment 'targetIndex' by 1 to move to the next character we need to find in the 'target' subsequence.

            // Always increment 'sourceIndex' by 1 to continue scanning the 'source' string for matches.

        // After searching through 'source', any characters remaining in 'target' must be appended.
        // Calculate the difference between the 'target' length and the matched 'targetIndex'.
        // Return this difference as the minimum number of characters to append.
    }

     */

    private int appendCharacters(String source, String target) {

    }

    public static void main(String[] args) {

        P010_Medium_AppendCharactersToStringToMakeSubsequence solution = new P010_Medium_AppendCharactersToStringToMakeSubsequence();
        String[] sources = {
                "axbyc",
                "abc",
                "a",
                "ab",
                "xyz"
        };

        String[] targets = {
                "abcde",
                "abcbc",
                "a",
                "aba",
                "abc"
        };

        for (int i = 0; i < sources.length; ++i) {
            int result = solution.appendCharacters(sources[i], targets[i]);
            System.out.println((i + 1) + "\tSource: '" + sources[i] + "'");
            System.out.println("\tTarget: '" + targets[i] + "'");
            System.out.println("\tResult: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }


}
