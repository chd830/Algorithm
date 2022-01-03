package DFS;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/16922
public class 로마숫자만들기 {
    static int N;
    static int[] arr;
    static int[] nums = {1, 5, 10, 50};
    static HashSet<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        set = new HashSet<>();
        comb(0, 0, 0);
        System.out.println(set.size());
    }
    static void comb(int idx, int cnt, int sum) {
        if(cnt == N) {
            set.add(sum);
            return;
        }
        for(int i = idx; i < 4; i++)
            comb(i, cnt+1, sum+nums[i]);
    }
}
