package review;

import java.util.*;
import java.io.*;

// +, -, *, / 로 할 수 있는 모든 수식 중 제일 큰 값과 제일 작은 값
public class 연산자끼워넣기 {
    static int N;
    static int[] arr;
    static int[] sub;
    static int[] oper = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer token = null;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        sub = new int[N-1];
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            oper[i] = Integer.parseInt(token.nextToken());
        }
        check(0);
        sb.append(max).append("\n").append(min).append("\n");
        System.out.println(sb);
    }
    // 나올 수 있는 모든 순열의 경우
    static void check(int idx) {
        if(idx == sub.length) {
            int[] copy = new int[arr.length];
            for(int i = 0; i < arr.length; i++) {
                copy[i] = arr[i];
            }
            int sum = 0;
            for(int i = 0; i < sub.length; i++) {
                switch (sub[i]) {
                    case 0:
                        sum = copy[i] + copy[i+1];
                        copy[i+1] = sum;
                        break;
                    case 1:
                        sum = copy[i] - copy[i+1];
                        copy[i+1] = sum;
                        break;
                    case 2:
                        sum = copy[i] * copy[i+1];
                        copy[i+1] = sum;
                        break;
                    case 3:
                        sum = copy[i] / copy[i+1];
                        copy[i+1] = sum;
                        break;
                }
            }
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }
        for(int i = 0; i < oper.length; i++) {
            if(oper[i] > 0) {
                oper[i]--;
                sub[idx] = i;
                check(idx+1);
                oper[i]++;
            }
        }
    }

}
