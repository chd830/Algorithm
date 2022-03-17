package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2628
public class 종이자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        List<Integer> horizontal = new ArrayList<>();
        List<Integer> vertical = new ArrayList<>();
        horizontal.add(0);
        horizontal.add(M);
        vertical.add(0);
        vertical.add(N);
        int line = Integer.parseInt(br.readLine());
        for(int i = 0; i < line; i++) {
            token = new StringTokenizer(br.readLine());
            if(Integer.parseInt(token.nextToken()) == 0)
                horizontal.add(Integer.parseInt(token.nextToken()));
            else
                vertical.add(Integer.parseInt(token.nextToken()));
        }
        Collections.sort(horizontal);
        Collections.sort(vertical);
        int max = 0;
        for(int i = 0; i < horizontal.size()-1; i++) {
            int r = horizontal.get(i+1)-horizontal.get(i);
            for(int j = 0; j < vertical.size()-1; j++) {
                int c = vertical.get(j+1)-vertical.get(j);
                max = Math.max(max, r*c);
            }
        }
        System.out.println(max);
    }
}
