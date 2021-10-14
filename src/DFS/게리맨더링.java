package DFS;

import java.util.*;

// https://www.acmicpc.net/problem/17471
public class 게리맨더링 {
    static int N;
    static int[] population, area;
    static ArrayList<Integer>[] list;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();

        population = new int[N + 1];
        list = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            population[i] = scan.nextInt();
        }

        for(int i = 1; i <= N; i++) {
            int num = scan.nextInt();
            for(int j = 0; j < num; j++) {
                list[i].add(scan.nextInt());
            }
        }
        System.out.println(Arrays.toString(population));
        area = new int[N+1];
        visited = new boolean[N+1];
        dfs(1);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
    public static void dfs(int k) {
        if(k == N + 1) { //모든 지역 다 뽑았다면
            int area1 = 0;
            int area2 = 0;
            for(int i = 1; i <= N; i++) {
                if(area[i] == 1) area1 += population[i];
                else area2 += population[i];
            }

            visited = new boolean [N + 1];
            int link = 0; // 연결된 지역들의 개수를 셈.
            for(int i = 1; i <= N; i++) {
                if(!visited[i]) {
                    bfs(i, area[i]); //연결된 지역들을 모두 방문표시하는 bfs탐색
                    link++;
                }
            }
            //지역이 2개뤄 나눠졌고, 2지역안에서 서로 연결되어 있다면 최소값 계산
            if(link == 2)
                min = Math.min(min, Math.abs(area1 - area2));

            return;
        }

        area[k] = 1; //k지역 1번 선거구에 할당.
        dfs(k + 1);

        area[k] = 2; //k지역 2번 선거구에 할당.
        dfs(k + 1);
    }

    public static void bfs(int idx, int areaNum) {
        Queue<Integer> q = new LinkedList<>();
        visited[idx] = true;
        q.offer(idx);

        while(!q.isEmpty()) {
            int current = q.poll();

            for(int i = 0; i < list[current].size(); i++) {
                int next = list[current].get(i);
                if(area[next] == areaNum && !visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}
