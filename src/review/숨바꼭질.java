package review;

import java.util.*;
import java.io.*;

// 최단거리를 찾으려면 BFS를 사용하고 도달할 수 있는 모든 점을 찾으려면 DFS를 사용
public class 숨바꼭질 {
    static int[] arr = new int[1000000];
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        if(N >= M) {
            System.out.println(N-M);
        }
        else {
            recur();
        }
    }
    static void recur() {
        Queue<Integer> que = new LinkedList();
        que.add(N);
        while(!que.isEmpty()) {
            int idx = que.poll();
            if (idx == M) {
                System.out.println(arr[idx]);
                return;
            }
            if (idx + idx < arr.length && arr[idx + idx] == 0) {
                arr[idx + idx] = arr[idx] + 1;
                que.add(idx+idx);
            }
            if (idx + 1 < arr.length && arr[idx + 1] == 0) {
                arr[idx + 1] = arr[idx] + 1;
                que.add(idx+1);
            }
            if (idx - 1 >= 0 && arr[idx - 1] == 0) {
                arr[idx - 1] = arr[idx] + 1;
                que.add(idx-1);
            }
        }
    }
}
