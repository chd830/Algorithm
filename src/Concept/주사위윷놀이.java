package Concept;

import java.util.Scanner;
public class 주사위윷놀이 {
	static int[][] map = { { 0, 1, 2, 3, 4, 5 }, { 2, 2, 3, 4, 5, 6 }, { 4, 3, 4, 5, 6, 7 }, { 6, 4, 5, 6, 7, 8 },
			{ 8, 5, 6, 7, 8, 9 }, { 10, 21, 22, 23, 24, 25 }, { 12, 7, 8, 9, 10, 11 }, { 14, 8, 9, 10, 11, 12 },
			{ 16, 9, 10, 11, 12, 13 }, { 18, 10, 11, 12, 13, 14 }, { 20, 27, 28, 24, 25, 26 },
			{ 22, 12, 13, 14, 15, 16 }, { 24, 13, 14, 15, 16, 17 }, { 26, 14, 15, 16, 17, 18 },
			{ 28, 15, 16, 17, 18, 19 }, { 30, 29, 30, 31, 24, 25 }, { 32, 17, 18, 19, 20, 0 }, { 34, 18, 19, 20, 0, 0 },
			{ 36, 19, 20, 0, 0, 0 }, { 38, 20, 0, 0, 0, 0 }, { 40, 0, 0, 0, 0, 0 }, { 13, 22, 23, 24, 25, 26 },
			{ 16, 23, 24, 25, 26, 20 }, { 19, 24, 25, 26, 20, 0 }, { 25, 25, 26, 20, 0, 0 }, { 30, 26, 20, 0, 0, 0 },
			{ 35, 20, 0, 0, 0, 0 }, { 22, 28, 24, 25, 26, 20 }, { 24, 24, 25, 26, 20, 0 }, { 28, 30, 31, 24, 25, 26 },
			{ 27, 31, 24, 25, 26, 20 }, { 26, 24, 25, 26, 20, 0 } };
	static int[] pos;
	static int[] dice;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		pos = new int[4];
		dice = new int[10];
		for(int i = 0; i < 10; i++)
			dice[i] = sc.nextInt();
		dfs(0, 0);
		System.out.println(ans);
	}
	static void dfs(int idx, int score) {
		if( idx == 10 ) {
			ans = Math.max(ans, score);
			return;
		}
		out:
		for(int i = 0; i < 4; i++) {
			if( pos[i] == -1 )
				continue;
			int now = pos[i];
			int next = map[now][dice[idx]];
			if( next == 0 ) {
				pos[i] = -1;
				dfs(idx + 1, score);
				pos[i] = now;
			}
			for(int j = 0; j < 4; j++) {
				if( i == j )
					continue;
				if( pos[j] == next )
					continue out;
			}
			pos[i] = next;
			dfs(idx + 1, score + map[0][next]);
			pos[i] = now;
		}
	}
}
