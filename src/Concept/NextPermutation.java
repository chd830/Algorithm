package Concept;

import java.util.Arrays;
import java.util.Scanner;

public class NextPermutation {
    static int N;
    static int[] input;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        input = new int[N];
        for(int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(input));
        nextPermutation();
    }
    public static void nextPermutation() {
        int i = N-1;
        while(i > 0 && input[i] <= input[i-1]) {
            i--;
        }
        if(i <= 0) {
            return;
        }
        int j = N-1;
        while(input[i-1] >= input[j]) {
            j--;
        }
        swap(i-1, j);
        j = N-1;
        while(i < j) {
            swap(i, j);
            i++;
            j--;
        }
        System.out.println(Arrays.toString(input));
        nextPermutation();
    }
    public static void swap(int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
