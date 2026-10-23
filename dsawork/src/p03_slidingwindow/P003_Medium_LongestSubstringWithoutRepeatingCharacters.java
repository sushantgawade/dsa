package p03_slidingwindow;


import java.util.HashMap;
import java.util.Map;

public class P003_Medium_LongestSubstringWithoutRepeatingCharacters {

    /*

    Problem: Longest Substring without Repeating Characters
    75
    med
    30 min
    Explore how to identify the longest substring without repeating characters in a given string by applying the sliding window technique. Understand problem constraints and develop an efficient solution to optimize time and space complexity while practicing hands-on implementation.
    Statement
    Given a string, str, return the length of the longest substring without repeating characters.



    Solution
    So far, you’ve probably brainstormed some approaches on how to solve this problem. Let’s explore some of these approaches and figure out which one to follow while considering time complexity and any implementation constraints.

    Naive approach
    The naive approach is to explore all possible substrings. For each substring, we check whether any character in it is repeated. After checking all the possible substrings, the substring with the longest length that satisfies the specified condition is returned.

    The total time complexity of this solution is
    O(n 3)
    . To explore all possible substrings, the time complexity is
    O(n 2)
    , and to check whether all the characters in a substring are unique or not, the time complexity can be approximated to
    O(n)
    . So, the total time complexity is
    O(n2)∗O(n)=O(n 3). The space complexity of this naive approach is
    O(min(m,n))
    , where
    m
    m
     is the size of the character set and
    n
    n
     is the size of the string.

    Optimized approach using sliding window
    We use a modified version of the classic sliding window method. Instead of a fixed-size window, we allow our window to grow, looking for the window that corresponds to the longest substring without repeating characters.

    We initialize an empty hash map along with a variable to track character indices and the starting point of the window. Next, we traverse the string character by character. During each iteration, the current character is checked to see if it exists in the hash map. If it does not exist, it is added to the hash map along with its index. However, if the current character already exists in the hash map and its index falls within the current window, it indicates that a repeating character has been discovered. In this case, the start of the window is updated to the previous location of the current element and incremented, and the length of the current window is calculated. The longest substring seen so far is updated if the length of the current window is greater than its current value. Finally, the length of the longest substring is returned as the result.

    Here’s how we implement this technique.

    We initialize the following set of variables to 0 to keep track of the visited elements.

    windowStart: The starting index of the current substring.

    windowLength: The length of the current substring.

    longest: The length of the longest substring.

    For every element in the string, we check whether or not it’s present in the hash map.

    If it isn’t present, we store it in the hash map such that the key is the current element and the value is its index in the string.
    If it’s already present in the hash map, then the element may have already appeared in the current substring. For this, we check if the previous occurrence of the element is before or after the starting index, windowStart, of the current substring.

    If it’s after windowStart, we calculate the current substring’s length, windowLength, as the difference between the current index and windowStart. If longest is less than the new windowLength, we set longest as windowLength.

    To prevent the repetition of the current element in the current window, the next candidate substring will be set to start from just after the last occurrence of the current element.

    We then update the value of the corresponding key in the hash map, setting it to the index of the current element.
    After traversing the entire sequence of elements, longest holds the length of the longest substring without repeating characters.

    The following illustration shows these steps in detail:


Let’s look at the code for the solution:

Solution summary
To recap, the solution to this problem can be divided into the following parts:

Traverse the input string.

Use a hash map to store elements along with their respective indexes.

If the current element is present in the hash map, check whether it’s already present in the current window. If it is, we have found the end of the current window and the start of the next. We check if it’s longer than the longest window seen so far and update it accordingly.

Store the current element in the hash map with the key as the element and the value as the current index.

At the end of the traversal, we have the length of the longest substring with all distinct characters.

Time complexity
The time complexity of this solution is O(n)
, where
n
n
 is the length of the input string. This is because we have to iterate over all the elements in the string.

Space complexity
The space complexity of this solution is O(1)
, which is the space occupied by the hash map. This is because there’s only a limited number of unique characters that could appear in the input string


    public static int findLongestSubstring(String str) {
        // Check if the input string is empty; if so, return 0.

        // Initialize tracking variables:
        // - 'n' to store the length of the string.
        // - 'windowStart' to mark the beginning of the current sliding window.
        // - 'longest' to store the maximum substring length discovered.
        // - 'windowLength' to calculate lengths during iteration.
        // - 'i' to iterate through the string as the end of the window.

        // Initialize a hash table to store characters as keys and their latest indices as values.

        // Iterate through the string using 'i' from 0 up to 'n - 1':
            // Determine if the current character 'str.charAt(i)' has been seen before using the hash table.

            // If the character is not in the hash table:
                // Add the character and its current index 'i' to the hash table.

            // If the character is in the hash table:
                // Check if the previously recorded index for this character is within the current window (>= windowStart).

                // If the duplicate character is within the window:
                    // Calculate the current 'windowLength' as (i - windowStart).
                    // If 'windowLength' is greater than 'longest', update 'longest'.
                    // Move 'windowStart' to the position immediately after the previous occurrence of the character.

                // Update the hash table to store the current index 'i' for this character.

        // After the loop completes, perform a final check to see if the window ending at the last index (i - windowStart) is longer than 'longest'.

        // Return the value of 'longest'.
    }

     */


    private static int findLongestSubstring(String str) {

        if(str.length() == 0 ) {
            return 0;
        }

        int n = str.length();
        int windowStart = 0, longest = 0, windowLength = 0, i = 0 ;

        Map<Character, Integer> lastSeen = new HashMap<>();

        for(i =0; i< n; i++) {

            if(!lastSeen.containsKey(str.charAt(i)) ) {

                lastSeen.put(str.charAt(i), i);
            }
            else {

                if(lastSeen.get(str.charAt(i)) >= windowStart) {

                    windowLength = i - windowStart;

                    if(longest < windowLength) {
                        longest =  windowLength;
                    }

                    windowStart = lastSeen.get(str.charAt(i)) + 1;
                }

                lastSeen.replace(str.charAt(i), i);

            }

        }

        if(longest < i - windowStart) {
            longest = i - windowStart;
        }

        return longest;
    }

    public static void main(String[] args) {

        String[] inputs = {
                "abcabcbb",
                "pwwkew",
                "bbbbb",
                "ababababa",
                "",
                "ABCDEFGHI",
                "ABCDEDCBA",
                "AAAABBBBCCCCDDDD"
        };
        for (int i = 0; i < inputs.length; i++) {
            int str = P003_Medium_LongestSubstringWithoutRepeatingCharacters.findLongestSubstring(inputs[i]);
            System.out.print(i + 1);
            System.out.println("\tInput string: " + inputs[i]);
            System.out.println("\n\tLength of longest substring: " + str);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }


}
