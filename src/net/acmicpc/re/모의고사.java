package net.acmicpc.re;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 모의고사 {
    public static void main(String[] args) {
        int[] result = solution(new int[]{1, 3, 2, 4, 2});
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int[] answers) {
        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if (pattern1[i % 5] == answers[i]) {
                score[0]++;
            }
            if (pattern2[i % 8] == answers[i]) {
                score[1]++;
            }
            if (pattern3[i % 10] == answers[i]) {
                score[2]++;
            }
        }
        int max = Math.max(score[0], Math.max(score[1], score[2]));
        List<Integer> list = new ArrayList();
        if (score[0] == max) {
            list.add(1);
        }
        if (score[1] == max) {
            list.add(2);
        }
        if (score[2] == max) {
            list.add(3);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
