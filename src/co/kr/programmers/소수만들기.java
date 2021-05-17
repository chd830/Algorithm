package co.kr.programmers;

import java.util.*;

public class 소수만들기 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 2, 3, 4}));
    }
    static int cnt = 0;
    static int[] sub = new int[3];
    static boolean[] odd = new boolean[500000];
    static boolean[] visited;
    public static int solution(int[] nums) {
        Arrays.fill(odd, true);
        for(int i = 2; i < odd.length; i++) {
            for (int j = i + i; j < odd.length; j += i) {
                odd[j] = false;
            }
        }
        visited = new boolean[nums.length];
        // 서로 다른 세개 뽑기
        comb(nums, 0, 0);
        return cnt;
    }
    static void comb(int[] nums, int idx, int subIdx) {
        if(subIdx == sub.length) {
            int sum = 0;
            for(int s : sub)
                sum += s;
//            System.out.println(Arrays.toString(sub)+"\t"+sum);
            if(odd[sum])
                cnt++;
            return;
        }
        for(int i = idx; i < nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                sub[subIdx] = nums[i];
                comb(nums, i+1, subIdx+1);
                visited[i] = false;
            }
        }
    }
}
