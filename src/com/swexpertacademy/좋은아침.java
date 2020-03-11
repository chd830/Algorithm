package com.swexpertacademy;

import java.util.Arrays;

public class 좋은아침 {
    static char[] chars = {'a', 'b', 'c', 'd'};
    public static void main(String[] args) {
        //chars로 만들 수 있는 부분집합
        makeSubArray();
        //chars로 3개를 고르는 순열
        int r = 3;
        makePermutationUsingRecur(r, new char[r], new boolean[chars.length]);
        //chars에서 3개를 고르는 조합
        makePermutationOverlap(r, new char[r]);
    }

    /**
     * @param r : 뽑아야 할 숫자
     * @param temp : 뽑힌 녀석들
     * @param visited : 중복 방지용
     */
    static void makePermutationUsingRecur(int r, char[] temp, boolean[] visited) {
        for(int i = 0; i < chars.length; i++) {
            if(r == 0) {
                System.out.println(Arrays.toString(temp));
                return;
            }
            if(!visited[i]) {
                visited[i] = true;
                temp[r-1] = chars[i];
                makePermutationUsingRecur(r-1, temp, visited);
                visited[i] = false;
            }
        }
    }
    /**
     * @param r : 뽑아야 할 숫자
     * @param temp : 뽑힌 녀석들
     */
    static void makePermutationOverlap(int r, char[] temp) {
        for(int i = 0; i < chars.length; i++) {
            if(r == 0) {
                System.out.println(Arrays.toString(temp));
                return;
            }
            temp[r-1] = chars[i];
            makePermutationOverlap(r-1, temp);
        }
    }
    static void makeSubArray() {
        for(int i = 0; i < 1<<chars.length; i++) {
            for(int j = 0 ;j < chars.length; j++) {
                if((i & 1<<j) != 0) {
                    System.out.print(chars[j]+" ");
                }
            }
            System.out.println();
        }
    }

}
