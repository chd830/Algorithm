package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/42627
public class P_디스크컨트롤러 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{0, 3}, {1, 9}, {2, 6}}));
        System.out.println(solution(new int[][] {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}}));
    }
    static class Node implements Comparable<Node> {
        int start;
        int time;
        Node(int start, int time) {
            this.start = start;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            if(this.time == o.time)
                return Integer.compare(this.start, o.start);
            return Integer.compare(this.time, o.time);
        }
    }
    public static int solution(int[][] jobs) {
        int cnt = 0;
        int result = 0;
        int time = 0;
        List<Node> list = new ArrayList<>();
        boolean[] check = new boolean[jobs.length];
        Arrays.fill(check, false);
        boolean flag = false;
        while(true) {
            if(!list.isEmpty() && list.get(0).time == 0) {
                result += time-list.get(0).start;
                list.remove(0);
                cnt++;
                flag = false;
                if(!list.isEmpty())
                    Collections.sort(list);
            }
            if(cnt == jobs.length)
                break;
            for(int i = 0; i < jobs.length; i++) {
                int[] job = jobs[i];
                if(job[0] <= time && !check[i]) {
                    list.add(new Node(job[0], job[1]));
                    check[i] = true;
                    if(!flag)
                        Collections.sort(list);
                }
            }
            if(!list.isEmpty()) {
                flag = true;
                list.get(0).time--;
            }
            time++;
        }
        return result/jobs.length;
    }
}
