package STL;

import java.util.*;
import java.io.*;

// https://codeforces.com/problemset/problem/231/A
public class Codeforce_231A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cnt = new int[N];
        StringTokenizer token = null;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                if (Integer.parseInt(token.nextToken()) == 1)
                    cnt[i]++;
            }
        }
        int answer = 0;
        for(int i = 0; i < N; i++) {
            if(cnt[i] >= 2)
                answer++;
        }
        System.out.println(answer);
    }
}
