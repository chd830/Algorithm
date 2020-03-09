package com.swexpertacademy;

import java.util.Scanner;

//최대상금
public class d3_1244 {
    static int n;
    static int max;
    static String maxVal;
    static  int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            String s = sc.next();
            n = sc.nextInt();
            arr = new int[s.length()];
            max = 0;
            int num = Integer.parseInt(s);
            int idx = arr.length;
            for(int i = 0; i < s.length(); i++) {
                arr[i] = s.charAt(i)-'0';
            }
            int[] copy = arr.clone();
            maxVal="";
            for(int i = copy.length-1; i >= 0; i--) {
                maxVal += copy[i];
            }
            perm(0, 0);
            System.out.println("#"+t+" "+max);
        }
    }
    public static void perm(int r, int k) {
        if(r == n) {
            String result = "";
            for(int i = 0; i < arr.length; i++) {
                result += arr[i];
            }
            if(max < Integer.parseInt(result)) {
                max = Integer.parseInt(result);
            }
            return;
        }
        for(int i = k; i < arr.length; i++) {
            for(int j = i+1; j < arr.length; j++) {
                if(arr[i] <= arr[j]) {
                    swap(i, j);
                    perm(r+1, i);
                    swap(i, j);
                }
            }
        }
    }
    static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
