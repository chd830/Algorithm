package BruteForce;

import java.io.*;
import java.util.*;

public class 드래곤커브 {
    static int N;
    static int x;
    static int y;
    static int d;
    static int g;
    static boolean[][] map = new boolean[101][101];
    static List<Integer> directions;
    static int[][] pos = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer token = null;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            x = Integer.parseInt(token.nextToken());
            y = Integer.parseInt(token.nextToken());
            d = Integer.parseInt(token.nextToken());
            g = Integer.parseInt(token.nextToken());
            dragonCurve();
        }
        System.out.println(cntSquare());
    }
    static void dragonCurve() {
        directions = new ArrayList<>();
        directions.add(d);
        int dir;
        // 다음에 나올 수 있는 방향 directions에 추가하기
        while(g-- > 0) {
            for(int i = directions.size()-1; i >= 0; i--) {
                dir = (directions.get(i)+1)%4;
                directions.add(dir);
            }
        }
        map[x][y] = true;
        int cx = x;
        int cy = y;
        // directions에 저장되어있는 방향을 가져와서 이전의 값에 계속 방향을 더해가면서 다음 값 등록
        for(int i = 0; i < directions.size(); i++) {
            dir = directions.get(i);
            int nx = cx + pos[dir][0];
            int ny = cy + pos[dir][1];
            map[nx][ny] = true;
            cx = nx;
            cy = ny;
        }
    }
    // 사각형의 개수
    static int cntSquare() {
        int cnt = 0;
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1])
                    cnt++;
            }
        }
        return cnt;
    }
}
