package 구현;

import java.util.*;
import java.io.*;

public class 짝수문자열얻기 {
    /*
    LIS

    cache: 앞서 구한것들을 저장
    {3, 5, 7, 9, 2, 1}
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] strs = new String[N];
        for(int a = 0; a < N; a++) {
            strs[a] = br.readLine();
            int[] d = new int[strs[a].length()];
            char[] c = strs[a].toCharArray();
            d[0] = 0;
            int[] alph = new int[26];
            for (int i = 0; i < strs[a].length(); i++) {
                Arrays.fill(alph, 0);
                for (int j = 0; j <= i; j++) {
                    alph[c[j] - 'a']++;
                    if (alph[c[j] - 'a'] != 0 && alph[c[j] - 'a'] % 2 == 0)
                        d[i]++;
                }
            }
            System.out.println(strs[a].length()-d[strs[a].length()-1]*2);
        }
    }
}
