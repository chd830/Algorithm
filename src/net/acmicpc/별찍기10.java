package net.acmicpc;

import java.util.*;

public class 별찍기10 {
    private static final Scanner sc = new Scanner(System.in);
    private static char[][] arr;

    public static void main(String args[]) {
        int num = sc.nextInt();
        arr = new char[num][num];

        for (int i = 0; i < num; i++) {
            Arrays.fill(arr[i], ' ');
        }

        recur(0, 0, num);
//        for (int i = 0; i < num; i++) {
//            System.out.println(visited[i]);
//        }
    }

    public static void recur (int x, int y, int n) {
        if(n < 1) {
            return;
        }
        arr[x][y] = '*';
        for(int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println();
        recur(x, y, n/3);
        recur(x, y+n/3, n/3);
        recur(x, y+n/3*2, n/3);
        recur(x+n/3, y, n/3);
        recur(x+n/3, y+n/3*2, n/3);
        recur(x+n/3*2, y, n/3);
        recur(x+n/3*2, y+n/3, n/3);
        recur(x+n/3*2, y+n/3*2, n/3);
    }
}