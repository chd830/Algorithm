package net.acmicpc;

public class WordSearch {
    static boolean[][] check;
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        check = new boolean[board.length][board[0].length];
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                if (board[y][x] == w[0] && exist(board, y, x, w, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int y, int x, char[] word, int i) {
        //끝까지 다 반복했을 경우 true를 반환해준다.
        if (i == word.length)
            return true;
        //재귀형식으로 함수를 반복할 때 x,y의 수가 0이나 word.length여서
        //조건보다 크거나 작을 때 false가 나오게 한다.
        if (y < 0 || x < 0 || y >= board.length || x >= board[y].length || board[y][x] != word[i] || check[y][x])
            return false;
        //word[i]와 같지않다면 return false
        if (board[y][x] != word[i])
            return false;
        //board[y][x] ^= 256은 메모리를 절약하기 위한 비트마스크
//        board[y][x] ^= 256;
        //재귀함수로 (x,y)기준 (x-1,y), (x+1,y), (x,y-1), (x,y+1)에서 같은값이 있는지 검색하고
        //같은 값이 있을 때 다시 같은값이 있는지를 찾는다.
        check[y][x] = true;
        boolean exist = exist(board, y, x + 1, word, i + 1)
                || exist(board, y, x - 1, word, i + 1)
                || exist(board, y + 1, x, word, i + 1)
                || exist(board, y - 1, x, word, i + 1);
//        board[y][x] ^= 256;
        check[y][x] = true;
        return exist;
    }
}
