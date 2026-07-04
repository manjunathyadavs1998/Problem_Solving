package dynamic_programming;

import java.util.Arrays;

public class MaximumCostRobber {
//4 1  1 1 4
public static int rob(int[] nums) {
    int[] dp=new int[nums.length+1];
    Arrays.fill(dp, -1);
    return solveDp(nums, nums.length - 1, dp);
}


    private static int solve(int[] nums, int index) {
        if (index < 0) return 0;
        if (index == 0) return nums[0];

        return Math.max(
                solve(nums, index - 1),
                nums[index] + solve(nums, index - 2)
        );
    }
    private static int solveDp(int[] nums, int index, int[] dp) {
        if (index < 0) return 0;
        if (index == 0) return dp[index]=nums[0];

        return dp[index]=Math.max(
                solve(nums, index - 1),
                nums[index] + solve(nums, index - 2)
        );
    }
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1}));
    }
}
