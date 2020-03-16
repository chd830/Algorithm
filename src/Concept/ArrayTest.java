package Concept;

import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for(int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
    }
}
