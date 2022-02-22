package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1244
public class 스위치켜고끄기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine())+1;
        int[] arr = new int[N];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for (int i = 1; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        int student = Integer.parseInt(br.readLine());
        while (student-- > 0) {
            token = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(token.nextToken());
            int key = Integer.parseInt(token.nextToken());
            switch (gender) {
                case 1:
                    for(int i = key; i < N; i += key)
                        arr[i] = arr[i] == 0 ? 1 : 0;
                    break;
                case 2:
                    int left = key-1;
                    int right = key+1;
                    while(true) {
                        if(left < 1 || right >= N)
                            break;
                        if(arr[left] != arr[right])
                            break;
                        left--;
                        right++;
                    }
                    left++;
                    right--;
                    while(left <= right) {
                        arr[left] = arr[left] == 0 ? 1 : 0;
                        left++;
                    }
                    break;
            }
            for(int i = 1; i < N; i++) {
                System.out.print(arr[i]+" ");
                if(i%20 == 0)
                    System.out.println();
            }
        }
    }
}

/*
0 1 0 1 0 0 0 1
- 1 3
0 1 1 1 0 1 0 1
- 2 3
1 0 0 0 1 1 0 1
 */