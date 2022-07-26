package Math;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1850
public class 최대공약수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        long N = Long.parseLong(token.nextToken());
        long M = Long.parseLong(token.nextToken());
        long n = gcd(N, M);
        StringBuilder sb = new StringBuilder();
        while(n-- > 0)
            sb.append(1);
        System.out.println(sb.toString());
    }
    static long gcd(long a, long b) {
        if(b == 0)
            return a;
        return gcd(b, a%b);
    }

}
