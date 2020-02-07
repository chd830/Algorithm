package com.swexpertacademy;

import java.util.Arrays;
import java.util.Scanner;

//재미있는 오셀로 게임
public class d3_4615 {
    static int[][] arr;
    static int[][] pos = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
    static int N;
    static int M;
//    public static void main(String[] args) {
    public d3_4615() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            N = sc.nextInt();
            arr = new int[N][N];
            M = sc.nextInt();
            for(int i = 0; i < M; i++) {
                int r = sc.nextInt();
                int c = sc.nextInt();
                int color = sc.nextInt();
                arr[--r][--c] = color;
                print();
                System.out.println();
                for(int j = 0; j < 8; j++) {
                    boolean check = false;
                    int dx = r + pos[j][0];
                    int dy = c + pos[j][1];
                    while(dx < N && dx >= 0 && dy < N && dy >= 0) {
                        if(arr[dx][dy] == color) {
                            check = true;
                            break;
                        }
                        if(arr[dx][dy] == 0) {
                            break;
                        }
                        dx += pos[j][0];
                        dy += pos[j][1];
                    }
                    if(check) {
                        System.out.println(r + ", " + c  + "에서 시작하고 " + (dx) + ", " + (dy) + "까지 ("+ pos[j][0]+", "+pos[j][1]+")");
//                        dx = r + pos[j][0];
//                        dy = c + pos[j][1];
//                        dy -= pos[j][0];
                        dx -= pos[j][0];
                        dy -= pos[j][1];
                        while(dx < N && dx >= 0 && dy < N && dy >= 0 && arr[dx][dy] != color) {
                            System.out.print("("+dx+", "+dy+": "+color+") ");
                            arr[dx][dy] = color;
                            dx -= pos[j][0];
                            dy -= pos[j][0];
                        }
                        print();
                    }
                }
//                System.out.println();
//                print();
//                System.out.println();
//                System.out.println();
            }
            print();
//            System.out.println();
//            print();
//            System.out.println();
        }
//        for(int i = 0; i < arr.length; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }

    }
    static void print() {
        for(int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
//    static void coloring( int startX, int startY, int endX, int endY) {
//        if(startX == endX) {
//            for(int i = startY+1; i < N; i++) {
//                arr[startX][i] =
//            }
//        }
//    }

}
