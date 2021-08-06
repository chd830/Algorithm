package DNQ;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1780
public class 종이의개수 {
    static int[][] arr;
    static int[] result = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        paper(0, 0, N);
        for(int i = 0; i < 3; i++)
            System.out.println(result[i]);
    }

    static void paper(int x, int y, int N) {
        if(check(x, y, N)) {
            return;
        }
        int size = N/3;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                paper(x+size*i, y+size*j, size);
            }
        }
    }
    static boolean check(int x, int y, int size) {
        int start = arr[x][y];
        for(int i = x; i < x+size; i++) {
            for(int j = y; j < y+size; j++) {
                if(arr[i][j] != start)
                    return false;
            }
        }
        result[start+1]++;
        return true;
    }
}