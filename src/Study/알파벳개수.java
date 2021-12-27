package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 알파벳개수 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();

        int[] alph = new int[26];
        for(char c : S.toCharArray())
            alph[(int)c-97]++;
        for(int i = 0; i < alph.length; i++)
            System.out.print(alph[i]+" ");
    }
}
