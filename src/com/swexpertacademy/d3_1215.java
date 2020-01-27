package com.swexpertacademy;

import java.util.Scanner;

public class d3_1215 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int T = 0; T < 10; T++) {
			int size = sc.nextInt();
			char[][] arr = new char[8][8];
			for(int i = 0; i < 8; i++) {
				String str = sc.next();
				for(int j = 0; j < 8; j++) {
					arr[i][j] = str.charAt(j);
				}
			}
			int sum = 0;
			for(int i = 0; i < 8; i++) {
				String hor = "";
				for(int j = 0; j < 8 ; j++) {
					hor += arr[i][j];
				}
//				System.out.println(hor);
				sum += check(hor, size);
//				System.out.println("horizen: "+sum);
			}
			for(int i = 0; i < 8; i++) {
				String ver = "";
				for(int j = 0; j < 8; j++) {
					ver += arr[j][i];
				}
//				System.out.println(ver);
				sum += check(ver, size);
//				System.out.println("ver + hor: "+sum);
			}
//			System.out.println("sum: "+sum);
			System.out.println("#"+(T+1)+" "+sum);
		}
		sc.close();
	}
	static int check(String str, int size) {
		int count = 0;
		for(int i = 0; i <= str.length() - size; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(str.substring(i, size+i));
			if(sb.toString().equals(sb.reverse().toString())) {
				count++;
			}
//			System.out.println("substring: "+sb+" reverse: "+sb.reverse());
		}
		return count;
	}
}
