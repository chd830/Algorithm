package Math;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2407
public class 조합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        M = Math.max(N-M, M);
        BigInteger answer = BigInteger.ONE;
        for(int i = M+1; i <= N; i++)
            answer = answer.multiply(new BigInteger(String.valueOf(i)));
        for(int i = N-M; i > 1; i--)
            answer = answer.divide(new BigInteger(String.valueOf(i)));
        System.out.println(answer);
    }
}
