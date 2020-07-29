package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 키로거5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            Stack<Character> front = new Stack<>();
            Stack<Character> rare = new Stack<>();
            for(char c : str.toCharArray()) {
                switch (c) {
                    case '<':
                        if(!rare.isEmpty()) {
                            front.push(rare.pop());
                        }
                        break;
                    case '>':
                        if(!front.isEmpty()) {
                            rare.push(front.pop());
                        }
                        break;
                    case '-':
                        if(!rare.isEmpty()) {
                            rare.pop();
                        }
                        break;
                    default:
                        rare.push(c);
                        break;
                }
            }
            while(!front.isEmpty()) {
                rare.push(front.pop());
            }
            for(int j = 0; j < rare.size(); j++) {
                sb.append(rare.elementAt(j));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
