package Concept;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BrowserTest {
    /**
     *
     * Visit: 현재 페이지를 B stack에 push, F stack clear
     * Back: 현재 페이지를 F stack에 push, B stack pop 후 현재페이지로 설정
     * Forward: 현재 페이지를 B stack에 push, F stack pop 후 현재페이지 설정
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        String current = "http://www.ssafy.com";

        Stack<String> B = new Stack();
        Stack<String> F = new Stack();

        while(true) {
            String input = br.readLine();
            if(input.charAt(0) == 'Q') {
                break;
            }
            token = new StringTokenizer(input, " ");
            switch(token.nextToken().charAt(0)) {
                case 'V':
                    F.clear();
                    B.push(current);
                    current = token.nextToken();
                    System.out.println(current);
                    break;
                case 'B':
                    if(B.isEmpty()) {
                        System.out.println("Ignored..");
                    }
                    else {
                        F.push(current);
                        current = B.pop();
                        System.out.println(current);
                    }
                    break;
                case 'F':
                    if(F.isEmpty()) {
                        System.out.println("Ignored..");
                    }
                    else {
                        B.push(current);
                        current = F.pop();
                        System.out.println(current);
                    }
                    break;
            }

        }
    }
}
