package com.code;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        WordSearch w = new WordSearch();
        char[][] board = {{'A'}};
                /*
                [["A","B","C","E"],["S","F","E","S"],["A","D","E","E"]]
"ABCESEEEFS"
                 */
        System.out.println(w.exist(board, "AB"));

    }
}
