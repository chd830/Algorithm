package review;

import java.util.*;
import java.io.*;

public class 트리 {
    static List<Integer>[] list = new ArrayList[51];
    static int root;
    static int N;
    static int node;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i <list.length; i++) {
            list[i] = new ArrayList<>();
        }
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int n = Integer.parseInt(token.nextToken());
            if(n == -1) {
                root = i;
            }
            else {
                list[n].add(i);
            }
        }
        node = Integer.parseInt(br.readLine());
        for(int i = 0 ;i < N; i++) {
            for(int j = 0; j < list[i].size(); j++) {
                if(list[i].get(j) == node) {
                    list[i].remove(j);
                }
            }
        }
//        for(int i = 0 ;i < N; i++) {
//            System.out.print(i+": \t");
//            for(int j = 0; j < list[i].size(); j++) {
//                System.out.print(list[i].get(j)+" ");
//                if(list[i].get(j) == node) {
//                    list[i].remove(j);
//                }
//            }
//            System.out.println();
//        }
        if(node != root) {
            check(root);
            System.out.println(cnt);
        }
        else {
            System.out.println(0);
        }
    }
    static int cnt;
    static void check(int idx) {
        if(list[idx].size() == 0) {
            cnt++;
            return;
        }
        for(int i =0 ; i < list[idx].size(); i++) {
            int next = list[idx].get(i);
            // 리프노드가 삭제된 경우
            if(list[idx].size() == 1 && next == node) {
                cnt++;
                return;
            }
            if(next < N && next != node) {
                check(next);
            }
        }
    }
}