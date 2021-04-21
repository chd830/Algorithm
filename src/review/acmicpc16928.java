package review;

import java.util.*;
import java.io.*;

// 뱀과 사다리 게임
public class acmicpc16928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int[] cnt = new int[101];
        int[] ladder = new int[101];
        boolean[] visited = new boolean[101];

        for(int i = 0; i < N+M; i++) {
            token = new StringTokenizer(br.readLine());
            ladder[Integer.parseInt(token.nextToken())] = Integer.parseInt(token.nextToken());
        }
        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        cnt[1] = 0;
        visited[1] = true;
        while(!que.isEmpty()) {
            int n = que.poll();
            if(n == 100) {
////                System.out.println(cnt[1]+"\t"+cnt[2]+"\t"+cnt[60]+"\t"+cnt[65]+"\t"+cnt[25]+"\t"+cnt[30]+"\t"+cnt[98]+"\t"+cnt[100]);
//                System.out.println(cnt[1]+"\t"+cnt[5]+"\t"+cnt[6]+"\t"+cnt[12]+"\t"+cnt[98]+"\t"+cnt[100]);
//                System.out.println(cnt[1]+"\t"+cnt[5]+"\t"+cnt[6]+"\t"+cnt[86]+"\t"+cnt[92]+"\t"+cnt[98]+"\t"+cnt[100]);
                System.out.println(cnt[n]);
                System.exit(0);
            }
            for(int i = 1; i < 7; i++) {
                int x = n + i;
                // 조건문을 한번에 다 때려넣으면 22%에서 에러가 난다. x > 100, visited[x]를 따로 두고
                // ladder[x] != 0과 !visited[ladder[x]]를 따로 두어야한다.
                if(x > 100) continue;
                if(visited[x]) continue;
                visited[x] = true;
                if(ladder[x] != 0) {
                    if (!visited[ladder[x]]) {
//                    cnt[x] = cnt[n]+1;
                        visited[ladder[x]] = true;
                        cnt[ladder[x]] = cnt[n] + 1;
                        que.add(ladder[x]);
                    }
                }
                else {
                    cnt[x] = cnt[n]+1;
                    que.add(x);
                }
            }
        }
    }
}
