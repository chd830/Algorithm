package sort;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1181
public class 단어정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] sentence = new String[N];
        for(int i = 0; i < N; i++)
            sentence[i] = br.readLine();
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()) {
                    for(int i = 0; i < Math.min(o1.length(), o2.length()); i++) {
                        if(o1.charAt(i) != o2.charAt(i))
                            return Integer.compare(o1.charAt(i), o2.charAt(i));
                    }
                }
                return Integer.compare(o1.length(), o2.length());
            }
        };
        Arrays.sort(sentence, comp);
        String prev = "";
        for(int i = 0; i < N; i++) {
            if(prev.equals(sentence[i]))
                continue;
            System.out.println(sentence[i]);
            prev = sentence[i];
        }
    }
}
