package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2075
public class N번째큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer token = null;
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                que.add(Integer.parseInt(token.nextToken()));
            }
        }
        for(int i = 0; i < N*N-N; i++)
            que.poll();
        System.out.println(que.poll());
    }
}
