package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//dp사용
public class 가장큰정사각형1715 {
    public static int N;
    public static int M;
    public static char[][] map;
    public static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        map = new char[N][M];
        dp = new int[N][M];
        for(int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                int min = Integer.MAX_VALUE;
                if(map[i][j] == '1') {
                    if(j-1 >= 0 && i-1 >= 0) {
                        min = Math.min(min, dp[i][j-1]);
                        min = Math.min(min, dp[i-1][j]);
                        min = Math.min(min, dp[i-1][j-1]);
                    }
                    if(min == Integer.MAX_VALUE) {
                        dp[i][j] = 1;
                    }
                    else {
                        dp[i][j] = min + 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        System.out.println(max * max);
        br.close();
    }
//    시간초과
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer token = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(token.nextToken());
//        M = Integer.parseInt(token.nextToken());
//        map = new int[N][M];
//        for(int i = 0; i < N; i++) {
//            String str = br.readLine();
//            for(int j = 0; j < M; j++) {
//                map[i][j] = str.charAt(j) - '0';
//            }
//        }
//        min = N < M ? N : M;
//        maxArea = 0;
//        findSquare();
//        System.out.println(maxArea);
//    }
//    static int maxArea;
//    static int min;
//    static void findSquare() {
//        for(int i = 0; i < N; i++) {
//            for(int j = 0; j < M; j++) {
//                if(map[i][j] == 1) {
//                    for(int k = 1; k <= min; k++) {
//                        if(checkSquare(i, j, k)) {
//                            maxArea = Math.min(maxArea, k*k);
//                        }
//                    }
//                }
//            }
//        }
//    }
//    static boolean checkSquare(int x, int y, int size) {
//        if(x+size > min || y+size > min) {
//            return false;
//        }
//        for(int i = x; i < x+size; i++) {
//            for(int j = y; j < y+size; j++) {
//                if(map[i][j] == 0) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//    static int N;
//    static int M;
//    static int[][] map;
}
