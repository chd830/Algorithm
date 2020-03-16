package Concept;

import java.util.PriorityQueue;

public class PriorityQueueTest {
    static class Student implements Comparable<Student>{
        int no;
        int score;
        public Student(int no, int score) {
            this.no = no;
            this.score = score;
        }

        @Override
        public int compareTo(Student o) {
            return this.score - o.score;
        }

        @Override
        public String toString() {
            return "Student[no = "+no+" , score = "+score+"]";
        }

    }
    public static void main(String[] args) {
        PriorityQueue<Student> que = new PriorityQueue<>();
        que.add(new Student(10, 100));
        que.add(new Student(1, 80));
        que.add(new Student(5, 50));
        //작은 수부터 나오게 됨.
        System.out.println(que.poll());
        System.out.println(que.poll());
        System.out.println(que.poll());
    }
}
