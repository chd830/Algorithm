package review;

import java.util.*;
import java.io.*;

public class 타겟넘버 {
    static int cnt;
    public static int solution(int[] numbers, int target) {
        cnt = 0;
        recur(0, 0, numbers, target);
        return cnt;
    }
    static void recur(int idx, int sum, int[] numbers, int target) {
        if(idx == numbers.length) {
            if(sum == target) {
                cnt++;
            }
            return;
        }
        recur(idx+1, sum+numbers[idx], numbers, target);
        recur(idx+1, sum-numbers[idx], numbers, target);
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 1, 1, 1, 1}, 3));
    }
}
