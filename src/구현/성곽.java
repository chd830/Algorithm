package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2234
public class 성곽 {
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    static int[][][] count;
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(token.nextToken());
        int N = Integer.parseInt(token.nextToken());
        int[][] arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        count = new int[N][M][2];
        List<Integer> list = new ArrayList<>();
        int idx = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(count[i][j][0] == 0) {
                    int cnt = 1;
                    boolean[][] visited = new boolean[N][M];
                    Queue<Node> que = new LinkedList<>();
                    visited[i][j] = true;
//                    intToBinary(arr[i][j]);
                    que.add(new Node(i, j));
                    while (!que.isEmpty()) {
                        Node n = que.poll();
                        for (int d = 0; d < 4; d++) {
                            if((arr[n.x][n.y] & 1<<d) != 0)
                                continue;
                            int dx = n.x + dir[d][0];
                            int dy = n.y + dir[d][1];
                            if(isIn(dx, dy) && !visited[dx][dy]) {
                                que.add(new Node(dx, dy));
                                visited[dx][dy] = true;
                                cnt++;
                            }
                        }
                    }
                    list.add(cnt);
                    room(visited, cnt, idx++);
//                    print(count);
                }
            }
        }
//        print(count);
        Collections.sort(list);
        // 방의 개수
        System.out.println(list.size());
        // 가장 큰 방의 크기
        System.out.println(list.get(list.size()-1));
        // 하나의 벽을 제거해서 얻을 수 있는 가장 넓은 방의 크기
        // count배열을 사용해서 옆으로 이동할 수 없는 벽으로 막혀있을 때 옆의 수를 더해서 최댓값을 구함
        max = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                for(int d = 0; d < 4; d++) {
                    // 벽
                    if((arr[i][j] & 1<<d) != 0) {
                        int dx = i + dir[d][0];
                        int dy = j + dir[d][1];
                        if(isIn(dx, dy) && count[i][j][1] != count[dx][dy][1]) {
                            max = Math.max(max, count[i][j][0]+count[dx][dy][0]);
                        }
                    }
                }
            }
        }
        System.out.println(max);
    }
    static int max;
    static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < count.length && y < count[0].length;
    }
    static void intToBinary(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 4; i++) {
            if((n & 1<<i) != 0)
                sb.append(1);
            else
                sb.append(0);
        }
        System.out.println(n+"\t"+sb.reverse().toString());
    }
    static void print(int[][][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j][0]+"\t");
            }
            System.out.print("\t\t");
            for(int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j][1]+"\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    static void room(boolean[][] visited, int cnt, int idx) {
        for(int i = 0; i < visited.length; i++) {
            for(int j = 0; j < visited[0].length; j++) {
                if(visited[i][j]) {
                    count[i][j][0] = cnt;
                    count[i][j][1] = idx;
                }
            }
        }
    }
}
