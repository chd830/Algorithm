package review;

import java.util.*;
import java.io.*;

// 단어 수학
public class acmicpc1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] strs = new String[N];
        int[] alph = new int[26];
        int cnt = 10;
        for(int i = 0 ; i < N; i++) {
            strs[i] = br.readLine();
            for(int j = 0; j < strs[i].length(); j++) {
                int pos = strs[i].charAt(j)-65;
                if(alph[pos] == 0)
                    cnt--;
                alph[pos] += Math.pow(10, strs[i].length()-1-j);
            }
        }
        int[] res = new int[26];
        for(int i = 0; i < alph.length; i++) {
            for(int j = 0; j < alph.length; j++) {
                if(alph[i] == 0 || alph[j] == 0)
                    continue;
                if(alph[i] <= alph[j])
                    res[i]++;
            }
        }
//        System.out.println(Arrays.toString(alph));
//        System.out.println(Arrays.toString(res));
        int[] nums = new int[26];
        int num = 9;
        for(int i = 0; i < res.length; i++) {
            int min = Integer.MAX_VALUE;
            int minIdx = -1;
            for(int j = 0; j < res.length; j++) {
                if(res[j] == 0) {
                    continue;
                }
                if(min > res[j]) {
                    min = res[j];
                    minIdx = j;
                }
            }
            if(minIdx == -1)
                break;
            res[minIdx] = 0;
            nums[minIdx] = num--;
        }
        int result = 0;
        for(int i = 0; i < strs.length; i++) {
            String n = "";
            for(int j = 0; j < strs[i].length(); j++) {
                n += nums[strs[i].charAt(j)-65];
            }
            result += Integer.parseInt(n);
        }
        System.out.println(result);
//        System.out.println(Arrays.toString(nums));
    }
}