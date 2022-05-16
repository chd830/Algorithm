package STL;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/11286
public class 절댓값힙 {
    static class N implements Comparable<N> {
        int n;

        N(int n) {
            this.n = n;
        }
        @Override
        public int compareTo(N o) {
            if(Math.abs(this.n) == Math.abs(o.n))
                return Integer.compare(this.n, o.n);
            return Integer.compare(Math.abs(this.n), Math.abs(o.n));
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<N> que = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x != 0)
                que.add(new N(x));
            else if(que.isEmpty())
                sb.append(0).append("\n");
            else
                sb.append(que.poll().n).append("\n");
        }
        System.out.println(sb.toString());
    }
}
