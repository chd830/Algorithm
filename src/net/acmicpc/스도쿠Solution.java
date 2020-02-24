package net.acmicpc;

import java.util.Scanner;

public class 스도쿠Solution {
    public static int[][] map = new int[10][10];

    public static boolean check(int x, int y, int num) {
        for (int i = 0; i < 9; i++)
            if (map[x][i] == num || map[i][y] == num)
                return false;
        int r = 3 * (x / 3), l = 3 * (y / 3);
        for (int i = r; i < r + 3; i++) {
            for (int j = l; j < l + 3; j++) {
                if (map[i][j] == num)
                    return false;
            }
        }
        return true;
    }

    public static boolean solve(int pos) {
        if (pos == 81)
            return true;
        int x = pos / 9;
        int y = pos % 9;
        if (map[x][y] != 0)
            return solve(pos + 1);
        for (int i = 1; i <= 9; i++) {
            if (check(x, y, i)) {
                map[x][y] = i;
                if (solve(pos + 1))
                    return true;
                map[x][y] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        solve(0);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
