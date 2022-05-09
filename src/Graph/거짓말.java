package Graph;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1043
public class 거짓말 {
    static int N;
    static int P;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int P = Integer.parseInt(token.nextToken());
        parents = new int[N+1];
        for(int i = 0; i <= N; i++)
            parents[i] = i;
        boolean[] check = new boolean[N+1];
        token = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(token.nextToken());
        for(int i = 0; i < size; i++)
            check[Integer.parseInt(token.nextToken())] = true;

        List<Integer>[] parties = new ArrayList[P];
        for(int i = 0; i < P; i++)
            parties[i] = new ArrayList<>();
        int value = 0;
        int prev = 0;
        for(int i = 0; i < P; i++) {
            token = new StringTokenizer(br.readLine());
            size = Integer.parseInt(token.nextToken());
            if(size > 0) {
                prev = Integer.parseInt(token.nextToken());
                parties[i].add(prev);
            }
            for(int j = 1; j < size; j++) {
                value = Integer.parseInt(token.nextToken());
                parties[i].add(value);
                // parties는 같은 부모를 가지고 있음
                union(prev, value);
                prev = value;
            }
        }

        // find를 통해서 부모 역시 true로 변경
        for(int i = 1; i <= N; i++) {
            if(check[i])
                check[find(i)] = true;
        }
        // parties에서 첫번째 값의 부모(parties는 같은 부모를 가지고 있음)가 check가 아닌지 확인
        int cnt = 0;
        for(int i = 0; i < P; i++) {
            if(parties[i].size() > 0) {
                if(!check[find(parties[i].get(0))])
                    cnt++;
            }
        }
        System.out.println(cnt);
    }
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a >= b)
            parents[a] = b;
        else
            parents[b] = a;
    }
    static int find(int n) {
        if(parents[n] == n)
            return parents[n];
        return find(parents[n]);
    }
}
