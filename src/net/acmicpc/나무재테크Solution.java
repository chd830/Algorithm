package net.acmicpc;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

//0. 각 맵의 S2D2가 겨울에 추가할 양분의 양을 저장할 자료 ( 2차원 )
//0. 각 맵의 현재 양분양을 저장할 자료 ( 2차원 )
//1. 현재 살아있는 모든 나무를 담을 Priority Queue ( 좌표, 나이 )
//2. 봄이 지나 살아있는 나무들이 모여있을 큐
//3. 봄이 지나 죽을 나무들이 모여있을 큐

//봄 : 1을 하나씩 꺼내며 산놈은 2로 죽은놈은 3으로
//여름 : 2를 모두 꺼내며 양분추가 처리
//가을 : 3을 모두 꺼내며 8방에 생기는 나무를 다시 1에 삽입
//겨울 : 0을 한바퀴 돌면서 양분 업데이트
public class 나무재테크Solution {
    static class Tree implements Comparable<Tree> {
        int r, c, age;

        public Tree(int r, int c, int age) {
            this.r = r;
            this.c = c;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            // TODO Auto-generated method stub
            return Integer.compare(this.age, o.age);
        }
    }

    //s2d2가 겨울에 뿌릴 양분의 양
    static int[][] s2d2;
    //각 칸 별로 현재 양분의 양
    static int[][] map;
    //현재 살아 있는 모든 나무들
    static PriorityQueue<Tree> trees = new PriorityQueue<>();
    //봄을 지나 살아남은 나무들이 잠시 머물 곳
    static Queue<Tree> alive = new LinkedList<>();
    //봄을 지나 죽은 나무들이 잠시 머물 곳
    static Queue<Tree> dead = new LinkedList<>();
    static int N, M, K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //땅의 크기
        M = sc.nextInt(); //나무의 수
        K = sc.nextInt(); //몇년 후?
        map = new int[N + 1][N + 1];
        s2d2 = new int[N + 1][N + 1];
        //입력
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                s2d2[i][j] = sc.nextInt();
                map[i][j] = 5;
            }
        }
        for (int i = 0; i < M; i++)
            trees.add(new Tree(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        for (int k = 0; k < K; k++) {
            spring();
            summer();
            autumn();
            winter();
        }
        System.out.println(trees.size());
    }

    static void spring() {
        //trees 큐를 하나씩 꺼내면서
        while (!trees.isEmpty()) {
            Tree tree = trees.poll();
            //나무의 위치에 양분이 충분하다면 나무의 나이만큼 양분을 없애고 나이한살늘리고 alive 큐로 삽입
            if (tree.age <= map[tree.r][tree.c]) {
                map[tree.r][tree.c] -= tree.age;
                tree.age++;
                alive.add(tree);
            } else
                dead.add(tree);
        }
        //아니라면  dead큐로 삽입
    }

    static void summer() {
        //dead큐를 모두 돌면서, 나무의 나이의 반만큼을 나무의 위치에 양분 누적합
        while (!dead.isEmpty()) {
            Tree tree = dead.poll();
            map[tree.r][tree.c] += (tree.age / 2);
        }
    }

    static void autumn() {
        //alive큐를 모두 돌면서, 나이가 5의 배수라면 8방에 대해서 나무를 생성해 trees에 삽입, 현재 나무도 삽입
        while (!alive.isEmpty()) {
            Tree tree = alive.poll();
            if (tree.age % 5 == 0) {
                for (int d = 0; d < 8; d++) {
                    int nr = tree.r + dr[d];
                    int nc = tree.c + dc[d];
                    if (nr >= 1 && nc >= 1 && nr <= N && nc <= N)
                        trees.add(new Tree(nr, nc, 1));
                }
            }
            trees.add(tree);
        }
    }

    static void winter() {
        //N * N 을 탐색하면 map의 각 자리에 s2d2의 각 자리 값만큼을 누적합
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++)
                map[i][j] += s2d2[i][j];
        }
    }

    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
}