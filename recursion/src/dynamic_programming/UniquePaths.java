package dynamic_programming;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        Integer[][] dp=new Integer[m][n];
        return solve(m-1, n-1, dp);
    }
    private int solve(int m, int n, Integer[][] dp){
        if(dp[m][n]!=null) return dp[m][n];
        if(m==0 || n==0) return 1;
        int left=solve(m-1, n, dp);
        int right=solve(m, n-1, dp);
        return dp[m][n]=left+right;

    }
}
