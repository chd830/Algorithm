package review;

import java.util.*;
import java.io.*;

public class LCS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int[][] strs = new int[s1.length()+1][s2.length()+1];

        for(int i = 0; i < strs.length; i++) {
            for(int j = 0; j < strs[0].length; j++) {
                if(i == 0 || j == 0) {
                    strs[i][j] = 0;
                    continue;
                }
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    strs[i][j] = strs[i-1][j-1]+1;
                }
                else {
                    strs[i][j] = Math.max(strs[i-1][j], strs[i][j-1]);
                }
            }
        }
        System.out.println(strs[s1.length()][s2.length()]);
    }

}
