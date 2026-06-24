import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombination {

    /**
     * Problem:
     * Given a string containing digits from 2-9, return all possible
     * letter combinations that the number could represent.
     *
     * Example:
     * Input  : "23"
     * Output : [ad, ae, af, bd, be, bf, cd, ce, cf]
     *
     * Approach:
     * Use Backtracking (DFS).
     *
     * Each digit maps to multiple characters:
     * 2 -> abc
     * 3 -> def
     * 4 -> ghi
     * 5 -> jkl
     * 6 -> mno
     * 7 -> pqrs
     * 8 -> tuv
     * 9 -> wxyz
     *
     * For each digit:
     *  1. Pick one character.
     *  2. Move to next digit.
     *  3. Continue until all digits are processed.
     *  4. Store the generated combination.
     *  5. Backtrack and try the next character.
     *
     * Time Complexity:
     * O(4^N)
     * where N = number of digits.
     *
     * Space Complexity:
     * O(N) recursion stack
     * O(4^N * N) result storage
     */
    public static List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        // Edge case: empty input
        if (digits == null || digits.isEmpty()) {
            return result;
        }

        // Phone keypad mapping
        Map<Character, String> map = new HashMap<>();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        /*
         * Start recursion from:
         * index = 0 (first digit)
         * empty StringBuilder
         * empty result list
         */
        backtrack(
                digits,
                0,
                map,
                new StringBuilder(),
                result
        );

        return result;
    }

    /**
     * Recursive Backtracking Function
     *
     * Parameters:
     * digits  -> input digit string
     * index   -> current digit being processed
     * mapping -> digit to character mapping
     * sb      -> current combination being built
     * result  -> final answer
     *
     * Example for "23":
     *
     * Level 0:
     * ""
     *
     * Level 1:
     * a, b, c
     *
     * Level 2:
     * ad, ae, af
     * bd, be, bf
     * cd, ce, cf
     */
    public static void backtrack(
            String digits,
            int index,
            Map<Character, String> mapping,
            StringBuilder sb,
            List<String> result) {

        /*
         * Base Condition
         *
         * If we've processed all digits,
         * current StringBuilder contains
         * one complete combination.
         */
        if (index == digits.length()) {

            // Example: "ad"
            result.add(sb.toString());

            return;
        }

        /*
         * Get all possible characters
         * for current digit.
         *
         * Example:
         * digit = '2'
         * curr = "abc"
         */
        String curr = mapping.get(digits.charAt(index));

        /*
         * Try every possible character
         * for the current digit.
         */
        for (char ch : curr.toCharArray()) {

            /*
             * CHOOSE
             *
             * Example:
             * sb = ""
             * choose 'a'
             *
             * sb = "a"
             */
            sb.append(ch);

            /*
             * EXPLORE
             *
             * Move to next digit.
             */
            backtrack(
                    digits,
                    index + 1,
                    mapping,
                    sb,
                    result
            );

            /*
             * UNDO CHOICE (Backtrack)
             *
             * Example:
             *
             * Current:
             * sb = "ad"
             *
             * Remove last character:
             * sb = "a"
             *
             * So we can try:
             * ae, af ...
             */
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {

        System.out.println(letterCombinations("23"));

        // Output:
        // [ad, ae, af, bd, be, bf, cd, ce, cf]

        System.out.println(letterCombinations("235"));

        // Output:
        // [adj, adk, adl,
        //  aej, aek, ael,
        //  afj, afk, afl,
        //  ...
        //  cfj, cfk, cfl]
    }
}