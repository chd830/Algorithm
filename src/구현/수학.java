package 구현;

import java.util.*;
import java.io.*;

public class 수학 {
    public static void main(String[] args) {
//        System.out.println(solution(12));
//        System.out.println(solution(4));
        System.out.println(solution(500000));

//        System.out.println(solution((long)4));
//        System.out.println(solution((long)11));
//        System.out.println(solution((long)37));
    }
    /**
     * a^2 + b^2 = c^2 을 만족하게 하는 세 개의 자연수 a, b, c를 피타고라스의 수 또는 피타고라스의
     * 세 쌍(Pythagorean triple)이라고 합니다. 세 개의 자연수 a, b, c( a<=b<=c<=500,000)
     * 중 b 값이 매개변수로 주어 질 때, c값을 return 하도록 solution 함수를 작성하세요.
     */
    /*
    public static int solution(int b) {
        int answer = -1;
        for(long a = 1; a < b; a++) {
        long c = a*a + (long)b*;
        long sq = (c);
        if(sq*sq == c) answer++;
        return answer;
    }
     */
    public static int solution(int b) {
        int answer = -1;
        int a = 1;
        while(a < b) {
            int sum = a*a + b*b;
            for(int c = b; c < a+b; c++) {
                if(c*c == sum) {
                    System.out.println(a+"^2 + "+b+"^2 = "+c+"^2");
                    return c;
                }
            }
            a++;
        }
        return answer;
    }
    /**
     * 3의 거듭 제곱수는 3을 b번 곱한 수를 의미하며 3^b 형태로 표현합니다. 3^0 = 1이 성립하며,
     * 3^1 = 3, 3^2 = 9, 3^3 = 27, 3^4 = 81... 모두 거듭 제곱수입니다.
     * 3의 거듭 제곱수를 임의로 더하여 거듭 제곱수 사이에 들어가는 수를 만들 수 있습니다. 예를 들어,
     *
     * 4 = 1 + 3
     * 31 = 27 + 3 + 1
     * 입니다.
     *
     * 이때, 같은 거듭 제곱수를 2번 이상 더할 수는 없습니다. 이러한 규칙으로 만들어낼
     * 수 있는 수와 3의 거듭 제곱수를 합쳐서 순서대로 배치하면 1, 3, 4, 9, 10...이 됩니다.
     * 이렇게 배치한 숫자의 n번째 숫자가 무엇인지를 알려주는 함수 solution 을 완성해주세요.
     */
    // 삼진법으로 계산을 하면 간단하게 할 수 있음. 근데 제곱수를 두번이상 못더하니까 이진수처럼 접근하면 됨
    // N을 이진법으로 변환 후 3을 곱해서 값을 가져옴.
    /*
    // O(logN)
    public static long solution(long n) {
        long answer = 0;
        long b = 1;
        while(n != 0) {
            long c = n&1;
            answer += (c*b);
            // 삼진법으로 계산하기 위해 곱하기
            b *= 3;
            N /= 2;
        }
     */
    public static long solution(long n) {
        int[] d = new int[1234567];
        d[1] = 1;
        d[2] = 3;
        int idx = 0;
        for(int i = 3; i < d.length; i++) {
            d[i] = i+(2*(i-2)-1)+d[i-1];
            if(d[i] > n) {
                idx = i - 1;
                break;
            }
        }
        System.out.println(n+"의 위치는 3^"+(idx-1)+"인 "+(Math.pow(3, idx-1)+"보다 크다."));
        long value = d[idx]-n;
        long answer = 0;
        return answer;
    }
}
