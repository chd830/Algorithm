package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test {
    public static void main(String[] args) {
        int N = 3;
        int K = 4;
        int[] val = new int[N];
        int[] weight = new int[N];
        int[][] dp = new int[N+1][K+1];
        int max = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= K; j++) {
                // 현재무게가 제한무게보다 가벼울 때
                if(j >= weight[i-1])
                    // Math.max(현재무게가 없을 때의 값 + 가격, 이전의 값)
                    dp[i][j] = Math.max(val[i-1]+dp[i-1][j-weight[i-1]], dp[i-1][j]);
                // 현재무게가 제한무게보다 무거울 때
                else
                    // 이전의 값이 최고값임
                    dp[i][j] = dp[i-1][j];
                max = Math.max(dp[i][j], max);
            }
        }
    }
//    public static void main(String[] args) throws IOException {
//        boolean[] visited = new boolean[101];
//        Arrays.fill(visited, true);
//        for(int i = 2; i < 100; i++) {
//            for(int j = i+i; j < 100; j += i) {
//                visited[j] = false;
//            }
//        }
//        for(int i = 2; i < 100; i++) {
//            System.out.print(visited[i] ? i+"\t" : "");
//        }
//    }
//    static int[][] map;
//    static int N;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer token = new StringTokenizer(br.readLine());
//        map = new int[Integer.parseInt(token.nextToken())][Integer.parseInt(token.nextToken())];
//        recur(0);
//    }
//    static void recur(int N) {
//        if(N == map.length) {
//            for(int i = 0; i < map.length; i++)
//                System.out.println(Arrays.toString(map[i]));
//            System.out.println();
//            return;
//        }
//        for(int i = 0; i < map.length; i++) {
//            if(check(N, i)) {
//                map[N][i] = 1;
//                recur(N+1);
//                map[N][i] = 0;
//            }
//        }
//    }
//    static boolean check(int r, int c) {
//        //위
//        for(int i = r; i >= 0; i--) {
//            if(map[i][c] == 1) {
//                return false;
//            }
//        }
//        //왼쪽 위
//        for(int i = 1; r >= i && c >= i; i++) {
//            if(map[r-i][c-i] == 1) {
//                return false;
//            }
//        }
//        //오른쪽 위
//        for(int i = 1; r >= i && c + i < N; i++) {
//            if(map[r-i][c+i] == 1) {
//                return false;
//            }
//        }
//        return true;
//    }
}
