package twospointers;

public class P001_Easy_PalindromeCheck {

    public static boolean isPalindrome(String str) {

        int left = 0;
        int right = str.length() - 1;

        while(left < right) {

            while(left < right && !Character.isLetterOrDigit(str.charAt(left))) {
                left++;
            }
            while(left < right && !Character.isLetterOrDigit(str.charAt(right))) {
                right--;
            }

            if(Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))) {
                return false;
            }

            left++;
            right--;

        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println("Code for checking if String is palindrome");

        String[] testCases = {
                "A man, a plan, a canal: Panama",
                "race a car",
                "1A@2!3 23!2@a1",
                "No 'x' in Nixon",
                "12321"
        };

        boolean palindrome;

        for(String test : testCases) {


            palindrome = P001_Easy_PalindromeCheck.isPalindrome(test);

            System.out.printf("%n'%s' is %s ", test, palindrome?"palindrome" : "not palindrome");
        }

    }
}
