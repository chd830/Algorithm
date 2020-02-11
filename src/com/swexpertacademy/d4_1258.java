package com.swexpertacademy;

import java.util.*;

//행렬찾기
public class d4_1258 {
    static int N;
    static int r;
    static int c;
    static int[][] arr;
    static boolean[][] visited;
    static int[][] pos = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    //    public static void main(String[] args) {
    public d4_1258() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            N = sc.nextInt();
            arr = new int[N][N];
            visited = new boolean[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            List<int[]> list = new ArrayList();
            for(r = 0; r < N; r++) {
                row: for(c = 0; c < N; c++) {
                    if(!visited[r][c] && arr[r][c] != 0) {
                        list.add(area(r, c));
                    }
                }
            }
            Comparator<int[]> comp = new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0]*o1[1] < o2[0]*o2[1]) {
                        return o1[0]*o1[1] - o2[0]*o2[1];
                    }
                    else if(o1[0]*o1[1] == o2[0]*o2[1]) {
                        return o1[0] - o2[0];
                    }
                    return o1[0]*o1[1] - o2[0]*o2[1];
                }
            };
            Collections.sort(list, comp);
//            for(int i = 0; i < list.size(); i++){
//                System.out.println(list.get(i)[0]+" "+list.get(i)[1]);
//            }
            System.out.print("#"+t+" "+list.size()+" ");
            for(int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i)[0]+" "+list.get(i)[1]+" ");
            }
            System.out.println();
        }
    }

    public static int[] area(int i, int j) {
        int width = 1;
        int height = 1;
        int di = i + 0;
        int dj = j + 1;
        while(boundary(di, dj)) {
            visited[di][dj] = true;
            width++;
            dj += 1;
        }
        di = i + 1;
        c = dj;
        dj = j;
        while(boundary(di, dj)) {
            visited[di][dj] = true;
            while(j < c) {
                visited[di][j] = true;
                j++;
            }
            j = dj;
            height++;
            di += 1;
        }
        visited[i][j] = true;
        return new int[] {height, width};
    }
    public static boolean boundary(int di, int dj) {
        if(di < N && di >= 0 && dj < N && dj >= 0 && !visited[di][dj] && arr[di][dj] != 0) {
            return true;
        }
        return false;
    }
    public static void print() {
        for(int i = 0; i < N; i++ ){
            System.out.println(Arrays.toString(visited[i]));
        }
    }
}
