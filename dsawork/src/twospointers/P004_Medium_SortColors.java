package twospointers;

import java.util.Arrays;

public class P004_Medium_SortColors {

    /*
    Explore how to efficiently sort an array containing red, white,
    and blue colors represented by 0, 1, and 2 using the two pointers approach. Understand
    how to implement this one pass algorithm without extra space and apply it to
    coding interview problems involving linear data structures.
    */

    /*

    Statement
    You are given an array nums of length n, where each element represents an object colored either red,
    white, or blue. The integers 0, 1, and 2 are used to represent red, white, and blue, respectively.

    Sort the array in place so that all objects of the same color are grouped together,
    arranged in the order: red (0), white (1), and blue (2).

    You must solve this problem without using any library sort function.
     */

    //sdsdsdsdsd

    /*

    font color for comment 1DA043

    public static int[] sortColors (int[] colors) {
        // Initialize three pointers to partition the array:
        // 'low' to track the boundary where the next 0 (red) should be placed.
        // 'mid' to scan the current element during the one-pass traversal.
        // 'high' to track the boundary where the next 2 (blue) should be placed.

        // Iterate through the array while the scanning pointer 'mid' is less than or equal to 'high'.
            // If the element at the 'mid' pointer is 0:
                // Swap the element at 'mid' with the element at 'low'.
                // Increment both the 'low' and 'mid' pointers.

            // Else if the element at the 'mid' pointer is 1:
                // This represents the white color, which belongs in the middle.
                // Simply increment the 'mid' pointer to move to the next element.

            // Otherwise (the element must be 2):
                // Swap the element at 'mid' with the element at the 'high' pointer.
                // Decrement the 'high' pointer to shrink the unsorted boundary from the right.
                // Do not increment 'mid' yet, as the element swapped from 'high' needs to be inspected.

        // Return the modified array which is now sorted in-place.
        return colors;
    }

    */

    private static int[] sortColors(int[] colors) {


        int low = 0;
        int mid = 0;
        int high = colors.length - 1;

        while (mid <= high ) {

                                        /*
                                         0,2,1   [ l = 0, m = 0, h = 2 ]
                                         0,2,1   [ l = 1, m = 1, h = 2 ]
                                         0,1,2   [ l = 1, m = 1, h = 1 ]
                                         */
                                        /*
                                         1,2,0   [ l = 0, m = 0, h = 2 ]
                                         1,2,0   [ l = 0, m = 1, h = 2 ]
                                         1,0,2   [ l = 0, m = 1, h = 1 ]
                                         0,1,2   [ l = 1, m = 2, h = 1 ]
                                         */
            if(colors[mid] == 0) {

                int temp = colors[mid];
                colors[mid] = colors[low];
                colors[low] = temp;
                low++;
                mid++;
            }
            else if(colors[mid] == 1) {
                mid++;

            }
            else {
                int temp = colors[mid];
                colors[mid] = colors[high];
                colors[high] = temp;
                high--;
            }

        }

        return colors;

    }

    public static void main(String[] args) {

        int[][] testCases = {
                {1, 2, 0},
                {0},
                {2, 2, 1, 1, 0, 0},
                {1, 0, 2, 1, 0, 2, 1},
                {2, 1, 0, 0, 1, 2, 2, 0, 1},
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] nums = testCases[i];
            int[] inputCopy = nums.clone();
            P004_Medium_SortColors.sortColors(nums);
            System.out.println((i + 1) + ".\tInput array: " + Arrays.toString(inputCopy));
            System.out.println("\tResult: " + Arrays.toString(nums));
            System.out.println("-".repeat(100));
        }

    }

}
