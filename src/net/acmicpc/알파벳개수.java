package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 알파벳개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        int[] alph = new int[26];
        for(char ch : str.toCharArray()) {
            alph[ch-97]++;
        }
        for(int a : alph) {
            sb.append(a).append(" ");
        }
        System.out.println(sb);
    }
}
