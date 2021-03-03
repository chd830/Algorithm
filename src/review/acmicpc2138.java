package review;

import java.util.*;
import java.io.*;

// 전구와 스위치
public class acmicpc2138 {
    static int N;
    static boolean[] target;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        boolean[] cur = new boolean[N];
        boolean[] copy = new boolean[N];
        target = new boolean[N];
        for(int i = 0; i < N; i++) {
            cur[i] = str.charAt(i) == '0' ? false : true;
        }
        str = br.readLine();
        for(int i = 0; i < N; i++) {
            target[i] = str.charAt(i) == '0' ? false : true;
        }
        // 0을 누르는 경우
        min = Integer.MAX_VALUE;
        copy = cur.clone();
        cur[0] = !cur[0];
        cur[1] = !cur[1];
        push(cur.clone(), 1);
        // 0을 누르지 않는 경우
        push(copy, 0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
    static int min;
    static boolean isSame(boolean[] arr) {
        for(int i = 0; i < N; i++) {
            if(arr[i] != target[i]) {
                return false;
            }
        }
        return true;
    }
    static void push(boolean[] arr, int cnt) {
        for(int i = 1; i < N; i++) {
            if(arr[i-1] != target[i-1]) {
                cnt++;
                arr[i-1] = !arr[i-1];
                arr[i] = !arr[i];
                if(i+1 < N) {
                    arr[i + 1] = !arr[i + 1];
                }
            }
        }
//        System.out.println(Arrays.toString(arr));
        min = isSame(arr) ? Math.min(min, cnt) : min;
    }
}