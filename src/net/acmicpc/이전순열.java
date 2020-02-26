package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이전순열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());
        int[] arr = new int[num];
        int idx = 0;
        while(token.hasMoreTokens()) {
            arr[idx] = Integer.parseInt(token.nextToken());
            idx++;
        }
        if(prev_permute(arr, num)) {
            for(int i : arr) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
        else {
            System.out.println(-1);
        }
    }
    public static boolean prev_permute(int[] arr, int num) {
        //뒤에서 부터 arr[i]가 arr[i-1]보다 큰 지점을 찾고
        int i = num-1;
        while(i > 0 && arr[i] >= arr[i-1]) {
            i--;
        }
        //주어진 배열이
        // 만들 수 있는 순열 중에서 제일 작을 때 false 반환
        if(i <= 0) {
            return false;
        }
        //뒤에서 부터 arr[i]보다 작은 지점을 찾아서 바꾼다.
        int j = num-1;
        while(arr[j] >= arr[i-1]) {
            j--;
        }
        swap(arr, i-1, j);
        j = num-1;
        while(i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
        return true;
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}