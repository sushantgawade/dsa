package twospointers;

public class P015_Easy_RemoveElement {


    /*

        Understand how to use the two pointers pattern to remove all instances of a specific value from an array in place. This lesson teaches efficient array modification without extra memory allocation and returns the new length of the array excluding the target value. Practice this approach to prepare for coding interviews that test your mastery of array manipulation and pointers.
    Statement
    You are given an integer array, nums, and an integer, val. Your task is to remove all occurrences of val from nums in place, meaning no additional memory allocation should be used. The relative order of the elements in the array may be changed. After modifying the array, return the number of elements that are not equal to val.

    Let k represent the number of elements in nums that are not equal to val. To successfully solve this problem, you need to ensure the following:

    Modify the array, nums, such that the first k elements contain values that are not equal to val.

    The remaining elements in the array do not matter, and the size of nums is irrelevant after the first k elements.

    Return the value of k.

     */

    // Initialize a pointer 'k' to 0 to track the position of elements that are not equal to 'val'.
    // This pointer will also represent the count of such elements.

    // Iterate through each element in the array 'nums'.
    // Check if the current element is not equal to 'val'.

    // If the element does not equal 'val', move it to the position 'k' in the array.

    // Increment 'k' by 1 to prepare for the next non-matching element.

    // After the loop finishes, return the value of 'k', which is the count of elements not equal to 'val'.

    /*
    Solution
    The key intuition behind this solution is to use two pointers to efficiently overwrite unwanted elements in place. One pointer scans through the entire array, while the other keeps track of the position where the next element not equal to val should go. Each time we encounter an element that differs from val, we move it forward to its correct position. After completely traversing the array, all valid elements are shifted to the front, and the position pointer indicates the new length of the array.

    Initialize an iterator, k, with 0 to be at the start of the array.

    Initialize another iterator, j, with 0 to iterate over the array. For each integer, nums[j]:

    If it’s not equal to val, put the integer nums[j] at nums[k] and increment k.

    After the loop, return k representing the count of elements not equal to val.

    Let’s look at the following illustration to get a better understanding of the solution:
     */

    private int removeElement(int[] nums, int val) {

        int k =0;

        for ( int j = 0; j < nums.length; j++) {

            if(nums[j] != val) {
                nums[k] = nums[j];
                k++;
            }

        }

        return k;
    }

    public static void main(String[] args) {

        int[][] numsArr = {
                {5, 8, 8, 5, 3},
                {50, 49, 48, 47, 46, 45},
                {0, 0, 0, 0, 1, 0, 0, 0, 0},
                {10, 20, 30, 40, 50},
                {0, 50}
        };

        int[] valArr = {5, 48, 0, 25, 0};

        P015_Easy_RemoveElement sol = new P015_Easy_RemoveElement();
        for (int i = 0; i < numsArr.length; i++) {
            System.out.println((i + 1) + ".\tnums: " + java.util.Arrays.toString(numsArr[i]));
            System.out.println("\tval: " + valArr[i]);
            System.out.println("\tk: " + sol.removeElement(numsArr[i], valArr[i]));
            System.out.println("-".repeat(100));
        }

    }



}
