package STL;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/10866
public class 덱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        while(N-- > 0) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            switch (token.nextToken()) {
                case "push_back":
                    deque.addLast(Integer.parseInt(token.nextToken()));
                    break;
                case"push_front":
                    deque.addFirst(Integer.parseInt(token.nextToken()));
                    break;
                case "front":
                    if(!deque.isEmpty())
                        System.out.println(deque.getFirst());
                    else
                        System.out.println(-1);
                    break;
                case "back":
                    if(!deque.isEmpty())
                        System.out.println(deque.getLast());
                    else
                        System.out.println(-1);
                    break;
                case "empty":
                    System.out.println(deque.isEmpty() ? 1 : 0);
                    break;
                case"pop_front":
                    if(!deque.isEmpty())
                        System.out.println(deque.pollFirst());
                    else
                        System.out.println(-1);
                    break;
                case "pop_back":
                    if(!deque.isEmpty())
                        System.out.println(deque.pollLast());
                    else
                        System.out.println(-1);
                    break;
                case"size":
                    System.out.println(deque.size());
            }
        }
    }
}
