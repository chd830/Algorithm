package Concept;

import java.util.LinkedList;
import java.util.Queue;

public class 마이쮸 {
    public static void main(String[] args) {
        int N = 10;
        int person = 1;
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {person, 1});
        while(N > 0) {
            int cnt;
            if(!que.isEmpty()) {
                int[] p = que.poll();
                cnt = (N >= p[1]) ? p[1] : N;
                N -= cnt;
                if(N == 0) {
                    System.out.println("마지막 마이쮸는 "+p[0]+"가 "+cnt+"개를 가져간다. ");
                }
                else {
                    System.out.println(p[0]+"번 사람이 "+p[1]+"개수의 마이쮸를 가져갑니다.");
                    p[1]++;
                    que.offer(p);
                    que.offer(new int[] {++person, 1});
                }
            }
        }
    }
}
