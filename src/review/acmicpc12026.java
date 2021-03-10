package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// BOJ 거리
public class acmicpc12026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        int[] d = new int[N];
        Arrays.fill(d, -1);
        d[0] = 0;
        for (int i = 1; i < N; i++) {
            char now = arr[i];
            char prev = now == 'B' ? 'J' : now == 'O' ? 'B' : 'O';
            for (int j = 0; j < i; j++) {
                // BOJ가 순서대로 되지 않은 점(-1의 값을 가짐)과 방문할 수 없는 점은 생략한다.
                if (d[j] == -1) continue;
                if (arr[j] != prev) continue;
                // 이전의 값이 비어있거나 현재 값보다 클 때 지금의 값을 넣는다.
                int cost = d[j] + (i - j) * (i - j);
                if (d[i] == -1 || d[i] > cost) {
                    d[i] = cost;
                }
            }
        }
        System.out.println(d[N - 1]);
    }
}
