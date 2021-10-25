package net.acmicpc;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1644
public class 소수의연속합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean[] nums = new boolean[N+1];
        List<Integer> primeNumbers = new ArrayList<>();
        Arrays.fill(nums, true);
        nums[0] = false;
        nums[1] = false;
        for(int i = 2; i < N; i++) {
            for(int j = i+i; j <= N; j += i) {
                nums[j] = false;
            }
        }
        for(int i = 2; i <= N; i++) {
            if(nums[i])
                primeNumbers.add(i);
        }
        int answer = 0;
        int start = 0;
        int idx = 0;
        int end = primeNumbers.size()-1;
        int sum = 0;
        while(start <= end) {
            if(sum == N) {
                answer++;
            }
            if(sum < N) {
                sum += primeNumbers.get(start++);
            }
            else {
                sum -= primeNumbers.get(idx++);
            }
        }
        System.out.println(nums[N] ? answer+1 : answer);
    }
}
// 3999971