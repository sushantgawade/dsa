package twospointers;

import java.util.Arrays;
import java.util.List;

public class P005_Medium_ReverseWordsInAString {


    /*
        Explore the two pointers technique to reverse
        the order of words in a string without altering
        the characters within each word. Learn to manage
        spaces effectively by removing leading, trailing, and extra spaces,
        and return a clean, properly spaced sentence.
     */

    /*

   Statement
        You are given a string sentence that may contain leading or trailing spaces,
        as well as multiple spaces between words. Your task is to reverse the order of the words in the sentence without
        changing the order of characters within each word. Return the resulting modified sentence as a single string
        with words separated by a single space, and no leading or trailing spaces.
     */

    // Trim leading and trailing spaces from the input
    // sentence.sentence = sentence.trim();
    // String[] words = sentence.split("\\\\s+");
    // Split the sentence into an array of words using whitespace as a delimiter.
    // Ensure the splitting logic handles multiple consecutive spaces by treating them as a single separator.
    // Initialize a pointer at the beginning of the word array and another at the end.

    // Iterate as long as the start pointer is less than the end pointer:
    // Swap the word at the start pointer with the word at the end pointer using a temporary variable.
    // Move the start pointer forward to the next word.
    // Move the end pointer backward to the previous word.

    // Join the reversed array of words into a single string, ensuring words are separated by exactly one space.
    // Return the final formatted and reversed string.

    public static String reverseWords(String sentence) {

        sentence = sentence.trim();
        String[] words = sentence.split("\\s+");

        int left = 0, right = words.length - 1;

        while (left < right) {

            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }

        return String.join(" ", words);
    }

    public static void main(String[] args) {
        List<String> stringsToReverse = Arrays.asList(
                "Hello World",
                "a   string   with   multiple   spaces",
                "Case Sensitive Test 1234",
                "a 1 b 2 c 3 d 4 e 5",
                "     trailing spaces",
                "case test interesting an is this"
        );

        for (int i = 0; i < stringsToReverse.size(); i++) {
            System.out.println((i + 1) + ".\tOriginal string: '" + stringsToReverse.get(i) + "'");
            System.out.println("\tReversed string: '" + reverseWords(stringsToReverse.get(i)) + "'");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}
