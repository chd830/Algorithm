package Concept;

import java.util.*;
public class QueueAPITest {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();
        System.out.println(queue.isEmpty()+" "+ queue.size());
        queue.offer("김태희");
        queue.offer("이동욱");
        queue.offer("이지아");
        System.out.println(queue.isEmpty()+" "+ queue.size());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.isEmpty()+" "+ queue.size());
        System.out.println(queue.peek());
        System.out.println(queue.isEmpty()+" "+ queue.size());
    }
}
