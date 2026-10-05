package twospointers;

public class P031_Medium_SumOfSquareNumbers {


    /*
    Problem: Sum of Square Numbers
    med
    30 min
    Try to solve the Sum of Square Numbers problem.
    Statement
    Given a non negative integer c, determine whether there exist integers a and b such that a2 +b2=c
    . Return true if such integers exist, otherwise return false.

Solution
To decide if c can be written as a2+b2, we can treat a and b as two values we search over in a sorted way.
 Since squares grow as the number grows, we start left at 0 and right at​
 ⌋
, compute currSum = left^2 + right^2, and then move the pointer that will bring currSum closer to c. This two pointers approach avoids checking all pairs.

Now, let’s look at the solution steps below:

Initialize left to 0, and right to math.isqrt(c) (the integer square root of c), setting up a two-pointer search over the range of possible values whose squares could sum to c.

While left is less than or equal to right, repeat the following:

Compute currSum as left * left + right * right.

If currSum equals c, return True, since left and right are a valid pair of numbers whose squares sum to c.

If currSum is less than c, increment left to increase the sum.

Otherwise (currSum is greater than c), decrement right to decrease the sum.

If the loop ends without finding a match (left exceeds right), return False, since no pair of squares sums to c.

      public boolean judgeSquareSum(int c) {
            // Initialize a pointer 'left' starting at 0.
            // Initialize a pointer 'right' starting at the integer square root of 'c'.

            // Iterate while the 'left' pointer is less than or equal to the 'right' pointer:
                // Calculate the sum of squares using the current 'left' and 'right' pointers.
                // Use a long data type to store the result to prevent overflow for values near 2^31 - 1.

                // If the calculated sum equals the target value 'c':
                    // Return true, as a pair of integers satisfying the condition has been found.

                // If the calculated sum is less than 'c':
                    // Increment the 'left' pointer to increase the total sum.

                // Otherwise (if the sum is greater than 'c'):
                    // Decrement the 'right' pointer to decrease the total sum.

            // If the loop finishes without finding a valid pair, return false.
        }


 */

    public boolean judgeSquareSum(int c) {
        return false;
    }

    public static void main(String[] args) {

        int[] testCases = new int[] {0, 1, 2, 50, 2147483647};
        P031_Medium_SumOfSquareNumbers sol = new P031_Medium_SumOfSquareNumbers();

        for (int i = 0; i < testCases.length; i++) {
            int c = testCases[i];
            boolean result = sol.judgeSquareSum(c);
            System.out.println((i + 1) + ".\tInput array: [" + c + "]");
            System.out.println("\tTarget: " + c);
            System.out.println("\tResult: " + result);
            System.out.println("-".repeat(100));
        }


    }

}
