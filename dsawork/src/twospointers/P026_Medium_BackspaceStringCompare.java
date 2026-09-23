package twospointers;

public class P026_Medium_BackspaceStringCompare {

    /*

    Explore how to determine if two strings produce the same text after processing backspace characters.
    Learn the two pointers technique to solve this problem efficiently with linear time and constant space.
    Statement
    Given two strings s and t, return true if they produce the same result when typed into an empty text editor,
    where '#' represents a backspace character. Applying a backspace on an empty editor leaves it unchanged.

    Solution
    The key insight is that backspace characters affect only the characters to their left, which means if we traverse both strings from right to left, we can determine which characters are truly “visible” (i.e., not cancelled by a '#') and compare them on the fly without ever building the final strings. We maintain two pointers, one for each string, and a skip counter for each that tracks how many upcoming characters should be skipped due to pending backspaces. Whenever both pointers land on a valid character simultaneously, we compare them directly and move on.

    Now, let’s look at the solution steps below:

    Initialize two pointers, iS and iT, at the last indices of s and t respectively, and two skip counters, skipS and skipT, both set to 0.

    Enter a loop that continues as long as at least one pointer is still within bounds (i.e., iS >= 0 or iT >= 0).

    Advance iS leftward until it either goes out of bounds or lands on a valid (non-cancelled) character in s:

    If s[iS] is '#', increment skipS and move iS one step left, since this backspace will cancel the next real character we encounter.

    Else if skipS > 0, decrement skipS and move iS one step left, since this character is cancelled by a pending backspace.

    Otherwise, iS is pointing at a valid character, so stop the inner loop.

    Repeat the same advancement process for iT using skipT, finding the next valid character in t.

    Compare the characters at the current positions of both pointers:

    If both iS and iT are in bounds and s[iS] != t[iT], return False immediately, since the two typed outputs differ at this position.

    If exactly one pointer is in bounds while the other is exhausted, return False, since one string has remaining visible characters and the other does not.

    Decrement both iS and iT by 1 to move to the next pair of characters and repeat from step 3.

    If the loop completes without returning False, all visible characters matched, so return True.

     */

    private boolean backspaceCompare(String s, String t) {

    }

    public static void main(String[] args) {
        P026_Medium_BackspaceStringCompare sol = new P026_Medium_BackspaceStringCompare();

        String[][] testCases = {
                {"abc###", ""},
                {"x#y#z", "z"},
                {"hello##", "hel"},
                {"a##c", "#ac"},
                {"abc#d##", "ac"},
        };

        for (int idx = 0; idx < testCases.length; idx++) {
            String s = testCases[idx][0];
            String t = testCases[idx][1];
            boolean result = sol.backspaceCompare(s, t);
            System.out.println((idx + 1) + ".\tInput s: \"" + s + "\"");
            System.out.println("\tInput t: \"" + t + "\"");
            System.out.println("\tResult: " + result);
            System.out.println("-".repeat(100));
        }
    }

}
