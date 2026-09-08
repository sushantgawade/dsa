package twospointers;

public class P006_Easy_ValidWordAbbreviation {

    /*
    Explore how to determine if an abbreviation correctly represents a given word by applying the two pointers technique.
    This lesson helps you handle numeric skips and letter matches, ensuring full coverage without leading zeros or
    missing characters.

    Statement
    A string can be abbreviated by replacing any number of non-adjacent, non-empty substrings
    with their respective lengths. The numeric replacements must not contain leading zeros.

    Given a string word and an abbreviation abbr, determine whether abbr is a valid abbreviation of word.

    The abbreviation abbr consists of lowercase English letters and numeric values. Each numeric value in abbr
    represents the number of characters skipped in word. Letters in abbr must match the corresponding characters
    in word exactly. The abbreviation is valid if and only if it fully accounts for every character in word from
    left to right with no characters remaining or missing.

     */

    private boolean validWordAbbreviation(String word, String abbr) {

        int i = 0, j = 0;
        int wordLength = word.length();
        int abbrLength = abbr.length();

        int num = 0;

        while (i < wordLength   && j < abbrLength ) {

            if(Character.isDigit(abbr.charAt(j))) {


                if(abbr.charAt(j) == '0') {
                    return false;
                }

                num = 0;

                while (j < abbrLength && Character.isDigit(abbr.charAt(j))) {

                    num = num * 10 + (abbr.charAt(j) - '0');

                    j++;

                }
                i += num;
            }
            else {

                if(word.charAt(i) != abbr.charAt(j)) {
                    return false;
                }
                i++;
                j++;
            }


        }

        return i == wordLength && j == abbrLength;
    }

    public static void main(String[] args) {

        P006_Easy_ValidWordAbbreviation sol = new P006_Easy_ValidWordAbbreviation();

        String[][] testCases = {
                {"substitution", "s10n", "true"},
                {"word", "4", "true"},
                {"hello", "h3o", "true"},
                {"abbreviation", "a]2r0eviati2", "false"},
                {"abcdefg", "a05g", "false"},
        };

        // Iterate through each test case and print results
        for (int idx = 0; idx < testCases.length; idx++) {
            String word = testCases[idx][0];
            String abbr = testCases[idx][1];
            boolean result = sol.validWordAbbreviation(word, abbr);
            System.out.println((idx + 1) + ".\tword: [\"" + word + "\"]");
            System.out.println("\tabbr: \"" + abbr + "\"");
            System.out.println("\tResult: " + result);
            System.out.println("-".repeat(100));
        }
    }


}
