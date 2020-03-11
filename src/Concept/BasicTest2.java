package Concept;

import java.util.Arrays;
import java.util.Scanner;

public class BasicTest2 {
    static int N;
    static int R;
    static int[] input;
    static int[] number;
    static int totalCnt;

    //조합
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();
        input = new int[N];
        number = new int[R];

        for(int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }
        combination(N, R);
        System.out.println(totalCnt);
    }
    private static void combination(int n, int r) {
        if(r == 0) {
            ++totalCnt;
            System.out.println(Arrays.toString(number));
            return;
        }
        if(n < r) {
            return;
        }
        number[r-1] = input[n-1];
        //선택
        combination(n-1, r-1);
        //비선택
        combination(n-1, r);
    }
}
