package Dynamic;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/11659
public class 구간합구하기4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int[] arr = new int[N];
        token = new StringTokenizer(br.readLine());
        int[] d = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(token.nextToken());
        d[0] = arr[0];
        for(int i = 1; i < N; i++)
            d[i] = d[i-1]+arr[i];
        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(token.nextToken())-1;
            int end = Integer.parseInt(token.nextToken())-1;
            if(start > 0)
                System.out.println(d[end]-d[start-1]);
            else
                System.out.println(d[end]);
        }
    }
}
