package Array;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1316
public class 그룹단어체커 {
    static int[] alph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = N;
        loop: for(int i = 0; i < N; i++) {
            String str = br.readLine();
            alph = new int[26];
            char prev = str.charAt(0);
            alph[prev-97]++;
            for(int j = 1; j < str.length(); j++) {
                char cur = str.charAt(j);
                if(prev != cur) {
                    if(alph[cur-97] != 0) {
                        cnt--;
                        continue loop;
                    }
                    alph[cur-97]++;
                }
                prev = cur;
            }
        }
        System.out.println(cnt);
    }
}
