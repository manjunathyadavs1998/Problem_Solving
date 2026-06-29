package dynamic_programming;

public class MaximalSquareMemo {

    static int[][] memo;
    static int maxSquare = 0;

    public static int maximalSquare(char[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        memo = new int[m][n];

        for (int i = 0; i < m; i++)
            java.util.Arrays.fill(memo[i], -1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                solve(matrix, i, j);
            }
        }

        return maxSquare * maxSquare;
    }

    static int solve(char[][] matrix, int i, int j) {

        int m = matrix.length;
        int n = matrix[0].length;

        if (i >= m || j >= n)
            return 0;

        if (memo[i][j] != -1)
            return memo[i][j];

        int ans = 0;

        if (matrix[i][j] == '1') {

            int right = solve(matrix, i, j + 1);

            int down = solve(matrix, i + 1, j);

            int diagonal = solve(matrix, i + 1, j + 1);

            ans = 1 + Math.min(right, Math.min(down, diagonal));

            maxSquare = Math.max(maxSquare, ans);
        }

        memo[i][j] = ans;

        return ans;
    }

    public static void main(String[] args) {

        char[][] arr = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };

        System.out.println(maximalSquare(arr));
    }
}
