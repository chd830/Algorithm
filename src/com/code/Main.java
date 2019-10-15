package com.code;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        SpiralMatrix s = new SpiralMatrix();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> list = s.spiralOrder(matrix);
        for(int i : list) {
            System.out.print(i+"\t");
        }
    }
}
