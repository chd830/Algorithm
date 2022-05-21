package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1652
public class 누울자리를찾아라 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j) == '.' ? true : false;
            }
        }
        int width = 0;
        int height = 0;
        for(int i = 0; i < N; i++) {
            int cnt = 0;
            for(int j = 0; j < N; j++) {
                if(arr[i][j]) {
                    cnt++;
                }
                else {
                    if(cnt >= 2)
                        width++;
                    cnt = 0;
                }
            }
            if(cnt >= 2)
                width++;
            cnt = 0;
            for(int j = 0; j < N; j++) {
                if(arr[j][i]) {
                    cnt++;
                }
                else {
                    if(cnt >= 2)
                        height++;
                    cnt = 0;
                }
            }
            if(cnt >= 2)
                height++;
        }
        System.out.println(width+" "+height);
    }
}
