package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/14500
public class 테트로미노 {
    static int[][] tetromino = {
            {0, 0}, {0, 1}, {0, 2}, {0, 3},
            {0, 0}, {1, 0}, {2, 0}, {3, 0},

            {0, 0}, {0, 1}, {1, 0}, {1, 1},

            {0, 0}, {1, 0}, {2, 0}, {2, 1},
            {0, 0}, {1, 0}, {2, 0}, {2, -1},
            {0, 0}, {0, 1}, {0, 2}, {1, 0},
            {0, 0}, {0, 1}, {0, 2}, {-1, 0},
            {0, 0}, {0, 1}, {1, 1}, {2, 1},
            {0, 0}, {0, 1}, {1, 0}, {2, 0},
            {0, 0}, {0, 1}, {0, 2}, {-1, 2},
            {0, 0}, {0, 1}, {0, 2}, {1, 2},

            {0, 0}, {1, 0}, {1, 1}, {2, 1},
            {0, 0}, {1, 0}, {1, -1}, {2, -1},
            {0, 0}, {0, 1}, {-1, 1}, {-1, 2},
            {0, 0}, {0, 1}, {1, 1}, {1, 2},

            {0, 0}, {0, 1}, {0, 2}, {-1, 1},
            {0, 0}, {1, 0}, {2, 0}, {1, 1},
            {0, 0}, {0, 1}, {0, 2}, {1, 1},
            {0, 0}, {1, 0}, {2, 0}, {1, -1}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int max = 0;
        int[][] arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                for(int t = 0; t < tetromino.length; t += 4) {
                    int count = 0;
                    int d = 0;
                    for(; d < 4; d++) {
                        int dx = i + tetromino[t+d][0];
                        int dy = j + tetromino[t+d][1];
                        if(isIn(dx, dy, N, M)) {
                            count += arr[dx][dy];
                        }
                        else
                            break;
                    }
                    if(d == 4) {
//                        switch (t/4) {
//                            case 0: case 1:
//                                System.out.print("ㅡ ㅣ");
//                                break;
//                            case 2:
//                                System.out.print("ㅁ");
//                                break;
//                            case 3: case 4: case 5: case 6:
//                                System.out.print("L");
//                                break;
//                            case 8: case 9: case 10: case 11:
//                                System.out.print("ㅏ ㅓ ㅗ ㅜ");
//                                break;
//                            default:
//                                System.out.print("..");
//                                break;
//                        }
//                        System.out.println("\t"+i+"\t"+j+"\t"+count);
                        max = Math.max(max, count);
                    }
                }
            }
        }
        System.out.println(max);
    }

    static boolean isIn(int x, int y, int N, int M) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
