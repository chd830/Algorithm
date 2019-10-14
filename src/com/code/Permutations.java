package com.code;
import java.util.*;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        recur(result, new ArrayList(), nums);
        return result;
    }
    public void recur(List<List<Integer>> lists, List<Integer> list, int[] nums) {
        if(list.size() == nums.length) {
            lists.add(new ArrayList(list));
            return;
        }
        if(list.size() > nums.length)
            return;
        for(int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            recur(lists, list, nums);
            list.remove(list.size() - 1);
        }
    }
}
