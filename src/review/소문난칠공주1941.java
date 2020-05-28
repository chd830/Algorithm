package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 소문난칠공주1941 {
    static char[][] map = new char[5][5];
    static int[] sub = new int[7];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < 5; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        combination(0, 0);
    }
    public static void combination(int idx, int s_idx) {
        if(s_idx == 7) {
            System.out.println(Arrays.toString(sub));
            return;
        }
        if(idx == 25) {
            return;
        }
        sub[s_idx] = idx;
        combination(idx+1, s_idx+1);
        combination(idx+1, s_idx);
    }
}
