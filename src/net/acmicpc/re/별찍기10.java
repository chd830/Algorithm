package net.acmicpc.re;

import java.util.Arrays;
import java.util.Scanner;

public class 별찍기10 {
    static char arr[][]; //n크기만큼 2차원 배열을 생성한다.

    public static void star(int a, int b, int n) { // 재귀호출을 반복 할 메소드이다.
        int div = 0;
        if (n == 1) { // 재귀 호출이 끝나는 부분
            arr[a][b] = '*';
            return;
        }
        System.out.println(a+"\t"+ b+"\t"+n);
        div = n / 3; // 입력받은 n 값을 계속 3씩 나눠준다.

        for (int i = 0; i < 3; i++) { //3x3크기의 별을 만든다.
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) continue;
                star(a + (div * i), b + (div * j), div); //시작점을 옮겨준다. 27의 경우 (0,0) (0,9) 식으로 옮겨간다.
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        arr = new char[n][n];

        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(arr[i], ' ');
        }

        star(0, 0, n);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}
