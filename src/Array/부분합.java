package Array;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1806
public class 부분합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int[] arr = new int[N];
        int K = Integer.parseInt(token.nextToken());
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        int length = Integer.MAX_VALUE;
        int sum = 0;
        int idx = 0;
        for(int i = 0; i <= N; ) {
            if(sum >= K && idx <= i) {
                length = Math.min(length, i-idx);
                sum -= arr[idx];
                idx++;
                continue;
            }
            if(i != N)
                sum += arr[i];
            i++;
        }
        System.out.println(length == Integer.MAX_VALUE ? 0 : length);
    }
}
/*

10 21
11 2 5 6 8 9 2 3 10 9 10
답: 3

10 10
1 1 1 1 1 1 1 1 1 10
답: 1

10 10
3 3 3 3 3 3 3 3 3 3
답: 4

4 5
1 2 2 3
답: 2

10 9
1 1 1 1 1 1 1 1 1 8
답: 2

10 100
32 23 42 2 94 3 1 45 37 4
답: 3

10 271
17 50 83 12 28 34 59 74 90 5
답: 5

100 1300
37 82 86 86 93 23 4 62 88 50 94 38 53 48 60 75 44 65 16 66 99 82 12 53 18 78 27 99 50 4 79 42 81 95 83 25 15 61 97 27 2 88 31 61 64 36 86 3 53 1 97 78 100 59 45 100 36 41 52 13 60 30 62 79 49 25 66 60 43 28 69 54 19 51 50 100 89 83 11 96 9 47 45 45 46 12 17 15 67 91 94 68 5 25 85 39 12 66 88 65
답: 21

100 1200
60 71 85 40 95 70 56 88 29 59 6 4 4 48 31 80 31 51 14 100 45 42 77 39 47 77 19 80 31 9 91 54 55 27 82 34 55 3 42 64 18 96 75 46 88 32 81 9 61 24 51 6 96 28 49 84 13 78 35 63 20 62 99 82 96 69 86 64 68 93 46 78 14 4 34 9 52 86 84 94 48 59 77 4 26 27 80 55 48 99 55 83 15 56 61 29 25 14 7 30
답: 19

 */