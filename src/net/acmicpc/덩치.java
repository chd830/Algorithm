package net.acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class 덩치 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[][] arr = new int[size][size];
        int[] result = new int[size];
        Arrays.fill(result, 1);
        for(int i = 0; i < size; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        for(int i = 0 ;i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(i == j) {
                    continue;
                }
                if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    result[i]++;
                }
            }
        }
        for(int i : result)
            System.out.print(i+" ");
    }
}
