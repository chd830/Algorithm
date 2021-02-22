package review;

import java.util.*;
import java.io.*;

public class 이전순열 {
    static int N;
    static int[] arr;
    static boolean check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        check = false;
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        prev();
        if(check) {
            System.out.println(-1);
        }
        else {
            for (int i : arr) {
                System.out.print(i + " ");
            }
        }
    }
    static void prev() {
        int i = N-1;
        while(i > 0 && arr[i-1] <= arr[i]) {
            i--;
        }
//        System.out.print(i+"\t");
        if(i <= 0) {
            check = true;
            return;
        }
        int j = N-1;
        while(arr[j] >= arr[i-1]) {
            j--;
        }
//        System.out.println(j);
        swap(i-1, j);
//        System.out.println(Arrays.toString(arr));
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
