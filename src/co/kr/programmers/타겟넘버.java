package co.kr.programmers;

import java.util.*;

public class 타겟넘버 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 1, 1, 1, 1}, 3));
    }
    static int cnt;
    static boolean[] visited;
    public static int solution(int[] numbers, int target) {
        cnt = 0;
        visited = new boolean[numbers.length];
        dfs(0, 0, target, numbers);
        return cnt;
    }
    static void dfs(int idx, int sum, int target, int[] numbers) {
        if(idx == visited.length) {
            if(sum == target)
                cnt++;
            return;
        }
        dfs(idx+1, sum+numbers[idx], target, numbers);
        dfs(idx+1, sum-numbers[idx], target, numbers);
    }
}
