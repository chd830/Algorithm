package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class 요세푸스문제0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        Queue<Integer> que = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            que.add(i);
        }
        int cnt = 1;
        while(!que.isEmpty()) {
            int num = que.poll();
            if(cnt%K == 0 && que.size() >= 1) {
                sb.append(num+", ");
            }
            else if(cnt%K == 0 && que.size() < 1) {
                sb.append(num);
            }
            else {
                que.add(num);
            }
            cnt++;
        }
        sb.append(">");
        System.out.println(sb);
    }
}
