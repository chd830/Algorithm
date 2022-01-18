package Study;

import java.util.*;

// https://www.acmicpc.net/problem/5397
public class 키로거 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0; i < N; i++) {
            String str = sc.next();
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();
            /*
            <: 왼쪽이동
            >: 오른쪽이동
            -: 백스페이스

            첫째 줄에 테스트 케이스의 개수가 주어진다.
            각 테스트 케이스는 한줄로 이루어져 있고,
            강산이가 입력한 순서대로 길이가 L인 문자열이 주어진다.
            (1 ≤ L ≤ 1,000,000)
            강산이가 백스페이스를 입력했다면, '-'가 주어진다.
             이때 커서의 바로 앞에 글자가 존재한다면, 그 글자를 지운다.
             화살표의 입력은 '<'와 '>'로 주어진다.
             이때는 커서의 위치를 움직일 수 있다면,
             왼쪽 또는 오른쪽으로 1만큼 움직인다.
             나머지 문자는 비밀번호의 일부이다.
             물론, 나중에 백스페이스를 통해서 지울 수는 있다.
             만약 커서의 위치가 줄의 마지막이 아니라면,
             커서 및 커서 오른쪽에 있는 모든 문자는 오른쪽으로 한 칸 이동한다.
             */
            for(char c : str.toCharArray()) {
                switch(c) {
                    case '<':
                        if(!left.isEmpty())
                            right.push(left.pop());
                        break;
                    case '>':
                        if(!right.isEmpty())
                            left.push(right.pop());
                        break;
                    case '-':
                        left.pop();
                        break;
                    default:
                        left.push(c);
                        break;
                }
            }
            // v1
            String answer = "";
            StringBuilder sb = new StringBuilder();
            str = "";
            while(!left.isEmpty()) {
                str += left.peek();
                sb.append(left.pop());
            }
            sb.reverse();
            for(int j = str.length()-1; j >= 0; j--)
                answer += str.charAt(j);
            while(!right.isEmpty()) {
                answer += right.peek();
                sb.append(right.pop());
            }
            System.out.println("V1\n"+answer);
            System.out.println("V2\n"+sb.toString());
        }
    }
}