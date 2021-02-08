package review;

import java.util.*;
import java.io.*;

public class 퇴사14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 상담을 완료하는데 걸리는 시간
        // 각각 상담했을 때 받을 수 있는 금액
        // 최대 수익 구하기
        int N = Integer.parseInt(br.readLine());
        StringTokenizer token = null;
        int[] price = new int[N];
        int[] time = new int[N];
        int[] res = new int[N+1];
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(token.nextToken());
            price[i] = Integer.parseInt(token.nextToken());
        }
        int max = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j < i; j++) {
                // i이후로 일을 안하면서 j까지 왔을 때
                res[i] = Math.max(res[i], res[j]);

                // 일한만큼 보상받기
                if(j + time[j] == i) {
                    res[i] = Math.max(res[i], res[j]+price[j]);
                }
            }
            max = Math.max(max, res[i]);
        }
        System.out.println();
    }
}
