package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/16197
public class 두동전 {
    static class Node {
        int x;
        int y;
        int cnt;
        Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static int N;
    static int M;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        char[][] arr = new char[N][M];
        Queue<Node> que = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
                if(arr[i][j] == 'o')
                    que.add(new Node(i, j, 0));
            }
        }

        while(!que.isEmpty()) {
            Node coin1 = que.poll();
            Node coin2 = que.poll();
            if(coin1.cnt > 10) {
                System.out.println(-1);
                System.exit(0);
            }
            for(int d = 0; d < 4; d++) {
                int[] d1 = { coin1.x+dir[d][0], coin1.y+dir[d][1] };
                int[] d2 = { coin2.x+dir[d][0], coin2.y+dir[d][1] };
                // 모두 보드 밖에 있을 때 ->  아무 작업도 하지 않음
                if(!isIn(d1) && !isIn(d2))
                    continue;
                // coin1만 보드 밖에 있을 때나 coin2만 보드 밖에 있을 때
                if((isIn(d1) && !isIn(d2)) || (!isIn(d1) && isIn(d2))) {
                    System.out.println(coin1.cnt+1);
                    System.exit(0);
                }
                // 두개가 모두 보드 안에 있을 때 -> 기본
                if(isIn(d1) && isIn(d2)) {
                    // 두개 모두 벽일 때 -> 진행하지 않음
                    if (arr[d1[0]][d1[1]] == '#' && arr[d2[0]][d2[1]] == '#')
                        continue;
                    // 한 부분만 벽일 때 -> 벽인 부분은 이동하지 않음
                    if (arr[d1[0]][d1[1]] == '#') {
                        d1[0] = coin1.x;
                        d1[1] = coin1.y;
                    }
                    if (arr[d2[0]][d2[1]] == '#') {
                        d2[0] = coin2.x;
                        d2[1] = coin2.y;
                    }
                    que.add(new Node(d1[0], d1[1], coin1.cnt + 1));
                    que.add(new Node(d2[0], d2[1], coin2.cnt + 1));
                }
            }
        }
    }
    static boolean isIn(int[] arr) {
        return arr[0] >= 0 && arr[1] >= 0 && arr[1] < N && arr[1] < M;
    }
}

