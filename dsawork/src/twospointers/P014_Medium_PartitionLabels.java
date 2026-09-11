package twospointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P014_Medium_PartitionLabels {

    /*

    Explore how to apply the two pointers technique to partition a string into as many parts as possible,
    making sure each character appears in only one part. Understand the problem constraints, practice solution
    development, and gain skills to solve similar linear data structure challenges efficiently.

    Statement
    You are given a string s. Your task is to divide the string into as many parts as possible such that each
    letter appears in at most one part.

    In other words, no character should occur in more than one partition. After concatenating all parts in order,
    the result should be the original string s.

    For example, given s = "bcbcdd", a valid partition is ["bcbc", "dd"]. However, partitions like ["bcb", "cdd"]
    or ["bc", "bc", "dd"] are invalid because some letters appear in multiple parts.

    Return a list of integers representing the sizes of these partitions.

    Solution

    The solution employs a two pointer approach combined with a last-occurrence map to divide the string, s, into the maximum number of contiguous partitions, such that each character appears in at most one part. At first glance, the problem appears to be tricky because the challenge lies in determining where to split the string. If we try to make a partition at the first occurrence of a character, it may fail. For example, in s = "abacbc", if we cut right after 'a', we get "a" and "bacbc", which is invalid because 'a' appears again later. This observation indicates that a valid partition must extend until the last occurrence of every character it contains. To solve this, we first determine the last position of each character in the string. Then, while iterating through s, we use two pointers: one marking where the current partition begins, and the other tracking how far it must extend to include all occurrences of the characters seen so far. As we move through the string, we keep updating the first pointer based on the characters we encounter. When we reach the second pointer, it means the current partition is complete (all characters in it appear only within this section). We record its size, reset the first pointer to start a new partition, and continue scanning. This approach ensures we form valid partitions that contain all necessary characters while maximizing the number of partitions.

    Now, let’s look at the steps of the solution:

    We create an array, lastOccurrence, of size
    26
    26
     (for each lowercase English letter) to store the last index of each character in s.

    Next, we iterate through the string s, and store the last index of each character in lastOccurrence.

     We initialize partitionStart and partitionEnd with    0
     to mark the beginning of the current partition and to represent the farthest boundary that the current partition must reach, respectively.

    We also create a list partitionSizes to store the sizes of completed partitions.

    Next, we iterate through s again:

    Update partitionEnd to the maximum of its current value and the last occurrence of the current character.

    If the current index reaches partitionEnd, it means the partition is complete, so we cut the partition:

    Compute the partition size (i - partitionStart + 1) and add it to partitionSizes.

    Update partitionStart to i + 1 for the next partition.

    After finishing the iteration, return partitionSizes, which holds the lengths of all valid partitio

     */

    private List<Integer> partitionLabels(String s) {

        List<Integer> partitionSizes = new ArrayList<>();

        return partitionSizes;
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList(
                "ababcbacadefegdehijhklij",
                "eccbbbbdec",
                "caedbdedda",
                "abcdef",
                "bcbcdd"
        );

        int i = 0;
        for (String s : strings) {
            P014_Medium_PartitionLabels obj=new P014_Medium_PartitionLabels();
            System.out.println((i + 1) + ".\ts: " + s);
            List<Integer> result = obj.partitionLabels(s);
            System.out.println("\n\tPartition sizes: " + result);
            System.out.println("----------------------------------------------------------------------------------------------------");
            i++;
        }
    }


}
