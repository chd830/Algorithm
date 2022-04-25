package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/21608
public class 상어초등학교 {
    static class Student implements Comparable<Student> {
        int num;
        List<Integer> friend;
        Student(int num, List<Integer> friend) {
            this.num = num;
            this.friend = friend;
        }

        @Override
        public int compareTo(Student o) {
            return Integer.compare(this.num, o.num);
        }
    }
    static class Choice implements Comparable<Choice> {
        int x;
        int y;
        int friend;
        int blank;
        Choice(int x, int y, int friend, int blank) {
            this.x = x;
            this.y = y;
            this.friend = friend;
            this.blank = blank;
        }

        @Override
        public int compareTo(Choice o) {
            if(this.friend == o.friend) {
                if(this.blank == o.blank) {
                    if (this.x == o.x)
                        return Integer.compare(this.y, o.y);
                    return Integer.compare(this.x, o.x);
                }
                return -Integer.compare(this.blank, o.blank);
            }
            return -Integer.compare(this.friend, o.friend);
        }
    }
    static int N;
    static int[][] arr;
    static int[][] blank;
    static int[][] friend;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static List<Student> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        blank = new int[N][N];
        setBlank();
        StringTokenizer token = null;
        list = new ArrayList<>();
        for(int i = 0; i < N*N; i++) {
            token = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(token.nextToken());
            List<Integer> l = new ArrayList<>();
            for(int j = 0; j < 4; j++)
                l.add(Integer.parseInt(token.nextToken()));
            list.add(new Student(n, l));
        }
        // 비어있는 칸 중에서 좋아하는 학생이 인접한 칸이 가장 많은 칸
        // 인접한 칸 중에서 비어있는 칸이 많은 칸
        // 행의 번호가 가장 작은 칸, 열의 번호가 가장 작은 칸
        arr[1][1] = list.get(0).num;

        loop: for(int i = 1; i < list.size(); i++) {
            blank = new int[N][N];
            setBlank();
            Student s = list.get(i);
            // 주변에 좋아하는 학생이 얼마나 있는지 카운트하기
            friend = new int[N][N];
            List<Choice> choiceList = new ArrayList<>();
            for(int x = 0; x < N; x++) {
                for(int y = 0; y < N; y++) {
                    countFriends(x, y, s);
                    choiceList.add(new Choice(x, y, friend[x][y],  blank[x][y]));
                }
            }
            Collections.sort(choiceList);
            for(int j = 0; j < choiceList.size(); j++) {
                Choice c = choiceList.get(j);
                if(arr[c.x][c.y] == 0) {
                    arr[c.x][c.y] = s.num;
                    continue loop;
                }
            }
        }
        long answer = 0;
        Collections.sort(list);
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                friend = new int[N][N];
                Student s = list.get(arr[i][j]-1);
                countFriends(i, j, s);
                answer += Math.pow(10, friend[i][j]-1);
            }
        }
        System.out.println(answer);
    }
    static void setBlank() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                for(int d = 0; d < 4; d++) {
                    int dx = i + dir[d][0];
                    int dy = j + dir[d][1];
                    if(isIn(dx, dy) && arr[dx][dy] == 0)
                        blank[i][j]++;
                }
            }
        }
    }
    static void print() {
        for(int i = 0; i < N; i++)
            System.out.println(Arrays.toString(arr[i]));
        System.out.println();
    }
    static void countFriends(int x, int y, Student student) {
        for(int d = 0; d < dir.length; d++) {
            int dx = x + dir[d][0];
            int dy = y + dir[d][1];
            if(isIn(dx, dy) && isFriend(student, dx, dy))
                friend[x][y]++;
        }
    }
    static boolean isFriend(Student student, int x, int y) {
        for(int i = 0; i < student.friend.size(); i++) {
            if(arr[x][y] == student.friend.get(i))
                return true;
        }
        return false;
    }
    static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}