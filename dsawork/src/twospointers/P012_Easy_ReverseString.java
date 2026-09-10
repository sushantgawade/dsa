package twospointers;

import java.util.Arrays;

public class P012_Easy_ReverseString {

    /*
    Explore how to reverse a string in-place by applying the two pointers technique to modify the original
    character array without additional memory. This lesson helps you understand and implement an efficient solution
    for linear data structures, reinforcing concepts useful in coding interviews.

    Statement
    You are given a character array, s, representing a string. Write a function that reverses the array in-place.

    The reversal must be done by modifying the original array directly.

    You cannot use extra memory beyond a constant amount O(1).

     */


    // Initialize a pointer 'left' at the first index (0) of the array.
    // Initialize a pointer 'right' at the last index (s.length - 1) of the array.

    // Repeat the following steps while 'left' is less than 'right':
    // Store the character at the 'left' index in a temporary variable to prevent losing it.

    // Swap the characters by assigning the value at 'right' to the 'left' index.

    // Assign the value stored in the temporary variable to the 'right' index.

    // Move the 'left' pointer one position to the right (increment).

    // Move the 'right' pointer one position to the left (decrement).

    // The array is reversed in-place with O(1) extra space once the pointers meet or cross.

    private void reverseString(char[] str) {

        int left = 0;
        int right = str.length -1;

        while( left < right) {

            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;

            left++;
            right--;
        }

    }

    public static void main(String[] args) {

        char[][] testCases = {
                {'h','e','l','l','o'},
                {'m','o','r','n','i','n','g'},
                {'p','y','t','h','o','n'},
                {'a'},
                {'r','a','c','e','c','a','r'}
        };

        P012_Easy_ReverseString sol = new P012_Easy_ReverseString();

        for (int i = 0; i < testCases.length; i++) {
            char[] original = Arrays.copyOf(testCases[i], testCases[i].length);

            sol.reverseString(testCases[i]);

            System.out.println((i + 1) + "\tInput string: " + Arrays.toString(original));
            System.out.println("\n\tReversed string: " + Arrays.toString(testCases[i]));
            System.out.println("----------------------------------------------------------------------------------------------------\n");
        }

    }


}
