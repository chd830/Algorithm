package review;

import java.util.*;
import java.io.*;

public class 네트워크 {
    static boolean[][] arr;
    static boolean[] visited;
    public static int solution(int n, int[][] computers) {
        arr = new boolean[n][n];
        visited = new boolean[n];
        for(int i = 0; i < computers.length; i++) {
            for(int j = 0; j < computers[i].length; j++) {
                if(computers[i][j] == 1) {
                    arr[i][j] = true;
                    arr[j][i] = true;
                }
            }
        }
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                cnt++;
                check(i);
            }
        }
        return cnt;
    }
    static void check(int idx) {
        for(int i = 0; i < arr.length; i++) {
            if(i == idx) {
                continue;
            }
            if(arr[idx][i] && !visited[i]) {
                visited[i] = true;
                check(i);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        System.out.println(solution(3, new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(solution(3, new int[][] {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }
}
