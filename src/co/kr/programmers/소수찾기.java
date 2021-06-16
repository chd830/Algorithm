package co.kr.programmers;

import java.util.*;

public class 소수찾기 {
    public static void main(String[] args) {
        System.out.println(solution("17"));
        System.out.println(solution("011"));
    }
    static int cnt = 0;
    static int[] sub;
    static boolean[] visited;
    public static int solution(String numbers) {
        cnt = 0;
        checkOdd();
        for(int i = 1; i <= numbers.length(); i++) {
            sub = new int[i];
            visited = new boolean[numbers.length()];
            perm(0, numbers);
        }
        return cnt;
    }
    static void perm(int idx, String numbers) {
        if(idx == sub.length) {
            String num = "";
            for(int i : sub)
                num += i;
//            System.out.println(Arrays.toString(sub)+"\t"+odd[Integer.parseInt(num)]);
            if(odd[Integer.parseInt(num)]) {
                odd[Integer.parseInt(num)] = false;
                cnt++;
            }
            return;
        }
        for(int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                sub[idx] = numbers.charAt(i)-'0';
                perm(idx+1, numbers);
                visited[i] = false;
            }
        }
    }
    static boolean[] odd = new boolean[10000000];
    static void checkOdd() {
        Arrays.fill(odd, true);
        odd[0] = false;
        odd[1] = false;
        for(int i = 2; i < odd.length; i++) {
            for(int j = i+i; j < odd.length; j += i) {
                odd[j] = false;
            }
        }
    }
}
