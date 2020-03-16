package Concept;

import java.util.Arrays;
import java.util.Comparator;

public class ComparableTest {
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
        Student[] students = new Student[] {
                new Student(1, 100),
                new Student(10, 50),
                new Student(5, 10)
        };
        Arrays.sort(students);
        for(Student s : students) {
            System.out.println(s.toString());
        }
        System.out.println();
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.score - o1.score;
            }
        });
        for(Student s : students) {
            System.out.println(s);
        }
    }
}
