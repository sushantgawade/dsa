package p03_slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P002_Medium_LongestRepeatingCharacterReplacement {


    /*

    Problem: Longest Repeating Character Replacement
    75
    med
    30 min
    Hint
    Explore how to apply the sliding window technique to solve the longest repeating character replacement problem. Understand how to identify the
    length of the longest substring where characters can be replaced up to k times to achieve uniformity. This lesson helps you develop an efficient
    approach to this common coding interview challenge, improving your problem-solving skills in string manipulation and optimization.
    Statement
    Given a string, s, and an integer, k, find the length of the longest substring in s, where all characters are identical, after replacing, at most,
    k characters with any other uppercase English character.



    Solution
    So far, you’ve probably brainstormed some approaches and have an idea of how to solve this problem. Let’s explore some of these approaches and figure out which one to follow based on considerations such as time complexity and any implementation constraints.

    Naive approach
    A brute force method checks every possible substring to see if it can be transformed into a string of identical characters with at most k replacements. Here’s how it works:

    Consider every substring starting from that character for each character in the string.

    For each substring, use a nested loop to count the number of replacements needed to make all its characters identical.

    If the number of replacements is within the allowed limit k and the substring is longer than any previously found valid substring, update the longest length.

    This method uses three nested loops—one to choose the starting point, one to choose the ending point, and one to calculate the required replacements—resulting in a time complexity of
    O(n3), where n is the length of the input string.

    Optimized approach using sliding window
    We have to find the maximum length of a substring where we can replace up to k characters to make all characters in the substring identical. To solve this efficiently, we use the sliding window approach. It involves two pointers marking the start and end of a segment that moves across the main string. This method helps to quickly adjust the segment by expanding and contracting the window without repeatedly examining the same characters.

    The process starts by expanding the window one character at a time and using a hash map to record the frequency of each character within the window. It also tracks the count of the most frequent characters in the window to determine how many characters need to be replaced to make the window uniform. If the difference between the window size and this highest frequency exceeds the allowed number of replacements, the window is contracted from the start until it becomes valid again. Throughout this process, the maximum valid window size is continuously updated, and finally, the length of the longest valid substring is returned.

    Here are the detailed steps of the algorithm that we have just discussed:

    We start by initializing the data structures and variables required to track the sliding window clearly:

    lengthOfMaxSubstring will track the length of the longest valid substring found; this is initially set to 0.

    start pointer marks the left boundary of the sliding window; this is initially set to 0.

    We create a frequency map, charFreq, that keeps track of how many times each character appears within our current sliding window.

    A counter, mostFreqChar, tracks the maximum frequency of any character within our current window; this is initially set to 0.

    Next, we iterate over the string using a pointer, end, starting from 0 to stringLength - 1:

    First, we take the character at the current position end.

    Then, we update the frequency count of this character in the charFreq map:

    If the character does not exist in charFreq, we initialize its frequency to 1.

    If the character is already present, we increment its frequency by 1.

    After updating this frequency, we compare the updated count of this character with the current mostFreqChar. If the new frequency is greater, we set mostFreqChar equal to this new higher frequency.

    After each character addition, we check if the current window is valid. Specifically, we check if the number of replacements needed (calculated as (end - start + 1) - mostFreqChar) exceeds k:

    If replacements exceed k, we reduce the window size by:

    Decreasing the character frequency at position start in the charFreq map by 1 because this character will no longer be inside our window.

    Moving the start pointer forward by one position, contracting the window to restore validity.

    Finally, we compare the length of our current window (end - start + 1) with lengthOfMaxSubstring. If the current window length is larger, we update lengthOfMaxSubstring to this new value.

    Once the whole string has been traversed, we return the recorded value of lengthOfMaxSubstring, representing the length of the longest substring that can be converted into a uniform substring by replacing at most k characters.


Let’s have a look at the code for the algorithm we just discussed.

Solution summary
To recap, the solution can be divided into the following parts:

We iterate over the input string using two pointers.

In each iteration:

If the new character is not present in the hash map, we add it. Otherwise, we increment its frequency by 1.
We slide the window one step forward if the number of replacements required in the current window has exceeded our limit.
If the current window is the longest so far, then we update the length of the longest substring that has the same character.
Finally, we return the length of the longest substring with the same character after replacements.

Time complexity
The time complexity of the solution is O(n) , where n
 is the length of the input string because we iterate over the input string only once.

Space complexity
The space complexity of the solution is O(1) , since we will be storing the frequency of 26 characters at most in the hash map.




    public static int longestRepeatingCharacterReplacement(String s, int k) {
        // Determine the length of the input string.
        // Initialize a variable to track the maximum substring length found.
        // Initialize the starting pointer for the sliding window.
        // Use a frequency map or array to keep track of character counts within the current window.
        // Initialize a variable to store the count of the most frequent character in the current window.

        // Iterate through the string with an 'end' pointer to expand the sliding window.
            // Retrieve the character at the current 'end' position.
            // Increment the count of this character in the frequency tracking structure.
            // Update the tracking variable for the most frequent character if the current character's count is now higher.

            // Check if the current window is invalid (window size minus the count of the most frequent character exceeds k).
                // If invalid, decrement the frequency count of the character currently at the 'start' pointer.
                // Move the 'start' pointer one step to the right to shrink the window.

            // Calculate the current window size (end - start + 1).
            // Update the maximum substring length if the current window size is the largest found so far.

        // Return the recorded maximum length of the substring.
    }


     */


    private static int longestRepeatingCharacterReplacement(String s, Integer k) {

        int strLength = s.length();
        int lengthOfMaxSubstring = 0;
        int charMaxFreq = 0;
        Map<Character, Integer> charFreqMap  = new HashMap<>();

        int start = 0;

        for(int end =0; end < strLength; end++) {

            Character currentChar = s.charAt(end);

            charFreqMap.put(currentChar, charFreqMap.getOrDefault(currentChar, 0) + 1);

            charMaxFreq = Math.max(charMaxFreq, charFreqMap.get(currentChar));

            if(end - start + 1 - charMaxFreq > k ) {

                charFreqMap.put(s.charAt(start), charFreqMap.get(s.charAt(start)) - 1);

                start += 1;
            }

            lengthOfMaxSubstring = Math.max(lengthOfMaxSubstring, end - start + 1);

        }

        return  lengthOfMaxSubstring;

    }

    public static void main(String[] args) {


        List<String> inputStrings = Arrays.asList("AABCCBB", "ABBCB", "ABCCDE", "ABBCAB", "BBBBBBBBB");
        List<Integer> k = Arrays.asList(2, 1, 1, 2, 4);

        for (int i = 0; i < inputStrings.size(); ++i) {
            System.out.println((i + 1) + ".\tInput String: '" + inputStrings.get(i) + "'");
            System.out.println("\tk: " + k.get(i));
            System.out.println("\tLength of the longest substring with repeating characters: "
                    + longestRepeatingCharacterReplacement(inputStrings.get(i), k.get(i)));
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }


    }
}
