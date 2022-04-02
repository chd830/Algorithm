package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/22233
public class 가희와키워드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        // 키워드 N개
        // 글 M개
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            map.put(br.readLine(), 0);
        }
        StringBuilder sb = new StringBuilder();
        int cnt = N;
        for(int i = 0; i < M; i++) {
            String[] str = br.readLine().split(",");
            for(int j = 0; j < str.length; j++) {
                if(map.containsKey(str[j])) {
                    map.remove(str[j]);
                    cnt--;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }
}
