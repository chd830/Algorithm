package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/17085
public class 십자가2개놓기 {
    static int N;
    static int M;
    static int answer;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        arr = new char[N][M];
        answer = 1;
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        // 첫 십자가를 찾기
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == '#') {
                    int size1 = crossSize(i, j);
                    // k가 최대 size1까지 나올 수 있고 다음 size2를 구함
                    for(int k = 0; k <= size1; k++) {
                        checkVisited(i, j, k, '.');
                        for (int r = 0; r < N; r++) {
                            for (int c = 0; c < M; c++) {
                                if (arr[r][c] == '#') {
                                    int size2 = crossSize(r, c);
                                    int width1 = 4*k+1;
                                    int width2 = 4*size2+1;
                                    answer = Math.max(answer, width1*width2);
                                }
                            }
                        }
                    }
                    checkVisited(i, j, size1, '#');
                }
            }
        }
        System.out.println(answer);
    }
    static void checkVisited(int x, int y, int size, char flag) {
        for(int i = 0; i <= size; i++) {
            for(int j = 0; j < 4; j++) {
                int dx = x + dir[j][0]*i;
                int dy = y + dir[j][1]*i;
                arr[dx][dy] = flag;
            }
        }
        for(int i = x-size/2; i <= x+size/2; i++)
            arr[i][y] = flag;
        for(int i = y-size/2; i <= y+size/2; i++)
            arr[x][i] = flag;
    }
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int crossSize(int x, int y) {
        int size = 0;
        while(true) {
            boolean flag = true;
            for (int i = 0; i < 4; i++) {
                int dx = x + dir[i][0]*size;
                int dy = y + dir[i][1]*size;
                if (dx < 0 || dy < 0 || dx >= N || dy >= M || arr[dx][dy] == '.') {
                    flag = false;
                    break;
                }
            }
            if(flag)
                size++;
            else
                break;
        }
        return size-1;
    }
}
/*
5 15
###############
#...#.#...#.#..
###############
##..#.##..#.##.
###############

15 15
###############
#...#.#...#.#..
###############
##..#.##..#.##.
###############
###############
#...#.#...#.#..
###############
##..#.##..#.##.
###############
###############
#...#.#...#.#..
###############
##..#.##..#.##.
###############

 */