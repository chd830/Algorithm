package review;

import java.util.*;
import java.io.*;

public class 통나무건너뛰기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int min = 0;
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int[] sub = new int[N];
            StringTokenizer token = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(token.nextToken());
            }
            Arrays.sort(arr);
            int left = 0;
            int right = N-1;
            for(int i = 0; i < N; i++) {
                if(i%2 == 0) {
                    sub[right] = arr[i];
                    right--;
                }
                else {
                    sub[left] = arr[i];
                    left++;
                }
            }
            min = Math.abs(sub[0]-sub[N-1]);
            for(int i = 0; i < N-1; i++) {
                min = Math.max(min, Math.abs(sub[i] - sub[i+1]));
            }
            System.out.println(min);
        }
    }
}