package DFS;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1941
public class 소문난칠공주 {
    static int S;
    static int Y;
    static int cnt = 0;
    static String[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new String[5][5];
        for(int i = 0; i < 5; i++) {
            String str = br.readLine();
            for(int j = 0; j < 5; j++) {
                arr[i][j] = ""+str.charAt(j);
            }
        }
        comb(1, 0);
        /*
        7명으로 구성
        가로나 세로로 반드시 인접해야함
        이다솜파의 학생들로만 구성될 필요는 없음
        이다솜파가 4명 이상으로 구성
         */
        System.out.println(cnt);
    }
    static int[][] nums = { {1, 2, 3, 4, 5},
                            {6, 7, 8, 9, 10},
                            {11, 12, 13, 14, 15},
                            {16, 17, 18, 19, 20},
                            {21, 22, 23, 24, 25}
                            };
    static void connect() {
        visited = new boolean[5][5];
        int x = 0;
        int y = 0;

        int scount = 0;
        int ycount = 0;

        for(int i = 0; i < 7; i++) {
            int num = sub[i];
            x = num / 5;
            x = num%5 == 0 ? x-1 : x;
            y = num % 5 == 0 ? 4 : num % 5 - 1;
            if(arr[x][y].equals("S"))
                scount++;
            else
                ycount++;
            visited[x][y] = true;
        }
        if(near(x, y) && scount >= 4) {
            cnt++;
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
    static boolean near(int x, int y) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x, y));
        visited[x][y] = false;
        int count = 1;
        while(!que.isEmpty()) {
            Node n = que.poll();
            for(int d = 0; d < 4; d++) {
                int dx = n.x + dir[d][0];
                int dy = n.y + dir[d][1];
                if(dx >= 0 && dy >= 0 && dx < 5 && dy < 5 && visited[dx][dy]) {
                    visited[dx][dy] = false;
                    que.add(new Node(dx, dy));
                    count++;
                }
            }
        }
        return count == 7;
    }
    static boolean[] check = new boolean[26];
    static int[] sub = new int[7];
    static void comb(int idx, int subIdx) {
        if(subIdx == 7) {
            connect();
            return;
        }
        for(int i = idx; i < check.length; i++) {
            if(!check[i]) {
                check[i] = true;
                sub[subIdx] = i;
                comb(i+1, subIdx+1);
                check[i] = false;
            }
        }

    }
    // 조합으로 1~25까지 중에서 7개 뽑기
    // 7개가 연속되어잇는지를 체크하기
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
}
