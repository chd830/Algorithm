package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2565
public class 전깃줄 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer token = null;
        int[] d = new int[101];
        int[][] arr = new int[N][2];
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(token.nextToken());
            int n2 = Integer.parseInt(token.nextToken());
            arr[i][0] = n1;
            arr[i][1] = n2;
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        for(int i = 0; i < N; i++) {
            d[i] = 1;
            for(int j = 0; j < i; j++) {
                if(arr[j][1] < arr[i][1])
                    d[i] = Math.max(d[j]+1, d[i]);
            }
        }
        int max = 0;
        for(int i : d)
            max = Math.max(max, i);
        System.out.println(N-max);
    }
}
