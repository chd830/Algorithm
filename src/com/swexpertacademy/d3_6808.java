package com.swexpertacademy;

import java.util.Arrays;
import java.util.Scanner;

//규영이와 인영이의 카드게임
public class d3_6808 {
    static boolean[] visited = new boolean[9];
    static int[] gyuCard = new int[9];
    static int[] inCard = new int[9];
    static int[] inSub = new int[9];
    static int[] count;

    //    public static void main(String[] args) {
    public d3_6808() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int[] cards = new int[19];
            count = new int[2];
            Arrays.fill(cards, 1);
            cards[0] = 0;

            for (int i = 0; i < 9; i++) {
                gyuCard[i] = sc.nextInt();
                cards[gyuCard[i]]--;
            }
            for (int i = 1, j = 0; i < 19; i++) {
                if (cards[i] == 1) {
                    inCard[j] = i;
                    j++;
                }
            }
            check(0, 0, 0);
            System.out.println("#" + t + " " + count[1] + " " + count[0]);
        }
    }
    static void check(int idx, int gyu, int in) {
        if(idx == 9) {
            if(gyu < in) {
                count[0]++;
            }
            else if(gyu > in) {
                count[1]++;
            }
            return;
        }
        for(int i = 0; i < 9; i++ ){
            if(!visited[i]) {
                inSub[idx] = inCard[i];
                visited[i] = true;
                if(gyuCard[idx] < inSub[idx]) {
                    check(idx + 1, gyu, in + inSub[idx] + gyuCard[idx]);
                }
                else {
                    check(idx + 1, gyu + inSub[idx] + gyuCard[idx], in);
                }
                visited[i] = false;
            }
        }
    }
    static void sub(int idx) {
        if (idx == 9) {
            int[] result = new int[2];
            for (int i = 0; i < 9; i++) {
                if (gyuCard[i] < inSub[i]) {
                    result[1] += (gyuCard[i] + inSub[i]);
                } else if(gyuCard[i] > inSub[i]){
                    result[0] += (gyuCard[i] + inSub[i]);
                }
            }
            if (result[0] < result[1]) {
                count[0]++;
            } else {
                count[1]++;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (!visited[i]) {
                inSub[idx] = inCard[i];
                visited[i] = true;
                sub(idx + 1);
                visited[i] = false;
            }
        }
    }
}