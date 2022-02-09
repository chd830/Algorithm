package 구현;

import java.util.*;
import java.io.*;

// 돌아가면서 배열채우기
public class 달팽이 {
    public static void main(String[] args) {
        N = 7;
        cnt = 1;
        arr = new int[N][N];
//        snail(0);
    }
    static int[][] arr;
    static int x;
    static int y;
    static int cnt;
    static int N;
//    static void snail(int idx) {
//        boolean check = false;
//        for(int i = 0; i < N; i++) {
//            if(arr[idx][i] != 0)
//                continue;
//            arr[idx][i] = cnt++;
//            check = true;
//        }
//        for(int i = 0; i < N; i++) {
//            if(arr[i][N-1-idx] != 0)
//                continue;
//            arr[i][N-1-idx] = cnt++;
//            check = true;
//        }
//        for(int i = 0; i < N; i++) {
//            if(arr[N-1-idx][N-1-i] != 0)
//                continue;
//            arr[N-1-idx][N-1-i] = cnt++;
//            check = true;
//        }
//        for(int i = 0; i < N; i++) {
//            if(arr[N-1-i][idx] != 0)
//                continue;
//            arr[N-1-i][idx] = cnt++;
//            check = true;
//        }
//        print();
//        if(check) {
//            snail(idx+1);
//        }
//    }
    static void print() {
        for(int i = 0; i < N; i++)
            System.out.println(Arrays.toString(arr[i]));
        System.out.println();
    }
}
