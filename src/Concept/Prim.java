package Concept;

import java.util.Arrays;
import java.util.Scanner;

public class Prim {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] map = new int[N][2];
            for(int i = 0; i < 2; i++) {
                for(int j = 0; j < N; j++) {
                    map[j][i] = sc.nextInt();
                }
            }
            double E = sc.nextDouble();
            long[][] dist = new long[N][N];
            boolean[][] visited = new boolean[N][N];
            for(int i = 0; i < N-1; i++) {
                for(int j = i+1; j < N; j++) {
                    dist[i][j] = dist[j][i] = (map[i][0] - map[j][0]) * (map[i][0] - map[j][0]) + (map[i][1] - map[j][1]) * (map[i][1] - map[j][1]);
                }
            }
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    System.out.print(dist[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
//            System.out.println("#"+t+" ");
        }
    }

}
