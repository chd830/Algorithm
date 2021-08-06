package DNQ;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2447
public class 별찍기10 {
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        for (int i = 0; i < N; i++)
            Arrays.fill(arr[i], '*');
        int size = 1;
        while(size < N) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(i/size%3 == 1 && j/size%3 == 1)
                        arr[i][j] = ' ';
                }
            }
            size *= 3;
            for(int i = 0 ;i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(arr[i][j]);
                }
                System.out.println();
            }
        }
//        star(0, 0, N, false);
//        for(int i = 0 ;i < N; i++)
//            System.out.println(Arrays.toString(arr[i]));
//        System.out.println();
    }
    static void star(int x, int y, int N, boolean blank) {
        System.out.println(x+"\t"+y+"\t"+N+"\t"+blank);
        if(blank) {
            for(int i = x; i < x+N; i++) {
                for(int j = y; j < y+N; j++)
                    arr[i][j] = ' ';
            }
            return;
        }
        if(N == 1) {
            arr[x][y] = '*';
            return;
        }

        int size = N/3;
        int cnt = 0;
        for(int i = x; i < x+N; i += size) {
            for(int j = y; j < y+N; j += size) {
                cnt++;
                if (cnt == 5)
                    star(i, j, size, true);
                else
                    star(i, j, size, false);
            }
        }
    }
}
