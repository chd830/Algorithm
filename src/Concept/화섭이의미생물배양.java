package Concept;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 화섭이의미생물배양 {
    static int S;
    static int T;
    static int A;
    static int B;
    static int min;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int test_case = 1; test_case <= test; test_case++) {
            S = sc.nextInt();
            T = sc.nextInt();
            A = sc.nextInt();
            B = sc.nextInt();
            min = Integer.MAX_VALUE;
            dfs(T, 0);
            System.out.println("#"+test_case+" "+min);
        }
    }
    static void dfs(int t, int cnt) {
        if(t == S) {
            if(min > cnt) {
                min = cnt;
            }
            return;
        }
        if(t < S) {
            return;
        }
        if(t%B == 0) {
            dfs(t/B, cnt+1);
            //제출하면 이조건은 틀리다고 되는데 사실 맞는코드
            dfs(t-A, cnt+1);
        }
        else {
            dfs(t-A, cnt+1);
        }

    }
}
