package net.acmicpc.re;

import java.util.*;
import java.io.*;

public class 주식가격 {
    public static void main(String[] args) {
        int[] result = solution(new int[] {1, 2, 3, 2, 3});
        System.out.println(Arrays.toString(result));
    }
    public static int[] solution(int[] prices) {
        int len = prices.length;
        int[] result = new int[len];
        for(int i = 0; i < len; i++ ){
            for(int j = i+1; j < len; j++) {
                result[i] = j-i;
                if(prices[i] > prices[j]) {
                    break;
                }
            }
        }
        return result;
    }
}
