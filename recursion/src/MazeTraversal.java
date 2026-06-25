public class MazeTraversal {
    public static int numberOfWays(int i, int j, int m, int n){
        if(i==m-1 || j==n-1) return 1;
       // if(i>=m || j>=n) return  0;
        return numberOfWays(i+1, j, m,n)+numberOfWays(i, j+1, m, n);

    }

    public static void printPaths(int i, int j, int m, int n, String path) {

        if (i == m - 1 && j == n - 1) {
            System.out.println(path);
            return;
        }
        if (j  < n-1) { // move right
            printPaths(i, j + 1, m, n, path + "H");
        }
        if (i  < m-1) { // move down
            printPaths(i + 1, j, m, n, path + "V");
        }
    }


    public static void main(String[] args) {
        System.out.println(numberOfWays(0, 0, 2, 3));
        printPaths(0, 0, 3, 3, "");
    }
}
