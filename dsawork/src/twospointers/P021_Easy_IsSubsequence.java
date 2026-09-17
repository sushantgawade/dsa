package twospointers;

public class P021_Easy_IsSubsequence {


    /*
    Statement
    Given two strings s and t, determine whether s is a subsequence of t. Return TRUE if it is, or FALSE otherwise.

    A subsequence of a string is a new string formed by deleting zero or more characters from the original string,
    without changing the relative order of the remaining characters. For example, "ace" is a subsequence of "abcde", whereas "aec" is not.

    Solution
    The key intuition behind this problem is that we can use two pointers to match characters of s in t
    from left to right. We maintain a first pointer for string s and a second pointer for string t. As we scan through t,
    whenever the current character in t matches the current character we're looking for in s, we advance the first pointer to look for the next character. We always advance the second pointer regardless of a match. If by the end of the traversal the first pointer has reached the end of s, it means every character in s was found in t in the correct relative order, so s is a subsequence of t.

    Now, let’s look at the solution steps below:

    Initialize a pointer sPointer (pointing to the start of s) to 0.

    Initialize a pointer tPointer (pointing to the start of t) to 0.

    Iterate using a while loop as long as sPointer is less than the length of s and tPointer is less than the length of t.

    If the character at s[sPointer] equals the character at t[tPointer],

    Increment sPointer by 1.

    Regardless of whether there was a match, increment tPointer by 1 to continue scanning through t.

    After the loop terminates, check if sPointer equals the length of s.
    If it does, all characters of s have been matched in order within t, so return TRUE. Otherwise, return FALSE.

     public boolean isSubsequence(String s, String t) {
        // Initialize a pointer 'sPointer' to 0 to track characters in the potential subsequence 's'.
        // Initialize a pointer 'tPointer' to 0 to traverse the source string 't'.

        // Iterate through both strings while 'sPointer' is within the bounds of 's' and 'tPointer' is within the bounds of 't'.
            // Compare the character in 's' at the current 'sPointer' with the character in 't' at the current 'tPointer'.
            // If the characters match:
                // Move 'sPointer' forward by 1 to look for the next required character of the subsequence.

            // Always move 'tPointer' forward by 1 to continue scanning through the source string 't'.

        // After the loop, evaluate whether all characters of 's' were matched in their correct relative order.
        // Return TRUE if 'sPointer' is equal to the length of 's', otherwise return FALSE.
    }

     */

    private boolean isSubsequence(String s, String t) {

        int sPointer = 0;
        int tPointer = 0;

        while(sPointer < s.length() && tPointer < t.length()) {

            if(s.charAt(sPointer) == t.charAt(tPointer)) {
                sPointer++;
            }
            tPointer++;
        }

        return sPointer == s.length();
    }

    public static void main(String[] args) {

        P021_Easy_IsSubsequence sol = new P021_Easy_IsSubsequence();

        String[][] testCases = {
                {"abc", "ahbgdc"},
                {"axc", "ahbgdc"},
                {"", "ahbgdc"},
                {"abc", ""},
                {"ace", "abcde"},
        };

        for (int i = 0; i < testCases.length; i++) {
            String s = testCases[i][0];
            String t = testCases[i][1];
            boolean result = sol.isSubsequence(s, t);
            System.out.println((i + 1) + ".\ts: \"" + s + "\"");
            System.out.println("\tt: \"" + t + "\"");
            System.out.println("\n\tOutput: " + result);
            System.out.println("-".repeat(100));
        }

    }


}
