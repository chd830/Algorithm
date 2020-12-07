package review;

import java.io.*;
import java.util.Stack;

public class 사탕게임 {
    static int N;
    static int max;
    static char[][] map;
    static char[][] copy;
    static int[][] dir = {{0, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        max = 0;
        map = new char[N][N];
        copy = new char[N][N];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        //copy를 초기화
        //오른쪽이나 아래쪽의 사탕의 위치를 바꿈
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                for(int d = 0; d < dir.length; d++) {
                    int dx = i + dir[d][0];
                    int dy = j + dir[d][1];
                    if(dx < N && dy < N) {
                        init();
                        swap(i, j, dx, dy);
                        //연속되는 사탕이 몇개가 최대인지를 카운트 한 후 max변수에 넣기
                        count();
                    }
                }
            }
        }

        //가장 큰 값 출력
        System.out.println(max);
    }
    public static void count() {
        for(int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 1; j < N; j++) {
                if (copy[i][j] == copy[i][j - 1]) {
                    cnt += 1;
                } else {
                    cnt = 1;
                }
                max = Math.max(cnt, max);
            }
            cnt = 1;
            for (int j = 1; j < N; j++) {
                if (copy[j][i] == copy[j - 1][i]) {
                    cnt += 1;
                } else {
                    cnt = 1;
                }
                max = Math.max(cnt, max);
            }
        }
    }

    public static void swap(int i, int j, int dx, int dy) {
        char tmp = copy[i][j];
        copy[i][j] = copy[dx][dy];
        copy[dx][dy] = tmp;
    }
    public static void init() {
        for(int i = 0; i < N; i++) {
            copy[i] = map[i].clone();
        }
    }
}
