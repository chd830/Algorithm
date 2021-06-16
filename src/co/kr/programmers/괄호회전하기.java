package co.kr.programmers;

import java.util.*;

public class 괄호회전하기 {
    public static void main(String[] args) {
        System.out.println(solution("[](){}"));
        System.out.println(solution("}]()[}"));
        System.out.println(solution("}]()[{"));
        System.out.println(solution("([{)}]"));
    }
    public static int solution(String s) {
        int cnt = 0;
        for(int i = 0; i < s.length(); i++) {
            String tmp = s.substring(i, s.length())+s.substring(0, i);
            if(check(tmp)) {
                cnt++;
            }
//            System.out.println(tmp+"\t"+check(tmp));
        }
        return cnt;
    }
    static boolean check(String str) {
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()) {
            switch (c) {
                case '[':
                case '{':
                case '(':
                    stack.push(c);
                    break;
                case ']':
                    if(stack.isEmpty())
                        return false;
                    if(stack.pop() != '[')
                        return false;
                    break;
                case '}':
                    if(stack.isEmpty())
                        return false;
                    if(stack.pop() != '{')
                        return false;
                    break;
                case ')':
                    if(stack.isEmpty())
                        return false;
                    if(stack.pop() != '(')
                        return false;
                    break;
            }
        }
        return stack.isEmpty();
    }
}
