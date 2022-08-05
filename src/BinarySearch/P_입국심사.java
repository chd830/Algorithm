package BinarySearch;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/43238
public class P_입국심사 {
    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{7, 10}));
    }
    public static long solution(int n, int[] times) {
        Arrays.sort(times);
        long start = 1;
        long end = (long)n*times[times.length-1];
        while(start < end) {
            long mid = (start+end)/2;
            if(check(mid, times) < n)
                start = mid+1;
            else
                end = mid;
        }
        return start;
    }
    static long check(long time, int[] times) {
        long cnt = 0;
        for(int i = 0; i < times.length; i++) {
            cnt += time/times[i];
        }
        return cnt;
    }
}
