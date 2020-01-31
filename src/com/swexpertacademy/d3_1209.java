package com.swexpertacademy;

import java.util.Scanner;

//Sum
public class d3_1209 {
    //    public static void main(String[] args) {
    public d3_1209() {
        Scanner sc = new Scanner(System.in);
        int T = 1;
        for (int t = 1; t <= 10; t++) {
            sc.nextInt();
            int[][] arr = new int[100][100];
            int[] max = new int[4];
            int[] sum;
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < 100; i++) {
                sum = new int[2];
                for (int j = 0; j < 100; j++) {
                    sum[0] += arr[i][j]; //행
                    sum[1] += arr[j][i]; //열
                    if (i + j == 99) { //오른쪽위에서 왼쪽아래로 내려오는 대각선
                        max[3] += arr[i][j];
                    }
                }
                max[2] += arr[i][i]; //왼쪽위에서 오른쪽아래로 내려오는 대각선
                max[0] = Math.max(sum[0], max[0]);
                max[1] = Math.max(sum[1], max[1]);
            }
            System.out.println("\n#" + t + " " + Math.max(max[0], Math.max(max[1], Math.max(max[2], max[3]))));
        }
    }
}
