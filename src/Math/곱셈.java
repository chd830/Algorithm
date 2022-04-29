package Math;

import java.util.*;
import java.io.*;

//
public class 곱셈 {
    static long A;
    static long B;
    static long C;
    // A^B/C
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        A = Integer.parseInt(token.nextToken());
        B = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());
        System.out.println(multiple(A, B));
    }
    static long multiple(long a, long b) {
        a %= C;
        if(b == 0)
            return 1;
        // 나눌 횟수가 짝수일 때
        else if(b%2 == 0)
            return multiple(a*a, b>>1)%C;
        // 나눌 횟수가 홀수일 때
        else
            return a*multiple(a, b-1)%C;
    }
}
