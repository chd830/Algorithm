package BFS;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/14226
public class 이모티콘 {
    static class Emozi {
        int cur;
        int save;
        int time;
        Emozi(int cur, int save, int time) {
            this.cur = cur;
            this.save = save;
            this.time = time;
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
                System.out.println(e.time);
                break;
            }
            if(display > 0 && display < visited.length) {
                // copy
                if(!visited[display][display]) {
                    visited[display][display] = true;
                    que.add(new Emozi(display, display, e.time+1));
                }
                // delete
                if(!visited[display-1][clipboard]) {
                    visited[display-1][clipboard] = true;
                    que.add(new Emozi(display-1, clipboard, e.time+1));
                }
                // paste
                if(clipboard > 0 && display+clipboard < visited.length) {
                    visited[display+clipboard][clipboard] = true;
                    que.add(new Emozi(display+clipboard, clipboard, e.time+1));
                }
            }
        }
    }
}
