package review;

import java.util.*;
import java.io.*;

// 제일 짧은 경우의 수를 구하므로 bfs를 사용한다.
// 한 자리씩 계산하고 방문체크를 하지 않으면 메모리 초과 문제가 생긴다.
public class 소수경로1963 {

    static int N;
    static int M;
    static int[] visited;
    static boolean[] prime = new boolean[10000];
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer token;
        prime[0] = prime[1] = true;
        isPrimeNum();
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            token = new StringTokenizer(br.readLine());
            N = Integer.parseInt(token.nextToken());
            M = Integer.parseInt(token.nextToken());
            visited = new int[10000];
            boolean check = false;
            if(N == M) {
                sb.append(0).append("\n");
                continue;
            }
            Queue<Integer> que = new LinkedList<>();
            que.add(N);
            visited[N] = 1;
            loop:while(!que.isEmpty()) {
                int num = que.poll();
                // 1033일 때 각각 1030, 1003, 1033, 0033의 값을 가지게 된다.
                int one = num - (num % 10);
                int ten = num - ((num % 100) - (num % 10));
                int hun = num - ((num % 1000) - (num % 100));
                int thou = num - (num / 1000 * 1000);
                int[] nums = new int[] {thou, hun, ten, one};
                for(int i = 0; i < nums.length; i++) {
                    int next = 0;
                    for(int j = 0; j < 10; j++) {
                        next = nums[i] + (j * (int) (Math.pow(10, 3-i)));
                        if(next > 1000 && next < prime.length && !prime[next] && visited[next] == 0) {
                            que.add(next);
                            visited[next] = visited[num]+1;

                            if(next == M) {
                                check = true;
                                sb.append(visited[num]).append("\n");
                                break loop;
                            }
                        }
                    }
                }
            }
            if(!check) {
                sb.append("Impossible").append("\n");
            }
        }
        System.out.println(sb);
    }

    static void isPrimeNum() {
        for(int i = 2; i < prime.length; i++) {
            if(prime[i]) {
                continue;
            }
            for(int j = i+i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}
