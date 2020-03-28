package net.acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 스타트링크 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int F = sc.nextInt();
        int S = sc.nextInt();
        int G = sc.nextInt();
        int U = sc.nextInt();
        int D = sc.nextInt();
        int[] arr = new int[F+1];
        System.out.println(bfs(F, S, G, U, D, arr));
    }
    static String bfs(int Floor, int start, int end, int up, int down, int[] arr) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        //arr[start] = 0으로 하고 출력할 때 arr[current]로 하는 건 틀림.
        arr[start] = 1;
        while(!que.isEmpty()) {
            int current = que.poll();
            if(current == end) {
                return String.valueOf(arr[current]-1);
            }
            if(current + up <= Floor && arr[current+up] == 0) {
                que.add(current+up);
                arr[current+up] = arr[current] + 1;
            }
            if(current - down > 0 && arr[current-down] == 0) {
                que.add(current-down);
                arr[current-down] = arr[current]+1;
            }
        }
        return "use the stairs";
    }
}

