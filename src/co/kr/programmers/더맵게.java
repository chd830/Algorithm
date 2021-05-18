package co.kr.programmers;

import java.util.*;

public class 더맵게 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 2, 3, 9, 10, 12}, 7));
        System.out.println(solution(new int[] {1, 1, 1}, 10));
        System.out.println(solution(new int[] {1, 1, 1}, 4));
        System.out.println(solution(new int[] {10, 10, 10, 10, 10}, 100));
        System.out.println(solution(new int[]{0, 0, 3, 9, 10, 12}, 7));
        System.out.println(solution(new int[]{0, 0}, 1));
        System.out.println(solution(new int[]{1, 0}, 1));

        // 2, -1, 2, 4, 3, -1, 1
    }
    // 시간초과
//    public static int solution(int[] scoville, int K) {
//        int i = 0;
//        int j = 1;
//        int idx = 0;
//        while(true) {
//            Arrays.sort(scoville);
//            int sum = scoville[i] + scoville[j]*2;
//            if(j >= scoville.length-1) {
//                if(sum < K)
//                    return -1;
//                return idx+1;
//            }
//            if(scoville[i] >= K) {
//                return idx;
//            }
//            scoville[i] = -1;
//            scoville[j] = sum;
//            i++;
//            j++;
//            idx++;
//        }
//    }

    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int s : scoville)
            que.add(s);
        int idx = 0;
        while(!que.isEmpty()) {
            if(que.peek() >= K)
                return idx;
            if(que.size() < 2) {
                if(que.poll() >= K)
                    return idx;
                return -1;
            }
            int n1 = que.poll();
            int n2 = que.poll();
            int sum = n1 + n2*2;
            que.add(sum);
            idx++;
        }
        return idx;
    }
}
