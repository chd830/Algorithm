package net.acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DSLR {
    static final int MAX = 100000;
    static String[] from;
    static int[] order;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            String A = sc.next();
            String B = sc.next();
            int[] map = new int[MAX];
            from = new String[MAX];
            order = new int[MAX];
            Queue<Integer> que = new LinkedList<>();
            que.add(Integer.parseInt(A));
            while(!que.isEmpty()) {
                int n = que.poll();
                if(map[n*2%10000] == 0) {
                    map[n*2%10000] = map[n] + 1;
                    from[n*2%10000] = "D";
                    order[n*2%10000] = n;
                    que.add(n*2%10000);
                }
                if(n-1 >= 0 && map[n] == 0) {
                    if(n == 1) {
                        map[n-1] = 9999;
                    }
                    else {
                        map[n - 1] = map[n] + 1;
                    }
                    from[n-1] = "S";
                    order[n-1] = n;
                    que.add(n-1);
                }
                int left = (n/10) + (n%10)*1000;
                int right = (n%1000)*10 + n/1000;
                if(map[left] == 0) {
                    map[left] = n + 1;
                    from[left] = "L";
                    order[left] = n;
                    que.add(left);
                }
                if(map[right] == 0) {
                    map[right] = n + 1;
                    from[right] = "R";
                    order[right] = n;
                    que.add(right);
                }
            }
            sb = new StringBuilder();
            print(Integer.parseInt(A), Integer.parseInt(B));
            sb = sb.delete(0, 1);
            System.out.println(sb.toString());
        }
    }
    static StringBuilder sb;
    public static void print(int n, int m) {
        if(n != m) {
            print(n, order[m]);
        }
        sb.append(from[m]);
    }
}
