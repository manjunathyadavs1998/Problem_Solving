import java.util.ArrayList;
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

    public static void main(String[] args) {
        List<String>output=new ArrayList<>();
        generatePermutations("abcd", "",output);
        System.out.println(output);
    }
}
