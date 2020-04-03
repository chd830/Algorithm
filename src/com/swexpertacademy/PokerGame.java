package com.swexpertacademy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class PokerGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            String[] cards = new String[5];
            for(int i = 0; i < 5; i++) {
                cards[i] = sc.next();
            }
            System.out.println(Arrays.toString(cards));
            System.out.println("#"+t+" ");
        }
    }
    static int countSuits(String[] cards) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < cards.length; i++) {
            char ch = cards[i].charAt(0);
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch+1));
            }
            else {
                map.put(cards[i].charAt(0), 1);
            }
        }
        return map.size();
    }
    static int countRank(String[] cards) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < cards.length; i++) {
            char ch = cards[i].charAt(1);
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch+1));
            }
            else {
                map.put(ch, 1);
            }
        }
        return map.size();
    }
    static boolean isFullHouse(HashMap<Character, Integer> map) {
        for(int key : map.keySet()) {
            System.out.println(map.get(key));
            if(map.get(key) != 3 && map.get(key) != 2) {
                return false;
            }
        }
        return true;
    }
    static boolean continous() {

        return true;
    }
}
