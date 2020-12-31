package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 친구 {
    static int N;
    static int result;
    static int[][] arr = new int[50][50];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                char ch = str.charAt(j);
                if (ch == 'Y') {
                    arr[i][j] = 1;
                } else if (i != j) {
                    // INF의 값은 항상 제일큰 값을 줘야함
                    arr[i][j] = 987654321;
                }
            }
        }
        floyd_warshall();
        for(int i = 0; i < N; i++) {
            int tmp = 0;
            for(int j = 0; j < N; j++) {
                if(i == j) {
                    continue;
                }
                // 친구의 수: 한 다리 건너서 아는 친구 + 서로 친구
                else if(arr[i][j] <= 2) {
                    tmp++;
                }
                result = Math.max(result, tmp);
            }
        }
        System.out.println(result);
    }

    public static void floyd_warshall() {
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j || j == k || i == k)
                        continue;
                    else if (arr[i][j] > arr[i][k] + arr[k][j])
                        arr[i][j] = arr[i][k] + arr[k][j];
                }
            }
        }
    }
}
