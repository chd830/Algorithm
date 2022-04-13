package co.kr.programmers;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/86051
public class 없는숫자더하기 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 2, 3, 4, 6, 7, 8, 0}));
    }
    public static int solution(int[] numbers) {
        int answer = 0;
        int[] nums = new int[10];
        for(int number : numbers)
            nums[number]++;
        for(int i = 0; i < 10; i++) {
            if(nums[i] == 0)
                answer += i;
        }
        return answer;
    }
}
