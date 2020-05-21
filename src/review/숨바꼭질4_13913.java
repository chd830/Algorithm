package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 숨바꼭질4_13913 {
    public static final  int MAX = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int[] map = new int[MAX];
        int[] result = new int[MAX];
        boolean[] visited = new boolean[MAX];
        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        Queue<Integer> que = new LinkedList<>();
        que.add(N);
        loop: while(!que.isEmpty()) {
            int size = que.size();
            for(int i = 0; i < size; i++) {
                int num = que.poll();
                if(num == K) {
                    break loop;
                }
                if(num-1 >= 0 && !visited[num-1]) {
                    que.add(num-1);
                    result[num-1] = num;
                    map[num-1] = map[num]+1;
                    visited[num-1] = true;
                }
                if(num+1 < MAX && !visited[num+1]) {
                    que.add(num+1);
                    result[num+1] = num;
                    map[num+1] = map[num]+1;
                    visited[num+1] = true;
                }
                if(num*2 < MAX && !visited[num*2]) {
                    que.add(num*2);
                    result[num*2] = num;
                    map[num*2] = map[num]+1;
                    visited[num*2] = true;
                }
            }
        }
        System.out.println(map[K]);
        Stack<Integer> stack = new Stack<>();
        for(int i = K; i != N; i = result[i]) {
            stack.push(i);
        }
        stack.push(N);
        while(!stack.isEmpty()) {
            System.out.print(stack.pop()+" ");
        }
        System.out.println();
    }
}
