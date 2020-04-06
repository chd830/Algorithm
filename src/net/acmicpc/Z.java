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
        find(1, 1, 1);
    }
    static void find(int x, int y, int cnt) {
        System.out.println("("+x+", "+y+"): "+cnt);
        if(x == xPos && y == yPos) {
            System.out.println(cnt-1);
            System.exit(0);
        }
        if(cnt%32 == 0) {
            find(x+1, y-7, cnt+1);
        }
        else if(cnt%16 == 0) {
            find(x-3, y+1, cnt+1);
        }
        else if(cnt%8 == 0) {
            find(x+1, y-3, cnt+1);
        }
        else if(cnt%4 == 0) {
            find(x-1, y+1, cnt+1);
        }
        else if(cnt%2 == 0) {
            find(x+1, y-1, cnt+1);
        }
        else {
            find(x, y+1, cnt+1);
        }
    }
}
