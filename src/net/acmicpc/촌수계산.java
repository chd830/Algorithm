package net.acmicpc;

import java.util.*;

public class 촌수계산 {
    static int[] chain;
    static List<Integer>[] list;
    static boolean[] visited;
    static int start;
    static int end;
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        start = sc.nextInt();
        end = sc.nextInt();
        cnt = 0;
        int m = sc.nextInt();
        list = new ArrayList[n+1];
        visited = new boolean[n+1];
        chain = new int[n+1];
        for(int i = 0; i <= n; i++) {
            list[i] = new ArrayList();
        }
        for(int i = 0; i < m; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            list[num1].add(num2);
            list[num2].add(num1);
        }
        bfs();
//        System.out.println("\n"+Arrays.toString(chain));
        System.out.println((chain[end] == 0 ? -1 : chain[end]));
    }
    public static void bfs() {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visited[start] = true;
        while(!que.isEmpty()) {
            int num = que.poll();
//            System.out.print(num+" ");
            if(num == end) {
                break;
            }
            for(int i = 0; i < list[num].size(); i++) {
                int l = list[num].get(i);
                if(!visited[l]) {
                    chain[l] = chain[num]+1;
//                    System.out.println("\t"+Arrays.toString(chain));
                    visited[l] = true;
                    que.add(l);
                }
            }
        }
    }
}
