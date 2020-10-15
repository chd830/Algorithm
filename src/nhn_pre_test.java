import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class nhn_pre_test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        StringTokenizer token = null;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        List<Integer> area = new ArrayList<>();

        Queue<Node> que = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                int cnt = 0;
                if(map[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    cnt++;
                    que.add(new Node(i, j));
                    while(!que.isEmpty()) {
                        Node n = que.poll();
                        for(int d = 0; d < 4; d++) {
                            int dx = n.x + dir[d][0];
                            int dy = n.y + dir[d][1];
                            if(dx >= 0 && dy >= 0 && dx < N && dy < N && map[dx][dy] == 1 && !visited[dx][dy]) {
                                que.add(new Node(dx, dy));
                                visited[dx][dy] = true;
                                cnt++;
                            }
                        }
                    }
                    if(cnt != 0) {
                        area.add(cnt);
                    }
                }
            }
        }
        if(area.isEmpty()) {
            System.out.println(0);
            System.exit(0);
        }
        System.out.println(area.size());
        Collections.sort(area);
        for(int i : area) {
            System.out.print(i+" ");
        }
    }
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}