package com.code;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Permutations p = new Permutations();
        List<List<Integer>> result = p.permute(new int[] {1,2,3});
        for(List l : result ) {
            for(int i = 0; i < l.size(); i++) {
                System.out.print(l.get(i)+"\t");
            }
            System.out.println("");
        }
    }
}
