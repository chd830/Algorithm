package co.kr.programmers;

import net.acmicpc.나무재테크Solution;

import java.util.*;

public class 괄호변환 {
    public static void main(String[] args) {
        System.out.println(solution("(()())()"));
//        System.out.println(solution(")("));
//        System.out.println(solution("()))((()"));
        /*
        (()())()
        ()
        ()(())()
         */
    }
    public static String solution(String p) {
//        1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
//        4-5. 생성된 문자열을 반환합니다.
        if(p.length() == 0) {
            return p;
        }
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        //        2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
        int idx = divide(p);

        u.append(p.substring(0, idx));
        v.append(p.substring(idx));
        //        3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
        //        3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
        if(check(u.toString())) {
            return u.append(solution(v.toString())).toString();
        }
//        4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
//        4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
//        4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
//        4-3. ')'를 다시 붙입니다.
        answer.append("(").append(solution(v.toString())).append(")");
//        4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
        u.deleteCharAt(0);
        u.deleteCharAt(u.length()-1);
        for(char c : u.toString().toCharArray()) {
            if(c == '(')
                answer.append(")");
            else
                answer.append("(");
        }
        return answer.toString();
    }

    static boolean check(String p) {
        int n = 0;
        for(char c : p.toCharArray()) {
            if(c == '(')
                n++;
            else if(c == ')' && n > 1)
                n--;
        }
        return n < 1;
    }
    static int divide(String p) {
        int n = 0;
        for(int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            switch (c) {
                case '(':
                    n++;
                    break;
                case')':
                    n--;
                    break;
            }
            if(n == 0)
                return i+1;
        }
        return 0;
    }
}
