package co.kr.programmers;

import java.util.*;

public class 다단계칫솔판매 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                solution(new String []{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                        new String [] {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                        new String [] {"young", "john", "tod", "emily", "mary"},
                        new int[] {12, 4, 2, 5, 10})));
    }
    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int len = enroll.length;
        int[] parents = new int[len];
        Arrays.fill(parents, -1);
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(referral[i].equals(enroll[j])) {
                    parents[i] = j;
                    break;
                }
            }
        }
        int[] result = new int[len];
        for(int i = 0; i < amount.length; i++) {
            amount[i] *= 100;
        }
        // 벌어들인 수익과 사람을 나타내는 i
        for(int i = 0; i < seller.length; i++) {
            // 몇번째 사람을 나타내는지를 찾는 j
            for(int j = 0; j < len; j++) {
                if(seller[i].equals(enroll[j])) {
                    // 더 이상 상위의 값이 없을 때
                    int profit = amount[i];
                    while(j != -1) {
                        int adv = profit/10;
                        int cur = profit-adv;
                        result[j] += cur;
                        j = parents[j];
                        profit /= 10;
                    }
                    break;
                }
            }
        }
        return result;
    }
}