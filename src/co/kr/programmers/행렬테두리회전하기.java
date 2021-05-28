package co.kr.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 행렬테두리회전하기 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(6, 6, new int[][] {{2,2,5,4},{3,3,6,6},{5,1,6,3}})));
    }
    static int[][] map;
    public static int[] solution(int rows, int columns, int[][] queries) {
        map = new int[rows][columns];
        for(int i = 0, num = 1; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                map[i][j] = num++;
            }
        }
        int[] answer = new int[queries.length];
        int idx = 0;
        for(int[] query : queries) {
            int[][] copy = new int[rows][columns];
            for(int i = 0; i < rows; i++)
                copy[i] = map[i].clone();
            int num = Integer.MAX_VALUE;

            int startX = query[0]-1;
            int startY = query[1]-1;
            int endX = query[2]-1;
            int endY = query[3]-1;
            for(int i = startX; i <= endX; i++) {
                if(i == endX)
                    map[i][startY] = copy[i][startY + 1];
                else
                    map[i][startY] = copy[i + 1][startY];
                num = Math.min(num, map[i][startY]);
            }
            for(int i = startY+1; i <= endY; i++) {
                map[startX][i] = copy[startX][i-1];
                num = Math.min(num, map[startX][i]);
            }
            for(int i = startX+1; i <= endX; i++) {
                map[i][endY] = copy[i-1][endY];
                num = Math.min(num, map[i][endY]);
            }
            for(int i = endY-1; i > startY; i--) {
                map[endX][i] = copy[endX][i+1];
                num = Math.min(num, map[endX][i]);
            }
            answer[idx++] = num;
        }
        return answer;
    }
}
