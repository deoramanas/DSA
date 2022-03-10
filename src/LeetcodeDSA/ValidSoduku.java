package LeetcodeDSA;

import java.util.HashSet;
import java.util.Set;

public class ValidSoduku {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'8', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        boolean validSudoku = isValidSudoku(board);
        System.out.println(validSudoku);

    }

    public static boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    String s = "row_" + i + "_" + board[i][j];
                    String t = "col_" + j + "_" + board[i][j];
                    int box = ((i / 3) * 3) + (j / 3);
                    String w = "box_" + box + "_" + board[i][j];
                    if (set.contains(s)) {
                        return false;
                    } else {
                        set.add(s);
                    }
                    if (set.contains(t)) {
                        return false;
                    } else {
                        set.add(t);
                    }
                    if (set.contains(w)) {
                        return false;
                    } else {
                        set.add(w);
                    }
                }
            }
           // System.out.println(set);
        }

        return true;
    }
}
