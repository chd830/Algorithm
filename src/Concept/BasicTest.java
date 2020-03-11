package Concept;

import java.util.Arrays;
import java.util.Scanner;

public class BasicTest {
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
        combination(0, 0);
        System.out.println(totalCnt);
    }
    //현재 위치에 조합할 수 있는 것을 선택..?
    private static void combination(int cnt, int cur) {
        if(cnt == R) {
            totalCnt++;
            System.out.println(Arrays.toString(number));
            return;
        }
        for(int i = cur; i < N; i++) {
            number[cnt] = input[i];
            combination(cnt + 1, i + 1);
        }
    }
}
