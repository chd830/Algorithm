package com.swexpertacademy;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 7, 9};
        System.out.println("PrevPermutation");
        prevPermutation(Arrays.copyOf(arr, arr.length));
        System.out.println("NextPermutation");
        nextPermutation(Arrays.copyOf(arr, arr.length));
    }

    public static void prevPermutation(int[] arr) {
        int len = arr.length-1;
        int i = len;
        while(i > 0 && arr[i] >= arr[i-1]) {
            i--;
        }
        if(i <= 0) {
            return;
        }
        int j = len;
        while(arr[j] >= arr[i-1]) {
            j--;
        }
        swap(arr, i-1, j);
        j = len;
        while(i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
        System.out.println(Arrays.toString(arr));
        prevPermutation(arr);
        return;
    }

    public static void nextPermutation(int[] arr) {
        int len = arr.length-1;
        int i = len;
        while(i > 0 && arr[i] <= arr[i-1]) {
            i--;
        }
        if(i <= 0) {
            return;
        }
        int j = len;
        while(arr[j] <= arr[i-1]) {
            j--;
        }
        swap(arr, i-1, j);
        j = len;
        while(i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
        System.out.println(Arrays.toString(arr));
        nextPermutation(arr);
        return;
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
