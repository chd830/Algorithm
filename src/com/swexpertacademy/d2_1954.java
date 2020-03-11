package com.swexpertacademy;

import java.util.Arrays;
import java.util.Scanner;

//달팽이 숫자
public class d2_1954 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            arr = new int[N][N];
            recur(0, 0, 1);
            for(int i = 0; i < N; i++) {
                System.out.println(Arrays.toString(arr[i]));
            }
        }
    }

    static int[][] arr;
    static int N;
    public static void recur(int r, int c, int count) {
        if(count == N * N+1) {
            return;
        }
        arr[r][c] = count;
        if(c < N - 1 && arr[r][c+1] == 0)
            recur(r, c+1, count+1);
        if(r < N - 1 && arr[r+1][c] == 0)
            recur(r+1, c, count+1);
        if(0 < c && arr[r][c-1] == 0)
            recur(r, c-1, count+1);
        if(0 < r && arr[r-1][c] == 0)
            recur(r-1, c, count+1);
    }
}
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        for(int t = 1; t <= T; t++) {
//            int num = sc.nextInt();
//            int[][] customer = new int[num][num];
//
//            int count = 1;
//            int row = 0;
//            int col = 0;
////            int i = 1;
//            int index = 0;
//            for(int j = num; j >= 0; j -= 2) { //j는 num에서 -2만큼 지속적으로 줄어든다.
//                for(row = 0; row < j; row++) {//오른쪽으로 감
//                    customer[index][index+row] = count++;
//                }
//                for(col = 1; col < j; col++) {//아래로 내려감
//                    //num-index-1은 맨바깥에서 안쪽으로 한칸씩 이동하게 한다.
//                    customer[index+col][num-index-1] = count++;
//                }
//                for(row = 1; row < j; row++) {//왼쪽으로 감
//                    //num-index-row-1은 맨바깥에서 이미 지나온 r만큼 뺀다.
//                    customer[num-index-1][num-index-row-1] = count++;
//                }
//                for(col = 1; col < j - 1; col++) {//위로 감
//                    //num-indx-col-1도 역시 맨바깥에서 지나온 c만큼 뺀다.
//                    customer[num-index-col-1][index] = count++;
//                }
//                index++;
//            }
//            System.out.println("#"+t);
//            print(customer);
//        }
//    }
//    static void print(int[][] customer) {
//        for(int l = 0; l < customer.length; l++) {
//            System.out.println(Arrays.toString(customer[l]));
//        }
//    }
////    public d2_1954() {
////        Scanner sc = new Scanner(System.in);
////        int T = sc.nextInt();
////        for (int t = 1; t <= T; t++) {
////            int W = sc.nextInt();
////            int[][] customer = new int[W][W];
////            System.out.println("#" + t);
////            int row = 0;
////            int col = -1;
////            int k = 1;
////            int l = W;
////            int count = 1;
////            while (true) {
////                if(count > W*W) {
////                    break;
////                }
////                for (int n = 0; n < l; n++) {
////                    col = col + k;
//////                    System.out.println("col: "+col);
////                    customer[row][col] = count;
////                    count++;
////                }
////                l--;
////
////                for (int n = 0; n < l; n++) {
////                    row = row + k;
//////                    System.out.println("row: "+row);
////                    customer[row][col] = count;
////                    count++;
////                }
////                k = -k ;
////            }
////            print(customer);
////        }
////    }
//
////    static void print(int[][] customer) {
////        for (int i = 0; i < customer.length; i++) {
////            for (int j = 0; j < customer.length; j++) {
////                System.out.print(customer[i][j] + " ");
////            }
////            System.out.println();
////        }
////    }
//
//}
