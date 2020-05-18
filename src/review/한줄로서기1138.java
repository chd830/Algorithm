package review;

import java.io.*;
import java.util.*;

public class 한줄로서기1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        List<Integer> list = new ArrayList();
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        for(int i = N; i > 0; i--) {
            list.add(arr[i], i);
        }
        for(int a : list) {
            System.out.print(a+" ");
        }
    }
}
