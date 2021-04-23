package review;

import java.util.*;
import java.io.*;

// LCS
public class acmicpc9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int[][] arr = new int[s1.length()+1][s2.length()+1];
        int max = 0;
        for(int i = 1; i < s1.length()+1; i++) {
            for(int j = 1; j < s2.length()+1; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    arr[i][j] = arr[i-1][j-1]+1;
                else
                    arr[i][j] = Math.max(arr[i][j-1], arr[i-1][j]);
                max = Math.max(max, arr[i][j]);
            }
        }
        System.out.println(max);
    }
}
