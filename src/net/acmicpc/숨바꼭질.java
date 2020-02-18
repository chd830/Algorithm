package net.acmicpc;

import java.util.*;

public class 숨바꼭질 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] move = new int[100001];
        if(N >= K) {
            System.out.println(N-K);
            System.exit(0);
        }
        Queue<Integer> que = new LinkedList<>();
        que.add(N);
        move[N] = 1;
        while(!que.isEmpty()) {
            N = que.poll();
            if(N == K) {
                break;
            }
            if(N+1 <= 100000 && move[N+1] == 0) {
                move[N+1] = move[N]+1;
                que.add(N+1);
            }
            if(N-1 >= 0 && move[N-1] == 0) {
                move[N-1] = move[N]+1;
                que.add(N-1);
            }
            if(N*2 <= 100000 && move[N*2] == 0) {
                move[N*2] = move[N] + 1;
                que.add(N*2);
            }
        }
        System.out.println(move[K]-1);
    }
}
//    0 5 4 3 2 1 2 3 3 3 2 3 3 4 4 5 4 5 4 4
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int K = sc.nextInt();
//        int[] visited = new int[100001];
//        if(N >= K) {
//            System.out.println(N-K);
//            System.exit(0);
//        }
//        Queue<Integer> que = new LinkedList<>();
//        que.add(N);
//        visited[N] = 1;
//        while(!que.isEmpty()) {
//            N = que.poll();
//            if(N == K)
//                break;
//            if(N+1 <= 100000 && visited[N+1] == 0) {
//                que.offer(N+1);
//                visited[N+1] = visited[N]+1;
//            }
//            if(N-1 >= 0 && visited[N-1] == 0) {
//                que.offer(N-1);
//                visited[N-1] = visited[N]+1;
//            }
//            if(N*2 <= 100000 && visited[N*2] == 0) {
//                que.offer(N*2);
//                visited[N*2] = visited[N]+1;
//            }
//        }
//        for(int i = 0; i < 20; i++) {
//            System.out.print(visited[i]+" ");
//        }
//        System.out.println();
//        System.out.println(visited[K]-1);
//    }
//}
