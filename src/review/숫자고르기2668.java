package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 숫자고르기2668 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        visited = new boolean[N+1];
        end = new boolean[N+1];
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        max = 0;
        result = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            dfs(i);
        }
        System.out.println(result.size());
        Collections.sort(result);
        for(int i : result) {
            System.out.println(i);
        }
    }
    static boolean[] visited;
    static boolean[] end;
    static List<Integer> result;
    static int[] arr;
    static int max;
    static void dfs(int now) {
        if(visited[now]) {
            return;
        }
        visited[now] = true;
        int next = arr[now];
        if(!visited[next]) {
            dfs(next);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(next);
            List<Integer> num = new ArrayList<>();
            num.add(arr[next]);
            if(!end[next]) {
                for (int i = next; i != now; i = arr[i]) {
                    list.add(arr[i]);
                    num.add(i);
                }
                List<Integer> val = new ArrayList<>();
                for (int n : num) {
                    if (list.contains(n)) {
                        val.add(n);
                    }
                }
                if (list.size() == val.size()) {
                    for (int i : list) {
                        result.add(i);
                    }
                }
            }
        }
        end[now] = true;
    }
}