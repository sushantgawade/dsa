package twospointers;

import java.util.Arrays;

public class P019_Easy_RemoveDuplicatesFromSortedArray {


    /*

    Statement
    You are given an integer array nums that is already sorted in non-decreasing order. Your task is to remove
    the duplicate values in-place so that each element in the array appears only once, while preserving the
    original relative order of the elements.

    After removing the duplicates, let k be the number of unique elements remaining in the array. The first k
    positions of nums should contain these unique elements in sorted order. Any values beyond index k - 1 are
    irrelevant and can be ignored.

    Your goal is to modify the array in-place and return the value k, representing the count of unique elements.

    Solution
    The algorithm removes duplicates from a sorted array in-place using the two pointer technique. As the array is already sorted, all duplicate elements appear consecutively in the array. This allows us to keep only one occurrence of each value and overwrite duplicates as we encounter new unique elements, without using any extra space.

    To achieve this, one pointer maintains the boundary of the unique portion of the array, while the other scans through the remaining elements. Whenever a new value is found, it is placed immediately after the last unique element. By the end of the scan, the beginning of the array contains all unique elements in sorted order.

    The steps of the algorithm are as follows:

    Initialize pointer i = 0, marking the position of the last unique element found.

    Iterate through the array using pointer j, starting from index 1 until the end of the array.

    For each index j, compare nums[j] with nums[i].

    If they are different:

    Increment i because a new unique value should be placed next.

    Assign nums[i] = nums[j] to store the new unique element.

    Return i + 1, which represents the total number of unique elements in the array.

    Let’s look at the following illustration to get a better understanding of the solution:


    public static int removeDuplicates(int[] nums) {
        // Initialize a pointer i at the beginning of the array to keep track of the position of unique elements.

        // Iterate through the array with a second pointer j starting from the second element (index 1).

            // Compare the current element at index j with the last identified unique element at index i.
            // If the element at index j is different from the element at index i, a new unique element has been found.

                // Increment the i pointer to move to the next available slot for a unique value.

                // Copy the unique element found at index j into the position at index i.

        // The total number of unique elements is the index of the last unique element plus 1.
        // Return the count of unique elements (i + 1).
    }

     */

    private static int removeDuplicates(int[] arr) {

        int i =0;

        for( int j = 1; j < arr.length; j++ ) {

            if(arr[j] != arr[i]) {

                i++;

                arr[i] = arr[j];

            }

        }
        return i + 1;

    }



    public static void main(String[] args) {
        int[][] testCases = {
                {1, 1, 2, 2, 3},
                {-1, -1, 0, 0, 1, 1, 2},
                {5, 5, 5, 5},
                {1, 2, 3, 4},
                {0}
        };

        for (int idx = 0; idx < testCases.length; idx++) {
            int[] nums = testCases[idx];

            System.out.println((idx + 1) + ".\tnums: " + Arrays.toString(nums));

            // because function modifies in-place
            int[] arr = Arrays.copyOf(nums, nums.length);

            int k = removeDuplicates(arr);

            System.out.println("\n\tUnique Count (k): " + k);

            System.out.print("\tArray After Removing Duplicates: [");
            for (int i = 0; i < k; i++) {
                if (i > 0) System.out.print(", ");
                System.out.print(arr[i]);
            }
            System.out.println("]");
            System.out.println("----------------------------------------------------------------------------------------------------");
        }
    }



}
