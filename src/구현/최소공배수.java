package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1934
public class 최소공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(token.nextToken());
            int B = Integer.parseInt(token.nextToken());
            if (A == B) {
                sb.append(A).append("\n");
                continue;
            }
            else if(A < B) {
                int tmp = A;
                A = B;
                B = tmp;
            }
            sb.append(LCM(A, B)).append("\n");
        }
        System.out.println(sb.toString());
    }
    static int LCM(int a, int b) {
        return a*b/GCD(a, b);
    }
    static int GCD(int a, int b) {
        if(b == 0)
            return a;
        return GCD(b, a%b);
    }
}
