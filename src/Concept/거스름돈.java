package Concept;

import java.util.Arrays;
import java.util.Scanner;

public class 거스름돈 {
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("거스름돈을 입력해주세요?");
        int money = sc.nextInt();
        int[] change = {1,4,6};
        dp = new int[change.length][money+1];
        for(int i = 0; i <= money;i++) {
            dp[0][i] = i;
        }
        for(int i = 1 ; i < change.length; i++) {
            for(int j = 1 ; j < dp[0].length; j++) {
                if(j <change[i]) {
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.min(dp[i][j - change[i]] + 1 , dp[i-1][j]);
                }
            }
        }
        for(int[] d : dp) {
            System.out.println(Arrays.toString(d));
        }
//      System.out.println(Arrays.deepToString(dp));


        System.out.println("지불해야하는 거스름돈 개수 :" + dp[2][money]);

    }

}