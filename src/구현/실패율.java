package 구현;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/42889
public class 실패율 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3})));
        System.out.println(Arrays.toString(solution(4, new int[] {4, 4, 4, 4, 4})));
        System.out.println(Arrays.toString(solution(3, new int[] {1, 1, 1})));
    }
    static class Stage implements Comparable<Stage> {
        int n;
        double rate;
        Stage(int n, double rate) {
            this.n = n;
            this.rate = rate;
        }

        @Override
        public int compareTo(Stage o) {
            if(this.rate == o.rate)
                return Integer.compare(this.n, o.n);
            return -Double.compare(this.rate, o.rate);
        }
    }
    // 실패율 스테이지에 도달했으나 클리어하지못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
    public static int[] solution(int N, int[] stages) {
        int[] result = new int[N];
        Stage[] game = new Stage[N];
        int total  = stages.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i <= 200000; i++)
            map.put(i, 0);
        for(int stage : stages)
            map.put(stage, map.get(stage)+1);
        for(int i = 0; i < N; i++) {
            game[i] = new Stage(i+1, (double)map.get(i+1)/total);
            if(total == 0)
                game[i] = new Stage(i+1, 0);
            total -= map.get(i+1);
        }
        Arrays.sort(game);
        for(int i = 0; i < N; i++)
            result[i] = game[i].n;
        return result;
    }
}
