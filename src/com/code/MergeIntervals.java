package com.code;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList();

        int[] arr = new int[2];
        for(int i = 0; i < intervals.length; i++) {

        }

        int[][] result = new int[2][list.size()];
        for(int i = 0; i < list.size(); i++) {
            result[i][0] = list.get(i)[0];
            result[i][1] = list.get(i)[1];
        }
        return result;
    }
}
