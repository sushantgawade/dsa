package twospointers;

public class P027_Medium_NextGreaterElement3 {


    /*

    Problem: Next Greater Element III
    med
    30 min
    Explore how to use the two-pointer technique to find the smallest integer greater than a given number with the exact same digits.
    Understand constraints such as 32-bit integer limits and improve your problem-solving skills with this pattern.
    Practice implementation in Python to prepare for technical interviews.

    Statement
    Given a positive integer n, find the smallest integer that uses exactly the same digits as n and has a strictly greater value than n. If no such positive integer exists, return −1.


    Solution
    The key insight is to recognize this as a next permutation problem: we need to find the smallest rearrangement of the digits of n that yields a number strictly greater than n. The solution uses a two-pointer approach in two stages. First, we scan from right to left to locate the pivot, which the first digit that breaks the non-increasing order of the suffix. Next, after swapping the pivot with the smallest larger digit to its right, we use two pointers to reverse the suffix, producing the smallest possible arrangement that is still greater than the original number. Finally, we verify that the result fits within the 32-bit signed integer range and return -1 if it exceeds that limit.

    Now, let’s look at the solution steps below:

    Convert n into an array of its digits and let length be the number of digits.

    Find the pivot by scanning from right to left for the first position where a digit is smaller than the digit immediately to its right.

    Start at length - 2 and move left while the current digit is greater than or equal to the next digit.

    If no such position exists, the digits are in non-increasing order, meaning no larger permutation can be formed. Return -1.

    Find the swap candidate by scanning from the end of the array toward the pivot until finding the first digit greater than the pivot digit.

    Because the suffix to the right of the pivot is already in non-increasing order, this digit is the smallest possible larger replacement.

    Swap the pivot digit (digits[pivot]) with the swap candidate (digits[swapIdx]).

    Reverse the suffix of digits to the right of the pivot using two pointers.

    Set one pointer at pivot + 1 and the other at the last index.

    Repeatedly swap the digits at the two pointers and move them toward each other until they meet.

    This transforms the suffix into ascending order, producing the smallest number that is still larger than the original.

    Convert the digit array back into an integer.

    If the result exceeds 2^31 - 1, return -1; otherwise, return the result.

    Let’s look at the following illustration to get a better understanding of the solution:


    public int nextGreaterElement(int n) {
        // Convert the integer 'n' into an array of characters to allow for digit manipulation.

        // Start from the second-to-last digit and move left to find the first 'pivot' digit.
        // The pivot is the first digit that is strictly smaller than the digit to its immediate right.

        // If no such pivot is found (the index moves past the start of the array):
        // The digits are in descending order, meaning no larger permutation is possible.
        // Return -1.

        // Start from the last digit and move left to find the 'successor' digit.
        // The successor is the first digit that is strictly greater than the digit at the pivot index.

        // Swap the digit at the pivot index with the digit at the successor index.

        // Reverse the sequence of digits starting from the index immediately after the pivot to the end of the array.
        // This ensures that the suffix becomes the smallest possible sequence, resulting in the smallest next greater integer.

        // Convert the modified character array back into a long integer to handle potential overflow.

        // Check if the resulting value exceeds the maximum value allowed for a 32-bit signed integer.
        // If it fits within the limit, return the result as an integer; otherwise, return -1.
    }

     */

    private int nextGreaterElement(int n) {

        char[] digits = String.valueOf(n).toCharArray();

        int length = digits.length;

        int pivot = length - 2;

        while( pivot >= 0 && digits[pivot] >= digits[pivot + 1]) {

            pivot--;
        }

        if (pivot < 0) return -1;

        int swapIndex = length - 1;

        while(  swapIndex >= 0 && digits[swapIndex] <= digits[pivot]) {
            swapIndex--;
        }

        char temp = digits[swapIndex];
        digits[swapIndex] = digits[pivot];
        digits[pivot] = temp;


        int left = pivot + 1;
        int right = length - 1;

        while(left < right) {

            char tmp = digits[left];
            digits[left] = digits[right];
            digits[right] = tmp;

            left++;
            right--;
        }

        long num = Long.parseLong(new String(digits));
        return num <= Integer.MAX_VALUE ? (int)num : -1;
    }

    public static void main(String[] args) {

        P027_Medium_NextGreaterElement3 sol = new P027_Medium_NextGreaterElement3();
        int[] testCases = {1234, 4321, 534976, 2147483647, 1999999999};

        for (int i = 0; i < testCases.length; i++) {
            int n = testCases[i];
            int result = sol.nextGreaterElement(n);
            System.out.println((i + 1) + ".\tn = " + n);
            System.out.println("\tResult: " + result);
            System.out.println("-".repeat(100));
        }

    }


}
