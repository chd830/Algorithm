package review;

import java.util.*;
import java.io.*;

// 종이의 개수
public class acmicpc1780 {
    static int N;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        StringTokenizer token = null;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }

//        cut(N, 0, 0);
//        System.out.println();
        dfs(0, 0, N);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }
    static int zero;
    static int plus;
    static int minus;
    static boolean check(int x, int y, int size) {
        int first = arr[x][y];
        for(int i = x; i < x+size; i++) {
            for(int j = y; j < y+size; j++) {
                if(arr[i][j] != first) {
                    return false;
                }
            }
        }
        if(first == 0) {
            zero++;
        }
        else if(first == 1) {
            plus++;
        }
        else {
            minus++;
        }
        return true;
    }
    static void dfs(int x, int y, int size) {
        if(check(x, y, size)) {
            return;
        }
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
//                System.out.println((x + j*(size/3)+"\t"+(y + i*(size/3)))+"\t"+size/3);
                dfs(x + j*(size/3), y + i*(size/3), size/3);
            }
        }
    }
}
