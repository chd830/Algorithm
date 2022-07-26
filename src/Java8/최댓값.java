package Java8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/2562
// https://zzang9ha.tistory.com/282
public class 최댓값 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = 9;
        int[] arr = new int[len];
        for(int i = 0; i < len; i++)
            arr[i] = Integer.parseInt(br.readLine());
        int max = Arrays.stream(arr).max().getAsInt();
        int[] idx = IntStream.range(0, len).filter(i -> arr[i] == max).toArray();
        System.out.println(max+" "+(idx[0]+1));
    }
}