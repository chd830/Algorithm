package com.swexpertacademy;

import java.util.*;

public class 염라대왕의이름정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            List<String> list = new ArrayList();
            for(int i = 0; i < N; i++) {
                list.add(sc.next());
            }
            Comparator<String> comp = new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if(o1.length() < o2.length()) {
                        return -1;
                    }
                    else if(o1.length() > o2.length()) {
                        return 1;
                    }
                    else {
                        if(o1.charAt(0) < o2.charAt(0)) {
                            return -1;
                        }
                        else if(o2.charAt(0) < o1.charAt(0)) {
                            return 1;
                        }
                        return 0;
                    }
                }
            };
            Collections.sort(list, comp);
            System.out.println("#"+t);
            String prev = "";
            for(String s : list) {
                if(prev.equals(s)) {
                    continue;
                }
                System.out.println(s);
                prev = s;
            }
        }
    }
}