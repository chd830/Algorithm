package review;

import java.util.*;
import java.io.*;

public class acmicpc7562 {
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] dir = {{-2, 1}, {-1, 2}, {2, 1}, {1, 2}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
        int T = Integer.parseInt(br.readLine());
        StringTokenizer token;
        for(int t = 0; t < T; t++) {
            int I = Integer.parseInt(br.readLine());
            int[][] arr = new int[I][I];
            token = new StringTokenizer(br.readLine());
            Node start = new Node(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
            token = new StringTokenizer(br.readLine());
            Node end = new Node(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
            Queue<Node> que = new LinkedList<>();
            que.add(start);
            while(!que.isEmpty()) {
                Node n = que.poll();
                if(n.x == end.x && n.y == end.y) {
                    System.out.println(arr[n.x][n.y]);
                    break;
                }
                for(int d = 0; d < dir.length; d++) {
                    int dx = n.x + dir[d][0];
                    int dy = n.y + dir[d][1];
                    if(dx >= 0 && dy >= 0 && dx < I && dy < I && arr[dx][dy] == 0) {
                        arr[dx][dy] = arr[n.x][n.y]+1;
                        que.add(new Node(dx, dy));
                    }
                }
            }
        }
    }
}
