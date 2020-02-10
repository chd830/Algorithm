package com.swexpertacademy;

import java.util.Scanner;

//View
public class d3_1206 {
    //    public static void main(String[] args) {
    public d3_1206() {
        Scanner sc = new Scanner(System.in);
        for(int t = 1; t <= 10; t++) {
            int n = sc.nextInt();
            int result = 0;
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int prev = 0;
            if(n > 3 && arr[0] > arr[1] && arr[0] > arr[2]) {
                result += arr[0] - Math.max(arr[1], arr[2]);
            }
            if(n > 4 && arr[1] > arr[0] && arr[1] > arr[2] && arr[1] > arr[3]) {
                result += arr[1] - Math.max(arr[2], arr[3]);
            }
            for(int i = 2, count = 0; i < n - 2; i++) {
                if(arr[i] == 0) {
                    continue;
                }
                if(arr[i-2] < arr[i] && arr[i-1] < arr[i] && arr[i] > arr[i+1] && arr[i] > arr[i+2]) {
                    int max = Math.max(arr[i+1], Math.max(arr[i+2], Math.max(arr[i-1], arr[i-2])));
                    result += arr[i] - max;
                }
            }
            System.out.println("\n#"+t+" "+result);
        }
    }
}
