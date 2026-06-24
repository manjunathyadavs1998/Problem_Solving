public class StairClimbCase {

    /**
     * Problem:
     * You are climbing a staircase with n steps.
     *
     * Each time, you can either:
     *  - Climb 1 step
     *  - Climb 2 steps
     *
     * Find the total number of distinct ways to reach the top.
     *
     * Example:
     * n = 3
     *
     * Ways:
     * 1 + 1 + 1
     * 1 + 2
     * 2 + 1
     *
     * Answer = 3
     *
     * ----------------------------------------------------
     * Dynamic Programming Approach
     * ----------------------------------------------------
     *
     * Observation:
     *
     * To reach step i:
     *
     * We can come from:
     *  - step (i - 1) by taking 1 step
     *  - step (i - 2) by taking 2 steps
     *
     * Therefore:
     *
     * dp[i] = dp[i - 1] + dp[i - 2]
     *
     * This is exactly Fibonacci sequence.
     *
     * Example:
     *
     * n = 5
     *
     * dp[0] = 1
     * dp[1] = 1
     *
     * dp[2] = 2
     * dp[3] = 3
     * dp[4] = 5
     * dp[5] = 8
     *
     * Answer = 8
     *
     * Time Complexity:
     * O(n)
     *
     * Space Complexity:
     * O(n)
     */
    public static int climbStairs(int n) {

        // Base cases
        if (n == 0 || n == 1) {
            return 1;
        }

        // DP array
        int[] arr = new int[n + 1];

        // Initialization
        arr[0] = 1;
        arr[1] = 1;

        /*
         * Build solution bottom-up
         *
         * arr[i]
         * = ways from previous step
         * + ways from previous previous step
         */
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }

    /**
     * ----------------------------------------------------
     * Recursive Approach
     * ----------------------------------------------------
     *
     * Thinking:
     *
     * To reach step n:
     *
     * Last move could be:
     *
     * 1 step from (n - 1)
     * OR
     * 2 steps from (n - 2)
     *
     * Therefore:
     *
     * f(n) = f(n-1) + f(n-2)
     *
     * Base Cases:
     *
     * f(0) = 1
     * f(1) = 1
     *
     * Example:
     *
     * climb(4)
     *
     * = climb(3) + climb(2)
     *
     * = (climb(2)+climb(1))
     *   +
     *   (climb(1)+climb(0))
     *
     * = 5
     *
     * Time Complexity:
     * O(2^n)
     *
     * Space Complexity:
     * O(n)
     *
     * Due to recursion stack.
     */
    public static int climbStairsRecursive(int n) {

        // Base cases
        if (n == 0 || n == 1) {
            return 1;
        }

        /*
         * Recursive formula:
         *
         * Ways to reach current step =
         * ways from previous step +
         * ways from previous previous step
         */
        return climbStairsRecursive(n - 1)
                + climbStairsRecursive(n - 2);
    }

    public static void main(String[] args) {

        System.out.println(climbStairsRecursive(5));

        // Output:
        // 8

        System.out.println(climbStairs(5));

        // Output:
        // 8
    }
}