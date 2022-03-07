package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2531
public class 회전초밥 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
        연속해서 먹으면 할인
        쿠폰으로 받은 초밥 무료제공
        먹을 수 있는 초밥 가짓수의 최댓값
         */
        StringTokenizer token = new StringTokenizer(br.readLine());
        int dish = Integer.parseInt(token.nextToken());
        int sushi = Integer.parseInt(token.nextToken());
        int continues = Integer.parseInt(token.nextToken());
        int coupon = Integer.parseInt(token.nextToken());
        int[] belt = new int[dish];
        for(int i = 0; i < dish; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }
        int max = 0;
        for(int i = 0; i < dish; i++) {
            HashSet<Integer> set = new HashSet<>();
            boolean flag = false;
            for(int idx = i, j = i; idx < i+continues; idx++, j++) {
                if(j >= dish)
                    j -= dish;
                if(belt[j] == coupon)
                    flag = true;
                set.add(belt[j]);
            }
            if(!flag)
                max = Math.max(max, set.size()+1);
            else
                max = Math.max(max, set.size());
//            Iterator<Integer> it = set.iterator();
//            while(it.hasNext())
//                System.out.print(it.next()+"\t");
//            System.out.println();
        }
        System.out.println(max);
    }
}
