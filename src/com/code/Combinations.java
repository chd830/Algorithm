package com.code;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList<List<Integer>>();
        recur(combs, new ArrayList<Integer>(), 1, n, k);
        return combs;
    }

    public void recur(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
        if (k == 0) {
            combs.add(new ArrayList<Integer>(comb));
            return;
        }
        for (int i = start; i <= n-k + 1 ; i++) {
            comb.add(i);
            recur(combs, comb, i +1, n, k-1);
            comb.remove(comb.size() -1);
        }
    }
}
