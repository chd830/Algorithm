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
    public static String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();

        int left = 0;
        int right = k;
        int max = -1;

        while(sb.length() != number.length()-k) {
            max = -1;
            for(int j = left ; j <= right ; ++j){
                int num = number.charAt(j) - '0';
                if(num > max){
                    left = j;
                    max = num;
                }
            }
            sb.append(number.charAt(left));
            left++;
            right = sb.length()+k;
        }
        return sb.toString();
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
