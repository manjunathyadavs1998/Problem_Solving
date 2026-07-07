package dynamic_programming;

public class UnBoundKnapSack {

    public static int solve(int i, int cap, int[] wt, int[] val) {

        if (i < 0)
            return 0;

        if (wt[i] > cap)
            return solve(i - 1, cap, wt, val);

        int take = val[i] + solve(i, cap - wt[i], wt, val);

        int notTake = solve(i - 1, cap, wt, val);

        return Math.max(take, notTake);
    }
}
