package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2578
public class 빙고 {
    static final int SIZE = 5;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[SIZE][SIZE];
        StringTokenizer token = null;
        for(int i = 0; i < SIZE; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < SIZE; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        // 수를 다섯개씩 부름
        // 빙고 세개가 완성되는 거 찾기
        for(int i = 0; i < SIZE; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < SIZE; j++) {
                mark(Integer.parseInt(token.nextToken()));

//                System.out.println(bingo());
//                for (int k = 0; k < SIZE; k++)
//                    System.out.println(Arrays.toString(arr[k]));
                if(bingo() >= 3) {
                    System.out.println(i*SIZE+j+1);
                    System.exit(0);
                }
            }
        }
    }
    static void mark(int n) {
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                if(arr[i][j] == n) {
                    arr[i][j] = 0;
                    return;
                }
            }
        }
    }
    static int bingo() {
        int cnt = 0;
        boolean flag = false;
        // 가로체크 (i, j)에서 j가 0일 때부터 SIZE-1까지 확인하기
        for(int i = 0; i < SIZE; i++) {
            if(arr[i][0] == 0) {
                flag = true;
                for(int j = 0; j < SIZE; j++) {
                    if(arr[i][j] != 0) {
                        flag = false;
                        break;
                    }
                }
                if(flag)
                    cnt++;
            }
        }
        // 세로체크 (i, j)에서 i가 0일 때부터 SIZE-1까지 확인하기
        for(int i = 0; i < SIZE; i++) {
            if(arr[0][i] == 0) {
                flag = true;
                for(int j = 0; j < SIZE; j++) {
                    if(arr[j][i] != 0)
                        flag = false;
                }
                if(flag)
                    cnt++;
            }
        }
        // 오른쪽에서 내려오는 대각선
        flag = true;
        for(int i = 0; i < SIZE; i++) {
            if(arr[i][SIZE-1-i] != 0)
                flag = false;
        }
        if(flag)
            cnt++;
        // 왼쪽에서 내려오는 대각선
        flag = true;
        for(int i = 0; i < SIZE; i++) {
            if(arr[i][i] != 0)
                flag = false;
        }
        if(flag)
            cnt++;
        return cnt;
    }
}