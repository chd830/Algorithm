package STL;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1062
public class 가르침 {
    static int N;
    static int K;
    static int max;
    static int[] alph = new int[26];
    static String[] antarctica;
    static boolean[] visited = new boolean[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());
        antarctica = new String[N];
        for (int i = 0; i < N; i++) {
            antarctica[i] = br.readLine().replaceAll("anta|tica", "");
        }
        // anta-tica는 기본으로 포함되어있기 때문에 visited설정을 한 후 조합에서 5개를 제외한 개수를 센다.
        visited[0] = visited['c'-'a'] = visited['n'-'a'] = visited['t'-'a'] = visited['i'-'a'] = true;
        // 시간을 더 줄이는 방법
        if(K < 5)
            System.out.println(0);
        else if(K == 26)
            System.out.println(N);
        else {
            combination(0, 0);
            System.out.println(max);
        }
    }
    static void combination(int idx, int cur) {
        if(cur == K-5) {
            int cnt = 0;
            loop: for(int i = 0; i < N; i++) {
                for(char c : antarctica[i].toCharArray()) {
                    if(!visited[c-'a'])
                        continue loop;
                }
                cnt++;
            }
            max = Math.max(max, cnt);
            return;
        }
        for(int i = idx; i < 26; i++) {
            if(!visited[i]) {
                visited[i] = true;
                combination(i+1, cur+1);
                visited[i] = false;
            }
        }

    }
}
/*
6 6
antabcdefgtica
antabcdefgtica
antabcdefgtica
antabcdefgtica
antabcdefgtica
antaztica

actinz
 */