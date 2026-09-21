package twospointers;

public class P023_Medium_CompareVersionNumbers {

    /*

    Statement
    Given two version strings, version1 and version2, compare them. A version string is composed of revisions separated by dots ('.'). Each revision’s value is determined by converting it to an integer, disregarding any leading zeros.

    Compare the two version strings by evaluating their revision values from left to right. If one version string contains fewer revisions than the other, treat each missing revision as 0.

    Return the result of the comparison as follows:

    Return −1 if version1 is less than version2.

    Return 1 if version1 is greater than version2.

    Return 0 if both versions are equal.

    Solution
The key intuition behind this solution is to split both version strings by the dot delimiter into lists of revision strings, then use two pointers to traverse both lists simultaneously,
comparing corresponding revision values as integers. If one version has fewer revisions than the other, we treat the missing revisions as 0
. At each position, we compare the integer values of the current revisions: if they differ, we immediately return −1 or 1
 depending on which is smaller or larger. If all revisions are equal after the full traversal, we return 0.

Now, let’s look at the solution steps below:

Split version1 by '.' into a list of revision strings called revs1, and split version2 by '.' into a list of revision strings called revs2.

Initialize two pointers, p1 and p2, both set to 0, to track the current position in revs1 and revs2 respectively.

Compute maxLen as the maximum of the lengths of revs1 and revs2. This determines how many revision positions we need to compare.

Iterate while p1 or p2 is less than maxLen:

Retrieve the current revision value val1 by converting revs1[p1] to an integer if p1 is within bounds of revs1; otherwise, default val1 to 0.

Retrieve the current revision value val2 by converting revs2[p2] to an integer if p2 is within bounds of revs2; otherwise, default val2 to 0.

If val1 is less than val2, return −1  immediately since version1 is smaller.

If val1 is greater than val2, return 1 immediately since version1 is larger.

If val1 equals val2, increment both p1 and p2 by 1 and continue to the next revision.

If the loop completes without returning, all corresponding revisions are equal, so return 0.

Let’s look at the following illustration to get a better understanding of the solution

 public int compareVersion(String version1, String version2) {
        // Split the first version string into an array of strings using the dot ('.') as a delimiter.
        // Split the second version string into an array of strings using the dot ('.') as a delimiter.

        // Initialize two pointers or a single counter to iterate through the revision arrays.

        // Determine the maximum length between the two revision arrays to ensure all levels are checked.

        // Iterate through the revisions from left to right up to the maximum length found.
            // Identify the integer value of the current revision in 'version1'.
                // If the current index is within the bounds of the first array:
                    // Convert the revision string to an integer, which automatically ignores leading zeros.
                // Otherwise, if the index exceeds the array length:
                    // Treat the revision value as 0.

            // Identify the integer value of the current revision in 'version2'.
                // If the current index is within the bounds of the second array:
                    // Convert the revision string to an integer.
                // Otherwise, if the index exceeds the array length:
                    // Treat the revision value as 0.

            // Compare the two extracted revision values.
                // If the value from 'version1' is strictly less than the value from 'version2':
                    // Return -1 immediately.
                // If the value from 'version1' is strictly greater than the value from 'version2':
                    // Return 1 immediately.

            // If the values are equal, proceed to the next revision index.

        // If the entire loop completes without returning, it means all compared revisions were equal.
            // Return 0 to indicate both version strings represent the same version.
    }

     */

    private int compareVersion(String v1, String v2) {

    }

    public static void main(String[] args) {

        P023_Medium_CompareVersionNumbers solution = new P023_Medium_CompareVersionNumbers();

        String[][] testCases = {
                {"0.1", "1.1"},
                {"1.0.1", "1"},
                {"7.5.2.4", "7.5.3"},
                {"1.0.0", "1"},
                {"2.0.0.1", "2.0.0.2"},
        };

        for (int i = 0; i < testCases.length; i++) {
            String v1 = testCases[i][0];
            String v2 = testCases[i][1];
            int result = solution.compareVersion(v1, v2);
            System.out.println((i + 1) + ".\tInput array: [\"" + v1 + "\", \"" + v2 + "\"]");
            System.out.println("\tResult: " + result);
            System.out.println("-".repeat(100));
        }

    }


}
