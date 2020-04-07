package net.acmicpc;

import java.util.Scanner;

public class Z {
    static int cnt;
    static int xPos;
    static int yPos;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        cnt = 0;
        xPos = sc.nextInt()+1;
        yPos = sc.nextInt()+1;
        find(1, 1, (int)Math.pow(2, N));
    }
    static void find(int x, int y, int size) {
        System.out.println("("+x+", "+y+"): "+size);
        if(size == 1) {
            if(x == xPos && y == yPos) {
                System.out.println(cnt);
            }
            cnt++;
            return;
        }
        int s = size/2;
        find(x, y, s);
        find(x, y+s, s);
        find(x+s, y, s);
        find(x+s, y+s, s);
    }
}
