package review;

import java.util.*;
import java.io.*;

public class Solution {
    static int cnt[] = new int[101];
    static int ladder[] = new int[101];
    static boolean visited[] = new boolean[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 사다리의 수
        int m = Integer.parseInt(st.nextToken()); // 뱀의 수

        for(int i = 0; i < n+m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladder[a] = b;
        }

        bfs();
    }

    static void bfs() {
        Queue<Integer> que = new LinkedList<Integer>();
        que.add(1);
        cnt[1] = 0;
        visited[1] = true;

        while(!que.isEmpty()) {
            int n = que.poll();
            if(n == 100) {
//                                System.out.println(cnt[1]+"\t"+cnt[2]+"\t"+cnt[60]+"\t"+cnt[65]+"\t"+cnt[25]+"\t"+cnt[30]+"\t"+cnt[98]+"\t"+cnt[100]);
//                System.out.println(cnt[1]+"\t"+cnt[5]+"\t"+cnt[6]+"\t"+cnt[12]+"\t"+cnt[98]+"\t"+cnt[100]);
                System.out.println(cnt[1]+"\t"+cnt[5]+"\t"+cnt[6]+"\t"+cnt[86]+"\t"+cnt[92]+"\t"+cnt[98]+"\t"+cnt[100]);
                System.out.println(cnt[n]);
                return;
            }

            for(int i = 1; i < 7; i++) {
                int x = n + i;
                if(100 < x) continue;
                if(visited[x]) continue;
                visited[x] = true;

                if(ladder[x] != 0) { // 사다리 또는 뱀의 위치일때
                    if(!visited[ladder[x]]) {
                        que.add(ladder[x]);
                        visited[ladder[x]] = true;
                        cnt[ladder[x]] = cnt[n] + 1;
                    }
                }
                else { //아무것도 아닐때
                    que.add(x);
                    cnt[x] = cnt[n] + 1;
                }
            }
        }
    }
}