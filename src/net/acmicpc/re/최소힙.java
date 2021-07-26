package net.acmicpc.re;

import java.util.*;
import java.io.*;

// 1927
public class 최소힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> que = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) {
                if(que.size() == 0)
                    sb.append(0).append("\n");
                else
                    sb.append(que.poll()).append("\n");
            }
            else {
                que.add(n);
            }
        }
        System.out.println(sb.toString());
    }
}
