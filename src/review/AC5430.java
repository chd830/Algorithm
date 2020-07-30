package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class AC5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        loop: for(int testcase = 0; testcase < N; testcase++) {
            //정방향일 때 true, 역방향일 때 false
            boolean dir = true;
            Deque<String> deque = new LinkedList<>();
            String oper = br.readLine();
            int len = Integer.parseInt(br.readLine());
            String nums = br.readLine();
            nums = nums.substring(1, nums.length()-1);
            String[] num = nums.split(",");
            for(String n : num) {
                deque.add(n);
            }
            for(char c : oper.toCharArray()) {
                switch (c) {
                    case 'R':
                        dir = !dir;
                        break;
                    case 'D':
                        if(deque.isEmpty() || deque.peek().equals("")) {
                            sb.append("error").append("\n");
                            deque.clear();
                            continue loop;
                        }
                        //정방향일 때
                        if(dir) {
                            deque.pollFirst();
                        }
                        //역방향일 때
                        else {
                            deque.pollLast();
                        }
                        break;
                }
            }
            int size = deque.size();
            sb.append("[");
            //정방향일 때
            if(dir) {
                for(int i = 0; i < size; i++) {
                    sb.append(deque.pollFirst());
                    if(i != size-1) {
                        sb.append(",");
                    }
                }
            }
            //역방향일 때
            else {
                for(int i = 0; i < size; i++) {
                    sb.append(deque.pollLast());
                    if(i != size-1) {
                        sb.append(",");
                    }
                }
            }
            sb.append("]\n");
            deque.clear();
        }
        System.out.println(sb);
    }
}
