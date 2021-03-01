package review;

import java.util.*;
import java.io.*;

public class 차이를최대로10819 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(arr);
        next();
        System.out.println(max);
    }
    static int max;
    static void abs() {
        int sum = 0;
        for(int i = 0; i < N-1; i++) {
            sum += Math.abs(arr[i] - arr[i+1]);
        }
        max = Math.max(max, sum);
    }
    static void next() {
        abs();
        int i = N-1;
        while(i > 0 && arr[i-1] >= arr[i]) {
            i--;
        }
        if(i <= 0) {
            return;
        }
        int j = N-1;
        while(arr[j] <= arr[i-1]) {
            j--;
        }
        swap(i-1, j);
        j = N-1;
        while(i < j) {
            swap(i, j);
            i++;
            j--;
        }
        next();
    }
    static void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
