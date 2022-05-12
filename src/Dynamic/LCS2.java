package Dynamic;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/9252
public class LCS2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[1001][1001];
        for(int i = 1; i <= len1; i++) {
            for(int j = 1; j <= len2; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        System.out.println(dp[len1][len2]);
        if(dp[len1][len2] != 0) {
            List<Character> list = new ArrayList<>();
            int i = len1;
            int j = len2;
            while(i >= 1 && j >= 1) {
                if(dp[i][j] == dp[i-1][j])
                    i--;
                else if(dp[i][j] == dp[i][j-1])
                    j--;
                else {
                    list.add(s1.charAt(i-1));
                    i--;
                    j--;
                }
            }
            for(i = list.size()-1; i >= 0; i--)
                System.out.print(list.get(i));
        }
    }
}
