package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호의값2504re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<String> stack = new Stack<>();
        int ans = 0;
        for (char c : str.toCharArray()) {
            switch (c) {
                case '(':
                    stack.push(")");
                    break;
                case '[':
                    stack.push("]");
                    break;
                //괄호의 짝이 맞을 때까지 계속 꺼낸다
                //숫자가 나오면 숫자는 계속 더한다.
                //괄호의 짝이 맞으면 합한 수를 곱한 뒤 push한다.
                default:
                    int num = 0;
                    if (stack.isEmpty()) {
                        System.out.println(0);
                        System.exit(0);
                    }
                    while(!stack.isEmpty()) {
                        if(Character.isDigit(stack.peek().charAt(0))) {
                            num += Integer.parseInt(stack.pop());
                        }
                        else {
                            if(stack.peek().charAt(0) == c) {
                                stack.pop();
                                int t = ')' == c ? 2 : 3;
                                stack.push(num == 0 ? ""+t : ""+(t*num));
                                break;
                            }
                            else {
                                System.out.println(0);
                                System.exit(0);
                            }
                        }
                    }
                    break;
            }
        }
        while(!stack.isEmpty()) {
            if(Character.isDigit(stack.peek().charAt(0))) {
                ans += Integer.parseInt(stack.pop());
                continue;
            }
            System.out.println(0);
            System.exit(0);
        }
        System.out.println(ans);
    }
}
