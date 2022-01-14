package sort;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/20291
public class 파일정리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> map = new TreeMap<>();
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            String extension = str.split("\\.")[1];
            if(map.containsKey(extension))
                map.put(extension, map.get(extension)+1);
            else
                map.put(extension, 1);
        }
        StringBuilder sb = new StringBuilder();
        for(String key : map.keySet())
            sb.append(key).append(" ").append(map.get(key)).append("\n");
        System.out.println(sb.toString());
    }
}