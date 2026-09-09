package twospointers;


public class P007_Easy_ValidPalindrome2 {


    /*
    Explore how to verify if a given string can become a valid palindrome by removing at most one character.
    This lesson teaches you to apply the two-pointer technique to solve the problem efficiently,
    with linear time complexity and constant space. By practicing this approach, you'll enhance your skills
    in handling string and linear data structure problems relevant for coding interviews.

    Statement
    Write a function that takes a string as input and checks whether it can be a valid palindrome by removing
    at most one character from it.

    */

    public static boolean isSubstringPalindrome(String str, int left, int right) {

        while (left < right) {

            if(str.charAt(left) != str.charAt(right)) {

                return false;
            }

            left++;
            right--;
        }
        return true;
    }

    private static boolean isPalindrome(String input) {

        int left = 0;
        int right = input.length() - 1;

        while( left < right ) {

            if(input.charAt(left) != input.charAt(right)) {

                return isSubstringPalindrome(input, left + 1, right) || isSubstringPalindrome(input, left, right -1 );

            }

            left++;
            right--;
        }

        return true;
    }


    public static void main(String[] args) {

        String[] inputs = {"madame", "dead", "abca", "tebbem", "eeccccbebaeeabebccceea"};
        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tString: " + inputs[i]);
            System.out.println("\n\tValid Palindrome: " + isPalindrome(inputs[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }


}
