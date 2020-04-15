package Concept;

import java.util.Scanner;

public class KMP {
    //부분문자열을 찾는 알고리즘
    //접두사와 접미사 개념 활용. 반복되는 연산 생략

    //파이테이블: 길이별 접두사==접미사의 최대길이 저장
    static int[] getPi(String pattern) {
        int[] pi = new int[pattern.length()];
        int j = 0;
        for(int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                pi[i] = ++j;
            }
        }
        return pi;
    }

    static void KMP(String pattern, String origin) {
        int[] pi = getPi(pattern);
        int j = 0;
        for(int i = 0; i < origin.length(); i++) {
            //일단 처리
            while(j > 0 && origin.charAt(i) != pattern.charAt(j)) {
                j = pi[j-1];
            }
            //맞는 경우
            if(origin.charAt(i) == pattern.charAt(j)) {
                if(j == pattern.length()-1) {
                    System.out.println("result: "+(i-pattern.length()+1));
                    j = pi[j];
                }
                //맞았지만 패턴이 끝나지 않았을 경우
                else {
                    j++;
                }
            }
            System.out.println(i+" "+j);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        KMP(sc.next(), sc.next());
//        KMP("ABCDABCDABEE", "ABCDABE");
    }
}
