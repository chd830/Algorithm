package com.swexpertacademy;

        import java.util.Scanner;

public class d3_8741 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 3; i++) {
                String str = sc.next();
                sb.append(str.toUpperCase().charAt(0));
            }
            System.out.println("#"+t+" "+sb.toString());
        }
    }
}
