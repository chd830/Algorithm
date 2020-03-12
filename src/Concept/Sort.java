package Concept;

import java.util.*;

public class Sort {
    public static void main(String[] args) {
        int[] a = {3, 1, 5, 4, 2};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

        List<Integer> l = new ArrayList();
        l.add(3);
        l.add(1);
        l.add(5);
        l.add(4);
        l.add(2);
        Collections.sort(l);
        Collections.sort(l, Comparator.reverseOrder());
        for(int i : l) {
            System.out.print(i+" ");
        }
    }
}
