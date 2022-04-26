package String;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1764
public class 듣보잡 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < N; i++)
            set.add(br.readLine());
        String[] find = new String[M];
        for(int i = 0; i < M; i++)
            find[i] = br.readLine();
        Arrays.sort(find);
        List<String> list = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            if(set.contains(find[i]))
                list.add(find[i]);
        }
        System.out.println(list.size());
        for(String s : list)
            System.out.println(s);
    }
}
