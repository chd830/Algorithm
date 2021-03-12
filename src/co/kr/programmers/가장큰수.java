package co.kr.programmers;

import java.util.*;
import java.io.*;

public class 가장큰수 {
    public static void main(String[] args) throws IOException {
        System.out.println(solution(new int[] {6, 10, 2}));
        System.out.println(solution(new int[] {3, 30, 34, 5, 9}));
        System.out.println(solution(new int[] {0, 0, 0, 0}));
    }
    public static String solution(int[] nums) {
        Integer[] arr = new Integer[nums.length];
        for(int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1.toString();
                String s2 = o2.toString();
                return -Integer.compare(Integer.parseInt(s1+s2), Integer.parseInt(s2+s1));
            }
        };
        Arrays.sort(arr, comp);
        if(arr[0] == 0) {
            return "0";
        }
        String str = "";
        for(int i : arr) {
            str += i;
        }
        return str;
    }
}
