package net.acmicpc;

import java.io.*;
import java.util.*;

public class 오목 {
	static int[][] map;
	static int N = 20;
	static int[] dr = {0, 1, 1, 1};
	static int[] dc = {1, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/Test5.txt"));
		Scanner sc = new Scanner(System.in);
		map = new int[N][N];

		for(int r = 1; r < N; r++) {
			for(int c = 1; c < N; c++) {
				map[r][c] = sc.nextInt();
			}
		}
//		print(map);
		boolean flag = false;
		for(int r = 1; r < N; r++) {
			for(int c = 1; c < N; c++) {
				if(map[r][c] == 1 || map[r][c] == 1) {
					for(int k = 0; k < 4; k++) {
						int nr = r + dr[k];
						int nc = c + dr[k];
						int cnt = 1;
						while(check(nr, nc) && map[nr][nc] == map[r][c]) {
							nr += dr[k];
							nc += dc[k];
							cnt++;
						}
						if(cnt == 5) {
							//왼쪽에서 오른쪽 카운팅이 오목일 떼
							//오른쪽에서 왼쪽 카운팅도 오목인지 확인한다.
							int bCnt = 1;
							nr = (dr[k] * -1);
							nc = (dc[k] * -1);
							while(check(nr, nc) && map[nr][nc] == map[r][c]) {
								nr += dr[k] * -1;
								nc += dc[k] * -1;
								bCnt++;
							}
							if(bCnt > 5) {
								continue;
							}
							flag = true;
							System.out.println(map[r][c]);
							System.out.println(r+" "+c);
						}
					}
				}
			}
		}
		if(!flag) {
			System.out.println(0);
		}
	}
	static boolean check(int nr, int nc) {
		if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
			return true;
		}
		return false;
	}
	static void print(int[][] map) {
		for(int r = 0; r < N; r++) {
			System.out.println(Arrays.toString(map[r]));
		}
	}
}
