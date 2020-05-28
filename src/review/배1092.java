package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 배1092 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] limit = new int[N];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            limit[i] = Integer.parseInt(token.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        int[] weight = new int[M];
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            weight[i] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(limit);
        Arrays.sort(weight);
        Queue<Integer> que = new LinkedList<>();
        for(int w : weight) {
            que.add(w);
        }
        if(limit[N-1] < weight[M-1]) {
            System.out.println(-1);
            System.exit(0);
        }
        boolean[] visited = new boolean[M];
        int cnt = 0;
        int box = 0;
        while(!que.isEmpty() || box > M) {
            for(int i = 0; i < N; i++) {
                box++;
                int size = que.size();
                for(int j = 0; j < size; j++) {
                    int num = que.poll();
                    if(!visited[j] && num <= limit[i]) {
                        cnt++;
                        visited[j] = true;
                        break;
                    }
                    else {
                        que.add(num);
                    }
                }
            }
        }
        System.out.println(box);
    }
}
