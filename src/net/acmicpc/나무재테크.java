package net.acmicpc;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

//PrioirtyQueue를 정렬하는데 오래걸리기 때문에 짧은 시간으로 짜려면
//3차원 배열로 나이별로 관리하게 된다면 짧은 시간안에 짤 수 있다...

//0. 각 맵의 S2D2가 겨울에 추가할 양분의 양을 저장할 자료(2차원)
//0. 각 맵의 현재 양분양을 저장할 자료(2차원)
//1. 현재 살아있는 모든 나무를 담을 Priority Queue(좌표, 나이)
//2. 봄이 지나 살아있는 나무들이 모여있을 큐
//3. 봄이 지나 죽을 나무들이 모여있을 큐

//봄: 1을 꺼내서 산놈은 2. 죽은놈을 2로 보낸다.
//여름: 2를 모두 꺼내며 양분추가
//가을: 3을 모두 꺼내며 8방에 생기는 나무를 다시 1에 삽입
//겨울: 0을 한바퀴 돌면서 양분 업데이트
public class 나무재테크 {
    static class Tree implements Comparable<Tree> {
        int r;
        int c;
        int age;
        Tree(int r, int c, int age) {
            this.r = r;
            this.c = c;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return Integer.compare(this.age, o.age);
        }
    }
    //겨울에 뿌릴 양분의 양
    static int[][] s2d2;
    //칸 별 양분의 양
    static int[][] map;
    //살아있는 나무들
    static PriorityQueue<Tree> trees = new PriorityQueue<>();
    //봄을 지나 살아있는 나무들 임시저장
    static Queue<Tree> alive = new LinkedList<>();
    //봄을 지나 죽은 나무들 임시저장
    static Queue<Tree> dead = new LinkedList<>();
    static int N;
    static int M;
    static int K;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        map = new int[N+1][N+1];
        s2d2 = new int[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                s2d2[i][j] = sc.nextInt();
                map[i][j] = 5;
            }
        }
        for(int i = 0; i < M; i++) {
            trees.add(new Tree(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        for(int k = 0; k < K; k++) {
            spring();
            summer();
            autumn();
            winter();
        }
        System.out.println(trees.size());
    }
    static void spring() {
        //trees 큐를 하나씩 꺼내면서
        while(!trees.isEmpty()) {
            Tree tree = trees.poll();
            //양분이 충분하다면 나이만큼 양분을 없애고 alive 큐로 삽입
            if(tree.age <= map[tree.r][tree.c]) {
                map[tree.r][tree.c] -= tree.age;
                tree.age++;
                alive.add(tree);
            }
            else {
                //충분하지 않다면 dead큐로 삽입
                dead.add(tree);
            }
        }
    }
    static void summer() {
        //dead큐를 돌면서 나무의 나이의 반만큼을 위치에 양분 누적
        while(!dead.isEmpty()) {
            Tree tree = dead.poll();
            map[tree.r][tree.c] += (tree.age/2);
        }
    }
    static int[][] dir = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
    static boolean isIn(int r, int c) {
        return r >= 1 && c >= 1 && r <= N && c <= N;
    }
    static void autumn() {
        //alive큐를 돌면서 나이가 5의 배수라면 8방에 대해서 나무를 생성해 trees삽입
        while(!alive.isEmpty()) {
            Tree tree = alive.poll();
            //현재 나무도 삽입
            if(tree.age%5 == 0) {
                for(int i = 0; i < dir.length; i++) {
                    int dr = tree.r + dir[i][0];
                    int dc = tree.c + dir[i][1];
                    if(isIn(dr, dc)) {
                        trees.add(new Tree(dr, dc, 1));
                    }
                }
            }
            trees.add(tree);
        }
    }
    static void winter() {
        //N*N을 탐색하면 map의 각 자리에 s2d2의 각 자리값만큼을 누적합
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                map[i][j] += s2d2[i][j];
            }
        }
    }
}
