package review;

import java.util.*;
import java.io.*;

// 에너지 모으기
public class acmicpc16198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            list.add(Integer.parseInt(token.nextToken()));
        }
        dfs(0);
        System.out.println(max);
    }
    static int N;
    static int max;
    static List<Integer> list;
    static void dfs(int sum) {
        if(list.size() <= 2) {
            max = Math.max(max, sum);
            return;
        }
        for(int i = 1; i < list.size()-1; i++) {
            int n = list.get(i);
            int num = list.get(i-1) * list.get(i+1);
            list.remove(i);
            dfs(sum+num);
            list.add(i, n);
        }
    }
}
