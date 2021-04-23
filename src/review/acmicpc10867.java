package review;

import java.util.*;
import java.io.*;

// 중복 빼고 정렬하기
public class acmicpc10867 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            map.put(Integer.parseInt(token.nextToken()), 1);
        }
        int[] arr = new int[map.size()];
        int idx = 0;
        for(int i : map.keySet()) {
            arr[idx++] = i;
        }
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
