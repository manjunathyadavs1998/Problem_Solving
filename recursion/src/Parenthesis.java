import java.util.ArrayList;
import java.util.List;

public class Parenthesis {

    public static List<String> generateParenthesis(int n){

        List<String> output=new ArrayList<>();
        generate(0, 0, n, "", output);
        return output;

    }

    public static void generate(int open, int close, int n, String temp, List<String>output){

        if(open+close==2*n){
            output.add(temp);
            return;
        }
       if(open<n){
           generate(open+1, close, n, temp+"(", output);
       }
       if(close<open){
           generate(open, close+1, n, temp+")", output);
       }

    }
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
        System.out.println();
        System.out.println(generateParenthesis(4));
    }
}
