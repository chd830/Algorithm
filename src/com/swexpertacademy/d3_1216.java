package com.swexpertacademy;

import java.util.Scanner;

//회문2
public class d3_1216{
    static int SIZE = 100;
    public d3_1216() {
        Scanner sc = new Scanner(System.in);
        for (int T = 0; T < 10; T++) {
            int t = sc.nextInt();
            char[][] arr = new char[SIZE][SIZE];
            for (int i = 0; i < SIZE; i++) {
                String str = sc.next();
                for (int j = 0; j < SIZE; j++) {
                    arr[i][j] = str.charAt(j);
                }
            }
            int max = 0;
            for (int i = 0; i < SIZE; i++) {
                String hor = "";
                for (int j = 0; j < SIZE; j++) {
                    hor += arr[i][j];
                }
//				System.out.println(hor);
                max = Math.max(max, check(hor));
//				System.out.println("horizen: "+max);
            }
            for (int i = 0; i < SIZE; i++) {
                String ver = "";
                for (int j = 0; j < SIZE; j++) {
                    ver += arr[j][i];
                }
//				System.out.println(ver);
                max = Math.max(max, check(ver));
//				System.out.println("verticle: "+max);
            }
//			System.out.println("sum: "+sum);
            System.out.println("#" + (T + 1) + " " + max);
        }
        sc.close();
    }

    static int check(String str) {
        int max = 0;
        for (int i = 0; i <= str.length() - 1; i++) {
            int count = 0;
            for(int j = i+1; j <= str.length(); j++) {
                StringBuilder sb = new StringBuilder();
                sb.append(str.substring(i, j));
                if (sb.toString().equals(sb.reverse().toString())) {
//                    System.out.println("substring: "+sb+" reverse: "+sb.reverse());
                    count = sb.length();
                }
            }
            max = Math.max(count, max);
        }
        return max;
    }
}
