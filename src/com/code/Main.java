package com.code;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Triangle t = new Triangle();
        List<List<Integer>> tri = new ArrayList();
        List<Integer> l1= new ArrayList();
        l1.add(-1);
        List<Integer> l2 = new ArrayList();
        l2.add(2);
        l2.add(3);
        List<Integer> l3 = new ArrayList();
        l3.add(1);
        l3.add(-1);
        l3.add(-3);
//        List<Integer> l4 = new ArrayList();
//        l4.add(4);
//        l4.add(1);
//        l4.add(8);
//        l4.add(3);
        tri.add(l1);
        tri.add(l2);
        tri.add(l3);
//        tri.add(l4);
        System.out.println(t.minimumTotal(tri));

    }
}
