package review;

import java.util.*;
import java.io.*;

public class acmicpc1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] visited = new int[10000000];
        Queue<Integer> que = new LinkedList<>();
        que.add(N);
        while(true) {
            int num = que.poll();
            if(num == 1) {
                System.out.println(visited[1]);
                break;
            }
            if(num%3 == 0 && visited[num/3] == 0) {
                que.add(num/3);
                visited[num/3] = visited[num]+1;
            }
            if(num%2 == 0 && visited[num/2] == 0) {
                que.add(num/2);
                visited[num/2] = visited[num]+1;
            }
            if(num-1 >= 1 && visited[num-1] == 0) {
                que.add(num-1);
                visited[num-1] = visited[num]+1;
            }
        }
    }
}
