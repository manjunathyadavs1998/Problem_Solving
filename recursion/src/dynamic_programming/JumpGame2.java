package dynamic_programming;

public class JumpGame2 {

    public static int jump(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        dp[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {

            if (nums[i] == 0) {
                dp[i] = Integer.MAX_VALUE;
            } else {

                int lastIndex = Math.min(n - 1, i + nums[i]);

                int currSmall = Integer.MAX_VALUE;

                for (int j = i + 1; j <= lastIndex; j++) {
                    currSmall = Math.min(currSmall, dp[j]);
                }

                if (currSmall == Integer.MAX_VALUE)
                    dp[i] = Integer.MAX_VALUE;
                else
                    dp[i] = 1 + currSmall;
            }
        }

        return dp[0];
    }

    public static int jumpGreedy(int[] nums) {

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }
        return jumps;
    }
    public static void main(String[] args) {
        System.out.println(jump(new int[]{3,2,1,0,4}));
        System.out.println();
    }
}
