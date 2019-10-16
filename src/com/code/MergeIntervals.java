package com.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {

        if(intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> list = new ArrayList();
        int[] arr = intervals[0];
        list.add(arr);
        for (int[] interval : intervals) {
            System.out.println(interval[0]+", "+interval[1]);
        }
        for (int[] interval : intervals) {
            if (interval[0] <= arr[1]) // Overlapping intervals, move the end if needed
                arr[1] = Math.max(arr[1], interval[1]);
            else {                             // Disjoint intervals, add the new interval to the list
                arr = interval;
                list.add(arr);
            }
            System.out.println(arr[0]+", "+arr[1]);
        }
        return list.toArray(new int[list.size()][]);
    }
}
