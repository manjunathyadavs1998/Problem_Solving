public class MazeTraversal {
    public static int numberOfWays(int i, int j, int n){
        if(i==n-1 || j==n-1) return 1;
        if(i>=n || j>=n) return  0;
        return numberOfWays(i+1, j, n)+numberOfWays(i, j+1, n);

    }

    public static void main(String[] args) {
        System.out.println(numberOfWays(0, 0, 4));
    }
}
