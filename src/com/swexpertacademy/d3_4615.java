package com.swexpertacademy;

import java.util.Arrays;
import java.util.Scanner;

//재미있는 오셀로 게임
public class d3_4615 {
    static int[][] arr;
    int[][] pos = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
//    public static void main(String[] args) {
    public d3_4615() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            arr = new int[N+1][N+1];
            int M = sc.nextInt();
            for(int i = 0; i < M; i++) {
                int r = sc.nextInt();
                int c = sc.nextInt();
                int color = sc.nextInt();
                arr[r][c] = color;
                System.out.print("arr["+r+"]["+c+"]: "+arr[r][c]+"부터 ");
                for(int j = 0; j < 8; j++) {
                   int dx = r + pos[j][0];
                   int dy = c + pos[j][1];
                   while(dx <= N && dx >= 0 && dy <= N && dy >= 0 && arr[dx][dy] != 0) {
                       dx += pos[j][0];
                       dy += pos[j][1];
                   }
                   dx -= pos[j][0];
                   dy -= pos[j][1];
                    System.out.println("arr["+dx+"]["+dy+"]: "+arr[dx][dy]+"까지");
                   if(dx <= N && dx >= 0 && dy <= N && dy >= 0 && arr[dx][dy] == arr[r][c] && arr[r][c] != 0) {
                       System.out.println("coloring "+r+", "+c+"부터 "+dx+", "+dy+"까지");
                       coloring(arr, r, c, dx, dy);
                   }
//                   else if(dx <= N && dx >= 0 && dy <= N && dy >= 0 && arr[dx][dy] != arr[r][c] && arr[dx][dy] != 0) {
//                       dx -= pos[j][0];
//                       dy -= pos[j][0];
//                       System.out.println("2coloring "+r+", "+c+"부터 "+dx+", "+dy+"까지");
//                       coloring(arr, r, c, dx, dy);
//                   }
                }
                print(arr);
            }
        }
//        for(int i = 0; i < arr.length; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }
    }
    static void print(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
    static void coloring(int[][] arr, int startX, int startY, int endX, int endY) {
        if(startX == endX) {
            for(; startY < endY; startY++) {
                arr[startX][startY] = arr[startX][endY];
            }
        }
        else {
            for(; startX < endX; startX++) {
                arr[startX][startY] = arr[endX][endY];
            }
        }
    }

}
