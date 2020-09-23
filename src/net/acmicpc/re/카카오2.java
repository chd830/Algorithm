package net.acmicpc.re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 카카오2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        orderNums = new int[orders.length];
        courseOrder = "";
        solution(orders, course);
    }
    static boolean[] visited;
    static char[] alphs;
    static int[] orderNums;

    static String courseOrder;
    static void powerset(int idx) {
        if(idx == visited.length) {
            int cnt = 0;
            List<Character> list = new ArrayList<>();
            for(int i = 0; i < visited.length; i++) {
                // 부분집합의 개수가 2개이상인지 확인하기
                if(visited[i]) {
                    cnt++;
                }
                // 2개 이상일 때 orders에서 각각 몇개가 일치하는지 확인하고 어떤 값이 제일 큰지 기억하기

//                if(visited[i])
//                    System.out.print(alphs[i]+" ");
            }
            if(cnt >= 2) {

            }
            System.out.println();
            return;
        }
        visited[idx] = true;
        powerset(idx+1);
        visited[idx] = false;
        powerset(idx+1);
    }
    public static String[] solution(String[] orders, int[] course) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(String order : orders) {
            for(char c : order.toCharArray()) {
                if(map.containsKey(c)) {
                    continue;
                }
                map.put(c, 1);
            }
        }
        alphs = new char[map.size()];
        int idx = 0;
        for(char key : map.keySet()) {
            alphs[idx++] = key;
        }
        System.out.println(Arrays.toString(alphs));
        visited = new boolean[map.size()];
        powerset(0);
        return null;
    }
}
