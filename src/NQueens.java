import java.io.Console;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class NQueens {
    ArrayList<ArrayList<String>> list= new ArrayList<>();
    public static void main(String[] args) {
        NQueens obj = new NQueens();
        System.out.println("Please enter the size of the chess board");
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int n = Integer.valueOf(str);
        String[][] board = new String[n][n];
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                board[i][j] = "#";
            }
        }
        int ways = obj.nQueens(board, n, 0);
        System.out.println(ways);
    }

    public boolean isNotAttacked(String[][] board, int row, int col) {
        int i = row - 1, jLeft = col - 1, jRight = col + 1;
        while (i >= 0) {
            if (board[i][col] == "Q" || (jLeft >= 0 && board[i][jLeft] == "Q") || (jRight < board.length && board[i][jRight] == "Q")) {
                return false;
            } else {
                i -= 1;
                jLeft -= 1;
                jRight += 1;
            }
        }
        return true;
    }
    public int nQueens(String[][] board, int n, int row){
        if(row == n){
            return 1;
        }
        int noOfways = 0;
        for (int i = 0; i < n; i++) {
            if (isNotAttacked(board, row, i)){
                board[row][i] = "Q";
                noOfways += nQueens(board, n, row+1);
                board[row][i] = "#";
            }
        }
        return noOfways;
    }
}

