package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/8958
public class OX퀴즈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            String str = br.readLine();
            int cnt = 0;
            int sum = 0;
            for(char c : str.toCharArray()) {
                if(c == 'O') {
                    cnt++;
                    sum += cnt;
                }
                else
                    cnt = 0;
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb.toString());
    }
}
