package review;

import java.util.*;
import java.io.*;

public class LCS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int[][] strs = new int[s1.length()][s2.length()];
        for(int i = 0; i < s1.length(); i++) {
            int len = 0;
            for(int j = 0; j < s2.length(); j++) {
                if(s1.charAt(i) == s2.charAt(j)) {
                }
            }
        }
        for(int i = 0; i < strs.length; i++) {
            System.out.println(Arrays.toString(strs[i]));
        }
    }

}
