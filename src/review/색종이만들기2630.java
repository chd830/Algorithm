package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이만들기2630 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer token = null;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        white = 0;
        blue = 0;
        recur(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }
    static int white;
    static int blue;
    static int[][] map;
    static void recur(int x, int y, int n) {
        int color = map[x][y];
        for(int i = x; i < x+n; i++) {
            for(int j = y; j < y+n; j++) {
                if(map[i][j] != color) {
                    recur(x, y, n/2);
                    recur(x+n/2, y, n/2);
                    recur(x, y+n/2, n/2);
                    recur(x+n/2, y+n/2, n/2);
                    return;
                }
            }
        }
        if(color == 1) {
            blue++;
        }
        else {
            white++;
        }
    }
}
