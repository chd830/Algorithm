package Sort;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/18870
public class 좌표압축 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sorted = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = sorted[i] = Integer.parseInt(token.nextToken());
        Arrays.sort(sorted);
        int rank = 0;
        for(int s : sorted) {
            if(!map.containsKey(s)) {
                map.put(s, rank);
                rank++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int key : arr) {
            rank = map.get(key);
            sb.append(rank).append(" ");
        }
        System.out.println(sb.toString());
    }
}
