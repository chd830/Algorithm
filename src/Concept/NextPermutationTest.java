package Concept;

import java.util.Arrays;
import java.util.Scanner;

public class NextPermutationTest {
    static int N;
    static int[] input;
    static int totalCnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        input = new int[N];
        for(int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }
        Arrays.sort(input);
        nextPermutation();
        System.out.println("total count: "+totalCnt);
    }
    private static void nextPermutation() {
        System.out.println(Arrays.toString(input));
        totalCnt++;
        int i = N-1;
        while(i > 0 && input[i-1] >= input[i]) {
            i--;
        }
        if(i <= 0) {
            return;
        }
        int j = N-1;
        while(input[j] <= input[i-1]) {
            j--;
        }
        swap(i-1, j);
        j = N-1;
        while(i < j) {
            swap(i, j);
            i++;
            j--;
        }
        nextPermutation();
    }
    private static void swap(int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
