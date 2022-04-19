package Dynamic;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/11727
public class 타일링2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] d = new int[1001];
        d[0] = 0;
        d[1] = 1;
        d[2] = 3;
        d[3] = 5;
        for(int i = 4; i <= N; i++)
            d[i] = 2*d[i-2]%10007+d[i-1]%10007;
        System.out.println(d[N]%10007);
    }
}
