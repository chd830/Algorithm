package review;

import java.io.*;
import java.util.StringTokenizer;

public class 퇴사  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer token = null;
        //걸리는 기간
        int[] t = new int[N+1];
        //금액
        int[] p = new int[N+1];
        //n까지의 이익
        int[] dp = new int[N+1];
        for(int i = 1; i <= N; i++) {
            token = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(token.nextToken());
            p[i] = Integer.parseInt(token.nextToken());
            dp[i] = p[i];
        }

        //첫째날은 생략
        for(int i = 2; i <= N; i++) {
            for(int j = 1; j < i; j++) {
                //남은 일동안 일을 수행할 수 있어야 한다.
                if(i - j >= t[j]) {
                    //남은 일동안 할 수 있는 값 중에서 가장 큰 값
                    dp[i] = Math.max(p[i]+dp[j], dp[i]);
                }
            }
        }

        int max = 0;
        for(int i = 1; i <= N; i++) {
            //남은 일수가 정해진 날보다 적을 때
            if(i + t[i] <= N+1) {
                //최고값이 dp에 있는 값 보다 적으면 바꾼다.
                if(max < dp[i]) {
                    max = dp[i];
                }
            }
        }
        System.out.println(max);
    }
}
