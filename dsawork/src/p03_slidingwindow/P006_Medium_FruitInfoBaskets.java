package p03_slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class P006_Medium_FruitInfoBaskets {


    /*
    Problem: Fruit Into Baskets
    med
    30 min
    Explore how to apply the sliding window pattern to solve the Fruit Into Baskets problem. Learn to maximize fruit collection from a row with two baskets following specific rules. Understand problem constraints and develop an optimized approach for efficient solutions.
    Statement
    While visiting a farm of fruits, you have been given a row of fruits represented by an integer array, fruits,
    where fruits[i] is the type of fruit the  i th tree produces. You have to collect fruits, but there are some rules that you must follow while collecting fruits:

    You are given only two baskets, each capable of holding an unlimited quantity of a single type of fruit.

    You can start collecting from any tree but must collect exactly one fruit from each tree (including the starting tree) while moving to the right.

    You must stop while encountering a tree with a fruit type that cannot fit into any of your baskets.

    Return the maximum number of fruits you can collect following the above rules for the given array of fruits.

    Solution
    The challenge is to collect as many fruits as possible from a row of trees, each producing a specific type of fruit. We only have two baskets available; each can hold exactly one type of fruit, but there is no limit to the quantity of fruit(single type) a basket can hold. This means we can only collect at most two distinct types of fruits.

    The solution uses the sliding window pattern because it helps manage the range of trees being considered. It starts from a small window and expands it as more trees are added, allowing maximum fruit collection. However, if the number of fruit types exceeds two, the window reduces its size from the left until it becomes valid again (with only two fruit types). The solution keeps sliding the window and keeping track of the largest valid window size that represents the maximum number of fruits that can be collected.

    Here’s the step-by-step explanation of the solution:

    We initialize a hash map, baskets, to track the count of each fruit type available in the current window and a variable left to mark the start of the current window.

    We also create a variable, collected, to store the number of fruits we can collect.

    We then iterate through the fruits array, starting from the leftmost tree and moving toward the end of the array. We do the following for each tree while iterating:

    Add the fruit type as a key in baskets and increment the count against it by 1.

    If the length of baskets exceeds 2, the number of distinct fruit types is more than 2 in the current window.

    We remove the fruit from the left of the current window until the window has at most 2 types of fruit.

    If the count of a fruit becomes zero:

    We remove it from the baskets.

    Next, we increment the left by 1 to move the window forward.

    After adjusting the window, we compute the maximum number of fruits that can be collected from the current window using the formula:
    maximum(collected, right  -  left  +  1). We store this value in collected.

    After iterating through fruits, we return collected, representing the maximum number of collected fruits.

    Let’s look at the following illustration to get a better understanding of the solution:

    Let’s look at the code for the algorithm we just discussed:

    Time complexity
    The time complexity of this solution is  O(n), where n is the total number of fruit trees. This is because
    the left and right boundaries of the sliding window visit each fruit exactly once, resulting in 2n
     operations. Furthermore, adding or deleting one fruit in the hash map takes constant time. Therefore, the overall time complexity becomes
    O(n).

    Space complexity
    The space complexity of this solution is O(1) because there are at most 3 types of fruits in the window or the baskets at any given time.




    public static int totalFruit(int[] fruits) {
        // Initialize a hash map to keep track of the types of fruits and their counts in the current window.
        // Initialize a variable to store the maximum number of fruits collected.
        // Initialize a pointer for the start of the sliding window.

        // Iterate through the fruits array using a pointer for the end of the sliding window.
            // Add the fruit at the current end position to the baskets (hash map).
            // Increment the count for this fruit type in the map.

            // Check if the number of unique fruit types in the baskets exceeds the limit of two.
            // If we have more than two types, shrink the window from the left side.
                // While the baskets contain more than two types of fruits:
                    // Identify the fruit type at the start of the window.
                    // Decrement its count in the baskets map.
                    // If the count of that fruit type reaches zero, remove it from the map.
                    // Move the start pointer one step forward to the right.

            // Calculate the current window size (end pointer - start pointer + 1).
            // Update the maximum fruits collected if the current window size is greater than the current maximum.

        // Return the maximum fruits collected.
    }


     */

    private static int totalFruit(int[] fruit) {

        Map<Integer, Integer> map = new HashMap<>();

        int left = 0;

        int collected = 0;

        for(int right = 0;  right < fruit.length; right++) {

            map.put(fruit[right], map.getOrDefault(fruit[right], 0) + 1);

            while(map.size() > 2) {

                map.put(fruit[left], map.get(fruit[left]) - 1  );

                if(map.get(fruit[left]) == 0) {
                    map.remove(fruit[left]);
                }

                left++;
            }

            collected = Math.max(collected, right - left + 1);

        }

        return collected;

    }

    public static void main(String[] args) {


        int[][] fruits = {{3,4,2,1,3,2},
                {2,2,2,3,1,2,4,4,4,4},
                {1,1,1,1,1,1,1,1,1,1},
                {2,3,4,1,3,3,1,2,3,4,1,5,2,5,7,7},
                {5,4,3,2,1,1}};

        for (int i = 0; i < fruits.length; i++) {
            System.out.print((i + 1) + ".\tFruits: [");
            for (int j = 0; j < fruits[i].length; j++) {
                if (j > 0) System.out.print(", ");
                System.out.print(fruits[i][j]);
            }
            System.out.println("]");
            System.out.println("\n\tMaximum number of fruit(s) collected: " + totalFruit(fruits[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }
}
