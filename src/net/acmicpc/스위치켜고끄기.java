package net.acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class 스위치켜고끄기 {
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        arr = new int[num+1];
        for(int i = 1; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        num = sc.nextInt();
//        System.out.println(Arrays.toString(arr));
        for(int i = 0; i < num; i++) {
            int gender = sc.nextInt();
            int pos = sc.nextInt();
            if(gender == 1) {
                men(pos);
            }
            else {
                women(pos);
            }
//            System.out.println(Arrays.toString(arr));
        }
        for(int i = 0; i < arr.length; i++) {
            if(i == 0) {
                continue;
            }
            if(i%20 == 0) {
                System.out.println();
            }
            System.out.print(arr[i]+" ");
        }
    }

    public static void women(int num) {
        int front = num-1;
        int back = num+1;
        while(front > 1 && back < arr.length) {
            if(arr[front] == arr[back]) {
                front--;
                back++;
            }
            else {
                break;
            }
        }
        for(int i = front; i <= back; i++) {
            swap(i);
        }
//        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int idx) {
        int cur = arr[idx];
        if(cur == 0) {
            arr[idx] = 1;
        }
        else {
            arr[idx] = 0;
        }
    }
    public static void men(int num) {
        for(int i = 1; i < arr.length; i++) {
            if(i%num == 0) {
                swap(i);
//                System.out.println(Arrays.toString(arr));
            }
        }
    }

}
