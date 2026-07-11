package dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class TriangleGrid {
        public int minimumTotal(List<List<Integer>> triangle) {
            int size=triangle.size();
            if(size==1) return triangle.getFirst().getFirst();
            List<List<Integer>>dp=new ArrayList<>();
            dp.add(triangle.get(size-1));
            for(int i=size-2; i>=0; i--){
                List<Integer>temp=new ArrayList<>();
                List<Integer>curr=triangle.get(i);
                List<Integer> prev=dp.getLast();
                System.out.println(curr);
                for(int j=0; j<curr.size(); j++){
                    temp.add(curr.get(j)+Math.min(prev.get(j), prev.get(j+1)));
                }
                dp.add(temp);
            }
            System.out.println(dp);
            return dp.getLast().getFirst();

        }

    public static int minimumTotalTabulation(List<List<Integer>> triangle) {
        if(triangle.isEmpty()) return -1;
        int size = triangle.size();
        int[][] dp = new int[size][size];

        for(int i = 0; i < triangle.get(size - 1).size(); i++) {
            dp[size - 1][i] = triangle.get(size - 1).get(i);
        }

        for(int i = size - 2; i >= 0; i--) {
            for(int j = triangle.get(i).size() - 1; j >= 0; j--) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
        }

        return dp[0][0];
    }
    }

