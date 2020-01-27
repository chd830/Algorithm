package com.swexpertacademy;

import java.util.Scanner;

public class d2_2005 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			int num = sc.nextInt();
			int[][] arr = new int[num][num];
			for(int a = 0; a < num; a++) {
				for(int b = 0; b <= a; b++) {
					if(b == 0) {
						arr[a][b] = 1;
					}
					else {
						arr[a][b] = arr[a-1][b-1] + arr[a-1][b];
					}
				}
			}
			System.out.println("#"+(i+1));
			for(int a = 0; a < num; a++) {
				for(int b = 0; b < num; b++) {
					if(arr[a][b] != 0) {
						System.out.print(arr[a][b]+" ");
					}
				}
				System.out.println();
			}
		}
	}
}
