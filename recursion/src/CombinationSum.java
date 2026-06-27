import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>output=new ArrayList<>();
        List<Integer>list=new ArrayList<>();
        backTrack(candidates, 0, output, list, target);
        return output;
    }

    public static void backTrack(int[] arr, int start, List<List<Integer>>output, List<Integer>list, int sum){
        if(sum==0){
            output.add(new ArrayList<>(list));
            return;
        }
        if(sum<0) return;
        for (int i=start; i<arr.length; i++) {
            list.add(arr[i]);
            backTrack(arr,i, output, list, sum - arr[i]);
            list.removeLast();
        }
    }

    public static void main(String[] args) {


        System.out.println(combinationSum(new int[]{2,3,6,7}, 7));

    }
}
