package net.acmicpc.re;

import java.util.*;
import java.io.*;

// 6603
public class 로또 {
    static int N;
    static int[] arr;
    static boolean[] visited;
    /*
7 1 2 3 4 5 6 7
8 1 2 3 5 8 13 21 34
0
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        while(!str.equals("0")) {
            StringTokenizer token = new StringTokenizer(str);
            N = Integer.parseInt(token.nextToken());
            arr = new int[N];
            visited = new boolean[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(token.nextToken());
            }
            Arrays.sort(arr);
            System.out.println(Arrays.toString(arr));
            comb(0, 0);
            System.out.println();
            str = br.readLine();
        }
    }
    static void comb(int idx, int cnt) {
        if(cnt == 6) {
            for(int i = 0; i < N; i++) {
                System.out.print(visited[i] ? arr[i]+" " : "");
            }
            System.out.println();
            return;
        }
        for(int i = idx; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                comb(i+1, cnt+1);
                visited[i] = false;
            }
        }
    }
}
