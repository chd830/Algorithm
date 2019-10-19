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
        //k의 길이만큼의 집합을 만든다.
        if (k == 0) {
            System.out.print("comb: ");
            for(int i : comb) {
                System.out.print(i+"\t");
            }
            System.out.println();
            combs.add(new ArrayList<Integer>(comb));
            return;
        }
        for (int i = start; i <= n-k + 1; i++) {
            //i를 comb에 하나씩 더하고 마지막에 있는 수를 제거하면서
            //comb에 수를 k개가 되도록 채우고 combs에 더한다.
            System.out.println("add "+i+" in comb");
            comb.add(i);
            recur(combs, comb, i +1, n, k-1);
            System.out.println("remove "+(comb.size()));
            comb.remove(comb.size() -1);
        }
    }
}
