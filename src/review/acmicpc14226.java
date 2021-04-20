package review;

import java.util.*;
import java.io.*;

// 이모티콘
public class acmicpc14226 {
    static class Emozi {
        int cur;
        int save;
        int cnt;
        Emozi(int cur, int save, int cnt) {
            this.cur = cur;
            this.save = save;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] visited = new boolean[1001][1001];
        Queue<Emozi> que = new LinkedList<>();
        que.add(new Emozi(1, 0, 0));
        visited[1][0] = true;
        while(!que.isEmpty()) {
            Emozi e = que.poll();
            int display = e.cur;
            int clipboard = e.save;
            if(e.cur == N) {
                System.out.println(e.cnt);
                break;
            }
            if(display > 0 && display < visited.length) {
                if (!visited[display][display]) {
                    visited[display][display] = true;
                    que.add(new Emozi(display, display, e.cnt + 1));
                }
                if (clipboard > 0 && display + clipboard < visited.length) {
                    visited[display + clipboard][clipboard] = true;
                    que.add(new Emozi(display + clipboard, clipboard, e.cnt + 1));
                }
                if (!visited[display - 1][clipboard]) {
                    visited[display - 1][clipboard] = true;
                    que.add(new Emozi(display - 1, clipboard, e.cnt + 1));
                }
            }
        }
    }
}
