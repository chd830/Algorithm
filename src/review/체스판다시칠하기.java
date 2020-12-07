package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 체스판다시칠하기 {
    static int N;
    static int M;
    static int min;
    static boolean[][] chess;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        chess = new boolean[N][M];
        min = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                chess[i][j] = str.charAt(j) == 'W' ? true : false;
            }
        }
        for(int i = 0; i < N-7; i++) {
            for(int j = 0; j < M-7; j++) {
                find(i, j);
            }
        }
        System.out.println(min);
    }
    public static void find(int x, int y) {
        int dx = x+8;
        int dy = y+8;
        int cnt = 0;
        boolean check = chess[x][y];
        for(int i = x; i < dx; i++) {
            for(int j = y; j < dy; j++) {
                if(chess[i][j] != check) {
                    cnt++;
                }
                check = !check;
            }
            check = !check;
        }
        cnt = Math.min(cnt, 64-cnt);
        min = Math.min(min, cnt);
    }
}
