package com.swexpertacademy;

        import java.util.*;

//적고 지우기
public class d3_8821 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            String str = sc.next();
            int size = 0;
            HashSet<Character> set = new HashSet();
            for(char c : str.toCharArray()) {
                if(set.contains(c)) {
                    set.remove(c);
                    size--;
                }
                else {
                    set.add(c);
                    size++;
                }
            }
            System.out.println("#"+t+" "+(size > 0 ? size : 0));
        }
    }
}
