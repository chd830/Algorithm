package net.acmicpc.re;

import java.util.*;
import java.io.*;

// 11279
public class 최대힙 {
    static class Num implements Comparable<Num> {
        int n;

        Num(int n) {
            this.n = n;
        }

        @Override
        public int compareTo(Num o) {
            return -Integer.compare(this.n, o.n);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Num> que = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) {
                if(que.size() == 0)
                    sb.append(0).append("\n");
                else
                    sb.append(que.poll().n).append("\n");
            }
            else
                que.add(new Num(n));
        }
        System.out.println(sb.toString());
    }
}
