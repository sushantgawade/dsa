package twospointers;

import org.w3c.dom.ls.LSResourceResolver;

import java.util.HashSet;
import java.util.Set;

public class P020_Easy_ReverseVowelsOfAString {


    /*

    Statement
    Given a string s, reverse only the vowels in the string and return the resulting string.

    The vowels are ‘a’, ‘e’, ‘i’, ‘o’, and ‘u’, and they can appear in both lowercase and uppercase, potentially more than once.


    Solution
    The key intuition behind this solution is to use the Two Pointers pattern to efficiently reverse only the vowels in the string without disturbing the positions of consonants and other characters. We place one pointer at the beginning (left) and one at the end (right) of the string. Both pointers move toward each other: the left pointer skips over non-vowel characters moving forward, and the right pointer skips over non-vowel characters moving backward. When both pointers land on vowels, we swap those two vowels and continue moving inward. This effectively reverses the order of vowels in-place while leaving all other characters untouched.

    Now, let’s look at the solution steps below:

    Define a set vowels containing all lowercase (‘a’, ‘e’, ‘i’, ‘o’, ‘u’) and uppercase vowels (‘A’, ‘E’, ‘I’, ‘O’, ‘U’) for    O(1)
     lookup.

    Convert the input string s into a list of characters chars, as strings are immutable in Python and we need to perform in-place swaps.

    Initialize two pointers: left at index  0  and right at index len(chars) - 1.

    Enter a loop that continues while left < right:

    Advance the left pointer forward (incrementing by 1 ) as long as left < right and chars[left] is not in vowels.

    Advance the right pointer backward (decrementing by 1 ) as long as left < right and chars[right] is not in vowels.

    Swap the characters at positions left and right, both are now pointing at vowels.

    Move left forward by 1 and right backward by 1 to continue processing the remaining characters.

    After the loop terminates (when left >= right), join the chars list back into a string and return the result.

    Let’s look at the following illustration to get a better understanding of the solution:


    public String reverseVowels(String s) {
        // Create a set containing all lowercase and uppercase vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').

        // Convert the input string 's' into a character array to enable in-place modification.

        // Initialize two pointers:
        // 'left' starting at the beginning of the character array (index 0).
        // 'right' starting at the end of the character array (index length - 1).

        // Iterate while the 'left' pointer is less than the 'right' pointer:

            // Move the 'left' pointer forward as long as 'left' < 'right' and the current character is not a vowel.

            // Move the 'right' pointer backward as long as 'left' < 'right' and the current character is not a vowel.

            // If 'left' is still less than 'right', it means vowels were identified at both positions:
                // Swap the characters at the 'left' and 'right' indices.

                // Advance the 'left' pointer by one.
                // Decrement the 'right' pointer by one.

        // Convert the character array back into a string and return the result.
        return new String();
    }

     */


    private String reverseVowels(String str) {

        Set<Character> vowels = new HashSet<>();

        for(char c: "aeiouAEIOU".toCharArray()) {
            vowels.add(c);
        }

        char[] chars = str.toCharArray();

        int left = 0;
        int right = str.length() - 1;

        while(left < right) {

            while(left < right && !vowels.contains(chars[left])) {
                left++;
            }
            while(left < right && !vowels.contains(chars[right])) {
                right--;
            }

            char temp = chars[left];
            chars[left] =  chars[right];
            chars[right] = temp;

            left++;
            right--;
        }


        return new String(chars);
    }

    public static void main(String[] args) {

        P020_Easy_ReverseVowelsOfAString sol = new P020_Easy_ReverseVowelsOfAString();
        String[] testCases = {
                "photosynthesis",
                "celebrity",
                "artificial",
                "intelligence",
                "Python",
        };

        for (int i = 0; i < testCases.length; i++) {
            String result = sol.reverseVowels(testCases[i]);
            System.out.println((i + 1) + ".\tInput string: \"" + testCases[i] + "\"");
            System.out.println("\tResult: \"" + result + "\"");
            System.out.println("-".repeat(100));
        }

    }



}
