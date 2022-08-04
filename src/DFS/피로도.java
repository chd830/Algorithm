package DFS;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/87946
public class 피로도 {
    public static void main(String[] args) {
        System.out.println(solution(80, new int[][] {{80, 20}, {50, 40}, {30, 10}}));
    }
    public static int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        arr = new int[dungeons.length];
        perm(0, k, dungeons);
        return max;
    }
    static boolean[] visited;
    static int max;
    static int[] arr;
    static void perm(int idx, int k, int[][] dungeons) {
        if(idx == arr.length) {
//            System.out.println(Arrays.toString(arr)+"\t"+max);
            count(k, dungeons);
            return;
        }
        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[idx] = i;
                perm(idx+1, k, dungeons);
                visited[i] = false;
            }
        }
    }
    static void count(int k, int[][] dungeons) {
        int cnt = 0;
        for(int a : arr) {
            if(k >= dungeons[a][0]) {
                cnt++;
                k -= dungeons[a][1];
            }
        }
        max = Math.max(max, cnt);
    }
}
