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

    public static void main(String[] args) {

        int[] arr = {2, 3, 5};
        int target = 5;

        int[][] dp = new int[arr.length][target + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        System.out.println(solve(arr, 0, target, dp));
    }
}
