import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board=new char[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(board[i], '.');
        }
        backTrack(board, 0, res);
        return  res;
    }

    public static void backTrack(char[][] board, int row, List<List<String>>res){
        if(row==board.length){
            List<String>current=new ArrayList<>();
            for (char[] chars : board) {
                current.add(new String(chars));
            }
            res.add(current);
            return;
        }

        for(int col=0; col<board[row].length; col++){
            if(isSafe(board, row, col)){
                board[row][col]='Q';
                backTrack(board, row+1, res);
                board[row][col]='.';
            }
        }
    }

    public static boolean isSafe(char[][] board, int row, int col){
        for(int i=0; i<row; i++){
            if(board[i][col]=='Q') return  false;
        }
        int maxLeft=Math.min(row, col);
        for(int i=1; i<=maxLeft; i++){
            if(board[row-i][col-i]=='Q') return false;
        }
        int maxRight=Math.min(row, board.length-1-col);
        for(int i=1; i<=maxRight; i++){
            if(board[row-i][col+i]=='Q') return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}
