package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/22251
public class 빌런호석 {
    // 반전시켜야하는 LED의 개수
    static int[][] nums = {
            {0, 4, 3, 3, 4, 3, 2, 3, 1, 2},
            {4, 0, 5, 3, 2, 5, 6, 1, 5, 4},
            {3, 5, 0, 2, 5, 4, 3, 4, 2, 3},
            {3, 3, 2, 0, 3, 2, 3, 2, 2, 1},
            {4, 2, 5, 3, 0, 3, 4, 3, 3, 2},
            {3, 5, 4, 2, 3, 0, 1, 4, 2, 1},
            {2, 6, 3, 3, 4, 1, 0, 5, 1, 2},
            {3, 1, 4, 2, 3, 4, 5, 0, 4, 3},
            {1, 5, 2, 2, 3, 2, 1, 4, 0, 1},
            {2, 4, 3, 1, 2, 1, 2, 3, 1, 0}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());
        P = Integer.parseInt(token.nextToken());
        X = Integer.parseInt(token.nextToken());
        // 1층부터 N층까지 이용가능한 엘리베이터
        // K자리의 수를 볼 수 있음 ex)K == 4 1680 0601
        // P개를 반전시킬 수 있는 경우의 수 중
        // X부터 시작
//        visited = new boolean[1000001];
        count = 0;
        int x = X;
        Arrays.fill(num, -1);
        for(int i = 0; i < K; i++) {
            num[i] = x%10;
            x /= 10;
        }
        for(int i = 1; i <= N; i++) {
            if(i == X)
                continue;
            count += getAnswer(i, P, K);
        }
//        check(P, ""+X);
        System.out.println(count);
    }
    static int N;
    static int K;
    static int P;
    static int X;
    static int count;
//    static boolean[] visited;

    static int[] num = new int[6];
    static int getAnswer(int x, int P, int K) {
        int[] num2 = new int[6];
        Arrays.fill(num2, -1);
        for(int i = 0; i < K; i++) {
            num2[i] = x%10;
            x /= 10;
        }
        for(int i = 0; i < K; i++) {
            P -= nums[num[i]][num2[i]];
        }
        if(P >= 0)
            return 1;
        return 0;
    }
//    static class Nums {
//        String n;
//        int cnt;
//        Nums(String n, int cnt) {
//            this.n = n;
//            this.cnt = cnt;
//        }
//    }
//    static void check(int cnt, String num) {
//        Queue<Nums> que = new LinkedList<>();
//        que.add(new Nums(num, P));
//        visited[Integer.parseInt(num)] = true;
//        while(!que.isEmpty()) {
//            Nums str = que.poll();
//            for(int i = 0; i < K; i++) {
//                String tmp = "";
//                for(int j = 0; j < 10; j++) {
//                    int n = nums[str.n.charAt(i)-'0'][j];
//                    if(str.n.charAt(i)-'0' != j && n <= cnt) {
//                        tmp = str.n.substring(0, i);
//                        tmp += j;
//                        tmp += str.n.substring(i+1, K);
//                        if(!visited[Integer.parseInt(tmp)] && Integer.parseInt(tmp) <= N && str.cnt >= n) {
//                            que.add(new Nums(tmp, str.cnt-n));
//                            visited[Integer.parseInt(tmp)] = true;
//                            count++;
//                        }
//                    }
//                }
//            }
//        }
//    }
}
