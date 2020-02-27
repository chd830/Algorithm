package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 로또 {
    static int N;
    static int[] arr;
    static List<List<Integer>> lists;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            N = Integer.parseInt(token.nextToken());
            if (N == 0) {
                System.exit(0);
            }
            arr = new int[N];
            lists = new ArrayList();
            visited = new boolean[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(token.nextToken());
            }
            recur(lists, new ArrayList(), arr);
            System.out.println();
        }
    }
    public static void recur(List<List<Integer>> result, List<Integer> list, int[] nums ) {
        if(list.size() == 6) {
            Collections.sort(list);
//            if(!result.contains(list)) {
//                result.add(new ArrayList<>(list));
                for(int i : list) {
                    System.out.print(i+" ");
                }
                System.out.println();
//            }
        }
        else {
            for(int i = 0; i < nums.length; i++) {
                if(list.contains(nums[i])) {
                    continue;
                }
                list.add(nums[i]);
                recur(result, list, nums);
                list.remove(list.size() - 1);
            }
        }

    }
}
