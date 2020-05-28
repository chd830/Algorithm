package net.acmicpc;

import java.util.LinkedList;
import java.util.Scanner;

public class 아기상어 {

    static int map[][];
    static int N = 0;
    static int dX[] = {-1, 0, 1, 0};
    static int dY[] = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        map = new int[N][N];

        //1. 먹을 물고기 있는지 탐색
        //1-1. 제일 가까운 물고기 탐색은 자연스럽게 BFS로 해결, 만약 먹을 물고리 동률-> 가장위 -> 가장 왼쪽
        //2. 먹을 물고기 찾으면,먹고 나이증가 체크
        //3. 큐에 있는 모든 포인트 날리고 현재 찾은 포인트만 add
        LinkedList<Shark> que = new LinkedList<>();
        int age = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 9) {
                    que.add(new Shark(i, j, age));
                    map[i][j] = 0;
                }
            }
        }
        int eat = 0;
        int time = 0;
        while (true) {
            LinkedList<Shark> fish = new LinkedList<>();
            int[][] dist = new int[N][N];// 거리
            while (!que.isEmpty()) {
                Shark s = que.poll();
                for (int i = 0; i < 4; i++) {
                    int nX = s.x + dX[i];
                    int nY = s.y + dY[i];

                    if (-1 < nX && nX < N && -1 < nY && nY < N && dist[nX][nY] == 0 && map[nX][nY] <= age) {
                        dist[nX][nY] = dist[s.x][s.y] + 1;
                        //먹잇감 포착
                        if (1 <= map[nX][nY] && map[nX][nY] <= 6 && map[nX][nY] < age) {
                            fish.add(new Shark(nX, nY, dist[nX][nY]));
                            que.add(new Shark(nX, nY, dist[nX][nY]));
                            continue;
                        }
                        //먹잇감 없음(지나가긴함)
                        que.add(new Shark(nX, nY, dist[nX][nY]));
                    }
                }
            }

            //제일 가까운..
            if (fish.size() == 0) {
                System.out.println(time);
                return;
            }
            int d = 5000;
            Shark eatingFish = fish.get(0);
            for (int i = 1; i < fish.size(); i++) {
                if (eatingFish.dist > fish.get(i).dist) {
                    eatingFish = fish.get(i);
                }

                if (eatingFish.dist == fish.get(i).dist) {
                    if (eatingFish.x > fish.get(i).x) {
                        eatingFish = fish.get(i);
                        continue;
                    } else if (eatingFish.x == fish.get(i).x) {
                        if (eatingFish.y > fish.get(i).y) ;
                        eatingFish = fish.get(i);
                    }
                }
            }

            time += eatingFish.dist;
            eat++;
            map[eatingFish.x][eatingFish.y] = 0;
            if (eat == age) {
                age++;
                eat = 0;
            }
            que.add(new Shark(eatingFish.x, eatingFish.y, age));

        }


    }
    static class Shark {
        int x;
        int y;
        int dist;

        public Shark(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
