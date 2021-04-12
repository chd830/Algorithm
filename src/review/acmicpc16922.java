package review;

import java.util.*;
import java.io.*;

// 로마 숫자 만들기
public class acmicpc16922 {
    static int N;
    static int cnt;
    static int[] sub = {1, 5, 10, 50};
    static boolean[] visited = new boolean[1234];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cnt = 0;
        N = Integer.parseInt(br.readLine());
        comb(0, 0, 0);
        System.out.println(cnt);
    }
    static void comb(int idx, int subIdx, int sum) {
        if(subIdx == N) {
            if(!visited[sum]) {
                visited[sum] = true;
                cnt++;
            }
            return;
        }
        for(int i = idx; i < 4; i++) {
            comb(i, subIdx+1, sum + sub[i]);
        }

    }
}
