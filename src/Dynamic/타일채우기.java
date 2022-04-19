package Dynamic;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2133
public class 타일채우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] d = new int[N+1];
        d[0] = 1;
        for(int i = 2; i <= N; i++) {
            d[i] = 3*d[i-2];
            for(int j = i-4; j >= 0; j -= 2)
                d[i] += 2*d[j];
        }
        System.out.println(d[N]);
    }
}
