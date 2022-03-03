package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/20055
public class 컨베이어벨트위의로봇 {
    static int N;
    static int K;
    static int[][] map;
    static boolean[] robot;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        map = new int[N * 2][2];
        robot = new boolean[N];
        for (int i = 0; i < 2 * N; i++) {
            map[i][0] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        int time = 1;
        while (true) {
            // 벨트가 한칸 회전한다
            turnAroundMap();
            turnAroundRobot();
            // 가장 먼저 올라간 로봇부터 벨트가 회전하는 방향으로 한칸 이동할 수 있으면 이동한다
            // 이동시에는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아있어야한다
            for (int i = robot.length - 1; i > -1; i--) {
                if (robot[i]) {
                    int nxt = i + 1;
                    if(nxt==N) {
                        robot[i]=false;
                        continue;
                    }
                    if (nxt < N && !robot[nxt]) {
                        if (map[nxt][0] > 0) {
                            robot[nxt] = true;
                            robot[i] = false;
                            map[nxt][0]--;

                            if (map[nxt][0] == 0 && map[nxt][1] == 0) {
                                cnt++;
                                map[nxt][1] = 1;
                            }
                        }
                    }
                }
            }
            // 올라가는 위치에 로봇이 없으면 로봇을 하나 올린다
            if (!robot[0] && map[0][0] > 0) {
                map[0][0]--;
                robot[0] = true;
                if (map[0][0] == 0 && map[0][1] == 0) {
                    cnt++;
                    map[0][1] = 1;
                }
            }
            // 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다
            if (cnt >= K)
                break;
            time++;
        }
        // 끝
        System.out.println(time);
    }

    private static void turnAroundRobot() {
        for (int i = robot.length - 1; i > 0; i--) {
            robot[i] = robot[i - 1];
        }
        robot[0] = false;
    }

    private static void turnAroundMap() {
        int tmp1 = map[map.length - 1][0];
        int tmp2 = map[map.length - 1][1];
        for (int i = map.length - 1; i > 0; i--) {
            map[i][0] = map[i - 1][0];
            map[i][1] = map[i - 1][1];
        }
        map[0][0] = tmp1;
        map[0][1] = tmp2;
    }
}
