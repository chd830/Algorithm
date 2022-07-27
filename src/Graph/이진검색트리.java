package Graph;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/5639
public class 이진검색트리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>();
        while(true) {
            String str = br.readLine();
            if(str == null || str.equals(""))
                break;
            list.add(Integer.parseInt(str));
        }
        orders(0, list.size()-1);
    }
    static List<Integer> list;
    static void orders(int idx, int end) {
        // 범위를 벗어나면 return
        if(idx > end)
            return;
        // 왼쪽보다 오른쪽 노드가 더 크면 더이상 진행할 수 없는 노드
        int mid = idx+1;
        while(mid <= end) {
            if(list.get(idx) < list.get(mid))
                break;
            mid++;
        }
        // 왼쪽의 값을 찾음
        orders(idx+1, mid-1);
        // 오른쪽의 값을 찾음
        orders(mid, end);
        // root
        System.out.println(list.get(idx));
    }
}
/*
50
30
24
5
28
45
98
52
60
 */