package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1992
public class 쿼드트리 {
    static int N;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        answer = "";
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j)-'0';
            }
        }
        dnq(0, 0, N);
        System.out.println(answer);
    }
    static int check(int x, int y, int size) {
        for(int i = x; i < x+size; i++) {
            for(int j = y; j < y+size; j++) {
                if(arr[i][j] != arr[x][y])
                    return -1;
            }
        }
        return arr[x][y];

    }
    static String answer;
    static void dnq(int x, int y, int size) {
        if(check(x, y, size) > -1) {
            answer += arr[x][y];
            return;
        }
        else
            answer += "(";
        if(size == 1)
            return;
        int next = size/2;
        dnq(x, y, next);
        dnq(x, y+next, next);
        dnq(x+next, y, next);
        dnq(x+next, y+next, next);
        answer += ")";
    }
}
