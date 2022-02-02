package Study;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/10828
public class 스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            switch (token.nextToken()) {
                case "push":
                    stack.push(Integer.parseInt(token.nextToken()));
                    break;
                case "pop":
                    if(stack.isEmpty())
                        sb.append("-1").append("\n");
                    else
                        sb.append(stack.pop()).append("\n");
                    break;
                case "top":
                    if(stack.isEmpty())
                        sb.append("-1").append("\n");
                    else
                        sb.append(stack.peek()).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    if(stack.isEmpty())
                        sb.append("1").append("\n");
                    else
                        sb.append("0").append("\n");
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
