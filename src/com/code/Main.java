package com.code;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        SubsetsII s = new SubsetsII();
        int[] nums = {4,4,4,1,4};
        List<List<Integer>> result = s.subsetsWithDup(nums);
        for(List<Integer> l : result) {
            for(int i = 0; i < l.size(); i++) {
                System.out.print(l.get(i)+"\t");
            }
            System.out.println();
        }
    }
}
