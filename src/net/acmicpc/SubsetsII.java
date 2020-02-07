package net.acmicpc;
import java.util.*;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();
        recur(result, new ArrayList(), nums, 0);
        return result;
    }
    public void recur(List<List<Integer>> lists, List<Integer> list, int[] nums, int start) {
        if(!lists.contains(list)) {
            lists.add(new ArrayList(list));
        }
        else {
            return;
        }
        for(int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            recur(lists, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
