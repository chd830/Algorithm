package STL;

import java.util.*;
import java.io.*;

// https://codeforces.com/problemset/problem/158/A
public class Codeforce_158A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        long answer = 0;
        token = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(token.nextToken());
        for(int i = 0; i < N; i++) {
            if(arr[i] >= arr[K-1] && arr[i] > 0)
                answer++;
        }
        System.out.println(answer);
    }
}
