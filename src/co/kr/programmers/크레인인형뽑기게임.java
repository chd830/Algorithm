package co.kr.programmers;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/64061
public class 크레인인형뽑기게임 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}}, new int[] {1, 5, 3, 5, 1, 2, 1, 4}));
    }
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for(int move : moves) {
            int x = 0;
            int y = move-1;
            while(x < board.length && board[x][y] == 0) {
                x++;
            }
            if(x < board.length && board[x][y] != 0) {
                list.add(board[x][y]);
                board[x][y] = 0;
                while(list.size() >= 2 && list.get(list.size()-1) == list.get(list.size()-2)) {
                    answer += 2;
                    list.remove(list.size()-1);
                    list.remove(list.size()-1);
                }
            }
        }
        return answer;
    }
}
