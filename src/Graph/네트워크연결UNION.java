package Graph;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1922
public class 네트워크연결UNION {
    static class Computer implements Comparable<Computer> {
        int from;
        int to;
        int val;
        Computer(int from, int to, int val) {
            this.from = from;
            this.to = to;
            this.val = val;
        }

        @Override
        public int compareTo(Computer o) {
            return Integer.compare(this.val, o.val);
        }
    }
    static int[] parent;
    static List<Computer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        for(int i = 1; i <= N; i++)
            parent[i] = i;
        list = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(token.nextToken());
            int to = Integer.parseInt(token.nextToken());
            int val = Integer.parseInt(token.nextToken());
            list.add(new Computer(from, to, val));
        }
        Collections.sort(list);
        int sum = 0;
        for(int i = 0; i < list.size(); i++) {
            Computer computer = list.get(i);
            if(find(computer.from) != find(computer.to)) {
                sum += computer.val;
                union(computer.from, computer.to);
            }
        }
        System.out.println(sum);
    }
    static int find(int x) {
        if(x == parent[x])
            return x;
        return parent[x] = find(parent[x]);
    }
    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x != y)
            parent[y] = x;
    }
}
