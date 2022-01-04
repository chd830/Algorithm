package recur;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/3109
public class 빵집 {
    static int[][] dir = {{0, 1}, {-1, 1}, {1, 1}};
    static int R;
    static int C;
    static char[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        R = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());
        visited = new char[R][C];
        for(int i = 0; i < R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                visited[i][j] = str.charAt(j);
            }
        }
        for(int i = 0; i < R; i++)
            if(dfs(i, 0))
                cnt++;
        System.out.println(cnt);
    }
    static int cnt = 0;
    static boolean dfs(int i, int j) {
        visited[i][j] = '-';
        if(j == C-1)
            return true;
        // 대각선 위로
        if(i > 0 && visited[i-1][j+1] == '.')
            if(dfs(i-1, j+1))
                return true;
        // 오른쪽으로
        if(visited[i][j+1] == '.')
            if(dfs(i, j+1))
                return true;
        // 대각선 아래로
        if(i+1 < R && visited[i+1][j+1] == '.')
            if(dfs(i+1, j+1))
                return true;
        return false;
    }
}
