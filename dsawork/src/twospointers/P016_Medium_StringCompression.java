package twospointers;

import java.util.Arrays;
import java.util.List;

public class P016_Medium_StringCompression {


    /*
    Statement
    Given an array of characters, chars, compress it in place according to the following rules:

    Start with an empty string s.

    For each group of consecutive repeating characters in chars:

    If the group length is
    1
    , append just the character to s.

    Otherwise, append the character followed by the group length.

    The compressed string s should not be returned separately; instead, it must be written directly into the input character array chars. Note that if a group’s length is
    10
     or greater, each digit of the length should be stored as a separate character in chars.

    After modifying the array, return the new length of the compressed array.
     */


    // Initialize a pointer to track the insertion point for the compressed output.
    // Initialize a pointer to scan through the original character array.

    // Traverse the character array until the scan pointer reaches the end.
    // Identify the current character and the start of its repeating sequence.
    // Advance the scan pointer to find the end of this consecutive character group.

    // Calculate the number of characters in the current sequence.

    // Write the character representing the sequence at the current write pointer.
    // Increment the write pointer.

    // Check if the character sequence consists of more than one instance.
    // If so, convert the count of characters into its decimal digit representation.
    // Iterate through each digit in the count's representation.
    // Place the digit character at the current write pointer.
    // Increment the write pointer.

    // The scan pointer is now ready to process the next distinct group of characters.

    // Return the final write pointer position, representing the length of the compressed array.

    /*
    Solution
    The algorithm performs run-length encoding directly on the input array chars using two pointers to achieve constant extra space. A read pointer traverses the array to identify groups of consecutive repeating characters, while a write pointer overwrites chars with the compressed form as the algorithm progresses. For each group of identical characters, the algorithm writes the character once at the current write position. If the group’s length is greater than one, it converts the length to a string and writes each digit sequentially after the character. After all groups have been processed, the position of the write pointer represents the new compressed length of the array.

    The steps of the algorithm are as follows:

    Store the length of the input character array chars in a variable n.

    Initialize a write pointer w to 0. This pointer tracks where the compressed characters and counts should be placed in the chars array.

    Initialize a read pointer i to 0. This pointer iterates through the original chars array to find character groups.

    While i < n:

    Set j = i.

    Advance j while j < n and chars[j] == chars[i] to locate the end of the current group.

    Compute the group length: count = j - i.

    Write the character once at chars[w], then increment w.

    If count > 1, convert count to a string and write each digit into chars[w], incrementing w for each.

    Move to the next iteration by setting i = j.

    After processing all groups, return w, that is, the length of the compressed array.

    Let’s look at the following illustration to get a better understanding of the solution:
     */

    private static int compress(char[] chars) {

        int w = 0;

        int n = chars.length;

        int i = 0;

        while(i < n) {

            int j = i;

            while (j < n && chars[j] == chars[i]) {
                j++;
            }

            int count = j - i;

            chars[w++] = chars[i];


            if(count > 0 ) {

                for(char c : String.valueOf(count).toCharArray()) {
                    chars[w++] = c;
                }
            }

            i = j;

        }

        return w;
    }

    public static void main(String[] args) {

        List<char[]> testCases = List.of(
                new char[]{'a','a','b','b','c','c','c'},                   // multiple small runs
                new char[]{'a'},                                           // single char
                new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}, // 12 b's
                new char[]{'x','y','z'},                                   // all distinct
                new char[]{'a','b','b','c','c','c','c','c','c','c','c','c','c','c'} // long c-run
        );

        int idx = 1;
        for (char[] chars : testCases) {
            System.out.println("\n" + idx++ + ".\tInput = " + Arrays.toString(chars));
            int result = compress(chars);
            System.out.println("\n\tCompressed Length = " + result);
            System.out.println("\tCompressed Array  = " + Arrays.toString(Arrays.copyOf(chars, result)));
            System.out.println("-".repeat(100));
        }

    }


}
