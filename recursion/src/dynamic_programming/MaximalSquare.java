package dynamic_programming;
/*
https://leetcode.com/problems/maximal-square/description/
 */
public class MaximalSquare {
    public static int maximalSquare(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] dp=new int[m][n];
        int maxSquare=0;
        // First row
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j] == '1' ? 1 : 0;
            maxSquare = Math.max(maxSquare, dp[0][j]);
        }

        // First column
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            maxSquare = Math.max(maxSquare, dp[i][0]);
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[i][j]=='1'){
                    dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                }else{
                    dp[i][j]=0;
                }
                maxSquare=Math.max(maxSquare, dp[i][j]);
            }
        }
        return maxSquare*maxSquare;

    }
    public static void main(String[] args) {
        char[][] arr={{'1','0', '1', '0', '0'},
                {'1','0', '1', '1', '1'},
                {'1','1', '1', '1', '1'},
                {'1','0', '0', '1', '0'}
        };
        System.out.println(maximalSquare(arr));

    }
}
