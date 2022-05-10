package Dynamic;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2096
public class 내려가기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] max = new int[N+1][5];
        int[][] min = new int[N+1][5];
        for(int i = 0; i <= N; i++)
            Arrays.fill(min[i], 987654321);
        StringTokenizer token = null;
        for(int i = 1; i <= N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 3; j++) {
                max[i][j] = Integer.parseInt(token.nextToken());
                min[i][j] = max[i][j];
            }
        }
        for(int i = 2; i <= N; i++) {
            for(int j = 1; j <= 3; j++) {
                max[i][j] = Math.max(max[i-1][j]+max[i][j], Math.max(max[i-1][j-1]+max[i][j], max[i-1][j+1]+max[i][j]));
                min[i][j] = Math.min(min[i-1][j]+min[i][j], Math.min(min[i-1][j-1]+min[i][j], min[i-1][j+1]+min[i][j]));
            }
        }
        int maxValue = 0;
        int minValue = Integer.MAX_VALUE;
        for(int i = 1; i <= 3; i++) {
            maxValue = Math.max(maxValue, max[N][i]);
            minValue = Math.min(minValue, min[N][i]);
        }
        System.out.println(maxValue+" "+minValue);
    }
}
