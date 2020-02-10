package net.acmicpc;

import java.util.*;

public class 사나운개 {
//    public static void main(String[] args) {
    public 사나운개() {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> que1 = new LinkedList<>();
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int[] a = new int[num1+num2];
        for(int i = 0; i < num1 + num2; i++) {
            if(i < num1) {
                que1.add(1);
            }
            else {
                que1.add(0);
            }
        }
        System.out.println();
        num1 = sc.nextInt();
        num2 = sc.nextInt();
        Queue<Integer> que2 = new LinkedList<Integer>();
        int[] b = new int[num1+num2];
        for(int i = 0; i < num1 + num2; i++) {
            if(i < num1) {
                que2.add(1);
            }
            else {
                que2.add(0);
            }
        }
        System.out.println();
        int[] arr = new int[3];
        int max = 0;
        for(int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(arr[i], max);
        }
        int[] result = new int[max];
        int idx = 0;
        while(idx < max) {
            num1 = que1.poll();
            num2 = que2.poll();
//            System.out.println(num1+" "+num2);
            if(num1 == 1) {
                result[idx]++;
            }
            if(num2 == 1) {
                result[idx]++;
            }
            idx++;
            que1.add(num1);
            que2.add(num2);
//            System.out.println(Arrays.toString(result));
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.println(result[arr[i] - 1]);
        }
        
        
    }
}
