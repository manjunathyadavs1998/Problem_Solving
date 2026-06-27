public class Josephus {

    public static int findTheWinner(int n, int k) {
        return josephus(n, k) + 1;
    }

    private static int josephus(int n, int k) {
        if (n == 1) return 0;
        int x= josephus(n - 1, k);
        int y=(x+k)%n;
        return y;
    }

    public static void main(String[] args) {
        int alive=findTheWinner(7, 3);
        System.out.println(alive);
    }
}
