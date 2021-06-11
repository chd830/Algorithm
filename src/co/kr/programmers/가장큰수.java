package co.kr.programmers;

import java.util.*;
import java.io.*;

public class 가장큰수 {
    public static void main(String[] args) throws IOException {
        System.out.println(solution(new int[] {6, 10, 2})); //6210
        System.out.println(solution(new int[] {3, 30, 34, 5, 9})); //9534330
        System.out.println(solution(new int[] {0, 0, 0, 0}));
    }
    public static String solution(int[] nums) {
        List<String> list = new ArrayList<>();
        for(int n : nums)
            list.add(""+n);
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -Integer.compare(Integer.parseInt(o1+o2), Integer.parseInt(o2+o1));
            }
        };
        Collections.sort(list, comp);
        String res = "";
        boolean check = true;
        for(String l : list) {
            if(!check || !l.equals("0")) {
                check = false;
            }
            res += l;
        }
        return check ? "0" : res;
    }
    // 시간초과
//    static int[] sub;
//    static int max;
//    static boolean[] visited;
//    public static String solution(int[] nums) {
//        sub = new int[nums.length];
//        visited = new boolean[nums.length];
//        perm(0, nums);
//        return Integer.toString(max);
//    }
//    static void perm(int idx, int[] nums) {
//        if(idx == sub.length) {
//            String s = "";
//            for(int i = 0; i < sub.length; i++) {
//                s += nums[sub[i]];
//            }
//            max = Math.max(max, Integer.parseInt(s));
//            return;
//        }
//        for(int i = 0; i < sub.length; i++) {
//            if(!visited[i]) {
//                visited[i] = true;
//                sub[idx] = i;
//                perm(idx+1, nums);
//                visited[i] = false;
//            }
//        }
//    }
}
