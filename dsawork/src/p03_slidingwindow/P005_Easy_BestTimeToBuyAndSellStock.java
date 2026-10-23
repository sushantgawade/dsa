package p03_slidingwindow;

import java.util.Arrays;

public class P005_Easy_BestTimeToBuyAndSellStock {


    /*
    Problem: Best Time to Buy and Sell Stock
    75
    easy
    15 min
    Explore how to maximize profit by selecting the best days to buy and sell stocks using greedy techniques. Understand the problem constraints and develop an optimal linear time and constant space solution. This lesson helps you apply practical coding patterns to solve common interview questions efficiently.
    Statement
    Given an array, prices, where prices[i] represent the price of a stock on the i-th day, maximize profit by selecting a single day to buy the stock and a different day in the future to sell it.

    Return the maximum profit that can be achieved from this transaction. If no profit can be made, return 0.

    Solution
    So far, you’ve probably brainstormed some approaches and have an idea of how to solve this problem. Let’s explore some of these approaches and figure out which one to follow based on considerations such as time complexity and any implementation constraints.

    Naive approach
    A naive approach to solving this problem is to evaluate all possible combinations of buying and selling the stock to determine the maximum achievable profit. This can be implemented using nested loop:

    The outer loop selects a day to buy the stock by iterating through the prices array.

    The inner loop starts from the day after the chosen buying day and iterates through the remaining days to select the selling day.

    For each combination of buy and sell days, the profit is calculated using the formula: profit = prices[sell] - prices[buy]

    Update the maximum profit if the current profit exceeds the previously recorded maximum. As the algorithm evaluates all possible pairs of buy and sell days, the time complexity is
    O(n 2) , where n is the length of the input array. This approach requires only a constant amount of additional space, so the space complexity isO(1)
    .

    Optimized approach using greedy techniques
    To find the maximum profit efficiently, we use a greedy algorithm that relies on two pointers:

    Buy pointer: It starts on the first day and updates whenever a lower price is encountered, ensuring it always tracks the lowest price so far and represents the best day to buy.

    Sell pointer: Iterates through the price list from the second day onward to identify potential selling days and calculate profits relative to the current buy pointer.

    At each step, the algorithm evaluates the profit achieved by selling on the current day (indicated by the sell pointer) relative to the day marked by the buy pointer. If selling on the current day generates a higher profit than previously recorded, the maximum profit is updated. If the price on the sell day is lower than or equal to the buy day’s price, the buy pointer is adjusted to match the sell day, ensuring a new, more optimal buying point is selected.

    The steps of the algorithm are as follows:

    Initialize the variables below:

    buy = 0: Tracks the index of the day to buy the stock (starts at day 0).

    sell = 1: Tracks the index of the day to sell the stock (starts on day 1, i.e., the day after buying).

    maxProfit = 0: This will store the maximum profit encountered.

    Traverse the prices array using the sell pointer,  ensuring it stays within the array’s bounds. For each pair of buy and sell:

    Compute the current profit as: profit = prices[sell] - prices[buy].

    If the price on the sell day (prices[sell]) is greater than the price on the buy day (prices[buy]), update maxProfit with the greater value between the current profit and the existing maxProfit.

    If the price on the sell day (prices[sell]) is less than or equal to the price on the buy day (prices[buy]), update the buy pointer to the current sell day to select a new, more optimal buying day.

    Increment the sell pointer to explore the next possible selling day.

    After the end of the iterations, maxProfit will hold the maximum achievable profit and return maxProfit.

    Let’s look at the following illustration to get a better understanding of the solution:

    Solution summary
    The algorithm can be summarized in the following steps:

    Initialize buy and sell pointers to 0 and 1 , respectively, and maxprofit to0 .

    Iterate the sell pointer over the prices array until it reaches the end, computing the current profit by subtracting prices[buy] from prices[sell].

    If prices[buy] is less than prices[sell], store the maximum of current profit and maxprofit in maxprofit. Otherwise, update buy to be equal to sell

    Move sell to the next index in the array and continue the loop.

    Return the maxprofit once sell reaches the end of the array.

    Time complexity
    The time complexity of this algorithm isO(n), where n is the length of the prices array.

    Space complexity
    The space complexity of this algorithm is O(1).


    public static int maxProfit(int[] prices) {
        // Initialize a 'buy' pointer to the first day of the prices array (index 0).
        // Initialize a 'sell' pointer to the second day (index 1).
        // Initialize a variable 'maxProfit' to 0 to keep track of the maximum profit found.

        // Iterate through the array while the 'sell' pointer is within the bounds of the array.
            // Calculate the potential profit by subtracting the price at the 'buy' index from the price at the 'sell' index.

            // If the price at the 'buy' index is less than the price at the 'sell' index (profit is possible):
                // Update 'maxProfit' to be the maximum of the current 'maxProfit' and the calculated potential profit.

            // Otherwise, if the price at the 'buy' index is greater than or equal to the price at the 'sell' index:
                // We found a new lower price point for buying, so move the 'buy' pointer to the current 'sell' index.

            // Increment the 'sell' pointer to check the next day's price.

        // After the loop finishes, return the 'maxProfit' value.
        return 0;
    }

     */

    private static int maxProfit(int[] ints) {
    }

    public static void main(String[] args) {

        int[][] pricesList = {
                {1, 2, 4, 2, 5, 7, 2, 4, 9, 0, 9},
                {8, 2, 6, 4, 7, 5},
                {7, 6, 4, 3, 1},
                {2, 6, 8, 7, 8, 7, 9, 4, 1, 2, 4, 5, 8},
                {1, 2}
        };

        for (int i = 0; i < pricesList.length; i++) {
            System.out.println((i + 1) + ". Stock prices = " + Arrays.toString(pricesList[i]));
            System.out.println("   Maximum profit = " + maxProfit(pricesList[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }
}
