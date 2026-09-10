package twospointers;

import java.util.HashMap;
import java.util.Map;

public class P009_Easy_StrobogrammaticNumber {


    /*

    Explore how to use the two-pointer approach to determine if a given number is strobogrammatic,
    meaning it appears the same when rotated 180 degrees. This lesson helps you apply logical steps
    to verify these numbers in strings while practicing efficient problem-solving strategies.

    Statement
    Given a string num representing an integer, determine whether it is a strobogrammatic number.
    Return TRUE if the number is strobogrammatic or FALSE if it is not.

    Note: A strobogrammatic number appears the same when rotated
    180
    180
     degrees (viewed upside down). For example, “69” is strobogrammatic because it looks the same
     when flipped upside down, while “962” is not.

     */

    private static boolean isStrobogrammatic(String num) {

        Map<Character, Character> map = new HashMap<>();

        map.put('0','0');
        map.put('1','1');
        map.put('8','8');
        map.put('6','9');
        map.put('9','6');

        int left = 0;
        int right = num.length() - 1;

        while(left <= right ) {

            if(!map.containsKey(num.charAt(left)) || map.get(num.charAt(left)) != num.charAt(right) ) {

                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        String[] nums = {
                "609",
                "88",
                "962",
                "101",
                "123"
        };

        int i = 0;
        for (String num : nums) {
            System.out.println((i + 1) + ".\tnum: " + num);
            System.out.println("\n\tIs strobogrammatic: " + (isStrobogrammatic(num) ? "true" : "false"));
            System.out.println(new String(new char[100]).replace("\0", "-"));
            i++;
        }
    }



}
