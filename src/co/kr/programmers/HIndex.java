package co.kr.programmers;

import java.util.*;

public class HIndex {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {3, 0, 6, 1, 5}));
        // 3
        System.out.println(solution(new int[] {12, 11, 10, 9, 8, 1}));
        // 5
        System.out.println(solution(new int[] {2, 2, 2, 2, 2}));
        // 2
        System.out.println(solution(new int[] {0, 1, 1}));
        // 1
    }
    public static int solution(int[] citations) {
        Arrays.sort(citations);
        int cnt = 0;
        for(int i = citations.length-1; i >= 0; i--) {
            if(citations[i] > cnt)
                cnt++;
            else
                break;
        }
        return cnt;
    }
}
