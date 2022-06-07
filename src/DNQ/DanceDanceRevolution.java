package DNQ;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2342
public class DanceDanceRevolution {
    static class Node {
        int x;
        int y;
        int cnt;
        Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", cnt=" + cnt +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        int n = Integer.parseInt(token.nextToken());
        while (n != 0) {
            list.add(n);
            n = Integer.parseInt(token.nextToken());
        }
        if (list.size() == 0) {
            System.out.println(0);
            System.exit(0);
        }
        N = list.size();
        dp = new int[N+1][5][5];
        System.out.println(ddr(0, 0, 0));
    }
    static int[][][] dp;
    static int N;
    static List<Integer> list;
    static int ddr(int step, int l, int r) {
        if(step == N)
            return 0;
        if(dp[step][l][r] != 0)
            return dp[step][l][r];
        int left = transform(l, list.get(step))+ddr(step+1, list.get(step), r);
        int right = transform(r, list.get(step))+ddr(step+1, l, list.get(step));
        return dp[step][l][r] = Math.min(left, right);
    }
    static int transform(int from, int to) {
        if(from == to)
            return 1;
        if(from == 0)
            return 2;
        int n = Math.abs(from-to);
        if(n == 1 || n == 3)
            return 3;
        return 4;
    }
}
