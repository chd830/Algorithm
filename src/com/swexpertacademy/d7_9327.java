package com.swexpertacademy;

import java.util.Arrays;
import java.util.Scanner;

//현지의 기지국 설치
public class d7_9327 {
    public d7_9327() {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int t = 1; t <= tc; t++) {
            int  n = sc.nextInt();
            int m = sc.nextInt();
            int[] cost = new int[n+1];
            for(int i = 1; i <= n; i++) {
                cost[i] = sc.nextInt();
            }
            int[][] profit = new int[m][m];
            int[] s = new int[m];
            int[] e = new int[m];
            int[] c = new int[m];
            for(int i = 0; i < m; i++) {
                s[i] = sc.nextInt();
                e[i] = sc.nextInt();
                c[i] = sc.nextInt();
            }
            for(int i = 0; i < m; i++) {
                boolean[] isInstall = new boolean[n+1];
                for(int j = i; j < m; j++) {
                    if(i == j) {
                        profit[i][j] = c[i] - (cost[s[i]] + cost[e[i]]);
                        isInstall[s[j]] = true;
                        isInstall[e[j]] = true;
                        continue;
                    }
                    if(!isInstall[s[j]]) {
                        isInstall[s[j]] = true;
                        profit[i][j] -= cost[s[j]];
                    }
                    if(!isInstall[e[j]]) {
                        isInstall[e[j]] = true;
                        profit[i][j] -= cost[e[j]];
                    }
                    profit[i][j] += profit[i][j-1] + c[j];
                }
            }
            for(int i = 0; i < m; i++) {
                System.out.println(Arrays.toString(profit[i]));
            }
            int max = 0;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < m; j++) {
                    max = Math.max(profit[i][j], max);
                }
            }
            System.out.println("#"+t+" "+max);
        }
    }
}
