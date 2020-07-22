package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 방번호1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        while(N > 10) {
            int num = N%10;
            if(map.containsKey(num)) {
                map.put(num, map.get(num)+1);
            }
            else {
                map.put(num, 1);
            }
            N /= 10;
        }
        if(map.containsKey(N)) {
            map.put(N, map.get(N)+1);
        }
        else {
            map.put(N, 1);
        }
        int cnt = 0;
        int sixNineCnt = 0;
        for(int key : map.keySet()) {
            if(key == 6 || key == 9) {
                sixNineCnt += map.get(key);
            }
            else {
               cnt = Math.max(cnt, map.get(key));
            }
        }
        sixNineCnt = sixNineCnt%2 == 0 ? sixNineCnt/2 : sixNineCnt/2 + 1;
        System.out.println(Math.max(sixNineCnt, cnt));
    }
}
