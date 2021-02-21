package review;

import java.util.*;
import java.io.*;

public class 뿌요뿌요 {
    static int R = 12;
    static int C = 6;
    static int res;
    static boolean check;
    static char[][] map = new char[R][C];
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
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
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        res = 0;

        // 4개 이상을 찾기
        // 맵을 다시 그리기
        // 반복
        check = true;
        while(check) {
            removeList = new ArrayList<>();
            find();
        }
        System.out.println(res);
    }
    static List<Node> removeList;
    static void find() {
        check = false;
        for(int i = R-1; i >= 0; i--) {
            for(int j = C-1; j >= 0; j--) {
                if(map[i][j] != '.') {
                    boolean[][] visited = new boolean[R][C];
                    List<Node> list = new ArrayList<>();
                     Queue<Node> que = new LinkedList<>();
                     que.add(new Node(i, j));
                     visited[i][j] = true;
                     list.add(new Node(i, j));
                     while(!que.isEmpty()) {
                        Node n = que.poll();
                        for(int d = 0; d < 4; d++) {
                            int dx = n.x + dir[d][0];
                            int dy = n.y + dir[d][1];
                            if(dx >= 0 && dy >= 0 && dx < R && dy < C && map[dx][dy] == map[i][j] && !visited[dx][dy]) {
                                visited[dx][dy] = true;
                                que.add(new Node(dx, dy));
                                list.add(new Node(dx, dy));
                            }
                        }
                     }
                     if(list.size()>= 4) {
                         check = true;
                         removeList.addAll(list);
                     }
                }
            }
        }
        if(check) {
            remove(removeList);
            remark();
//            print();
            res++;
        }
    }
    static void print() {
        for(int i = 0; i < R; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println();
    }
    static void remark() {
        // 0 부터 5 까지
        for(int i = 0; i < C; i++) {
            // 11부터 0까지를 보면서
            // .인 위치를 기억했다가 .이 아닌 위치와 교환
            int idx = R-1;
            for(int j = idx; j >= 0; j--) {
                if(map[j][i] == '.') {
                    idx = j;
                    for(int k = j; k >= 0; k--) {
                        if(map[k][i] != '.') {
                            map[j][i] = map[k][i];
                            map[k][i] = '.';
                            break;
                        }
                    }
                }
            }

        }
    }
    static void remove(List<Node> list) {
        for(Node n : list) {
            map[n.x][n.y] = '.';
        }
    }
}