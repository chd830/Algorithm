package DNQ;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1992
public class 쿼드트리 {
    static boolean[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j) == '0' ? false : true;
            }
        }
        quadtree(0, 0, N);
        System.out.println(result);
    }
    static String result = "";
    static boolean check(int x, int y, int size) {
        boolean color = arr[x][y];
        for(int i= x; i < x+size; i++) {
            for(int j = y; j < y+size; j++) {
                if(arr[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
    static void quadtree(int x, int y, int N) {
        System.out.println(result);
        if(check(x, y, N)) {
            result += arr[x][y] ? "1" : "0";
            return;
        }
        int size = N/2;
        result += "(";
        quadtree(x, y, size);
        quadtree(x, y+size, size);
        quadtree(x+size, y, size);
        quadtree(x+size, y+size, size);
            result += ")";
    }
}
