package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 벽돌깨기 {
    static int N;
    static int W;
    static int H;
    static int answer;
    static int brickCnt;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new StringReader(src));
        StringTokenizer token;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 1; t <= T; t++) {
            sb.append("#"+t+" ");
            token = new StringTokenizer(br.readLine());
            N = Integer.parseInt(token.nextToken());
            H = Integer.parseInt(token.nextToken());
            W = Integer.parseInt(token.nextToken());
            map = new int[W][H];
            brickCnt = 0;
            answer = 0;
            for(int i = 0; i < W; i++) {
                token = new StringTokenizer(br.readLine());
                for(int j = 0; j < H; j++) {
                    map[i][j] = Integer.parseInt(token.nextToken());
                    if(map[i][j] != 0) {
                        brickCnt++;
                    }
                }
            }
            answer = brickCnt;
            dropMarble(N, brickCnt, map);
            sb.append(answer+"\n");
        }
        System.out.println(sb);
    }
    static class Brick {
        int row;
        int col;
        int pow;
        Brick(int x, int y, int pow) {
            this.row = x;
            this.col = y;
            this.pow = pow;
        }

        @Override
        public String toString() {
            return "Brick [ row: "+ row +", col: "+ col +", pow: "+pow+"]";
        }
    }
    //r-1을 통해서 순열값이 들어오게된다.
    static void dropMarble(int r, int brickCnt, int[][] map) {
        if(r == 0) {
            //순열값이 모두 나왔을 때
            answer = Math.min(answer, brickCnt);
            return;
        }
        for(int c = 0; c < H; c++) {
            //map의 복제
            int[][] clone = cloneMap(map);
            //해당 컬럼의 맨 처음 벽돌 가져오기
            Brick first = getFirstBrick(c, clone);
            //null 일 때 continue
            if(first == null) {
                continue;
            }
            //구슬을 떨어뜨려서 벽돌을 깬다
            int broken = crash(first, clone); //깨진 벽돌 개수
            //이미 다 벽돌이 깨졌을 때 정답 = 0, 종료한다.
            if(broken >= brickCnt) {
                answer = 0;
                return;
            }
            //화면 정리
            cleanMap(clone);
            //다음 벽돌 떨어뜨리기
            dropMarble(r-1, brickCnt-broken, clone);
        }
    }
    static void cleanMap(int[][] map) {
        for(int c = 0; c < H; c++) {
            for(int r = W-1, nr = W-1; r >= 0; r--) {
                if(map[r][c] != 0) {
                    int temp = map[r][c];
                    map[r][c] = 0;
                    map[nr--][c] = temp;
                }
            }
        }
    }
    static int crash(Brick first, int[][] map) {
        int broken = 0;
        map[first.row][first.col] = 0;
        broken++;
        for(int p = 1; p < first.pow; p++) {
            for(int d = 0; d < dir.length; d++) {
                int dx = first.row + dir[d][0] * p;
                int dy = first.col + dir[d][1] * p;
                if(isIn(dx, dy) && map[dx][dy] != 0) {
                    broken += crash(new Brick(dx, dy, map[dx][dy]), map);
                }
            }
        }
        return broken;
    }

    static Brick getFirstBrick(int c, int[][] map) {
        for(int r = 0; r < W; r++) {
            if(map[r][c] != 0) {
                return new Brick(r, c, map[r][c]);
            }
        }
        return null;
    }
    static int[][] cloneMap(int[][] map) {
        int[][] temp = new int[W][H];
        for(int r = 0; r < W; r++) {
            temp[r] = map[r].clone(); //deep copy
        }
        return temp;
    }
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < W && c < H;
    }
    static String src = "5\r\n" + "3 10 10\r\n" + "0 0 0 0 0 0 0 0 0 0\r\n" + "1 0 1 0 1 0 0 0 0 0\r\n"
            + "1 0 3 0 1 1 0 0 0 1\r\n" + "1 1 1 0 1 2 0 0 0 9\r\n" + "1 1 4 0 1 1 0 0 1 1\r\n"
            + "1 1 4 1 1 1 2 1 1 1\r\n" + "1 1 5 1 1 1 1 2 1 1\r\n" + "1 1 6 1 1 1 1 1 2 1\r\n"
            + "1 1 1 1 1 1 1 1 1 5\r\n" + "1 1 7 1 1 1 1 1 1 1\r\n" + "2 9 10\r\n" + "0 0 0 0 0 0 0 0 0\r\n"
            + "0 0 0 0 0 0 0 0 0\r\n" + "0 1 0 0 0 0 0 0 0\r\n" + "0 1 0 0 0 0 0 0 0\r\n" + "1 1 0 0 1 0 0 0 0\r\n"
            + "1 1 0 1 1 1 0 1 0\r\n" + "1 1 0 1 1 1 0 1 0\r\n" + "1 1 1 1 1 1 1 1 0\r\n" + "1 1 3 1 6 1 1 1 1\r\n"
            + "1 1 1 1 1 1 1 1 1\r\n" + "3 6 7\r\n" + "1 1 0 0 0 0\r\n" + "1 1 0 0 1 0\r\n" + "1 1 0 0 4 0\r\n"
            + "4 1 0 0 1 0\r\n" + "1 5 1 0 1 6\r\n" + "1 2 8 1 1 6\r\n" + "1 1 1 9 2 1\r\n" + "4 4 15\r\n"
            + "0 0 0 0 \r\n" + "0 0 0 0 \r\n" + "0 0 0 0 \r\n" + "1 0 0 0 \r\n" + "1 0 0 0 \r\n" + "1 0 0 0 \r\n"
            + "1 0 0 0 \r\n" + "1 0 5 0 \r\n" + "1 1 1 0 \r\n" + "1 1 1 9 \r\n" + "1 1 1 1 \r\n" + "1 6 1 2 \r\n"
            + "1 1 1 5 \r\n" + "1 1 1 1 \r\n" + "2 1 1 2 \r\n" + "4 12 15\r\n" + "9 9 9 9 9 9 9 9 9 9 9 9\r\n"
            + "9 9 9 9 9 9 9 9 9 9 9 9\r\n" + "9 9 9 9 9 9 9 9 9 9 9 9\r\n" + "9 9 9 9 9 9 9 9 9 9 9 9\r\n"
            + "9 9 9 9 9 9 9 9 9 9 9 9\r\n" + "9 9 9 9 9 9 9 9 9 9 9 9\r\n" + "9 9 9 9 9 9 9 9 9 9 9 9\r\n"
            + "9 9 9 9 9 9 9 9 9 9 9 9\r\n" + "9 9 9 9 9 9 9 9 9 9 9 9\r\n" + "9 9 9 9 9 9 9 9 9 9 9 9\r\n"
            + "9 9 9 9 9 9 9 9 9 9 9 9\r\n" + "9 9 9 9 9 9 9 9 9 9 9 9\r\n" + "9 9 9 9 9 9 9 9 9 9 9 9\r\n"
            + "9 9 9 9 9 9 9 9 9 9 9 9\r\n" + "9 9 9 9 9 9 9 9 9 9 9 9";
}
