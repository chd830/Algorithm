package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z1074 {
    static int N;
    static int r;
    static int c;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        cnt = 0;
        N = Integer.parseInt(token.nextToken());
        int pow = (int) Math.pow(2, N);
        r = Integer.parseInt(token.nextToken());
        c = Integer.parseInt(token.nextToken());
        recur(0, 0, pow);
    }

    static void recur(int x, int y, int size) {
        if (size == 1) {
            if (x == r && y == c) {
                System.out.println(cnt);
                System.exit(0);
            }
            cnt++;
            return;
        }
        size = size / 2;
        recur(x, y, size);
        recur(x, y + size, size);
        recur(x + size, y, size);
        recur(x + size, y + size, size);
    }
}
