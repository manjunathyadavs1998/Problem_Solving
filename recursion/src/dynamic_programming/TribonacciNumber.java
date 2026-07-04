package dynamic_programming;

import java.util.Arrays;

public class TribonacciNumber {

    public static int tribonacci(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp, -1);
        solve(n,dp);
        return dp[n];
    }

    private static int solve(int n, int[] dp){
        if(n==0) return 0;
        if(n==1||n==2) return 1;
        if(dp[n]!=-1) return dp[n];
        return dp[n]=solve(n-1, dp)+solve(n-2,dp)+solve(n-3,dp);


    }
    public static void main(String[] args) {
        System.out.println(tribonacci(25));

    }
}
