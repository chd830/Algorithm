package BFS;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/13913
public class 숨바꼭질13913 {

    private static final int MAX = 1000000;
    static int N;
    static int K;
    static int[] arr = new int[MAX];
    static int[] result = new int[MAX];
    static boolean[] visited = new boolean[MAX];
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());
        Queue<Integer> que = new LinkedList<>();
        que.add(N);
        loop: while(!que.isEmpty()) {
            int size = que.size();
            for(int i = 0; i < size; i++) {
                int num = que.poll();
                if(num == K)
                    break loop;
                if(num-1 >= 0 && !visited[num-1]) {
                    que.add(num-1);
                    result[num-1] = num;
                    arr[num-1] = arr[num]+1;
                    visited[num-1] = true;
                }
                if(num+1 < MAX && !visited[num+1]) {
                    que.add(num+1);
                    result[num+1] = num;
                    arr[num+1] = arr[num]+1;
                    visited[num+1] = true;
                }
                if(num*2 >= 0 && !visited[num*2]) {
                    que.add(num*2);
                    result[num*2] = num;
                    arr[num*2] = arr[num]+1;
                    visited[num*2] = true;
                }
            }
        }
        System.out.println(arr[K]);
        Stack<Integer> stack = new Stack<>();
        for(int i = K; i != N; i = result[i])
            stack.push(i);
        stack.push(N);
        while(!stack.isEmpty())
            System.out.print(stack.pop()+" ");
    }
}
