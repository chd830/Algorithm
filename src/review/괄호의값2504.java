package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호의값2504 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<String> stack = new Stack<String>();

        boolean isAble = true;
        for(char ch : str.toCharArray()) {
            String c = ""+ch;
            if("(".equals(c)) {
                stack.push(")");
                continue;
            }

            if("[".equals(c)) {
                stack.push("]");
                continue;
            }

            int num = 0;
            while(true) {
                if(stack.isEmpty()) {
                    isAble = false;
                    break;
                }

                if(isNumber(stack.peek())) {
                    num += Integer.parseInt(stack.pop());
                }
                else {
                    //스택에서 짝이 맞지 않거나 숫자가 아니라면 isAble = false
                    //짝이 맞는다면 숫자를 더한다.
                    if(isVPS(c, stack.peek())) {
                        stack.pop();
                        int t = (")".equals(c)) ? 2:3;

                        if(num == 0) {
                            stack.push(String.valueOf(t));
                        }
                        else {
                            stack.push(String.valueOf(t*num));
                        }
                        break;
                    }
                    else {
                        isAble = false;
                        break;
                    }
                }
            }
            if(!isAble) {
                break;
            }
        }

        int result = 0;

        //스택에 문자가 있으면 isAble = false
        while(!stack.isEmpty()) {
            if(isNumber(stack.peek())) {
                result += Integer.parseInt(stack.pop());
            }
            else {
                isAble = false;
                break;
            }
        }

        if(isAble) System.out.println(result);
        else System.out.println(0);
    }

    public static boolean isVPS(String c, String target) {
        if(c.equals(target)) {
            return true;
        }
        return false;
    }

    public static boolean isNumber(String str) {
        if(str.equals(")") || str.equals("]")) {
            return false;
        }
        return true;
    }
}

