package co.kr.programmers;

public class 네트워크 {
    public static void main(String[] args) {
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }

    static boolean[] visited;
    static int solution(int n, int[][] computers) {
        visited = new boolean[computers.length];
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                cnt++;
                visited[i] = true;
                dfs(i, computers);
            }
        }
        return cnt;
    }
    static void dfs(int idx, int[][] computers) {
        for(int i = 0; i < computers.length; i++) {
            if(computers[idx][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i, computers);
            }
        }
    }
}
