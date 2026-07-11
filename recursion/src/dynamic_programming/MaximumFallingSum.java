package dynamic_programming;

public class MaximumFallingSum {

        public int minFallingPathSum(int[][] matrix) {
            int m=matrix.length;
            int n=matrix[0].length;
            int res=Integer.MAX_VALUE;
            Integer[][] dp=new Integer[m][n];
            for(int j=0; j<n; j++){
                res=Math.min(res, solve(matrix, n-1, j, m, n, dp));
            }
            return res;
        }

        private int solve(int[][] arr, int i, int j, int m, int n, Integer[][]dp){

            if(i<0 || j<0 || i>=m || j>=n) return Integer.MAX_VALUE;
            if(i==0) return arr[i][j];
            if(dp[i][j]!=null) return dp[i][j];
            int st = solve(arr, i - 1, j, m, n, dp);
            int rt = solve(arr, i - 1, j + 1, m, n, dp);
            int left = solve(arr, i - 1, j - 1, m, n, dp);
            int minPrev = Math.min(st, Math.min(rt, left));
            // if (minPrev == Integer.MAX_VALUE)
            //     return dp[i][j] = Integer.MAX_VALUE;
            return dp[i][j] = arr[i][j] + minPrev;
        }

    public int minFallingPathSumTable(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int up = dp[i - 1][j];
                int leftDiag = Integer.MAX_VALUE;
                if (j > 0)
                    leftDiag = dp[i - 1][j - 1];
                int rightDiag = Integer.MAX_VALUE;
                if (j < n - 1)
                    rightDiag = dp[i - 1][j + 1];
                dp[i][j] = matrix[i][j] + Math.min(up, Math.min(leftDiag, rightDiag));
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, dp[m - 1][j]);
        }

        return ans;
    }
    }

