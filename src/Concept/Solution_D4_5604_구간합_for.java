package Concept;

import java.util.Scanner;

public class Solution_D4_5604_구간합_for {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			long A = sc.nextLong();
			long B = sc.nextLong();
			long[] ans = new long[10];
			long point = 1;
			while (A <= B) {
				while (B % 10 != 9 && A <= B) {
					cal(B, ans, point);
					B--;
				}
				//System.out.println("B:       "+B);
				if (B < A) {
					break;
				}
				while (A % 10 != 0 && A <= B) {
					cal(A, ans, point);
					A++;
				}
				//System.out.println("A:       "+A);
				A /= 10;
				B /= 10;
				//System.out.println("B2:       "+B);
				//System.out.println("A2:       "+A);
				for (int i = 0; i < 10; i++) {
					ans[i] += (B - A + 1) * point;
				}
				point *= 10;
			}
			long sum = 0;
			for (int i = 0; i < 10; i++) {
				sum += (ans[i] * i);
			}
			
			System.out.println("#"+tc+" "+sum);
		}
	}

	public static void cal(long x, long[] ans, long point) {
		while (x > 0) {
			String s = String.valueOf(x);
			int xx = s.charAt(s.length()-1)-'0';
			ans[xx] += point;
			x /= 10;
		}
	}
}
