import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output=new ArrayList<>();
        List<Integer>current=new ArrayList<>();
        backTrackAndRemoveDuplicates(nums, 0, output, current);
        return output;
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output=new ArrayList<>();
        List<Integer>current=new ArrayList<>();
        backTrackAndRemoveDuplicates(nums, 0, output, current);
        return output;
    }
    public static void backtrack(int[] arr, int index, List<List<Integer>>output, List<Integer>current){
        if(index==arr.length){
            output.add(new ArrayList<>(current));
            return;
        }
        backtrack(arr, index+1, output, current);
        current.add(arr[index]);
        backtrack(arr, index+1, output, current);
        current.removeLast();
    }

    public static void backTrackAndRemoveDuplicates(int[] nums, int start,
                                 List<List<Integer>> output,
                                 List<Integer> current) {

        output.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {

            // Skip duplicates at the same recursion level
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            current.add(nums[i]);
            backTrackAndRemoveDuplicates(nums, i + 1, output, current);
            current.removeLast();
        }
    }


    public static void main(String[] args) {
    int[] input={1,2,2};
    System.out.println(subsets(input));
    }
}
