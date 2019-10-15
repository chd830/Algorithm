package com.code;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        MergeIntervals m = new MergeIntervals();
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] result = m.merge(intervals);
        for(int i = 0; i < result.length; i++) {
            for(int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
