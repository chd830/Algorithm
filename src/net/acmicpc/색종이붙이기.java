package net.acmicpc;

import java.util.Scanner;

//dfs를 통해서 색종이를 계속 붙여가면서 최소개수를 찾아야한다.
public class 색종이붙이기 {
    static int min;
    static int[] size = {1, 2, 3, 4, 5};
    static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        min = 0;
        arr = new int[10][10];
        int[] paper = new int[5];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (arr[i][j] == 1) {
                    dfs(i, j);
                }
            }
        }
    }
    public static void paste(int x, int y) {

    }

    public static void dfs(int i, int j) {

    }
}

//    static int[][] dist = new int[10][10];
//    static int[] paper = {0, 5, 5, 5, 5, 5};
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        for(int i = 0; i < 10; i++) {
//            for(int j = 0; j < 10; j++)
//                dist[i][j] = sc.nextInt();
//        }
//        dfs(0);
//        System.out.println(ans == 987654321 ? -1 : ans);
//    }
//    static void dfs(int cnt) {
//        int startR = -1;
//        int startC = -1;
//        out:for(int i = 0; i < 10; i++) {
//            for(int j = 0; j < 10; j++) {
//                if( dist[i][j] == 1 ) {
//                    startR = i;
//                    startC = j;
//                    break out;
//                }
//            }
//        }
//        if( startR == -1 && startC == -1 ) {
//            ans = Math.min(ans, cnt);
//            return;
//        }
//        int max = 5;
//        while( max > 0 ) {
//            boolean isOk = true;
//            out: for(int i = 0; i < max; i++) {
//                for(int j = 0; j < max; j++) {
//                    if( startR + i >= 10 || startC + j >= 10 || dist[startR+i][startC+j] == 0 ) {
//                        isOk = false;
//                        break out;
//                    }
//                }
//            }
//            if(isOk)
//                break;
//            max--;
//        }
//        for(int i = max; i > 0; i--) {
//            if( paper[i] > 0) {
//                for(int r = startR; r < startR + i; r++) {
//                    for(int c = startC; c < startC + i; c++) {
//                        dist[r][c] = 0;
//                    }
//                }
//                paper[i]--;
//                dfs(cnt+1);
//                paper[i]++;
//                for(int r = startR; r < startR + i; r++) {
//                    for(int c = startC; c < startC + i; c++) {
//                        dist[r][c] = 1;
//                    }
//                }
//            }
//        }
//    }
//    static int ans = 987654321;
