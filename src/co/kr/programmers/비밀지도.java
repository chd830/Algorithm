package co.kr.programmers;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/17681
public class 비밀지도 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[] {9, 20, 28, 18, 11}, new int[] {30, 1, 21, 17, 28})));
    }
    static String binaryToInt(int n, int len) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            sb.append(n%2);
            n /= 2;
        }
        while(sb.length() < len)
            sb.append(0);
        return sb.reverse().toString();
    }
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        Arrays.fill(answer, "");
        int[][] map1 = new int[n][n];
        int[][] map2 = new int[n][n];
        for(int i = 0; i < n; i++) {
            String str = binaryToInt(arr1[i], n);
            for(int j = 0; j < n; j++) {
                map1[i][j] = str.charAt(j)-'0';
            }
        }
        for(int i = 0; i < n; i++) {
            String str = binaryToInt(arr2[i], n);
            for(int j = 0; j < n; j++) {
                map2[i][j] = str.charAt(j)-'0';
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map1[i][j] == 1 || map2[i][j] == 1)
                    answer[i] += "#";
                else
                    answer[i] += " ";
            }
        }
        return answer;
    }
}
