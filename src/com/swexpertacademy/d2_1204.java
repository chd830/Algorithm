package com.swexpertacademy;

import java.util.*;

public class d2_1204 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			int num = sc.nextInt();
			int[] arr = new int[1000];
			HashMap<Integer, Integer> map = new HashMap();
			for(int j = 0; j < 1000; j++) {
				arr[j] = sc.nextInt();
				if(map.containsKey(arr[j])) {
					map.put(arr[j], map.get(arr[j]) + 1);
				}
				else {
					map.put(arr[j], 1);
				}
			}
			int max = 0;
			int maxNum = 0;
			for(int key : map.keySet()) {
				if(max <= map.get(key)) {
					max = map.get(key);
					if(maxNum < key) {
						maxNum = key;
					}
				}
			}
			System.out.println("#"+num+" "+maxNum);
		}
	}
}
