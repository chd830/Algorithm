package DNQ;

import java.util.*;
import java.io.*;

public class 색종이만들기 {
    static int N;
    static int blue;
    static int white;
    static int[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        paper(0, 0, N);
    }
    static void paper(int x, int y, int size) {
        if(check(x, y, size)) {
            if(arr[x][y] == 0)
                white++;
            else
                blue++;
            return;
        }
        check(x, y, size/2);
        check(x+size/2, y, size/2);
        check(x, y+size/2, size/2);
        check(x+size/2, y+size/2, size/2);
    }
    static boolean check(int x, int y, int size) {
        int color = arr[x][y];
        for(int i = x; i < N; i += size) {
            for(int j = x; j < N; j +=  size) {
                if(arr[x][y] != color || visited[x][y])
                    return false;
            }
        }
        return true;
    }
}
