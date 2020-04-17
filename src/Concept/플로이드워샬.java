package Concept;

import java.util.Arrays;

public class 플로이드워샬 {
	public static void main(String[] args) {
		final int M = Integer.MAX_VALUE;
		int[][] D = {{0, M, 2, 3},
					 {4, 0, 1, 8},
					 {2, 5, 0, M},
					 {M, 9, 6, 0}};
		
		for (int k = 0; k < D.length; k++) { // 경유 정점
			for (int i = 0; i < D.length; i++) { // 출발 정점
				if (k == i) continue;
				for (int j = 0; j < D.length; j++) { // 도착정점
					if (k == j || i == j) continue;
					
					if (D[i][k] != M && D[k][j] != M &&
							D[i][j] > D[i][k] + D[k][j]) {
						D[i][j] = D[i][k] + D[k][j];
					}
				}
			}
		}
		
		for (int i = 0; i < D.length; i++) {
			System.out.println(Arrays.toString(D[i]));
		}
	} // end of main
} // end of class
















