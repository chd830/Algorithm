package net.acmicpc;

import java.util.*;

public class 촌수계산 {
    static int n;
    static int start;
    static int end;
    static int m;
    static List<Integer>[] list;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        start = sc.nextInt();
        end = sc.nextInt();
        m = sc.nextInt();
        list = new ArrayList[n+1];
        arr = new int[n+1];
        for(int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            list[b].add(a);
        }
        bfs();
        System.out.println((arr[end] == 0 ? -1 : arr[end]));
    }
    public static void bfs() {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        while(!que.isEmpty()) {
            if(arr[end] != 0) {
                return;
            }
            int num = que.poll();
            for(int l : list[num]) {
                if(arr[l] == 0) {
                    arr[l] = arr[num]+1;
                    que.add(l);
                }
            }
        }
    }
}
//    static int[] chain;
//    static List<Integer>[] list;
//    static boolean[] visited1;
//    static int start;
//    static int end;
//    static int island;
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        start = sc.nextInt();
//        end = sc.nextInt();
//        island = 0;
//        int m = sc.nextInt();
//        list = new ArrayList[n+1];
//        visited1 = new boolean[n+1];
//        chain = new int[n+1];
//        for(int i = 0; i <= n; i++) {
//            list[i] = new ArrayList();
//        }
//        for(int i = 0; i < m; i++) {
//            int num1 = sc.nextInt();
//            int num2 = sc.nextInt();
//            list[num1].add(num2);
//            list[num2].add(num1);
//        }
//
//        bfs();
////        System.out.println("\n"+Arrays.toString(chain));
//        System.out.println((chain[end] == 0 ? -1 : chain[end]));
//    }
//    public static void bfs() {
//        Queue<Integer> que = new LinkedList<>();
//        que.add(start);
//        visited1[start] = true;
//        while(!que.isEmpty()) {
//            int num = que.poll();
////            System.out.print(num+" ");
//            if(num == end) {
//                break;
//            }
//            for(int i = 0; i < list[num].size(); i++) {
//                int l = list[num].get(i);
//                if(!visited1[l]) {
//                    chain[l] = chain[num]+1;
////                    System.out.println("\t"+Arrays.toString(chain));
//                    visited1[l] = true;
//                    que.add(l);
//                }
//            }
//        }
//    }
//}
