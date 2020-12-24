package review;

import java.io.*;
import java.util.*;

public class 소수경로 {
    static int num1;
    static int num2;
    static final int INF = 10_000;
    static final int[] NUMS = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    static int[] visited;
    static boolean[] isPrime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        int T = Integer.parseInt(br.readLine());
        check();
        for(int i = 0; i < T; i++) {
            token = new StringTokenizer(br.readLine());
            num1 = Integer.parseInt(token.nextToken());
            num2 = Integer.parseInt(token.nextToken());

            visited = new int[INF];

            int result = 0;

            if(num1 != num2) {
                result = bfs();
            }
            System.out.println(result == -1 ? "Impossible" : result);
        }
    }
    private static void check() {
        isPrime = new boolean[INF];
        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;

        for(int i = 2; i < INF; i++) {
            if(!isPrime[i]) continue;
            for(int j = i+i; j < INF; j += i) {
                isPrime[j] = false;
            }
        }
    }
    private static int bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(num1);

        visited[num1] = 1;

        while (!q.isEmpty()) {
            int current = q.poll();
            int uni = current - (current % 10);
            int ten = current - ((current % 100) - (current % 10));
            int hun = current - ((current % 1000) - (current % 100));
            int tho = current - (current / 1000 * 1000);

            int[] nextSet = {tho, hun, ten, uni};
            for(int i = 0; i < nextSet.length; i++){
                int next = 0;

                for (final int N: NUMS) {
                    next = nextSet[i] + (N * (int) (Math.pow(10, 3 - i)));

                    if (next > 1000 && next < INF && isPrime[next]) {
                        if (visited[next] == 0) {
                            visited[next] = visited[current] + 1;

                            if (next == num2) {
                                return visited[next] - 1;
                            }

                            q.offer(next);
                        }
                    }
                }
            }
        }

        return -1;
    }
}