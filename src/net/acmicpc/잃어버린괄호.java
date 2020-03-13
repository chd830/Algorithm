package net.acmicpc;

import java.util.Scanner;

public class 잃어버린괄호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String num = "";
        int result = 0;
        int sum = 0;
        for(int i = 0; i < str.length(); i++) {
            if(Character.isDigit(str.charAt(i))) {
                num += str.charAt(i);
            }
            else if(str.charAt(i) == '+') {
                result += Integer.parseInt(num);
                num = "";
            }
            else if(str.charAt(i) == '-'){
                result += Integer.parseInt(num);
                num = "";
                i++;
                sum = 0;
                while(i < str.length()) {
                    if(str.charAt(i) == '+') {
                        sum += Integer.parseInt(num);
                        num = "";
                    }
                    else {
                        num += str.charAt(i);
                    }
                    i++;
                    if(str.charAt(i) == '-') {
                        i--;
                        break;
                    }
                }
                if(!num.equals("")) {
                    sum += Integer.parseInt(num);
                }
                result -= sum;
            }
        }
        System.out.println(result);
    }
}
