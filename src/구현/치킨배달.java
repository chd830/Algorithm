package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/15686
public class 치킨배달 {

    static int N;
    static int M;
    static int[] chic;
    static int[][] arr;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static boolean[] visited;
    static List<Node> home;
    static List<Node> chicken;
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        chic = new int[M];
        arr = new int[N][N];
        home = new ArrayList<>();
        chicken = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
                if(arr[i][j] == 1) {
                    home.add(new Node(i, j));
                }
                else if(arr[i][j] == 2) {
                    chicken.add(new Node(i, j));
                }
            }
        }
        visited = new boolean[chicken.size()];
        if(chicken.size() == M) {
            for(int i = 0; i < chic.length; i++)
                chic[i] = i;
            calc();
        }
        else
            comb(0, 0);
        System.out.println(result);
    }
    static int result = Integer.MAX_VALUE;
    static void calc() {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0; i < home.size(); i++) {
            min = Integer.MAX_VALUE;
            for(int j = 0; j < chic.length; j++) {
                min = Math.min(Math.abs(home.get(i).x-chicken.get(chic[j]).x)+ Math.abs(home.get(i).y-chicken.get(chic[j]).y), min);
            }
            sum += min;
        }
        result = Math.min(result, sum);
    }
    static void comb(int idx, int sub) {
        if(sub == M) {
            calc();
            return;
        }
        for(int i = idx; i < chicken.size(); i++) {
            if(!visited[i]) {
                chic[sub] = i;
                visited[i] = true;
                comb(i+1, sub+1);
                visited[i] = false;
            }
        }
    }
}
