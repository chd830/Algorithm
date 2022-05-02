package Dynamic;

import java.util.*;
import java.io.*;

public class 동물원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] d = new int[N+1][3];
        d[1][0] = d[1][1] = d[1][2] = 1;
        for(int i = 2; i <= N; i++) {
            // 할당하지 않음
            d[i][0] = (d[i-1][0]+d[i-1][1]+d[i-1][2])%9901;
            // 왼쪽할당
            d[i][1] = (d[i-1][0]+d[i-1][2])%9901;
            // 오른쪽 할당
            d[i][2] = (d[i-1][0]+d[i-1][1])%9901;
        }
        System.out.println((d[N][0]+d[N][1]+d[N][2])%9901);
    }
}
