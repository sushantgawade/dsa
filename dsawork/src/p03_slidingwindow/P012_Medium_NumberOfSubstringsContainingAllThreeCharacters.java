package p03_slidingwindow;

public class P012_Medium_NumberOfSubstringsContainingAllThreeCharacters {


    /*

    Problem: Number of Substrings Containing All Three Characters
    med
    30 min
    Explore how to efficiently count substrings in a string that contain all three characters 'a', 'b', and 'c' using the sliding window technique. This lesson helps you understand problem constraints and implement solutions that meet coding interview requirements, strengthening your pattern recognition and optimization skills.
    Statement
    Given a string s that consists only of the characters 'a', 'b', and 'c', return the number of substrings that contain at least one occurrence of each of the three characters.




    s consists only of characters 'a', 'b', or 'c'.

    Solution
    The key idea is to use a sliding window over s to count substrings that contain at least one 'a', 'b', and 'c' without enumerating all substrings. The traversal starts with both pointers (left and right) at the beginning of the string, and the window is expanded one character at a time by moving right forward. As the window expands, keep track of whether it currently contains at least one 'a', at least one 'b', and at least one 'c'.

    The moment the window contains all three characters, many substrings can be counted at once. That’s because if s[left..right] already has 'a', 'b', and 'c', then any substring that starts at the same left and ending at right or later (e.g. right + 1) will still have all three (adding more characters can’t remove what’s already inside). So, that fixed left and current right contributes n − right valid substrings.

    After counting those, the window is shrunk by moving left forward, because a smaller valid window enables counting additional substrings with a new starting position. Shrinking continues while the window still contains all three characters. Once a required character drops out, the window is no longer valid, so expansion resumes by moving right forward. This repeats until the scan reaches the end of the string.

    Now, let's look at the solution steps below:

    Initialize a dictionary count with keys 'a', 'b', and 'c', each set to
    0
    0
    , to track the frequency of each character in the current window.

    Initialize a left pointer to
    0
    0
     and a result counter to
    0
    0
    .

    Iterate through the string with a right pointer from
    0
    0
     to n - 1:

    Include the character s[right] in the window by incrementing count[s[right]].

    Enter a while loop that runs as long as the current window s[left..right] has at least one of each count['a'] > 0, count['b'] > 0, and count['c'] > 0:

    Add n - right to the result because every substring starting at left and ending at any index from right to n - 1 (i.e., right, right + 1, ..., n - 1) will still contain all three characters. Extending a valid substring to the right always keeps it valid.

    Shrink the window from the left by decrementing count[s[left]] and incrementing left by
    1
    1
    .

    Continue expanding with right and shrinking with left until right reaches the end. After that, return result as the total count of substrings containing all three characters.

    Let's look at the following illustration to get a better understanding of the solution:


    Now, let’s look at the code for this solution below:

    Time complexity
    The time complexity of the solution is
    O
    (
    n
    )
    O(n)
     because each of the left and right pointers traverses the string at most once. The right pointer moves forward in the outer loop, and the left pointer only moves forward inside the inner loop, never backward. Thus, the total number of operations across both pointers is at most
    2
    n
    2n
    , which simplifies to
    O
    (
    n
    )
    O(n)
    .

    Space complexity
    The space complexity of the solution is
    O
    (
    1
    )
    O(1)
     because only a fixed-size dictionary count with exactly
    3
    3
     entries is used, regardless of the input size. No additional data structures that scale with n are required.


     public int numberOfSubstrings(String s) {
            // Store the length of the input string 's' in a variable 'n'.
            // Initialize a frequency map or array to keep track of the counts of characters 'a', 'b', and 'c'.
            // Ensure the frequency counts for 'a', 'b', and 'c' start at zero.
            // Initialize a 'left' pointer at the start of the string to represent the window's beginning.
            // Initialize a 'result' counter to zero to store the total count of valid substrings.

            // Iterate through the string using a 'right' pointer to expand the sliding window:
                // Increment the count of the character at the current 'right' position in the frequency map.

                // While the current window contains at least one occurrence of 'a', 'b', and 'c':
                    // If the current window [left, right] is valid, then any substring starting at 'left'
                    // and ending at any index from 'right' to 'n-1' is also valid.
                    // Add the number of these valid substrings (calculated as n - right) to the 'result'.

                    // Shrink the window from the left by decrementing the count of the character at the 'left' index.
                    // Increment the 'left' pointer to move the start of the window forward.

            // Return the final accumulated 'result'.
            return 0;
        }



     */


    private int numberOfSubstrings(String input) {




    }

    public static void main(String[] args) {

        P012_Medium_NumberOfSubstringsContainingAllThreeCharacters sol = new P012_Medium_NumberOfSubstringsContainingAllThreeCharacters();

        String[] inputs = {"abcabc", "aaacb", "abc", "aabbcc", "abababc"};

        for (int i = 0; i < inputs.length; i++) {
            int result = sol.numberOfSubstrings(inputs[i]);
            System.out.println((i + 1) + ".\tInput string: \"" + inputs[i] + "\"");
            System.out.println("\tResult: " + result);
            System.out.println("-".repeat(100));
        }

    }

}
