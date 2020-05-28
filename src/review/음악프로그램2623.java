package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 음악프로그램2623 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int[] arr = new int[N+1];
        List<Integer>[] list = new ArrayList[N+1];
        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < Integer.parseInt(token.nextToken()); j++) {
                arr[Integer.parseInt(token.nextToken())]++;
            }
        }
    }
}
