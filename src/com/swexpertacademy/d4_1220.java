package com.swexpertacademy;

import java.util.Scanner;

//ladder2
public class d4_1220 {
    /*
    처음에 시작할 수 있는 위치를 저장하고
    왼쪽으로 갈때는 위치-- 오른쪽으로 갈때는 위치++로 접근해서 풀어보자.
     */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int a = 0; a < 10; a++) {
			int T = sc.nextInt();
			int x = 0;
			int y = 0;
			int[][] ladder = new int[102][102];
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					ladder[i][j] = sc.nextInt();
					if(ladder[i][j] == 2) {
						//2인지점찾기
						x = i;
						y = j;
					}
				}
			}
			//2인지점에서 출발해서 [0][y]인 위치에 도달할 때 까지 반복 
            for(int i = 98; i > 0; i--) { 
                if(y-1 >= 0) {
                    if(ladder[i][y-1] == 1) {  
                        while(true) {
                            if(y >= 0 && ladder[i][y] == 1) { //왼쪽으로 이동
                                y--;
                            }
                            else {
                                x = y+1;
                                break;
                            }
                        }
                        y = x; 
                        continue;
                    }
                }
                if(y+1 <= 99) {
                    if(ladder[i][y+1] == 1) {
                        while(true) {
                            if(y <= 99 && ladder[i][y] == 1) { //오른쪽으로 이동
                                y++;
                            }
                            else {
                                x = y-1;
                                break;
                            }
                        }
                        y = x;
                        continue;
                    }
                }
            } 
            System.out.println("#" + T + " " + y);
        } 
		sc.close();
//			for(int i = 99; i >= 0; i--) {
//				if(ladder[i][y+1] == 1) {
//					while(true) {
//						System.out.println("("+i+", "+y+")");
//						y++;
//						if(ladder[i][y+1] != 1) {
//							break;
//						}
//					}
//				}
//				else if(ladder[i][y-1] == 1) {
//					while(true) {
//						System.out.println("("+i+", "+y+")");
//						y--;
//						if(ladder[i][y-1] != 1) {
//							break;
//						}
//					}
//				}
//			}
//			System.out.println("#"+T+" "+y);
//		}
	}
}
