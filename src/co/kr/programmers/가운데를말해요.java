package co.kr.programmers;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1655
public class 가운데를말해요 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> o2-o1);
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if(min.size() == max.size())
                max.add(n);
            else
                min.add(n);

            if(!min.isEmpty() && !max.isEmpty()) {
                if(min.peek() < max.peek()) {
                    int tmp = min.poll();
                    min.add(max.poll());
                    max.add(tmp);
                }
            }
            sb.append(max.peek()).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
