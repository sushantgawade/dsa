package twospointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P002_Medium_SumOfThreeValues {

    /*
    Explore the 3Sum problem to identify all unique triplets in an array that sum to zero.
    Learn to apply the two pointers technique effectively to handle linear data structures and avoid duplicates.

    Statement
    Given an integer array nums, find all unique triplets [nums[i], nums[j], nums[k]]
    where i, j, and k are distinct indices, such that the three elements sum to zero.

    The result must not contain any duplicate triplets. The order of the output
    and the order of elements within each triplet does not matter.
    
    */


    private List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> threeSumList = new ArrayList<>();

        Arrays.sort(nums);

        int n = nums.length;

        for(int i =0; i < n-2;i++) {

            int left = i + 1;
            int right = n - 1;

            if(i > 0 && nums[i] == nums[i+1]) {
                continue;
            }

            if(nums[i] > 0) {
                break;
            }

            while(left < right) {

                int count = nums[i] + nums[left] + nums[right];

                if(left < right && count < 0) {
                    left++;
                }
                else if(left < right && count > 0) {
                    right--;
                }
                else {

                    threeSumList.add(Arrays.asList(nums[i] , nums[left] , nums[right]));

                    while (nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;

                }
            }


        }



        return threeSumList;

    }


    public static void main(String[] args) {

        P002_Medium_SumOfThreeValues sol = new P002_Medium_SumOfThreeValues();
        int[][] testCases = {
                {-2, 0, 1, 1, 2},
                {1, -1, -1, 0},
                {-4, -2, -1, 0, 1, 2, 3, 4},
                {3, -3, 0, -1, 1, 2, -2},
                {-5, -3, -1, 0, 1, 2, 3, 5},
        };

        for (int idx = 0; idx < testCases.length; idx++) {
            int[] nums = testCases[idx].clone();
            List<List<Integer>> result = sol.threeSum(nums);
            System.out.println((idx + 1) + ".\tInput array: " + Arrays.toString(testCases[idx]));
            System.out.println("\tResult: " + result);
            System.out.println("-".repeat(100));
        }

    }



       /* public List<List<Integer>> threeSum(int[] nums) {
        # Sort the input array in ascending order to simplify duplicate handling and enable two-pointer traversal.

        # Initialize an empty list to store the unique triplets found.

        # Determine the size of the input array.

        # Iterate through the array using a fixed pointer 'i' as the first element of the triplet.
            # If the current element is the same as the previous element (for i > 0):
                # Skip this iteration to avoid generating duplicate triplets.

            # If the current element at index 'i' is already greater than zero:
                # Break the loop since the sorted array contains no more elements that can sum to zero.

            # Initialize two pointers: 'left' at i + 1 and 'right' at the last index of the array.

            # While the 'left' pointer is strictly less than the 'right' pointer:
                # Calculate the current sum of elements at indices i, left, and right.

                # If the sum is less than zero:
                    # Increment the 'left' pointer to move toward larger values and increase the sum.

                # Else if the sum is greater than zero:
                    # Decrement the 'right' pointer to move toward smaller values and decrease the sum.

                # Otherwise, the sum is exactly zero:
                    # Construct a triplet list using elements at i, left, and right, and add it to the result list.

                    # While the 'left' pointer is less than 'right' and the next element at 'left' is a duplicate:
                        # Move the 'left' pointer forward.

                    # While the 'left' pointer is less than 'right' and the previous element at 'right' is a duplicate:
                        # Move the 'right' pointer backward.

                    # Move both pointers inward to continue the search for the next distinct pair.

        # Return the final list of unique triplets.
        }*/
}
