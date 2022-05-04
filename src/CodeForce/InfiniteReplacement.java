package CodeForce;

import java.util.*;
import java.io.*;

// https://codeforces.com/problemset/problem/1674/C
public class InfiniteReplacement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        loop: for(int time = 0; time < T; time++) {
            String s = br.readLine();
            String t = br.readLine();
            if(t.length() == 1 && t.charAt(0) == 'a')
                sb.append("1\n");
            else {
                for(char c : t.toCharArray()) {
                    if(c == 'a') {
                        sb.append("-1\n");
                        continue loop;
                    }
                }
                long answer = 1;
                int n = s.length();
                while(n-- > 0) {
                    answer = answer<<1;
                }
                sb.append(answer).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
