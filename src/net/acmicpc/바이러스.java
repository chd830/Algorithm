//package net.acmicpc;
//
//import java.util.*;
//
//public class 바이러스 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int computer = sc.nextInt();
//        int pair = sc.nextInt();
//        List<Integer>[] list = new ArrayList[computer+1];
//        boolean[] visited1 = new boolean[computer+1];
//        for(int i = 0; i <= computer; i++) {
//            list[i] = new ArrayList();
//        }
//        for(int i = 0; i < pair; i++) {
//            int num1 = sc.nextInt();
//            int num2 = sc.nextInt();
//            list[num1].add(num2);
//            list[num2].add(num1);
//        }
//        Queue<Integer> que = new LinkedList<>();
//        que.add(1);
//        visited1[1] = true;
//        while(!que.isEmpty()) {
//            int num = que.poll();
////            System.out.print(num+" ");
//            visited1[num] = true;
//            for(int i = 0; i < list[num].size(); i++) {
//                if(!visited1[list[num].get(i)]) {
//                    que.add(list[num].get(i));
//                    visited1[list[num].get(i)] = true;
//                }
//            }
//        }
////        System.out.println();
//        int count = 0;
//        for(boolean v : visited1) {
////            System.out.print(v+" ");
//            if(v) count++;
//        }
//        System.out.println(count-1);
//    }
//}
