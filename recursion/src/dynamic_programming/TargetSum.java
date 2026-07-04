package dynamic_programming;

public class TargetSum {


    public static  int findTargetSumWays(int[] nums, int target) {
            Integer[][] dp = new Integer[nums.length][2001];
            return solve(nums, target, 0, 0, dp);
        }

        private static int solve(int[] nums, int target, int index, int sum, Integer[][] dp) {

            if (index == nums.length)
                return sum == target ? 1 : 0;

            if (dp[index][sum + 1000] != null)
                return dp[index][sum + 1000];

            int plus = solve(nums, target, index + 1, sum + nums[index], dp);
            int minus = solve(nums, target, index + 1, sum - nums[index], dp);

            return dp[index][sum + 1000] = plus + minus;
        }

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[] {1,1,1,1,1}, 3));
        System.out.println(findTargetSumWays(new int[] {1}, 1));

    }
}
