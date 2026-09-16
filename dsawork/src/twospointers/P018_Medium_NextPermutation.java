package twospointers;

public class P018_Medium_NextPermutation {

    /*

    Statement
Your task is to rearrange an array, nums, containing positive integers to form the next lexicographically greater permutation. This means finding the next permutation in the sequence of all possible arrangements sorted in dictionary order.

For example, given the array [4,5,6], the next permutation is [4,6,5]. In the same way, [5,6,4] becomes [6,4,5].
If the array is already in its highest possible order (sorted in descending order), such as [6,5,4], it’s not possible
to find a lexicographically larger permutation. In this case, you must rearrange the array to its lowest possible order
(sorted in ascending order), which would be
[4,5,6].

The entire operation must be completed in-place while using only a constant amount of extra memory.


Solution
The problem asks us to find the next permutation of a given array of numbers. This is the next “dictionary order” (lexicographical) arrangement of the same numbers. We can solve this problem using a two pointers (or more accurately, a “two-index”) approach, as it allows us to efficiently find the two critical positions in the array that need to be changed.

We use one pointer (or index) to find the “pivot” element we need to increase, and a second pointer to find the “successor” element to swap it with. This targeted, two-index approach enables us to perform the minimal change required, which is crucial for finding the next permutation and satisfying the in-place, constant-memory constraints. To find the next smallest permutation that is larger than the current one, we need to make the smallest possible increase. This is done by modifying the “least significant” part of the array (the right-hand side) first. To do this, we make the smallest possible increase to the number, working from right to left:

Find the pivot: We scan from the right to find the first element (pivot) that is smaller than its right neighbor. This is the element we will increase.

Find the successor: We scan from the right again to find the smallest element (successor) that is larger than the pivot.

Swap: We swap the pivot and the successor.

Reverse the suffix: We reverse the part of the array to the right of the pivot’s original position. This ensures the new suffix is in its smallest possible order (ascending). This single reverse operation also cleverly handles both possible scenarios:

Case 1 (pivot is found): The suffix (from i + 1
 onward) was previously in descending order. Reversing it sorts it into ascending order. This makes the new permutation as small as possible, ensuring it’s the immediate next one.

Case 2 (no pivot is found): If the array were already in its largest order (e.g.,[3,2,1]), the first loop would finish with i=−1. This final step will then reverse from i+1 (which is index 0)
to the end, correctly transforming the entire array into its smallest possible order (e.g., .[1,2,3]).

Here’s a step-by-step breakdown of the code:

We initialize an index i to the second last element of nums.

Next, we iterate backward starting from i to find the “pivot”. This is the rightmost element that can be changed to increase the permutation’s size.

Then, we check if a pivot is actually found (i.e., i is greater than or equal to 0).

If a pivot is found, we initialize a second index, j, to the last element of nums.

Then, we iterate backward from j to find the “successor”. This is the smallest possible number in the suffix that we can swap with the pivot.

Once the “successor” is found, we swap the pivot nums[i] with its successor nums[j]. This guarantees the new permutation is larger than the original.

Finally, we reverse the portion of the array that comes after the pivot’s original index i (i.e., from index i + 1 to the end).

Let’s look at the following illustration to get a better understanding of the solution:

 private void swap(int[] nums, int i, int j) {
        // Store the value at index i in a temporary variable.
        // Assign the value at index j to index i.
        // Assign the value in the temporary variable to index j.
    }

    public void nextPermutation(int[] nums) {
        // Initialize a pointer to the second-to-last element.
        // Iterate backwards to find the first index 'i' where the element is smaller than the next element (the pivot).
            // Decrement the index while the sequence is non-increasing.

        // If a pivot is found (the index is not negative):
            // Initialize another pointer at the end of the array.
            // Iterate backwards from the end to find the first element that is strictly greater than the pivot element.
                // Decrement the pointer while elements are less than or equal to the pivot.

            // Swap the pivot element with the larger element found to its right.

        // Reverse the entire suffix starting immediately after the pivot index.
        // This ensures the suffix is in the smallest possible lexicographical order.
    }

    private void reverse(int[] nums, int start, int end) {
        // Use two pointers starting at 'start' and 'end' positions.
        // While the start pointer is less than the end pointer:
            // Swap the elements at the start and end indices.
            // Move the start pointer forward.
            // Move the end pointer backward.
    }

*/

    private void nextPermutation(int[] testCase) {
    }


    public static void main(String[] args) {

        int[][] testCases = {
                {4, 1, 5, 2, 9, 3, 7},
                {8, 2, 6, 4, 7, 5},
                {7, 6, 4, 3, 1},
                {2, 6, 8, 7, 8, 7, 9, 4, 1, 2, 4, 5, 8},
                {1, 2}
        };

        for (int i = 0; i < testCases.length; ++i) {
            System.out.print((i + 1) + ".\t Original array: [");
            for (int j = 0; j < testCases[i].length; ++j) {
                System.out.print(testCases[i][j]);
                if (j != testCases[i].length - 1)
                    System.out.print(", ");
            }
            System.out.println("]");

            P018_Medium_NextPermutation sol = new P018_Medium_NextPermutation();
            sol.nextPermutation(testCases[i]);

            System.out.print("\t Next permutation: [");
            for (int j = 0; j < testCases[i].length; ++j) {
                System.out.print(testCases[i][j]);
                if (j != testCases[i].length - 1)
                    System.out.print(", ");
            }
            System.out.println("]");

            System.out.println("-".repeat(100));
        }
    }



}
