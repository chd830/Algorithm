package com.code;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Combinations c = new Combinations();
        List<List<Integer>> result = c.combine(4,3);
        for(List<Integer> l : result) {
            for(int i = 0; i < l.size(); i++) {
                System.out.print(l.get(i)+"\t");
            }
            System.out.println();
        }

    }
}
