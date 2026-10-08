package fastandslowpointers;

public class P001_Easy_HappyNumber {


    /*
    Explore the fast and slow pointer method to check if a number is a happy number by repeatedly
    summing the squares of its digits. Understand how to detect cycles efficiently within this process. This lesson equips you to solve cycle detection problems relevant to coding interviews and improve your problem-solving skills.
    Statement
    Write an algorithm to determine if a number n is a happy number.

    We use the following process to check if a given number is a happy number:

    Starting with the given number n , replace the number with the sum of the squares of its digits.
    Repeat the process until:
    The number equals 1 , which will depict that the given number n is a happy number.
    The number enters a cycle, which will depict that the given number n is not a happy number.
    Return TRUE if n is a happy number, and FALSE if not.

Solution
So far, you have probably brainstormed some approaches and have an idea of how to solve this problem.
Let’s explore some of these approaches and figure out which one to follow based on considerations such as
time complexity and any implementation constraints.

Naive approach
The brute force approach is to repeatedly calculate the squared sum of digits of the input number and
store the computed sum in a hash set. For every calculation, we check if the sum is already present in
the set. If yes, we've detected a cycle and should return FALSE. Otherwise, we add it to our hash set
and continue further. If our sum converges to 1, we've found a happy number.

While this approach works well for small numbers, we might have to perform several computations for
larger numbers to get the required result. So, it might get infeasible for such cases. The time
complexity is O(logn) because finding the next value requires processing each digit, which takes O(logn)
 time as the number of digits in nn is approximately logn. Once the value drops below 243, it can
 take, at most, 243
 more steps to terminate, which is a constant and, therefore, negligible. For numbers greater than 243 ,
 the chain length follows a logarithmic pattern like
O(logn)+O(loglogn)+O(logloglogn), but the dominant term remains O(logn)
. The smaller logarithmic terms collectively add up to less than
O(logn), so they can be ignored. Consequently, the final time complexity is
O(logn). The space complexity is O(logn) since we're using additional space to store our calculated sums.

Optimized approach using Fast and Slow Pointers pattern
To determine whether a number is a happy number, it is iteratively replaced by the sum of the squares of its
digits, forming a sequence of numbers. This sequence either converges to
1
 (if the number is happy) or forms a cycle (if the number is not happy). We use the fast and slow pointers
 technique to detect such cycles efficiently. This technique involves advancing two pointers through the
 sequence at different speeds: one moving one step at a time and the other two at a time.

The pointer moving slower is initialized to the given number, and the faster one starts at the sum of the
squared digits of the given number. Then, in each subsequent iteration, the slow pointer updates to the
sum of squared digits of itself, while the fast pointer advances two steps ahead: first by updating to
the sum of squared digits of itself and then to the sum of squared digits of this recently calculated sum.
If the number is happy, the fast pointer will eventually reach
1
. However, if the number is not happy, indicating the presence of a cycle in the sequence, both pointers
will eventually meet. This is because, in the noncyclic part of the sequence, the distance between the
pointers increases by one number in each iteration. Once both pointers enter the cyclic part, the faster
pointer starts closing the gap on the slower pointer, decreasing the distance by one number in each
iteration until they meet. This way, we can efficiently determine whether a number is a happy number or not.

As an example, suppose we have the number
2
 as our n. This is what the infinite loop would look like:

     public static int sumOfSquaredDigits(int number) {
        // Initialize a variable to store the total sum of squares.
        // Continue processing while the current number is greater than 0:
            // Extract the last digit of the number using the modulo operator (number % 10).
            // Add the square of this digit to the total sum.
            // Remove the last digit from the number using integer division (number / 10).
        // Return the final calculated sum of squared digits.
        return 0;
    }

    public static boolean isHappyNumber(int n) {
        // Initialize a 'slow' pointer to the starting number n.
        // Initialize a 'fast' pointer to the sum of the squared digits of n using the helper function.

        // Iterate while the 'fast' pointer has not reached 1 and 'slow' is not equal to 'fast':
            // Move the 'slow' pointer forward by one step by calculating the sum of squared digits.
            // Move the 'fast' pointer forward by two steps by calculating the sum of squared digits twice.

        // If the 'fast' pointer reached 1, the number is a happy number; return true.
        // If the pointers meet and the value is not 1, a cycle is detected; return false.
        return false;
    }

     */

    public static int sumOfSquaredDigits(int number) {

        int sumOfSquareOfDigits =  0;

        while(number > 0) {

            int digit = number % 10;

            number = number / 10;

            sumOfSquareOfDigits += Math.pow(digit, 2);
        }

        return  sumOfSquareOfDigits;
    }

    private static boolean isHappyNumber(int number) {

        int slowPointer = number;
        int fastPointer = sumOfSquaredDigits(number);

        while(fastPointer != 1 && slowPointer != fastPointer) {

            slowPointer = sumOfSquaredDigits(slowPointer);
            fastPointer = sumOfSquaredDigits(sumOfSquaredDigits(fastPointer));
        }

        return fastPointer == 1;
    }

    public static void main(String[] args) {

        int a[] = {1, 5, 19, 25, 7};
        for (int i = 0; i < a.length; i++) {
            System.out.println((i + 1) + ".\tInput Number: " + a[i]);
            String output = isHappyNumber(a[i]) ? "True" : "False";

            System.out.println("\n\tIs it a happy number? " + output);
            System.out.println(new String(new char[100]).replace('\0', '-'));

        }
    }



}
