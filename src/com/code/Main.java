package com.code;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Subsets s = new Subsets();
        List<List<Integer>> result = s.subsets(new int[] {1,2,3});
        for(List<Integer> l : result) {
            for(int i = 0; i < l.size(); i++) {
                System.out.print(l.get(i)+"\t");
            }
            System.out.println();
        }

    }
}
