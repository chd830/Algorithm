package net.acmicpc;

import java.util.*;

public class 단지번호붙이기 {
    static int[][] map;
    static int cnt;
    static int size;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        map = new int[num][num];
        String str = "";
        for(int i = 0; i < num; i++) {
            str = sc.next();
            for(int j = 0; j < str.length(); j++) {
                map[i][j] = str.charAt(j)-48;
            }
        }
        List<Integer> list = new ArrayList();
        for(int i = 0; i < num; i++) {
            for(int j = 0; j < num; j++) {
                if(map[i][j] == 1) {
                    bfs(i, j);
                    list.add(size);
                    size = 0;
                }
            }
        }
        System.out.println(cnt);
        Collections.sort(list);
        for(int l : list) {
            System.out.println(l);
        }
    }
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void bfs(int x, int y) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x, y));
        map[x][y] = 0;
        cnt++;
        size++;
        while(!que.isEmpty()) {
            Node n = que.poll();
            for(int i = 0; i < 4; i++) {
                int dx = n.x + pos[i][0];
                int dy = n.y + pos[i][1];
                while(dx < map.length && dx >= 0 && dy < map.length && dy >= 0 && map[dx][dy] == 1) {
                    size++;
                    que.add(new Node(dx, dy));
                    map[dx][dy] = 0;
                }
            }
        }
    }
}
