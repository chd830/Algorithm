package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 탑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Stack<Integer> stack = new Stack();
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
            stack.add(arr[i]);
        }
        int[] result = new int[N];
        int idx = N-1;
        int max = Integer.MIN_VALUE;
        int j = N-1;
        while(!stack.isEmpty()) {
            int num = stack.pop();
            if(max < num) {
                max = num;
                idx--;
            }
            if(arr[j] < max) {
                result[j] = idx;
                j--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i : result) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
