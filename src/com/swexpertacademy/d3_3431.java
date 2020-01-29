package com.swexpertacademy;

import java.util.Scanner;

//준환이의 운동관리
public class d3_3431 {
    public d3_3431() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++) {
            int L = sc.nextInt();
            int U = sc.nextInt();
            int X = sc.nextInt();
            if(X < L) {
                System.out.println("#"+(i+1)+" "+(L-X));
            }
            else if(U < X) {
                System.out.println("#"+(i+1)+" -1");
            }
            else {
                System.out.println("#"+(i+1)+" 0");
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++) {
            int L = sc.nextInt();
            int U = sc.nextInt();
            int X = sc.nextInt();
            if(X < L) {
                System.out.println("#"+(i+1)+" "+(L-X));
            }
            else if(U < X) {
                System.out.println("#"+(i+1)+" -1");
            }
            else {
                System.out.println("#"+(i+1)+" 0");
            }
        }


    }
}
