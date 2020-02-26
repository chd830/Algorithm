package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다음순열 {
    static int[] arr;
    static int num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        arr = new int[num];
        StringTokenizer token = new StringTokenizer(br.readLine());
        int idx = 0;
        while(token.hasMoreTokens()) {
            arr[idx++] = Integer.parseInt(token.nextToken());
        }
        if(next_permute()) {
            for(int i : arr) {
                System.out.print(i+" ");
            }
            System.exit(0);
        }
        System.out.println(-1);
    }
    static boolean next_permute() {
        //뒤에서 부터 arr[i-1]보다 arr[i]가 큰 지점을 찾고
        int i = num-1;
        while(i > 0 && arr[i-1] >= arr[i]) {
            i--;
        }
        //만약에 주어진 배열이 만들 수 있는 배열중에서 제일 크다면 false를 반환
        if(i <= 0) {
            return false;
        }
        //뒤에서 부터 arr[i-1]보다 작은 지점을 찾는다.
        int j = num-1;
        while(arr[j] <= arr[i-1]) {
            j--;
        }
        //arr[i-1]과 arr[j]를 바꾸고
        int temp = arr[i-1];
        arr[i-1] = arr[j];
        arr[j] = temp;
        //i를 증가시키면서 와 맨 뒤에서 부터 감소하는 값과 모두 바꾼다.
        j = num-1;
        while(i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i ++;
            j--;
        }
        return true;
    }
}
