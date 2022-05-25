package Math;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/11653
public class 소인수분해 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int start = 2;
        while(N > 1) {
            if(N%start == 0) {
                N/=start;
                sb.append(start).append("\n");
            }
            else
                start++;
        }
        System.out.print(sb.toString());
    }
}
