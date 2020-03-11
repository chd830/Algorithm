package Concept;

import java.util.Arrays;
import java.util.Scanner;

public class BitMaskingTest {
    static int N;
    static int R;
    static int totalCnt;
    static int[] input;
    static int[] number;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();
        totalCnt = 0;
        input = new int[N];
        number = new int[R];
        for(int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }
        permute(0, 0);
        System.out.println("총 횟수: "+totalCnt);
    }
    public static void permute(int cnt, int flag) {
        if(cnt == R) {
            totalCnt++;
            System.out.println(Arrays.toString(number));
            return;
        }
        for(int i = 0; i < N; i++) {
            if((flag & (1<<i)) != 0) {
                continue;
            }
            number[cnt] = input[i];
            permute(cnt+1, flag | 1<<i);
        }
    }
}
