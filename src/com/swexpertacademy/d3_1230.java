package com.swexpertacademy;

import java.util.*;

//암호문3
public class d3_1230 {
    public d3_1230() {
        for(int T = 1; T <= 10; T++) {
			int N = sc.nextInt();
			List<Integer> list = new ArrayList();
			for(int i = 0; i < N; i++) {
				list.add(sc.nextInt());
			}
			N = sc.nextInt();
			for(int i = 0; i < N; i++) {
				String str = sc.next();
				command(str, list);
			}
			System.out.print("\n#"+T+" ");
			for(int i = 0; i < 10; i++) {
				System.out.print(list.get(i)+" ");
			}
		}
    }
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		for(int T = 1; T <= 10; T++) {
			int N = sc.nextInt();
			List<Integer> list = new ArrayList();
			for(int i = 0; i < N; i++) {
				list.add(sc.nextInt());
			}
			N = sc.nextInt();
			for(int i = 0; i < N; i++) {
				String str = sc.next();
				command(str, list);
			}
			System.out.print("#"+T+" ");
            for(int i = 0; i < 10; i++) {
                System.out.print(list.get(i)+" ");
            }
		}
	}
	static void command(String command, List<Integer> list) {
		int x = 0;
		int y = 0;
		switch(command) {
		case "I":
			x = sc.nextInt();
			y = sc.nextInt();
			for(int i = 0; i < y; i++) {
				list.add(x+i, sc.nextInt());
			}
			return;
		case "D":
			x = sc.nextInt();
			y = sc.nextInt();
			for(int i = 0; i < y; i++) {
				list.remove(x);
			}
            return;
		case"A":
			y = sc.nextInt();
			for(int i = 0; i < y; i++) {
				list.add(sc.nextInt());
			}
			return;
		}
	}
}
