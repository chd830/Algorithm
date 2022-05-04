package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1013
public class Contact {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            String str = br.readLine().trim();
            if(str.matches("(100+1+|01)+"))
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }
        System.out.println(sb.toString());
    }
}
