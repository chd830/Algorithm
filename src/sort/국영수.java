package sort;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/10825
public class 국영수 {
    static class Student implements Comparable<Student> {
        String name;
        int korean;
        int english;
        int math;
        Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", korean=" + korean +
                    ", english=" + english +
                    ", math=" + math +
                    '}';
        }

        @Override
        public int compareTo(Student o) {
            if(this.korean == o.korean) {
                if(this.english == o.english) {
                    if (this.math == o.math) {
                        for (int i = 0; i < Math.min(this.name.length(), o.name.length()); i++) {
                            if (this.name.charAt(i) != o.name.charAt(i))
                                return Integer.compare(this.name.charAt(i), o.name.charAt(i));
                        }
                    }
                    return -Integer.compare(this.math, o.math);
                }
                return Integer.compare(this.english, o.english);
            }
            return -Integer.compare(this.korean, o.korean);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        int N = Integer.parseInt(br.readLine());
        Student[] students = new Student[N];
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            students[i] = new Student(token.nextToken(), Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
        }
        Arrays.sort(students);
        for(Student student : students)
            System.out.println(student.name);
    }
}
