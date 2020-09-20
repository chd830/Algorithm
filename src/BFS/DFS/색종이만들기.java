package BFS.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이만들기 {
    static int N;
    static int white;
    static int blue;
    static boolean[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        white = 0;
        blue = 0;
        map = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = token.nextToken().equals("1") ? true : false;
            }
        }
        recur(0, 0, N);
    }

    public static void recur(int N, int x, int y) {
        if(N == 1) {
            if(map[y][x]) {
                blue++;
            }
            else {
                white++;
            }
            return;
        }
        boolean sameColor = true;
        boolean color  = map[y][x];

        //같은 색이 아니라면 끝내기
        out: for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[y+i][x+j] != color) {
                    sameColor = false;
                    break out;
                }
            }
        }

        //같은 색일 때 파란색인지 하얀색인지 체크한다.
        if(sameColor) {
            if(map[y][x]) {
                blue++;
            }
            else {
                white++;
            }
            return;
        }

        //2로 나눠서 다음 색종이를 체크한다.
        int newN = N/2;
        recur(newN, x, y);
        recur(newN, x+newN, y);
        recur(newN, x, y+newN);
        recur(newN, x+newN, y+newN);
    }
}