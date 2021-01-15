package review;

import java.util.*;
import java.io.*;

// N에서 움직여야 하는거리와 입력할 수 있는
// M이 0일 때 값을 입력받으면 런타임에러가 생기게 된다.
public class 리모컨 {
    static boolean[] btn = new boolean[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        if(M != 0) {
            token = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                btn[Integer.parseInt(token.nextToken())] = true;
            }
        }
        int ans = Math.abs(N-100);
        for(int i = 0; i < 1000000; i++) {
            int len = check(i);
            if(len > 0) {
                ans = Math.min(ans, len + Math.abs(i-N));
            }
        }
        System.out.println(ans);
    }

    static int check(int num) {
        if(num == 0) {
            if(btn[num])
                return 0;
            return 1;
        }
        int len = 0;
        while(num > 0) {
            if(btn[num%10])
                return 0;
            len++;
            num /= 10;
        }
        return len;
    }
}
