package review;

import java.util.*;
import java.io.*;

// Z
public class acmicpc1074 {
    static int N;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        N = (int)Math.pow(2, N);
        int r = Integer.parseInt(token.nextToken());
        int c = Integer.parseInt(token.nextToken());
        arr = new int[N][N];
        recur(0, 0);

    }

    static void print() {
        for(int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println();
    }
    static int cnt = 1;
    static void recur(int x, int y) {
        print();
        if((x == N-1 && y == N-1) || x >= N || y >= N) {
            return;
        }
        arr[x][y] = cnt++;
        arr[x][y+1] = cnt++;
        arr[x+1][y] = cnt++;
        arr[x+1][y+1] = cnt++;
        recur(x, y+2);
        recur(x+2, y);
        recur(x+2, y+2);
    }
}
