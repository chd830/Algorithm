package co.kr.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 삼각달팽이 {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(4)));
//        System.out.println(Arrays.toString(solution(5)));
        System.out.println(Arrays.toString(solution(6)));
    }
    public static int[] solution(int n) {
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i+1; j++) {
                arr[i][j] = -1;
            }
        }
        int start = 1;
        int max = n*(n+1)/2;
        int i = 0;
        int j = 0;
        while(start < max) {
            while(i+1 < n &&arr[i+1][j] < 0)
                arr[i++][j] = start++;
            while(j+1 < n && arr[i][j+1] < 0)
                arr[i][j++] = start++;
            while(i-1 > 0 && i-1 > 0 && arr[i-1][j-1] < 0)
                arr[i--][j--] = start++;
        }
        arr[i][j] = start;
        int[] result = new int[max];
        int idx = 0;
        for(i = 0; i < n; i++) {
            for(j = 0; j < i+1; j++) {
                result[idx++] = arr[i][j];
            }
        }
        return result;
    }
}
