package recur;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/9663
public class NQueen {
    static int N;
    static int result;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        result = 0;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        set(0);
        StringBuilder sb = new StringBuilder();
        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
    }
    static void set(int idx) {
        if(idx == N) {
//            for(int i = 0; i < N; i++)
//                System.out.println(Arrays.toString(arr[i]));
//            System.out.println();
            result++;
            return;
        }
        for(int i = 0; i < N; i++) {
            if(check(idx, i)) {
                arr[idx][i] = -1;
                set(idx+1);
                arr[idx][i] = 0;
            }
        }
    }
    static boolean check(int x, int y) {
        // 세로
        for(int i = x; i >= 0; i--) {
            if(arr[i][y] == -1)
                return false;
        };
        // 오른쪽 위 대각선
        for(int i = x, j = y; i >= 0 && j < N; i--, j++) {
            if(arr[i][j] == -1)
                return false;
        }
        // 왼쪽 위 대각선
        for(int i = x, j = y; i >= 0 && j >= 0; i--, j--) {
            if(arr[i][j] == -1)
                return false;
        }
        return true;
    }
}
