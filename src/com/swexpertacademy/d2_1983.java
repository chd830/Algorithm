package com.swexpertacademy;

import java.util.*;

//조교의 성적 매기기
public class d2_1983 {
//    public static void main(String[] args) {
    public d2_1983() {
        Scanner sc = new Scanner(System.in);
        String[] grade = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[][] arr = new int[N][3];
            int[] sum = new int[N];
            int[] rank = new int[N];
            for(int i = 0; i < N; i++){
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
                arr[i][2] = sc.nextInt();
                sum[i] = arr[i][0] * 35 + arr[i][1] * 45 + arr[i][2] * 20;
            }
            for(int i = 0; i < N - 1; i++) {
                for(int j = 0; j < N; j++) {
                    if(sum[i] < sum[j]) {
                        rank[i]++;
                    }
                }
            }
            System.out.println(Arrays.toString(sum));
            System.out.println(Arrays.toString(rank));
            System.out.println("#"+t+" "+grade[rank[K+1]/(N/10)]);
//            System.out.println("#"+t+" "+(rank[K]/(N/10) % 2 == 0 ? grade[rank[K]/(N/10)+1] : grade[rank[K]/(N/10)-1]));
        }
    }
}
