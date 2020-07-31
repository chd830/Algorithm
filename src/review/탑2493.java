package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;


public class 탑2493 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stack<tower> stack = new Stack<tower>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            long val = Long.parseLong(st.nextToken());
            while(!stack.isEmpty()){
                // 현재 값보다 큰 높이가 있을 때
                if(stack.peek().height >= val){
                    //위치를 저장한다.
                    sb.append(stack.peek().position).append(" ");
                    break;
                }
                stack.pop();
            }
            //스택의 값이 비어있으면 맨 처음 높이거나 현재 값보다 큰 높이가 없으므로 0을 추가한다.
            if(stack.isEmpty())
                sb.append("0").append(" ");
            stack.push(new tower(val, i));
        }
        System.out.println(sb);
    }
    static class tower{
        long height;
        int position;
        public tower(long height, int position){
            this.height = height;
            this.position = position;
        }
    }
}
