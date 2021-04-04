package review;

import java.util.*;
import java.io.*;

// 리모컨
public class acmicpc1107 {
    static int[] arr = new int[1000000];
    static boolean[] err = new boolean[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        if(M != 0) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                err[Integer.parseInt(token.nextToken())] = true;
            }
        }

        if(N == 100) {
            System.out.println(0);
            System.exit(0);
        }
        int min = can(0) ? N+1 : Integer.MAX_VALUE;
        min = Math.min(Math.abs(100-N), min);
        for(int i = arr.length; i > 0; i--) {
            if(can(i)) {
                min = Math.min(min, (int)Math.log10(i) + Math.abs(N-i)+1);
            }
        }
        System.out.println(min);
    }
    static boolean can(int num) {
        while(num >= 10) {
            if(err[num%10])
                return false;
            num/= 10;
        }
        return !err[num];
    }
}
