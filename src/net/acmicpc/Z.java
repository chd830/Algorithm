package net.acmicpc;

import java.util.Scanner;

public class Z {
    static int xPos;
    static int yPos;
    static int[][] map;
    static int[][] cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        xPos = sc.nextInt()+1;
        yPos = sc.nextInt()+1;
        int pow = (int)Math.pow(2, N);
        map = new int[pow+1][pow+1];
        cnt = new int[pow+1][pow+1];
        find(1, 1);
    }
    static void find(int x, int y) {
        if(x == xPos && y == yPos) {
            System.out.println(cnt[x][y]);
            System.exit(0);
        }
        if(x == 0 || y == 0 || x >= map.length || y >= map.length) {
            return;
        }
        System.out.println("("+x+", "+y+"): "+cnt[x][y]);
        if(x%4 == 0 && y%4 == 0) {
            cnt[x-3][y+1] = cnt[x][y]+1;
            find(x-3, y+1);
        }
        if(x%2 == 0 && y%4 == 0) {
            cnt[x+1][y] = cnt[x][y]+1;
            find(x+1, 1);
        }
        if(x%2 == 1 && y %2 == 0) {
            cnt[x+1][y-1] = cnt[x][y]+1;
            find(x+1, y-1);
        }
        if(x%2 == 0 && y%2 == 0) {
            cnt[x-1][y+1] = cnt[x][y]+1;
            find(x-1, y+1);
        }
        if(y+1 < map.length) {
            cnt[x][y+1] = cnt[x][y]+1;
            find(x, y + 1);
        }
    }
}
