package co.kr.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
    public static void main(String[]) {
        System.out.println(solution(new int[][] {}));
    }
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static int solution(int[][] maps) {
        int[][] count = new int[maps.length][maps[0].length];
        for(int i = 0; i < maps.length; i++)
            Arrays.fill(count[i], -1);
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, 0));
        count[0][0] = 1;
        while(!que.isEmpty()) {
            Node n = que.poll();
            if(n.x == maps.length-1 && n.y == maps[0].length-1)
                return count[n.x][n.y];
            for(int d = 0; d < 4; d++) {
                int dx = n.x + dir[d][0];
                int dy = n.y + dir[d][1];
                if(dx >= 0 && dy >= 0 && dx < maps.length && dy < maps[0].length && count[dx][dy] == -1 && maps[dx][dy] == 1) {
                    count[dx][dy] = count[n.x][n.y]+1;
                    que.add(new Node(dx, dy));
                }
            }
        }
        return -1;
    }
}
