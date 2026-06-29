package dynamic_programming;

public class MaximalSquareRecursion {

    static int maxSquare = 0;

    public static int maximalSquare(char[][] matrix) {
        maxSquare = 0;

        int m = matrix.length;
        int n = matrix[0].length;

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

        // Base case
        if (i >= m || j >= n)
            return 0;

        // Recursively compute
        int right = solve(matrix, i, j + 1);
        int down = solve(matrix, i + 1, j);
        int diagonal = solve(matrix, i + 1, j + 1);

        if (matrix[i][j] == '1') {
            int side = 1 + Math.min(right, Math.min(down, diagonal));
            maxSquare = Math.max(maxSquare, side);
            return side;
        }

        return 0;
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
