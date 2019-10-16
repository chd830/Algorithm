package com.code;

import java.util.*;

public class PermutationSequence {
    public String getPermutationFast(int n, int k) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> num = new ArrayList<Integer>();
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
            num.add(i);
        }
        for (int i = 0, l = k - 1; i < n; i++) {
            fact /= (n - i);
            int index = (l / fact);
            System.out.println("i: "+i+", l: "+l+", fact: "+fact+", index: "+index);
            sb.append(num.remove(index));
            l -= index * fact;
        }
        return sb.toString();
    }
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        List<List<Integer>> result = new ArrayList();
        recur(result, new ArrayList(), nums);
        for(List<Integer> l : result) {
            for(int i = 0; i< l.size(); i++) {
                System.out.print(l.get(i)+"\t");
            }
            System.out.println();
        }
        String res = "";
        List<Integer> r = result.get(k - 1);
        for(int i : r) {
            System.out.print(i+"\t");
        }
        System.out.println();
        for(int i = 0; i < n; i++) {
            res += result.get(k - 1).get(i);
        }
        return res;
    }
    public void recur(List<List<Integer>> lists, List<Integer> list, int[] nums) {
        if(list.size() == nums.length) {
            lists.add(new ArrayList(list));
            return;
        }
        else if(list.size() > nums.length) {
            return;
        }
        else {
            for(int i = 0; i < nums.length; i++) {
                if(list.contains(nums[i])) continue;
                list.add(nums[i]);
                recur(lists, list, nums);
                list.remove(list.size() - 1);
            }
        }
    }
}
