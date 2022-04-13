package co.kr.programmers;

import java.util.*;
import java.io.*;

// https://programmers.co.kr/learn/courses/30/lessons/42889
public class 실패율 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3})));
        System.out.println(Arrays.toString(solution(4, new int[] {4, 4, 4, 4, 4})));
    }
    public static int[] solution(int N, int[] stages) {
        int[] success = new int[N+1];
        for(int i = 0; i < stages.length; i++) {
            int grade = stages[i];
            for(int j = 0; j < grade; j++)
                success[j]++;
        }
        int[] sum = new int[N+1];
        sum[N] = success[N];
        for(int i = N-1; i > 0; i--)
            sum[i] += success[i]+sum[i+1];
        double[] rate = new double[N];
        for(int i = 1; i <= N; i++)
            rate[i - 1] = ((double) success[i - 1] - success[i]) / success[i - 1];
        int[] answer = new int[N];
        for(int i = 0; i < N; i++)
            answer[i] = i+1;
        for(int i = 0; i < N-1; i++) {
            for(int j = i+1; j < N; j++) {
                if(rate[i] < rate[j]) {
                    double tmp = rate[i];
                    rate[i] = rate[j];
                    rate[j] = tmp;
                    int temp = answer[i];
                    answer[i] = answer[j];
                    answer[j] = temp;
                }
                if(rate[i] == rate[j]) {
                    if(answer[i] > answer[j]) {
                        int temp = answer[i];
                        answer[i] = answer[j];
                        answer[j] = temp;
                    }
                }
            }
        }
        return answer;
    }
}
