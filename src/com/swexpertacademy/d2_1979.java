package com.swexpertacademy;

import java.util.Arrays;
import java.util.Scanner;

//어디에 단어가 들어갈 수 있을까
public class d2_1979 {
    static int[][] arr;
    static int[][] pos = {{0, 1}, {1, 0}};
    static int N = 0;
    static int K = 0;
//    public static void main(String[] args) {
    public d2_1979() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int result = 0;
            arr = new int[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int count = 0;
            int bcount = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
//                    System.out.println("i: "+i+", j: "+j);
                    for(int k = 0; k < 2; k++) {
                        count = 0;
                        bcount = 0;
                        int x = i;
                        int y = j;

                        while(x < N && x >= 0 && y < N && y >= 0 && arr[x][y] == 1) {
                            x += pos[k][0];
                            y += pos[k][1];
                            count++;
                        }
                        if(count == K) {
                            x -= pos[k][0];
                            y -= pos[k][1];
                            while(x < N && x >= 0 && y < N && y >= 0 && arr[x][y] == 1) {
                                x -= pos[k][0];
                                y -= pos[k][1];
                                bcount++;
                            }
//                            if(bcount == K) {
//                                result++;
//                            }
                        }
                        if(count == K && bcount == K) {
                            result++;
                        }
                    }
//                    System.out.println("count: "+count+", bcount: "+bcount+", result: "+result);
                }
            }
            System.out.println("#"+t+" "+result);
        }
    }
    static void print(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
