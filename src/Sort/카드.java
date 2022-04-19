package Sort;

import java.util.*;

//https://www.acmicpc.net/problem/11652
public class 카드 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        String n = "";
        for(int i = 0; i < N; i++) {
            n = sc.next();
            if(map.containsKey(n))
                map.put(n, map.get(n)+1);
            else
                map.put(n, 1);
        }
        String idx = n;
        int val = map.get(n);
        for(String key : map.keySet()) {
            if(val < map.get(key)) {
                idx = key;
                val = map.get(key);
            }
            else if(val == map.get(key)) {
                if(idx.length() > key.length()) {
                    idx = key;
                }
                else if(idx.length() == key.length()) {
                    for(int i = 0; i < idx.length(); i++) {
                        if(idx.charAt(i) < key.charAt(i)) {
                            break;
                        }
                        else if(idx.charAt(i) > key.charAt(i)) {
                            idx = key;
                            break;
                        }
                    }
                }
                val = map.get(key);
            }
        }
        System.out.println(idx);
    }
}
