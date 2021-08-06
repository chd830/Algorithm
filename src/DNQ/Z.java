package DNQ;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1074
public class Z {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        r = Integer.parseInt(token.nextToken());
        c = Integer.parseInt(token.nextToken());
        z(0, 0, (int)Math.pow(2, N));
    }
    static int r;
    static int c;
    static int cnt = 0;
    static void z(int x, int y, int N) {
        if(x == r && y == c) {
            System.out.println(cnt);
            System.exit(0);
        }
        if(N == 1) {
            System.out.println("("+x+", "+y+")\t"+cnt);
            cnt++;
            return;
        }
        // 해당하지 않는 사분면은 패스하기
        if(!(x <= r && r < x+N && y <= c && c < y+N)) {
            cnt += N*N;
            return;
        }
        int size = N/2;
        z(x, y, size);
        z(x, y+size, size);
        z(x+size, y, size);
        z(x+size, y+size, size);
    }

}
