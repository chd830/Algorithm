package co.kr.programmers;

import net.acmicpc.나무재테크Solution;

import java.util.*;

public class 멀쩡한사각 {
    public static void main(String[] args) {
        System.out.println(solution(1234123414, 1234123412));
    }
    public static long solution(int w, int h) {
        return (long)w*(long)h-(w+h-gcd(w, h));
    }
    static long gcd(int a, int b) {
        return a%b == 0 ? b : gcd(b, a%b);
    }
}
