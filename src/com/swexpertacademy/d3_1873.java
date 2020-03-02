package com.swexpertacademy;

import java.util.Scanner;

//상호의 배틀필드
public class d3_1873 {
    static int[][] pos = {{0}, {0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    static char[] direction = {' ', '<', '^', '>', 'v'};
    static char[][] arr;
    static int startX;
    static int startY;
    static int dir;

    //    public static void main(String[] args) {
    public d3_1873() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int H = sc.nextInt();
            int W = sc.nextInt();
            arr = new char[H][W];
            startX = 0;
            startY = 0;
            dir = 0;
            for (int i = 0; i < H; i++) {
                String str = sc.next();
                for (int j = 0; j < W; j++) {
                    arr[i][j] = str.charAt(j);
                    switch (arr[i][j]) {
                        case '<':
                            dir = 1;
                            startX = i;
                            startY = j;
                            break;
                        case '>':
                            dir = 3;
                            startX = i;
                            startY = j;
                            break;
                        case '^':
                            dir = 2;
                            startX = i;
                            startY = j;
                            break;
                        case 'v':
                            dir = 4;
                            startX = i;
                            startY = j;
                            break;

                    }
                }
            }
//            System.out.println("dir: "+dir);
//            System.out.println("방향: "+move[dir][0]+", "+move[dir][1]+". 시작위치: "+startX+", "+startY);
                /*
                방향을 바꾸고 평지일 때 한칸 이동
                Up
                Down
                Left
                Right
                Shoot 현재 방향으로 포탄 발사
                 */

            int N = sc.nextInt();
            String str = sc.next();
            for (char c : str.toCharArray()) {
                switch (c) {
                    case 'S':
                        shoot(dir);
                        break;
                    case 'U':
                        dir = 2;
                        move(dir);
                        break;
                    case 'D':
                        dir = 4;
                        move(dir);
                        break;
                    case 'L':
                        dir = 1;
                        move(dir);
                        break;
                    case 'R':
                        dir = 3;
                        move(dir);
                        break;
                }
//                    for (int i = 0; i < H; i++) {
//                        for (int j = 0; j < W; j++) {
//                            System.out.print(customer[i][j] + " ");
//                        }
//                        System.out.println();
//                    }
//                    System.out.println("-------------");

            }
            System.out.print("#"+t+" ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    System.out.print(arr[i][j]);
                }
                System.out.println();
            }
//            System.out.println("-------------");
        }
    }

    public static void move(int dir) {
        int xPos = startX + pos[dir][0];
        int yPos = startY + pos[dir][1];
        arr[startX][startY] = direction[dir];
        if (xPos >= 0 && xPos < arr.length && yPos >= 0 && yPos < arr[0].length && arr[xPos][yPos] == '.') {
            arr[startX][startY] = '.';
            startX = xPos;
            startY = yPos;
            arr[startX][startY] = direction[dir];
        }
    }

    public static void shoot(int dir) {
//        System.out.println(move[dir][0]+" "+move[dir][1]);
        int xPos = startX + pos[dir][0];
        int yPos = startY + pos[dir][1];
        int count = 0;
        while(count != 1) {
            if(xPos < 0 || xPos >= arr.length || yPos < 0 || yPos >= arr[0].length) {
                return;
            }
            if (xPos >= 0 && xPos < arr.length && yPos >= 0 && yPos < arr[0].length) {
                if(arr[xPos][yPos] == '#') {
                    return;
                }
                if(arr[xPos][yPos] == '*') {
                    arr[xPos][yPos] = '.';
                    count++;
                }
            }
            xPos += pos[dir][0];
            yPos += pos[dir][1];
        }
    }
}
