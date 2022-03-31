package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/12100
public class Easy2048 {
    static int N;
    static int max;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        //1왼, 2오, 3위, 4아래
        game(0);
        System.out.println(max);
    }
    static void shift(int dir) {
        switch (dir) {
            case 1:
                left();
                break;
            case 2:
                right();
                break;
            case 3:
                up();
                break;
            case 4:
                down();
                break;
        }

    }
    static void game(int cnt) {
        if(cnt == 5) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    max = Math.max(max, arr[i][j]);
                }
            }
            return;
        }
        int[][] copy = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++)
                copy[i][j] = arr[i][j];
        }
        for(int i = 1; i < 5; i++) {
            shift(i);
            game(cnt+1);
            for(int j = 0 ;j < N; j++) {
                for(int k = 0; k < N; k++)
                    arr[j][k] = copy[j][k];
            }
        }
    }
    static void up() {
        for(int i = 0; i < N; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < N; j++) {
                if(arr[j][i] != 0)
                    list.add(arr[j][i]);
                arr[j][i] = 0;
            }
            for(int j = 0, idx = 0; j < list.size(); j++) {
                if(j < list.size()-1 && list.get(j).equals(list.get(j+1)))
                    arr[idx++][i] = list.get(j)+list.get(++j);
                else
                    arr[idx++][i] = list.get(j);
            }
        }
    }
    static void down() {
        for(int i = 0; i < N; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j = N-1; j >= 0; j--) {
                if(arr[j][i] != 0)
                    list.add(arr[j][i]);
                arr[j][i] = 0;
            }
            for(int j = 0, idx = N-1; j < list.size(); j++) {
                if(j < list.size()-1 && list.get(j).equals(list.get(j+1)))
                    arr[idx--][i] = list.get(j)+list.get(++j);
                else
                    arr[idx--][i] = list.get(j);
            }
        }
    }
    static void right() {
        for(int i = 0; i < N; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j = N-1; j >= 0; j--) {
                if(arr[i][j] != 0)
                    list.add(arr[i][j]);
                arr[i][j] = 0;
            }
            for(int j = 0, idx = N-1; j < list.size(); j++) {
                if(j < list.size()-1 && list.get(j).equals(list.get(j+1)))
                    arr[i][idx--] = list.get(j)+list.get(++j);
                else
                    arr[i][idx--] = list.get(j);
            }
        }
    }
    static void left() {
        // 왼쪽
        for(int i = 0; i < N; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < N; j++) {
                if(arr[i][j] != 0)
                    list.add(arr[i][j]);
                arr[i][j] = 0;
            }
            for(int j = 0, idx = 0; j < list.size(); j++) {
                if(j < list.size()-1 && list.get(j).equals(list.get(j+1)))
                    arr[i][idx++] = list.get(j)+list.get(++j);
                else
                    arr[i][idx++] = list.get(j);
            }
        }
    }
}