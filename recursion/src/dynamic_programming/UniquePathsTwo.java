package dynamic_programming;

public class UniquePathsTwo {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        Integer[][] dp=new Integer[m][n];
        return solve(m-1, n-1, dp, obstacleGrid);
    }

    private int solve(int m, int n, Integer[][] dp, int[][] arr){

        if (m < 0 || n < 0) return 0;
        if (arr[m][n] == 1) return 0;
        if (m == 0 && n == 0) return 1;
        if (dp[m][n] != null) return dp[m][n];
        //if(dp[m][n]!=null) return dp[m][n];

        int left=solve(m-1, n, dp, arr);
        int right=solve(m, n-1, dp, arr);
        return dp[m][n]=left+right;

    }
}
