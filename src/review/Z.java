package review;

import java.util.*;
import java.io.*;

public class Z {
    static int N;
    static int r;
    static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        r = Integer.parseInt(token.nextToken());
        c = Integer.parseInt(token.nextToken());
        cnt = 0;
        recur(0, 0, (int)Math.pow(2, N));
    }
    static int cnt;
    static void recur(int x, int y, int len) {
//        System.out.println(x+"\t"+y+"\t"+cnt);
        if(x == r && y == c) {
            System.out.println(cnt);
            System.exit(0);
        }
        if(len == 1) {
            cnt++;
            return;
        }
        // 현재 재귀호출하는 영역에서 정답이 없을 경우 재귀호출을 더이상 시도하지 않고
        // 재귀호출하는 영역에서 나오는 값을 계산하여 더한 후 다음 영역을 계산한다.
        if(!(x <= r && r < x+len && y <= c  && c < y+len)) {
            cnt += len*len;
            return;
        }
        recur(x, y, len/2);
        recur(x, y+len/2, len/2);
        recur(x+len/2, y, len/2);
        recur(x+len/2, y+len/2, len/2);
    }
}
