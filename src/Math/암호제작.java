package Math;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1837
public class 암호제작 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        BigInteger P = new BigInteger(token.nextToken());
        BigInteger K = new BigInteger(token.nextToken());
        BigInteger i = new BigInteger("1");
        while(true) {
            // K보다 크거나 같을 때
            if(i.compareTo(K) == 1 || i.compareTo(K) == 0)
                break;
            i = i.add(BigInteger.ONE);
            // P mod i의 값이 0이고 K보다 i값이 작을 때
            if(P.remainder(i).compareTo(BigInteger.ZERO) == 0 && i.compareTo(K) == -1) {
                System.out.println("BAD " + i);
                System.exit(0);
            }
        }
        System.out.println("GOOD");
    }
}