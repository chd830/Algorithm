package BFS;

import java.util.*;

public class 거리두기확인하기 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[][] {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}})));
    }
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
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        Arrays.fill(answer, 1);
        loop: for(int idx = 0; idx < places.length; idx++) {
            String[] place = places[idx];
            Character[][] arr = new Character[5][5];
            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 5; j++) {
                    arr[i][j] = place[i].charAt(j);
                }
            }
            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 5; j++) {
                    if(arr[i][j] == 'P') {
                        boolean[][] visited = new boolean[5][5];
                        Queue<Node> que = new LinkedList<>();
                        que.add(new Node(i, j, 0));
                        visited[i][j] = true;
                        while(!que.isEmpty()) {
                            Node n = que.poll();
                            for(int d = 0; d < 4; d++) {
                                int dx = n.x + dir[d][0];
                                int dy = n.y + dir[d][1];
                                if(dx >= 0 && dy >= 0 && dx < 5 && dy < 5 && !visited[dx][dy] && n.cnt < 2) {
                                    visited[dx][dy] = true;
                                    if(arr[dx][dy] == 'P') {
                                        answer[idx] = 0;
                                        continue loop;
                                    }
                                    else if(arr[dx][dy] == 'O')
                                        que.add(new Node(dx, dy, n.cnt+1));
                                }
                            }
                        }
                    }
                }
            }

        }
        return answer;
    }
}
