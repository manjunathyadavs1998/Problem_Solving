package dynamic_programming;

import java.util.Arrays;

public class TargetSumSubset {
    static boolean solve(int[] arr, int index, int target, int[][] dp) {

        if (target == 0)
            return true;

        if (index == arr.length)
            return false;

        if (target < 0)
            return false;

        if (dp[index][target] != -1)
            return dp[index][target] == 1;

        boolean take = solve(arr, index + 1, target - arr[index], dp);

        boolean skip = solve(arr, index + 1, target, dp);

        dp[index][target] = (take || skip) ? 1 : 0;

        return take || skip;
    }

    private static boolean targetSumExistsTabulation(int[] arr, int target) {

        int n = arr.length;
        int[][] dp = new int[n + 1][target + 1];

        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;

        for (int j = 1; j <= target; j++)
            dp[0][j] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {

                dp[i][j] = dp[i - 1][j];

                int val = arr[i - 1];

                if (val <= j && dp[i - 1][j - val] == 1)
                    dp[i][j] = 1;
            }
        }

        return dp[n][target] == 1;
    }

    public static void main(String[] args) {

        int[] arr = {2, 3, 5};
        int target = 5;

        int[][] dp = new int[arr.length][target + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        System.out.println(solve(arr, 0, target, dp));
        System.out.println(targetSumExistsTabulation(arr, 5));
    }
}
