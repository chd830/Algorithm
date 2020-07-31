package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;


public class 탑2493 {
    //시간초과
    static int[] arr;
    static Stack<Integer> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        Arrays.fill(arr, 0);
        StringTokenizer token = new StringTokenizer(br.readLine());
        stack = new Stack<>();
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        //각각의 인덱스에서
        while(true) {
            if(N == 1) {
                stack.push(0);
                break;
            }
            search(N-1);
            N--;
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }
    public static void search(int end) {
        int com = end - 1;
        while(com >= 0) {
            //건물에 막힐 때
            if(arr[end] < arr[com]) {
                stack.push(com+1);
                return;
            }
            //끝까지 건물에 막히지 않을 때
            else if(com == 0) {
                stack.push(0);
                return;
            }
            --com;
        }
    }
}
