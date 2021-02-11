package review;

import java.util.*;

public class Solution {
//    public int solution(String s) {
//        for(int i = 0; i < s.length()-1; i++) {
//            if(s.charAt(i) == s.charAt(i+1)) {
//                return solution(s.substring(0, i) + s.substring(i + 2, s.length()));
//            }
//        }
//        return s.length() == 0 ? 1 : 0;
//    }
//
//    public int sum(int start, int end) {
//        int sum = 0;
//        for(; start <= end; start++) {
//            sum += start;
//        }
//        return sum;
//    }
//    public int solution(int n) {
//        int cnt = 1;
//        for(int i = 1; i <= n; i++) {
//            for(int j = i+1; j <= n; j++) {
//                if(sum(i, j) == n) {
//                    cnt++;
//                }
//            }
//        }
//        return cnt;
//    }

    static int cnt = 0;
    public int solution(int n, int[] money) {
        recur(n, 0, money);
        return cnt;
    }
    public void recur(int n, int idx, int[] money) {
        if(n == 0) {
            cnt++;
            cnt %= 1000000007;
        }
        for(int i = idx; i < money.length; i++) {
            if(n-money[i] >= 0) {
                recur(n - money[i], i, money);
            }
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.solution("baabaa"));
//        System.out.println(s.solution("cdcd"));
//        System.out.println(s.solution(15));
        System.out.println(s.solution(5, new int[] {1, 2, 5}));
    }
}
