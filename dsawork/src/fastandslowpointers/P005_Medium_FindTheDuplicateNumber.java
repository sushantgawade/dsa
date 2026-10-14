package fastandslowpointers;

import java.util.Arrays;

public class P005_Medium_FindTheDuplicateNumber {

    /*
    Problem: Find The Duplicate Number
    med
    30 min
    Hint
    Understand how to detect a duplicate number in an array where values range from 1 to n using the fast and slow pointer technique. Explore the constraints, problem statement, and strategies to solve this challenge efficiently without modifying the original array or using extra space.
    Statement
    Given an array of positive numbers, nums, such that the values lie in the range [1,n], inclusive, and that there are n+1
     numbers in the array, find and return the duplicate number present in nums. There is only one repeated number in nums, but it may appear more than once in the array.

    Solution
    This solution involves two key steps: identifying the cycle and locating the entry point of this identified cycle, which represents the duplicate number in the array.

    The fast and slow pointers technique detects such cycles efficiently, where one pointer takes one step at a time and the other advances by two steps. Initially pointing at the start of the array, the position of each pointer for the next step is determined by the current value they are pointing to. If a pointer points to the value
    5 at index 0, its next position will be index 5. As the pointers traverse the array, both will eventually catch up because there’s a cycle. This is because, in the noncyclic part, the distance between the pointers increases by one index in each iteration. However, once both pointers enter the cyclic part, the fast pointer starts closing the gap on the slow pointer, decreasing the distance by one index each iteration until they meet.

    Once the duplicate number is confirmed, we reset one of the pointers (usually the slow pointer) to index 0 while the other stays at the position where the pointers met. Then, both pointers move one step at a time until they meet again. With this positioning and pace of pointers, pointers are guaranteed to meet at the cycle’s starting point, corresponding to the duplicate number.

    Now, let’s look at the detailed workflow of the solution:

    For this problem, the duplicate number will create a cycle in the nums array. The cycle in the nums array helps identify the duplicate number.

    To find the cycle, we’ll move in the nums array using the f(x)=nums[x] , where x
     is the index of the array. This function constructs the following sequence to move:

     x, nums[x], nums[nums[x]], nums[nums[nums[x]]], ...


    In the sequence above, every new element is an element in nums present at the index of the previous element.

    Let’s say we have an array,
    [2, 3, 1, 3]
    . We’ll start with
    x=nums[0]    , which is 2 , present at the    0 th

     index of the array and then move to nums[x], which is 1 , present at the 2 nd

     index. Since we found 1 at the 2 nd

     index, we’ll move to the    1 st

    , and so on. This example shows that if we’re given an array of length n+1 , with values in the range
    [1, n]
    , we can use this traversal technique to visit all the locations in the array.


    Now, let's dive deep into how our two parts of the solution work.

In the first part, the slow pointer moves once, while the fast pointer moves twice as fast as the slow pointer until
both of the pointers meet each other. Since the fast pointer is moving twice as fast as the slow pointer,
it will be the first one to enter and move around the cycle. At some point after the slow pointer also enters and
moves in the cycle, the fast pointer will meet the slow pointer. This will be the intersection point.

In part two, we’ll start moving again in the cycle, but this time, we’ll slow down the fast pointer so that it moves with the same speed as the slow pointer.

Let’s look at the journeys of the two pointers in part two:

The slow pointer will start from the 0th position.

The fast pointer will start from the intersection point.

After a certain number of steps, let’s call it F, the slow pointer meets the fast pointer. This is the ending point for both pointers.

This common ending position will be the entry point of the cycle.

Let’s look at the visual presentation of the second part of our solution:

Now, let’s try to understand how it is that our solution is able to always locate the entry point of the cycle.

Let’s return to the example we just discussed, using this graphical representation:

7
 is the intersection point where the slow and fast pointers will meet.
8
 is the entry point of the cycle, which is our duplicate number.

The fast pointer is traversing two times faster than the slow pointer. This can be represented by the following equation:


fast
​
 =2d
slow
​

 ———
(1)

Here,
d
 represents the number of elements traversed.

Let’s look at the following diagram to see the steps taken by the slow and fast pointers from the starting point to the intersection


In the diagram above:

Green represents the entry point of the cycle.

Blue represents the intersection point.

Yellow represents the starting point.F
 represents the steps taken from the starting point to the entry point.
a
 represents the steps taken to reach the intersection point from the entry point.

C
 represents the cycle length, in terms of the number of steps taken to go once around the cycle.

With this setup in mind, let’s see the distance traveled by the slow and fast pointers.

The slow pointer travels
F
 steps from the starting point to the entry point of the cycle and then takes
a
 steps from the entry point to the intersection point of the cycle, that is, the point where both pointers intersect. So, we can express the distance traveled by the slow pointer in the form of this equation:


d
slow
​
 =F+a
———

 (2)

In the time it takes the slow pointer to travel
F+a
 steps, the fast pointer, since it’s traveling twice as fast as the slow pointer, will have also traveled around the cycle at least once. So, we can say the fast pointer, first, travels
F
 steps from the starting point to the entry point of the cycle, then travels at least a cycle, and at the end travels
a
 steps from the entry point to the intersection point of the cycle. Now, we can express the distance traveled by the fast pointer as the following equation:

d
fast
​
 =F+C+a
———

 (3)

Recall eq.
(1):

d
fast
​
 =2d
slow
​

 ———
(1)

If we substitute the equivalent expression of
d
slow
​

 given in eq.

(2)
 and the equivalent expression of

d
fast
​

 given in eq.
(3)
 into eq.
(1)
, we get:


F+C+a=2(F+a)

Let’s simplify this equation:

F+C+a=2F+2a


C=F+a

Therefore, the distance from the starting point to the intersection point,
F+a
, equals
C
.

We can also re-arrange this equality as follows:


F=C−a

Let’s consult our diagram again:


As we can see,
C−a
 is, in fact, the distance from the intersection point back to the entry point. This illustrates why, when we move one pointer forward, starting at the intersection point, and another pointer from the starting point, the point where they meet is the entry point of the cycle.

Note: The proof above does not consider the case where
F
 is longer than the length of the cycle. In this situation, it’s possible that the fast pointer will go around the cycle more than once. To express this more general case, we can say that the distance covered by the fast pointer from the entry point to the intersection point is:
F+nC+a
, where
n
 is a positive integer. As a result, our substitution will take this form:
F+nC+a=2(F+a)
, which simplifies to
nC=F+a
, that is:
F=nC−a
. This simply means that after going around the cycle
n
 times, the fast pointer will still be
a
 steps behind the entry point of the cycle.

Let’s look at the implementation of the solution discussed above:

Time complexity
The time complexity of the algorithm is
O(n)
, where
n
 is the length of nums. This is because, in each part of the solution, the slow pointer traverses nums just once.

Space complexity
The algorithm takes
O(1)
 space complexity, since we only used constant space to store the fast and slow pointers.


The following example illustrates this traversal:


 public static int findDuplicate(int[] nums) {
        // Initialize two pointers, slow and fast, at the first element of the array.

        // Phase 1: Use Floyd's Cycle-Finding algorithm to detect the presence of a cycle.
        // Traverse the array until the slow and fast pointers meet:
            // Advance the slow pointer by one step (move to the index indicated by its current value).
            // Advance the fast pointer by two steps (move twice to the index indicated by the current values).
            // If the slow pointer matches the fast pointer:
                // The cycle has been detected; exit the loop to proceed to the next phase.

        // Phase 2: Locate the entrance of the cycle, which corresponds to the duplicate number.
        // Reset the slow pointer back to the beginning of the array.
        // Move both the slow and fast pointers forward one step at a time:
            // Advance the slow pointer by one step.
            // Advance the fast pointer by one step.
            // If the slow pointer equals the fast pointer:
                // The point of collision is the duplicate element.

        // Return the value of the duplicate number identified at the meeting point.
        return 0;
    }

     */

    private static int findDuplicate(int[] nums) {


        /*
        The Setup$A$ = Distance from start to the loop entrance.$B$ = Distance
        from loop entrance to the crash point.$C$ = The rest of the loop (from crash point back to the entrance).
        Notice that $B + C$ = The total length of one full loop.The Two Facts We Knowslow walked: $A + B$ steps.
        fast walked: $2(A + B)$ steps (because it moves at twice the speed).Connecting ThemBecause fast is
         moving twice as fast, by the time they crash, fast has gone around the loop one full extra time
         compared to slow.That means fast's total distance is equal to slow's distance plus 1
         full loop:$$\text{Fast distance} = \text{Slow distance} + (B + C)$$Now, let's plug our actual
         formulas into that sentence:$$2(A + B) = (A + B) + (B + C)$$Watch What Happens When We
         SimplifySubtract $(A + B)$ from both sides of the equals sign:$$A + B = B + C$$Look at
         what is on both sides: there is a $B$ on the left and a $B$ on the right! If you subtract
         $B$ from both sides, it completely disappears:$$A = C$$That’s it! That is why Distance $A$ equals Distance $C$.
         */

        int slow = nums[0];
        int fast = nums[0];

        while(true) {

            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast) {
                break;
            }

        }

        /*
        What the Code Does Step-by-Step
        slow = nums[0]; (Reset):
        You take your slow pointer and teleport it all the way back to the starting line, while fast stays frozen right at the collision point inside the loop.

        slow = nums[slow]; fast = nums[fast]; (Step together):
        You now move both pointers forward at the exact same speed (1 step at a time).

        The Meeting Point:
        Since
        A=C, if slow walks forward by distance
        A (from the start to the cycle entrance) and fast walks forward by distance
        C (from the collision point around the loop to the cycle entrance), they are guaranteed to collide face-to-face right at the entrance of the cycle!

        The moment slow == fast, that index is the exact starting node of the cycle, and you return it.
         */

        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return fast;
    }

    public static void main(String[] args) {

        int[][] nums = {
                {1, 3, 2, 3, 5, 4},
                {2, 4, 5, 4, 1, 3},
                {1, 6, 3, 5, 1, 2, 7, 4},
                {1, 2, 2, 4, 3},
                {3, 1, 3, 5, 6, 4, 2}
        };
        for (int i = 0; i < nums.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tnums = "+ Arrays.toString(nums[i]));
            System.out.println("\tDuplicate number = "+ findDuplicate(nums[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }

}
