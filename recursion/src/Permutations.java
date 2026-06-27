import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public static void generatePermutations(String input, String temp, List<String> output){
        if(input.isEmpty()){
            output.add(temp);
            return;
        }
        for(int i=0; i<input.length(); i++){
            char ch= input.charAt(i);
            String remainingString=input.substring(0, i)+input.substring(i+1);
            String currStr=temp+ch;
            generatePermutations(remainingString, currStr, output);
        }

    }

    public static List<List<Integer>> generateArrayPermutations(int[] arr){
        List<List<Integer>>output=new ArrayList<>();
        int n=arr.length;
        boolean[] flag=new boolean[n];
        Arrays.fill(flag, false);
        List<Integer>list=new ArrayList<>();
        backTrack(arr, output, list, flag);
        return output;


    }
    public static void backTrack(int[] arr, List<List<Integer>>output, List<Integer>list, boolean[] flag){

        if(list.size()==arr.length){
            output.add(new ArrayList<>(list));
            return;
        }
        for(int i=0; i<arr.length; i++){
            if(flag[i]){
                continue;
            }
            list.add(arr[i]);
            flag[i]=true;
            backTrack(arr, output, list, flag);
            list.removeLast();
            flag[i]=false;
        }
    }

    public static List<List<Integer>> permuteUnique(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>>output=new ArrayList<>();
        int n=arr.length;
        boolean[] flag=new boolean[n];
        Arrays.fill(flag, false);
        List<Integer>list=new ArrayList<>();
        backTrackForUnique(arr, output, list, flag);
        return output;


    }
    public static void backTrackForUnique(int[] arr, List<List<Integer>>output, List<Integer>list, boolean[] flag) {

        if (list.size() == arr.length) {
            output.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if ((i > 0 && arr[i] == arr[i - 1]) && !flag[i - 1] || (flag[i])) continue;
            list.add(arr[i]);
            flag[i] = true;
            backTrack(arr, output, list, flag);
            list.removeLast();
            flag[i] = false;
        }
    }

    public static void main(String[] args) {
        List<String>output=new ArrayList<>();
        generatePermutations("abcd", "",output);
        System.out.println(output);

        System.out.println(generateArrayPermutations(new int[] {1,2,3}));
    }
}
