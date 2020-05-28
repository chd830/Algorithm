package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 불켜기11967 {
    static boolean[][] map;
    static class Light implements Comparable<Light> {
        int startX;
        int startY;
        int endX;
        int endY;
        Light(int startX, int startY, int endX, int endY) {
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
        }

        @Override
        public int compareTo(Light o) {
            if(this.startX == o.startX) {
                return Integer.compare(this.startY, o.startY);
            }
            return Integer.compare(this.startX, o.startX);
        }

        @Override
        public String toString() {
            return "Light{" +
                    "startX=" + startX +
                    ", startY=" + startY +
                    ", endX=" + endX +
                    ", endY=" + endY +
                    '}';
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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        map = new boolean[N][N];
        map[0][0] = true;
        PriorityQueue<Light> list = new PriorityQueue<>();
        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            list.add(new Light(Integer.parseInt(token.nextToken())-1, Integer.parseInt(token.nextToken())-1, Integer.parseInt(token.nextToken())-1, Integer.parseInt(token.nextToken())-1));
        }
        int cnt = 0;
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, 0));
        while(!que.isEmpty()) {
            Node n = que.poll();
            for(int i = 0; i < list.size(); i++) {
                Light light = list.poll();
                System.out.println(light);
                if(!map[light.startX][light.startY] && light.startX == n.x && light.startY == n.y) {
                    System.out.println(light+"\t\t"+n);
                    map[light.endX][light.endY] = true;
                    que.add(new Node(light.endX, light.endY));
                    cnt++;
                }
                else {
                    list.add(light);
                }
            }
        }
        System.out.println(cnt);
    }
}
