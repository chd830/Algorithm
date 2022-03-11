package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/14467
public class 소가길을건너간이유1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 소의 번호와 소의 위치 제공
        // 왼쪽 0 오른쪽 1
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[101];
        int[] count = new int[101];
        Arrays.fill(arr, -1);
        int maxCow = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int cow = Integer.parseInt(token.nextToken());
            maxCow = Math.max(maxCow, cow);
            int direction = Integer.parseInt(token.nextToken());
            if (arr[cow] == 0) {
                if (direction == 1) {
                    count[cow]++;
                    arr[cow] = direction;
                }
            } else if (arr[cow] == 1) {
                if (direction == 0) {
                    count[cow]++;
                    arr[cow] = direction;
                }
            } else {
                count[cow]++;
                arr[cow] = direction;
            }
        }
        int sum = 0;
        for (int i = 1; i <= maxCow; i++) {
            if (count[i] > 1) {
                sum += count[i] - 1;
            }
        }
        System.out.println(sum);

    }
}
