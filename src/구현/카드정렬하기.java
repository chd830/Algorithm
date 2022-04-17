package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1715
public class 카드정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int i = 0; i < N; i++)
            que.add(Integer.parseInt(br.readLine()));
        int sum = 0;
        if(N < 2)
            sum = 0;
        else {
            while (que.size() > 1) {
                int n1 = que.poll();
                int n2 = que.poll();
                sum += n1+n2;
                que.add(n1+n2);
            }
        }
        System.out.println(sum);
    }
}
