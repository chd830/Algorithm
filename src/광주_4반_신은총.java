import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 광주_4반_신은총 {
    static int[][] dir = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
        for(int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            int[][] map = new int[10][10];
            for(int i = 0; i < 10; i++) {
                StringTokenizer token = new StringTokenizer(br.readLine());
                for(int j = 0; j < 10; j++) {
                    map[i][j] = Integer.parseInt(token.nextToken());
                }
            }
            Queue<Node> que = new LinkedList<>();
            int cnt = 0;
            for(int i = 0; i < 10; i++) {
                for(int j = 0; j < 10; j++) {
                    if(map[i][j] == 1) {
                        cnt++;
                        map[i][j] = -1;
                        que.add(new Node(i, j));
                        while(!que.isEmpty()) {
                            Node n = que.poll();
                            for(int k = 0; k < 8; k++) {
                                int dx = n.x+dir[k][0];
                                int dy = n.y+dir[k][1];
                                if(isIn(dx, dy) && map[dx][dy] == 1) {
                                    que.add(new Node(dx, dy));
                                    map[dx][dy] = -1;
                                }
                            }
                        }
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }
    static boolean isIn(int dx, int dy) {
        return dx >= 0 && dy >= 0 && dx < 10 && dy < 10;
    }
}

