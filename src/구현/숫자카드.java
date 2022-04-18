package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/10815
public class 숫자카드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            set.add(Integer.parseInt(token.nextToken()));
        int M = Integer.parseInt(br.readLine());
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            if(set.contains(Integer.parseInt(token.nextToken())))
                sb.append("1 ");
            else
                sb.append("0 ");
        }
        System.out.println(sb.toString());
    }
}
