package net.acmicpc;

import java.util.Scanner;

public class 잃어버린괄호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String num = "";
        int result = 0;
        loop: for(int i = 0; i < str.length(); i++) {
            if(Character.isDigit(str.charAt(i))) {
                num += str.charAt(i);
            }
            else if(str.charAt(i) == '-') {
                if(!num.equals("")) {
                    result += Integer.parseInt(num);
                }
                num = "";
                int sum = 0;
                while(++i < str.length()) {
                    if(Character.isDigit(str.charAt(i))) {
                        num += str.charAt(i);
                    }
                    else if(str.charAt(i) == '+'){
                        sum += Integer.parseInt(num);
                        num = "";
                    }
                    else if(str.charAt(i) == '-'){
                        if(!num.equals("")) {
                            sum += Integer.parseInt(num);
                            num = "";
                        }
                        result -= sum;
                        i--;
                        continue loop;
                    }
                }
                if(!num.equals("")) {
                    sum += Integer.parseInt(num);
                }
                result -= sum;
                num = "";
            }
            else if(str.charAt(i) == '+') {
                result += Integer.parseInt(num);
                num = "";
            }
        }
        if(!num.equals("")) {
            result += Integer.parseInt(num);
        }
        System.out.println(result);
    }
}
