package 브루트포스;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1780
public class 종이의개수 {
    static int N;
    static int[] result = new int[3];
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        dfs(0, 0, N);
        System.out.println(Arrays.toString(result));
    }
    static boolean check(int x, int y, int size) {
        int val = arr[x][y];
        for(int i = x; i < x+size; i++) {
            for(int j = y; j < y+size; j++) {
                if(arr[i][j] != val)
                    return false;
            }
        }
        return true;
    }
    static void dfs(int x, int y, int size) {
        System.out.println(x+"\t"+y+"\t"+size);
        if(check(x, y, size)) {
            result[arr[x][y]+1]++;
            return;
        }
        int next = size/3;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j ++) {
                dfs(x+next*i, y+next*j, next);
            }
        }
    }
}