package review;

import java.util.*;
import java.io.*;

public class 이전순열 {
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
        prev();
        System.out.println(Arrays.toString(arr));
    }
    static void prev() {
        int i = N-1;
        while(i > 0 && arr[i-1] <= arr[i]) {
            i--;
        }
        if(i <= 0) {
            System.out.println(-1);
            System.exit(0);
        }
        int j = N-1;
        while(arr[j] >= arr[i-1]) {
            j--;
        }
        swap(i-1, j);
        j = N-1;
        while(i < j) {
            swap(i, j);
            i++;
            j--;
        }
    }
    static void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
