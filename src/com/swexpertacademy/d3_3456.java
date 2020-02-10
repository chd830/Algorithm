package com.swexpertacademy;

import java.util.*;

//직사각형 길이 찾기
public class d3_3456 {
//    public static void main(String[] args) {
    public d3_3456() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            HashMap<Integer, Integer> map = new HashMap();
            for(int i = 0; i < 3; i++) {
                int num = sc.nextInt();
                if(map.containsKey(num)) {
                    map.put(num, map.get(num)+1);
                }
                else {
                    map.put(num, 1);
                }
            }
            for(int key : map.keySet()) {
                if(map.get(key) == 1) {
                    System.out.println("#"+t+" "+key);
                    break;
                }
                else if(map.get(key) == 3) {
                    System.out.println("#"+t+" "+key);
                    break;
                }
            }
        }
    }
}
