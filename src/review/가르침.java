package review;

import java.util.*;
import java.io.*;

// 시간초과
public class 가르침 {
    static int N;
    static int K;
    static int res;
    static String[] strs;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());
        strs = new String[N];
        visited = new boolean[26];
        for(int i = 0; i < N; i++) {
            strs[i] = br.readLine().replaceAll("anta|tica", "");
        }
        if(K < 5) {
            System.out.println(0);
        }
        else if(K == 26) {
            System.out.println(N);
        }
        else {
            visited[0] = true;
            visited[2] = true;
            visited[13] = true;
            visited[8] = true;
            visited[19] = true;

            check(0, 0);
            System.out.println(res);
        }
    }
    static void check(int alph, int cnt) {
        // K에서 주어진 수만큼 알파벳이 있을 때
        if(cnt == K-5) {
            int tmp = 0;
            for(int i = 0; i < N; i++) {
                boolean flag = true;

                // K보다 많은 알파벳이 있는지 확인
                for(int j = 0; j < strs[i].length(); j++) {
                    if(!visited[strs[i].charAt(j)-97]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    tmp++;
                }
            }
            res = Math.max(tmp, res);
            return;
        }
        // 조합
        for(int i = alph; i < 26; i++) {
            if(!visited[i]) {
                visited[i] = true;
                check(i+1, cnt+1);
                visited[i] = false;
            }
        }
    }
}
