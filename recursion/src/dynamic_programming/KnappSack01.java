package dynamic_programming;

import java.util.Arrays;

public class KnappSack01 {


        static int solve(int[] wt, int[] val, int index, int capacity, int[][] dp) {

            if (index == wt.length || capacity == 0)
                return 0;

            if (dp[index][capacity] != -1)
                return dp[index][capacity];

            int skip = solve(wt, val, index + 1, capacity, dp);

            int take = 0;
            if (wt[index] <= capacity) {
                take = val[index] +
                        solve(wt, val, index + 1, capacity - wt[index], dp);
            }

            return dp[index][capacity] = Math.max(take, skip);
        }

        public static void main(String[] args) {

            int[] wt = {1, 3, 4, 5};
            int[] val = {1, 4, 5, 7};

            int capacity = 7;

            int[][] dp = new int[wt.length][capacity + 1];

            for (int[] row : dp)
                Arrays.fill(row, -1);

            System.out.println(solve(wt, val, 0, capacity, dp));
        }
    }
