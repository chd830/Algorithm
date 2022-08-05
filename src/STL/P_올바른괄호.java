package STL;

import java.util.Stack;

// https://school.programmers.co.kr/learn/courses/30/lessons/12909
public class P_올바른괄호 {
    public static void main(String[] args) {
        System.out.println(solution("()()"));
        System.out.println(solution("(()()"));
        System.out.println(solution(")()()("));
    }
    public static boolean solution(String s) {
        Stack<Integer> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '(') {
                stack.push(1);
            }
            else {
                if(stack.isEmpty())
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
