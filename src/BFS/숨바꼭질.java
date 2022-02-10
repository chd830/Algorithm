package BFS;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1697
public class 숨바꼭질 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int subin = Integer.parseInt(token.nextToken());
        int brother = Integer.parseInt(token.nextToken());
        int[] distance = new int[brother*2+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Queue<Integer> que = new LinkedList<>();
        que.add(subin);
        distance[subin] = 0;

        /*
        Queue
        Poll: 값을 꺼냄
        Peek: 값을 보여줌
        Push, Add: 값을 넣음
         */
        while(!que.isEmpty()) {
            int node = que.poll();
            if(node == brother) {
                break;
            }
            if(node*2 < distance.length && distance[node*2] > distance[node]+1) {
                distance[node * 2] = distance[node] + 1;
                que.add(node*2);
            }
            if(node+1 < distance.length && distance[node+1] > distance[node]+1) {
                distance[node + 1] = distance[node] + 1;
                que.add(node+1);
            }
            if(node-1 >= 0 && distance[node-1] > distance[node]+1) {
                distance[node - 1] = distance[node] + 1;
                que.add(node-1);
            }
        }
        System.out.println(distance[brother]);
    }
}
