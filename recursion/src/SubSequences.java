import java.util.ArrayList;
import java.util.List;

public class SubSequences {
    public static void generateUsingMasking(String str) {
        int n = str.length();
        for (int mask = 0; mask < (1 << n); mask++) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << (n - 1 - i))) != 0) {
                    sb.append(str.charAt(i));
                }
            }

            System.out.println(sb);
        }
    }

    public static List<String> generateAllSubSequences(String input){
        List<String>output=new ArrayList<>();
        generate(input, "", 0, output);
        return output;
    }

    public static void generate(String input, String temp, int index,List<String>output){

        if(index==input.length()){
            output.add(temp);
            return;
        }
        generate(input, temp, index+1, output);
        char ch=input.charAt(index);
        generate(input,temp+ch, index+1, output);


    }
    public static void main(String[] args) {
        System.out.println(generateAllSubSequences("abc"));
        System.out.println(generateAllSubSequences("pep"));
        System.out.println(generateAllSubSequences("lala"));

        System.out.println("******************************************************");
        generateUsingMasking("pep");


        }
    }

