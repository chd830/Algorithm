package 브루트포스;

import java.util.*;

// https://www.acmicpc.net/problem/9663
public class NQueen {
    static int N;
    static int res;
    static boolean[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new boolean[N][N];
        queen(0);
        System.out.println(res);
    }
    static void queen(int count) {
        if(count == N) {
            res++;
//            print();
            return;
        }
        for(int i = 0; i < N; i++) {
            if(can(count, i)) {
                arr[count][i] = true;
                queen(count+1);
                arr[count][i] = false;
            }
        }
    }
    static void print() {
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] ? "■\t" : "□\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    static boolean can(int x, int y) {
        // 오른쪽 대각선 위
        int i = x-1;
        int j = y+1;
        while(j < N && i >= 0) {
            if(arr[i][j])
                return false;
            i--;
            j++;
        }
        // 왼쪽 대각선 위
        i = x-1;
        j = y-1;
        while(i >= 0 && j >= 0) {
            if(arr[i][j])
                return false;
            i--;
            j--;
        }
        // 위
        i = 0;
        while(i < x) {
            if(arr[i][y])
                return false;
            i++;
        }
        return true;
    }
}
