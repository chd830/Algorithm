package review;

import java.util.*;
import java.io.*;

// 숫자판 점프
public class acmicpc2210 {
    static int[][] arr = new int[5][5];
    static HashMap<String, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        for(int i = 0; i < 5; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                next(i, j, new ArrayList<>());
            }
        }
        System.out.println(map.size());
    }
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static void next(int x, int y, List<Integer> list) {
        if(list.size() == 6) {
            String s = "";
            for(int i : list) {
                s += i;
            }
            map.put(s, 1);
            return;
        }
        for(int d = 0; d < 4; d++) {
            int dx = x + dir[d][0];
            int dy = y + dir[d][1];
            if(dx >= 0 && dy >= 0 && dx < 5 && dy < 5) {
                list.add(arr[dx][dy]);
                next(dx, dy, list);
                list.remove(list.size()-1);
            }
        }
    }

}
