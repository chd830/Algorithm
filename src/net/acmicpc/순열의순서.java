package net.acmicpc;

import java.util.*;

public class 순열의순서 {
    //팩토리얼 값이 들어있는 배열
    static long[] f = new long[21];
    //방문했는지 여부체크용 배열
    static boolean[] c = new boolean[21];
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        f[0] = 1;
        for (int i=1; i<=20; i++) {
            f[i] = f[i-1] * i;
        }
        int n = sc.nextInt();
        int what = sc.nextInt();
        /*
        7, 3, 5, 6, 1일 때
        1, x, x, x, x >> 5!
        3, x, x, x, x >> 5!
        5, x, x, x, x >> 5!
        6, x, x, x, x >> 5!
        7, 1, x, x, x >> 4!
        순서로 접근해서 갯수를 순열의 순서를 파악하고
        K - x!을 통해서 순열의 순서를 파악할 수 있다.
         */
        //임의의 순열이 몇번째인지 체크
        if (what == 2) {
            int[] a = new int[n];
            for (int i=0; i<n; i++) {
                a[i] = sc.nextInt();
            }
            long ans = 0;
            for (int i=0; i<n; i++) {
                for (int j=1; j<a[i]; j++) {
                    //방문하지 않았을 때 팩토리얼만큼 더해놓기
                    if (c[j] == false) {
                        ans += f[n-i-1];
                    }
                }
                c[a[i]] = true;
            }
            System.out.println(ans+1);
            //K번째 순열이 뭔지 구하기.
        } else if (what == 1) {
            long k = sc.nextLong();
            int[] a = new int[n];
            for (int i=0; i<n; i++) {
                for (int j=1; j<=n; j++) {
                    if (c[j] == true) continue;
                    if (f[n-i-1] < k) {
                        k -= f[n-i-1];
                    } else {
                        a[i] = j;
                        c[j] = true;
                        break;
                    }
                }
            }
            for (int i=0; i<n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
    }
}
