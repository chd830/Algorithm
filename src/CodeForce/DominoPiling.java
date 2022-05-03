package CodeForce;

import java.util.*;
import java.io.*;

// https://codeforces.com/problemset/problem/50/A
public class DominoPiling {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        System.out.println(N*M/2);
    }
}
