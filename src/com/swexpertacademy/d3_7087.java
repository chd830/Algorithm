package com.swexpertacademy;

import java.util.*;

//문제 제목 붙이기
public class d3_7087 {
    public d3_7087() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            int num = sc.nextInt();
            List<String> strs = new ArrayList();
            for(int i = 0; i < num; i++) {
                strs.add(sc.next());
            }
            Comparator<String> comp = new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if(o1.charAt(0) < o2.charAt(0)) {
                        return 0;
                    }
                    return 1;
                }
            };
            Collections.sort(strs);
            char prev = ' ';
            int count = 0;
            for(String s : strs) {
//                System.out.println("prev: "+prev+", s.charAt(0): "+s.charAt(0)+", "+(s.charAt(0) - prev));
                if(s.charAt(0) - prev != 33 && s.charAt(0) - prev > 1) {
                    break;
                }
                if(prev == s.charAt(0)) {
                    continue;
                }
                else {
                    count++;
                }
                prev = s.charAt(0);
            }
            System.out.println("#"+t+" "+count);
        }
    }
}
