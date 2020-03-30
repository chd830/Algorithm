package net.acmicpc;

import java.util.*;

public class 영식이와친구들 {
//    public static void main(String[] args) {
    public 영식이와친구들() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int L = sc.nextInt();
        int[] arr = new int[N];
        int count = 0;
        int next = 0;
        while(true) {
            arr[next]++;
            if(arr[next] >= M) {
                break;
            }
            if(arr[next]%2 == 1) {
                next += L;
                if (next >= N) {
                    next -= N;
                }
            }
            else {
                next -= L;
                if(next < 0) {
                    next += N;
                }
            }
            count++;
//            System.out.println(Arrays.toString(visited1));
        }
        System.out.println(count);
    }
}
