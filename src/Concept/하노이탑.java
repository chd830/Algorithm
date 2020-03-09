package Concept;

import java.util.Scanner;

public class 하노이탑 {
    static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        int N = sc.nextInt();
        hanoi(N, 1, 2, 3);
        System.out.println(sb.toString());
    }
    //원판갯수(맨 아래 원판번호), 시작기둥, 임시기둥, 목적기둥
    public static void hanoi(int cnt, int from, int temp, int to) {
        //기저조건
        if(cnt == 0) {
            return;
        }
        //시작기둥의 cnt-1 덩어리를 임시기둥으로 옮김.
        hanoi(cnt-1, from, to, temp);
        //시작기둥의 cnt 원판을 목적기둥으로 옮김. >> 할 필요 없는 작업이지만 StringBuilder로 출력
        sb.append(cnt+": "+from+" -> "+to+"\n");
        //임시기둥의 cnt-1 덩어리 원판ㅇ르 목적기둥으로 옮김.
        hanoi(cnt-1, temp, from, to);
    }
}