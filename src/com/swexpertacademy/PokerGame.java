package com.swexpertacademy;

import java.util.Arrays;
import java.util.Comparator;
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
            Arrays.sort(cards, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if(o1.charAt(1) == 'A' && Character.isDigit(o2.charAt(1))) {
                        return -1;
                    }
                    else if(Character.isDigit(o1.charAt(1)) && o2.charAt(1) == 'A') {
                        return 1;
                    }
                    return Integer.compare(o1.charAt(1), o2.charAt(1));
                }
            });
            System.out.println(Arrays.toString(cards));
            System.out.println("#"+t+" ");
        }
    }
}
