package net.acmicpc;

import java.util.*;

public class 롤케이크 {
//    public static void main(String[] args) {
    public 롤케이크() {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int[] cake = new int[L+1];
        int N = sc.nextInt();
        int[][] arr = new int[N+1][2];
        int[] person = new int[N+1];
        int expectCake = 0;
        int expect = 0;
        for(int i = 1; i <= N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            if(arr[i][0] > arr[i][1]) {
                int temp = arr[i][0];
                arr[i][0] = arr[i][1];
                arr[i][1] = temp;
            }
            if(expectCake < arr[i][1] - arr[i][0]) {
                expectCake = arr[i][1] - arr[i][0];
                expect = i;
            }
        }
        int max = 0;
        for(int i = 1; i <= N; i++) {
            while (arr[i][1] >= arr[i][0]) {
                if (cake[arr[i][1]] == 0) {
                    cake[arr[i][1]] = i;
                    person[i]++;
                }
                arr[i][1]--;
            }
            max = Math.max(person[i], max);
        }
        System.out.println(Arrays.toString(cake));
        System.out.println(Arrays.toString(person));
        System.out.print(expectCake+" ");
        System.out.println(expect);
        for(int i = 1; i < N; i++) {
            if(person[i] == max) {
                System.out.println(i);
                System.exit(0);
            }
        }
        sc.close();
    }
}
