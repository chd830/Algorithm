package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 찾기 {
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String pattern = br.readLine();
        List<Integer> list = KMP(pattern, str);
        System.out.println(list.size());
        for(long l : list) {
            System.out.print(l+" ");
        }
    }
    static int[] getPi(String pattern) {
        int[] pi = new int[pattern.length()];
        int j = 0;
        for(int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                pi[i] = ++j;
            }
        }
        return pi;
    }
    static List<Integer> KMP(String pattern, String origin) {
        List<Integer> list = new ArrayList<>();
        int[] pi = getPi(pattern);
        int j = 0;
        for(int i = 0; i < origin.length(); i++) {
            while(j > 0 && origin.charAt(i) != pattern.charAt(j)) {
                j = pi[j-1];
            }
            if(origin.charAt(i) == pattern.charAt(j)) {
                if(j == pattern.length()-1) {
                    list.add(i-pattern.length()+2);
                    j = pi[j];
                }
                else {
                    j++;
                }
            }
        }
        return list;
    }
}
