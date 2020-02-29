package net.acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class 암호만들기 {
    static char[] c;
    static char[] sub;
    static char[] alph = {'a', 'e', 'i', 'o', 'u'};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        c = new char[M];
        sub = new char[N];
        for(int i = 0; i < M; i++) {
            c[i] = sc.next().charAt(0);
        }
        Arrays.sort(c);
        permute(0, 0);

    }
    public static boolean check() {
        int vowel = 0;
        int consonant = 0;
        for(int i = 0; i < sub.length; i++) {
            boolean isVowel = false;
            for(int j = 0; j < alph.length; j++) {
                if(sub[i] == alph[j]) {
                    isVowel = true;
                    vowel++;
                    break;
                }
            }
            if(!isVowel) {
                consonant++;
            }
        }
        return (vowel >= 1) && (consonant >= 2);
    }
    public static void permute(int idx, int s_idx) {
        if(s_idx == sub.length) {
            if(check()) {
                for (char i : sub) {
                    System.out.print(i);
                }
                System.out.println();
            }
            return;
        }
        if(idx == c.length) {
            return;
        }
        sub[s_idx] = c[idx];
        permute(idx+1, s_idx+1);
        permute(idx+1, s_idx);
    }
}