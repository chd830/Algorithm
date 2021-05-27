package co.kr.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 카카오프렌즈컬러링북 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(6, 4, new int[][] {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}})));
    }
    // 그림에 있는 영역의 수와 가장 큰 영역
    public static int[] solution(int m, int n, int[][] picture) {
        boolean[][] visited = new boolean[picture.length][picture[0].length];
        int size = 0;
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        for(int i = 0; i < picture.length; i++) {
            for(int j = 0; j < picture[0].length; j++) {
                if(picture[i][j] != 0 && !visited[i][j]) {
                    numberOfArea++;
                    Queue<Node> que = new LinkedList<>();
                    que.add(new Node(i, j));
                    visited[i][j] = true;
                    size = 1;
                    while(!que.isEmpty()) {
                        Node node = que.poll();
                        for(int d = 0; d < 4; d++) {
                            int dx = node.x + dir[d][0];
                            int dy = node.y + dir[d][1];
                            if(dx >= 0 && dy >= 0 && dx < picture.length && dy < picture[0].length && !visited[dx][dy] && picture[dx][dy] == picture[i][j]) {
                                visited[dx][dy] = true;
                                que.add(new Node(dx, dy));
                                size++;
                            }
                        }
                    }
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
                }
            }
        }

        return new int[] {numberOfArea, maxSizeOfOneArea};
    }
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static class Node{
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
