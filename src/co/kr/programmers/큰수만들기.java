package co.kr.programmers;

import java.util.*;

public class 큰수만들기 {
    public static void main(String[] args) {
        /*
        94
        3234
        775841
         */
        System.out.println(solution("1924", 2));
        System.out.println(solution("1231234", 3));
        System.out.println(solution("4177252841", 4));
    }
    public static String solution(String num, int k) {
        char[] nums = num.toCharArray();
        String ans = "";
        // 필요한 글자수(num.lenght()-k)만큼 반복
        for(int j = 0, idx = -1; j < num.length()-k; j++) {
            char max = 0;
            // 앞에 적을 수 있는 제일 큰 수 체크
            for(int i = idx+1; i <= k+j; i++) {
                if(max < nums[i]) {
                    idx = i;
                    max = nums[i];
                }
            }
            // 답에 추가
            ans += max;
        }
        return ans;
    }
//    시간초과
//    static int max;
//    static int[] sub;
//    static boolean[] visited;
//    static void comb(int idx, int subIdx, String number) {
//        if(subIdx == sub.length) {
//            String num = "";
//            for(int i = 0; i < sub.length; i++) {
//                num += number.charAt(sub[i]);
//            }
////            System.out.println(Arrays.toString(sub)+"\t"+num);
//            max = Math.max(max, Integer.parseInt(num));
//            return;
//        }
//        for(int i = idx; i < visited.length; i++) {
//            if(!visited[i]) {
//                visited[i] = true;
//                sub[subIdx] = i;
//                comb(i+1, subIdx+1, number);
//                visited[i] = false;
//            }
//        }
//    }
//    static String solution(String number, int k) {
//        max = 0;
//        visited = new boolean[number.length()];
//        sub = new int[number.length()-k];
//        comb(0, 0, number);
//        return String.valueOf(max);
//    }
}
