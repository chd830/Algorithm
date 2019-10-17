package com.code;
import java.util.*;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        recur(result, new ArrayList(), nums, 0);
        return result;
    }
    public void recur(List<List<Integer>> lists, List<Integer> list, int[] nums, int start) {
        lists.add(new ArrayList(list));
        for(int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            recur(lists, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
