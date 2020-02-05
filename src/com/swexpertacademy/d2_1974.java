package com.swexpertacademy;

import java.util.HashSet;
import java.util.Scanner;

//스도쿠 검증
public class d2_1974 {
    //    public static void main(String[] args) {
    //합으로 구현했을 때 45이지만 1부터 9까지의 값이 들어가 있지 않는 경우가 있어서 Set으로 구현할 것
    public d2_1974() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            boolean isSudoku = true;
            int[][] arr = new int[9][9];

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            System.out.println("#"+t+" "+isValid(arr));
        }
    }

    static int isValid(int[][] arr) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            set.clear();
            set2.clear();
            for (int j = 0; j < 9; j++) {
                set.add(arr[i][j]);
                set2.add(arr[j][i]);
            }
            if (set.size() != 9 || set2.size() != 9) {
                return 0;
            }
        }
        set.clear();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                set.clear();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        set.add(arr[3 * i + k][3 * j + l]);
                    }
                }
                if (set.size() < 9) return 0;
            }
        }
        return 1;
    }
}
