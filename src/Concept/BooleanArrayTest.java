package Concept;

import java.util.Arrays;
import java.util.Scanner;

public class BooleanArrayTest {
    static int N;
    static int R;
    static int[] input;
    static int[] number;
    static boolean[] isSelected;
    static int totalCnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();
        input = new int[N];
        number = new int[R];
        isSelected = new boolean[N];
        for(int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }
        permute(0);
        System.out.println(totalCnt);
    }

    public static void permute(int s_idx) {
        if(s_idx == number.length) {
            totalCnt++;
            System.out.println(Arrays.toString(number));
            return;
        }
        for(int i = 0; i < N; i++) {
            if(!isSelected[i]) {
                isSelected[i] = true;
                number[s_idx] = input[i];
                permute(s_idx+1);
                isSelected[i] = false;
            }
        }
    }
}
