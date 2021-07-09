package net.acmicpc.re;

import java.util.*;
import java.io.*;

public class 좋은수열 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sequence(0, "");
    }
    static boolean check(String str) {
        for(int i = 2; i < str.length(); i++) {
            int j = 0;
            while(j+i+i <= str.length()) {
//                System.out.println("("+j+", "+(j+i)+") "+str.substring(j, j+i)+"\t("+(j+i)+", "+(j+i+i)+")"+str.substring(j+i, j+i+i));
                if(str.substring(j, j+i).equals(str.substring(j+i, j+i+i)))
                    return false;
                j++;
            }
        }
        return true;
    }
    static void sequence(int cnt, String str) {
        if(str.length() == 0) {
            sequence(1, "1");
            sequence(1, "2");
            sequence(1, "3");
            return;
        }
        if(!check(str)) {
            return;
        }
        if(cnt == N) {
            if(check(str)) {
                System.out.println(str);
                System.exit(0);
            }
            return;
        }
        switch (str.charAt(str.length()-1)) {
            case '1':
                sequence(cnt+1, str+"2");
                sequence(cnt+1, str+"3");
                break;
            case '2':
                sequence(cnt+1, str+"1");
                sequence(cnt+1, str+"3");
                break;
            case '3':
                sequence(cnt+1, str+"1");
                sequence(cnt+1, str+"2");
                break;
        }
    }
}
